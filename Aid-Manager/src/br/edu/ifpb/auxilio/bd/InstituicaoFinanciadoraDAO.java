package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
					 " `nomeIF`, " +
					 " `cnpj`, " +
					 " `orcamentoAuxilio`," +
					 " `idTecnicoAdmin`" + 
					 "VALUES(?,?,?,?)";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, IF.getNomeIF());
			stmt.setString(2, IF.getCnpj());
			stmt.setDouble(3, IF.getOrcamentoAuxilio());
			stmt.setInt(4, IF.getAdmin().getIdTecnicoAdmin());
			stmt.execute();
			stmt.close();

		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public boolean update(InstituicaoFinanciadora IF) {
		String sql = "update instituicaoFinanciadora set"
				+ " `nomeIF` = ?, " 
				+ " `cnpj` =?, " 
				+ " `orcamentoAuxilio`=?," 
				+ " `idTecnicoAdmin`=?" 
				+ "WHERE idEdital = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, IF.getNomeIF());
			stmt.setString(2, IF.getCnpj());
			stmt.setDouble(3, IF.getOrcamentoAuxilio());
			stmt.setInt(4, IF.getAdmin().getIdTecnicoAdmin());
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
}
