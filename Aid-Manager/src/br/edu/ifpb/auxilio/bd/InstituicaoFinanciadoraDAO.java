package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifpb.auxilio.dominio.InstituicaoFinanciadora;


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
	
	public InstituicaoFinanciadora getObject (String cnpj){
		
		InstituicaoFinanciadora IF = new InstituicaoFinanciadora();
		String sql = "select * from instituicaoBancaria where cnpj = ?";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, cnpj);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				IF.setNomeIF(rs.getString("Nome_if"));
				IF.setCnpj(rs.getString("CNPJ"));
				IF.setOrcamentoAuxilio(rs.getDouble("orcamento_auxilio"));
				//stmt.setInt(4, IF.getServidor().getIdServidor());
				IF.setIdIF(rs.getInt("id_if"));
			}
			return IF;
		}
		catch (Exception e){
			System.out.println("Exception is :"+e);
		}
		return null;
				
	}
}
