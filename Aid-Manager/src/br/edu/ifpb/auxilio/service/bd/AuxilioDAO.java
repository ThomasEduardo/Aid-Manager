/**
 * 
 * @author FannyVieira, RaylaMedeiros, MateusOliveira
 *
 */
package br.edu.ifpb.auxilio.service.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.auxilio.entidade.Auxilio;
import br.edu.ifpb.auxilio.entidade.Discente;
import br.edu.ifpb.auxilio.entidade.InstituicaoFinanciadora;
import br.edu.ifpb.auxilio.entidade.Pessoa;
import br.edu.ifpb.auxilio.service.bd.Conexao;


public class AuxilioDAO{
	
private Connection conn;
	
	public AuxilioDAO(){
		conn = Conexao.getConnection();
		if(conn != null)
			System.out.println("Conexão estabelecida");
		else System.out.println("Erro na conexão com o BD");	
	}
	
	
	public void insert(Auxilio auxilio) {

		String sql = "INSERT INTO auxilio( "
				+ " `tipo_Auxilio`, "
				+ " `valor_Auxilio`, "
				+ " `validade_Inicial`, "
				+ " `validade_Final`,"
				+ " `instituicaoFinanciadora_id`, "
				+ " `processo_id`)"
				+ "VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, auxilio.getTipoAuxilio());
			stmt.setDouble(2, auxilio.getValorAuxilio() );
			stmt.setDate  (3, new java.sql.Date(auxilio.getValidadeInicial().getTime()));
			stmt.setDate  (4, new java.sql.Date(auxilio.getValidadeFinal().getTime()));
			stmt.setInt   (5, auxilio.getIF().getIdIF());
         		stmt.setInt   (6, auxilio.getP().getIdProcesso());
         	
         	
			stmt.execute();
			stmt.close();
			
		
		} catch (SQLException e) { 
			
			throw new RuntimeException(e);
			
		}

	}
	
	public boolean update(Auxilio auxilio) { 
		
		String sql = "update auxilio set "
				+ " tipo_auxilio=?, "
				+ " valor_auxilio=?, "
				+ " validade_inicial=?, "
				+ " validade_final=?,"
				+ " instituicaoFinanciadora_id=?, "
				+ " processo_id=? "
				+ "WHERE id_auxilio = ?";
		try {
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			
			stmt.setString(1, auxilio.getTipoAuxilio());
			stmt.setDouble(2, auxilio.getValorAuxilio() );
			stmt.setDate  (3, new java.sql.Date(auxilio.getValidadeInicial().getTime()));
			stmt.setDate  (4, new java.sql.Date(auxilio.getValidadeFinal().getTime()));
			stmt.setInt   (5, auxilio.getIF().getIdIF());
			stmt.setInt   (6, auxilio.getP().getIdProcesso());
			stmt.setInt   (7, auxilio.getIdAuxilio());
			
			
			stmt.execute();
			stmt.close();
			return true;

		} catch (Exception e) {
			
			
			e.printStackTrace();
			
		}
		
		return false;
		
	}
	
	
	
	public Auxilio getById(int idAuxilio) {
		PreparedStatement stmt = null;
		String sql = "select * from auxilio where id_auxilio = ?";
		
		try {

			Auxilio auxilio = new Auxilio();
			

			stmt = (PreparedStatement) conn.prepareStatement(sql);
			
			stmt.setInt(1, idAuxilio);
			
			ResultSet rs = stmt.executeQuery();
			

			List<Auxilio> auxilios  = convertToList(rs);
			
			if (!auxilios.isEmpty()) {
				auxilio = auxilios.get(0);
			}
			
			
			stmt.close();
			rs.close();
			
			return auxilio;

		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		
		return null;

	}
	
	
	
	public List<Auxilio> convertToList(ResultSet rs)
			throws SQLException {

		List<Auxilio> auxilios = new ArrayList<Auxilio>();

		try {

			while (rs.next()) {

				Auxilio auxilio = new Auxilio();
				auxilio.setIdAuxilio(rs.getInt("id_auxilio"));
				auxilio.setTipoAuxilio(rs.getString("tipo_auxilio"));
				auxilio.setValorAuxilio(rs.getDouble("valor_auxilio"));
				auxilio.setValidadeInicial(new java.util.Date(rs.getDate("validade_inicial").getTime()));
				auxilio.setValidadeFinal(new java.util.Date(rs.getDate("validade_final").getTime()));
				
				// Instituicao Financiadora 
				
				InstituicaoFinanciadoraDAO IF = new InstituicaoFinanciadoraDAO();
				auxilio.setIF(IF.getById(rs.getInt("instituicaoFinanciadora_id")));
				//Processo
				
				ProcessoDAO p = new ProcessoDAO();
				auxilio.setP(p.getById(rs.getInt("processo_id")));

				auxilios.add(auxilio);
			}

		} catch (SQLException sqle) {
			System.out.println("Exception is :" + sqle);
		}

		return auxilios;
	}
	
	public List<Auxilio> getAll() throws SQLException {
		
		List<Auxilio> auxilios = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {

			String sql = String
					.format("%s",
							"SELECT `id_auxilio`, "
									+ "`tipo_auxilio`, "
									+ "`valor_auxilio`, "
									+ "`validade_Inicial`, "
									+ "`validade_final`, "
									+ "`instituicaoFinanciadora_id`, "
									+ "`processo_id` "
						    + " FROM `auxilio`");

			stmt = (PreparedStatement) conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql);
			
			auxilios = convertToList(rs);

		} catch (SQLException sqle) {
			
			sqle.printStackTrace();
			
		}
		return auxilios;
		
	}
	

	
	public List<Auxilio> find(Auxilio auxilio) throws SQLException {
		List<Auxilio> auxilios = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = String
					.format("%s '%%%s%%'",
							"SELECT auxilio.`id_auxilio`, "
							+ " auxilio.`tipo_auxilio`, "
							+ " auxilio.`valor_auxilio`, "
							+ " auxilio.`validade_Inicial`, "
							+ " auxilio.`validade_final`, "
							+ " auxilio.instituicaoFinanciadora_id,"
							+ " auxilio.processo_id"
							+ " FROM auxilio"
							+ " INNER JOIN processo"
							+ " on processo.id_processo = auxilio.processo_id"
							+ " INNER JOIN instituicaoFinanciadora instf"
							+ " on instf.id_if = auxilio.instituicaoFinanciadora_id"
							+ " INNER JOIN pessoa"
							+ " ON pessoa.id_pessoa = processo.interessado_id" 
						        + " WHERE pessoa.matricula LIKE",
							auxilio.getP().getInteressado().getMatricula());

			stmt = (PreparedStatement) conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			auxilios = convertToList(rs);

		} catch (SQLException sqle) {
			throw new SQLException(sqle);
					
		} 

		return auxilios;
	}
	
	
	public int qtdeAuxilios(Discente discente) throws SQLException{
		
        int qtdeAuxilios = 0;
		
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = String
					.format("%s '%%%s%%'",
							"SELECT   count(aux.id_auxilio) "
							        + "FROM auxilio aux "
							        + "INNER JOIN processo "
							        + "ON (aux.processo_id = processo.id_processo) "
							        + "AND(processo.parecer = 'Aprovado') "
							        + "INNER JOIN pessoa "
							        + "ON pessoa.id_pessoa = processo.interessado_id "
						        + " AND pessoa.matricula LIKE",
							discente.getMatricula());

			stmt = (PreparedStatement) conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql);
			

				while (rs.next()) {
					
					qtdeAuxilios = rs.getInt("count(aux.id_auxilio)");
				}

			stmt.close();
			rs.close();

		} catch (SQLException sqle) {
			throw new SQLException(sqle);
					
		} 

		return qtdeAuxilios;
		
	}
		
	public List<Auxilio> getAllByInstFinanc(Auxilio auxilio) throws SQLException {
		List<Auxilio> auxilios = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = String
					.format("%s '%%%s%%'",
							"SELECT auxilio.`id_auxilio`, "
							+ " auxilio.`tipo_auxilio`, "
							+ " auxilio.`valor_auxilio`, "
							+ " auxilio.`validade_Inicial`, "
							+ " auxilio.`validade_final`, "
							+ " auxilio.instituicaoFinanciadora_id,"
							+ " auxilio.processo_id"
							+ " FROM auxilio"
							+ " INNER JOIN processo"
							+ " on processo.id_processo = auxilio.processo_id"
							+ " INNER JOIN instituicaoFinanciadora instf"
							+ " on instf.id_if = auxilio.instituicaoFinanciadora_id" 
						        + " WHERE instf.cnpj LIKE",
							auxilio.getIF().getCnpj());

			stmt = (PreparedStatement) conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			auxilios = convertToList(rs);

		} catch (SQLException sqle) {
			throw new SQLException(sqle);
					
		} 

		return auxilios;
	}
	
	public List<Auxilio> getAllByServidor(Auxilio auxilio) throws SQLException {
		List<Auxilio> auxilios = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = String
					.format("%s '%%%s%%'",
							"SELECT auxilio.`id_auxilio`, "
							+ " auxilio.`tipo_auxilio`, "
							+ " auxilio.`valor_auxilio`, "
							+ " auxilio.`validade_Inicial`, "
							+ " auxilio.`validade_final`, "
							+ " auxilio.instituicaoFinanciadora_id,"
							+ " auxilio.processo_id"
							+ " FROM auxilio"
							+ " INNER JOIN processo"
							+ " on processo.id_processo = auxilio.processo_id"
							+ " INNER JOIN instituicaoFinanciadora instf"
							+ " on instf.id_if = auxilio.instituicaoFinanciadora_id "
							+ " INNER JOIN servidor"
							+ " ON servidor.id_servidor = processo.servidor_id"
							+ " INNER JOIN pessoa"
							+ " ON pessoa.id_pessoa = servidor.pessoa_id" 
						        + " WHERE pessoa.matricula LIKE",
							auxilio.getP().getServidor().getMatricula());

			stmt = (PreparedStatement) conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			auxilios = convertToList(rs);

		} catch (SQLException sqle) {
			throw new SQLException(sqle);
					
		} 

		return auxilios;
	}
	
	//Ajustar
	public List<Auxilio> discentesComtemplados(Auxilio auxilio) throws SQLException {
		List<Auxilio> auxilios = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = String
					.format("%s '%%%s%%'",
							"select processo.num_processo,"
							+ "pessoa.nome_pessoa, "
							+ "pessoa.matricula, "
							+ " db.agencia, "
							+ " db.banco, "
							+ " db.num_agencia, "
							+ " aux.tipo_auxilio, "
							+ "aux.valor_auxilio "
							+ "from processo"
							+ "inner join pessoa "
							+ "on pessoa.id_pessoa = processo.interessado_id "
							+ "inner join discente"
							+ "	on discente.pessoa_id = pessoa.id_pessoa "
							+ "inner join dadosBancarios db "
							+ "on db.discente_id = discente.id_discente "
							+ "inner join auxilio aux"
							+ "on aux.processo_id = processo.id_processo "
							+ "where processo.parecer = 'Aprovado' and aux.tipo_auxilio = 'Transporte'");

			stmt = (PreparedStatement) conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			auxilios = convertToList(rs);

		} catch (SQLException sqle) {
			throw new SQLException(sqle);
					
		} 

		return auxilios;
	}
	
}
	
	


