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

import br.edu.ifpb.auxilio.entidade.Familiar;
import br.edu.ifpb.auxilio.entidade.InstituicaoFinanciadora;


public class InstituicaoFinanciadoraDAO {
	
	private Connection conn;

	public InstituicaoFinanciadoraDAO() {
		
		conn = Conexao.getConnection();
		
		if (conn != null)
			System.out.println("Conexão estabelecida");
		else
			System.out.println("Erro na conexão com o BD");
		
	}

	public void insert(InstituicaoFinanciadora IF) {

		String sql = "INSERT INTO instituicaoFinanciadora " +
					 " `nome_if`, " +
					 " `cnpj`, " +
					 " `orcamento_auxilio`," +
					 " `servidor_id`" + 
					 "VALUES(?,?,?,?)";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, IF.getNomeIF());
			stmt.setString(2, IF.getCnpj());
			stmt.setDouble(3, IF.getOrcamentoAuxilio());
			stmt.setInt(4, IF.getServidor().getIdServidor());
			
			
			stmt.execute();
			stmt.close();

		}catch (SQLException e) {
			
			throw new RuntimeException(e);
			
		}
	}
	public boolean update(InstituicaoFinanciadora IF) {
		
		
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
	
	
	public void Delete(){
		//Falta fazer
	}
	
	public InstituicaoFinanciadora getById (int idIf){
		
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
							" SELECT   `nome_if`, " 
									  + " `cnpj`, " 
									  + " `orcamento_auxilio`" 
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
						 "  SELECT       `nome_if`, " 
									  + " `cnpj`, " 
									  + " `orcamento_auxilio`"
									  + " `servidor_id`"); 

			stmt = (PreparedStatement) conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			instfs = convertToList(rs);

		} catch (SQLException sqle) {
			throw new SQLException(sqle);
		} 

		return instfs;
	}
}
