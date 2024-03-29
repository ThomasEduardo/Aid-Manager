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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.auxilio.entidade.InstituicaoFinanciadora;


public class InstituicaoFinanciadoraDAO {
	
	private Connection conn;

	public InstituicaoFinanciadoraDAO() {
		
		conn = Conexao.getConnection();
		
		if (conn != null)
			System.out.println("Conex�o estabelecida");
		else
			System.out.println("Erro na conex�o com o BD");
		
	}

	public int insert(InstituicaoFinanciadora IF) throws SQLException{
		
		int idIf;

		String sql = String
				.format("%s %s('%s','%s',%s,%d) ",
					 "INSERT INTO instituicaofinanciadora(" 
					 +" nome_if, " +
					 " cnpj, " +
					 " orcamento_auxilio," +
					 " servidor_id)",
					 "VALUES",
					 IF.getNomeIF(),
					 IF.getCnpj(),
					 IF.getOrcamentoAuxilio(),
					 IF.getServidor().getIdServidor());
		try{
			
			PreparedStatement stmt = conn.prepareStatement(sql);

			
			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			
			idIf = BancoUtil.getGenerateKey(stmt);
		

		}catch (SQLException e) {
			
			throw new RuntimeException(e);
			
		}
		
		return idIf;
	}
	public boolean update(InstituicaoFinanciadora IF) throws SQLException{
		
		
		String sql = "update instituicaoFinanciadora set"
				+ " `nome_if` = ?, " 
				+ " `cnpj` =?, " 
				+ " `orcamento_auxilio`=?," 
				+ " `servidor_id`=?" 
				+ "WHERE id_edital = ?";
		
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, IF.getNomeIF());
			stmt.setString(2, IF.getCnpj());
			stmt.setDouble(3, IF.getOrcamentoAuxilio());
			stmt.setInt(4, IF.getServidor().getIdServidor());
			stmt.setInt(5, IF.getIdIF());
			
			
			stmt.execute();
			stmt.close();
			
			
			return true;

		} catch (Exception e) {
			
			System.out.println("Exception is :" + e);
			
		}
		
		return false;
		
	}
	

	
	public InstituicaoFinanciadora getById (int idIf)throws SQLException{
		
		InstituicaoFinanciadora IF = new InstituicaoFinanciadora();
		String sql = "select * from instituicaoFinanciadora where id_if = ?";
		
		
		try{
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idIf);
			
			ResultSet rs = stmt.executeQuery();
			
			List<InstituicaoFinanciadora> InstituicaoFinanciadoras  = convertToList(rs);
			if (!InstituicaoFinanciadoras.isEmpty()) {
				IF = InstituicaoFinanciadoras.get(0);
			}
			
		}
		catch (Exception e){
			System.out.println("Exception is :"+e);
		}
		return IF;
				
	}
	
	
	public List<InstituicaoFinanciadora> convertToList(ResultSet rs)
			throws SQLException {

		List<InstituicaoFinanciadora> Ifs = new ArrayList<InstituicaoFinanciadora>();

		try {

			while (rs.next()) {

				InstituicaoFinanciadora IF = new InstituicaoFinanciadora();
				
				IF.setNomeIF(rs.getString("nome_if"));
				IF.setCnpj(rs.getString("cnpj"));
				IF.setOrcamentoAuxilio(rs.getDouble("orcamento_auxilio"));
				IF.setIdIF(rs.getInt("id_if"));
				
				// Servidor
				ServidorDAO servidor = new ServidorDAO();
				IF.setServidor(servidor.getById(rs.getInt("servidor_id")));
				
				Ifs.add(IF);
			}

		} catch (SQLException sqle) {
			System.out.println("Exception is :"+sqle);
		}

		return Ifs;
	}
	
	
	
	public List<InstituicaoFinanciadora> find(InstituicaoFinanciadora instf) throws SQLException {
		List<InstituicaoFinanciadora> instfs = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = String.format("%s '%%%s%%'",
							" SELECT       id_if ,"
							          + "`nome_if`, " 
									  + " `cnpj`, " 
									  + " `orcamento_auxilio`,"
									  + "  servidor_id"
									  + " FROM instituicaoFinanciadora" 
						    + " WHERE cnpj LIKE",
							instf.getCnpj());
 
			stmt = (PreparedStatement) conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			instfs = convertToList(rs);

		} catch (SQLException sqle) {
			throw new SQLException(sqle);
					
		} 

		return instfs;
	}
	
	public List<InstituicaoFinanciadora> getAll() throws SQLException {
		List<InstituicaoFinanciadora> instfs = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = String.format("%s",
						 "  SELECT      id_if,   "
								 	  + "`nome_if`, " 
									  + " `cnpj`, " 
									  + " `orcamento_auxilio`,"
									  + " `servidor_id`"
									  + " FROM instituicaoFinanciadora"); 

			stmt = (PreparedStatement) conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			instfs = convertToList(rs);

		} catch (SQLException sqle) {
			throw new SQLException(sqle);
		} 

		return instfs;
	}
	
	public List<InstituicaoFinanciadora> getAllByServidor(InstituicaoFinanciadora instf) throws SQLException {
		List<InstituicaoFinanciadora> instfs = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = String.format("%s '%%%s%%'",
							" SELECT   id_if, "
							          + "`nome_if`, " 
									  + " `cnpj`, " 
									  + " `orcamento_auxilio`,"
									  + "  servidor_id"
									  + " FROM instituicaoFinanciadora instf"
									  + " INNER JOIN servidor "
									  + " ON servidor.id_servidor = instf.servidor_id "
									  + " INNER JOIN pessoa"
									  + " ON pessoa.id_pessoa = servidor.pessoa_id " 
						    + " AND pessoa.matricula LIKE",
							instf.getServidor().getMatricula());
 
			stmt = (PreparedStatement) conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			instfs = convertToList(rs);

		} catch (SQLException sqle) {
			throw new SQLException(sqle);
					
		} 

		return instfs;
	}
	
	/**
	 * Retorna todas as institui��es financiadoras que o servidor gerencia,filtrando atr�ves do nome da mesma.
	 * 
	 * @author Fanny
	 * */
	public List<InstituicaoFinanciadora> getAllByNome(InstituicaoFinanciadora instf) throws SQLException {
		List<InstituicaoFinanciadora> instfs = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = String.format("%s '%%%s%%' %s '%%%s%%'",
							" SELECT   id_if, "
							          + "`nome_if`, " 
									  + " `cnpj`, " 
									  + " `orcamento_auxilio`,"
									  + "  servidor_id"
									  + " FROM instituicaoFinanciadora instf"
									  + " INNER JOIN servidor "
									  + " ON servidor.id_servidor = instf.servidor_id "
									  + " INNER JOIN pessoa"
									  + " ON pessoa.id_pessoa = servidor.pessoa_id " 
						    + " AND pessoa.matricula LIKE",
							instf.getServidor().getMatricula(),
							" AND instf.nome_if  LIKE",
							instf.getNomeIF());
 
			stmt = (PreparedStatement) conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			instfs = convertToList(rs);

		} catch (SQLException sqle) {
			throw new SQLException(sqle);
					
		} 

		return instfs;
	}
	
	public void delete(String cnpj)throws SQLException{
			String sql = "DELETE FROM instituicaoFinanciadora where cnpj = "+cnpj;
		 try{
			 PreparedStatement stmt = conn.prepareStatement(sql);
			 stmt.execute();
			 stmt.close();
		 }
		 catch(SQLException e){
			 e.printStackTrace();
		 }

	 }
	
	/**
	    * Fun��o que retorna o id do processo,atr�ves do n�mero do processo fornecido
	    * @author Fanny
	    * 
	    * */	
	   
	   public int getId(String cnpj) throws SQLException {
			
			int idIf  = 0;

			PreparedStatement stmt = null;
			ResultSet rs = null;

			try {
				String sql = String 
						.format("%s '%s'",
						"SELECT id_if from instituicaoFinanciadora where "
						+ "cnpj = ",
						 cnpj);

				stmt = (PreparedStatement) conn.prepareStatement(sql);

				rs = stmt.executeQuery(sql);

				while (rs.next()) {
	               idIf = rs.getInt("id_if");
				}

			} catch (SQLException sqle) {

				sqle.printStackTrace();

			} 
			
			return idIf;
		}
	
}
