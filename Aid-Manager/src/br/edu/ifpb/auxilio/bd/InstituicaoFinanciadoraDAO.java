package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.ifpb.auxilio.dominio.Auxilio;
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
					 " `idIF`, " +
					 " `nomeIF`, " +
					 " `cnpj`, " +
					 " `orcamentoAuxilio`," +
					 " `idTecnicoAdmin`" + 
					 "VALUES(?,?,?,?,?)";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, IF.getIdIF());
			stmt.setString(2, IF.getNomeIF());
			stmt.setString(3, IF.getCnpj());
			stmt.setDouble(4, IF.getOrcamentoAuxilio());
			stmt.setInt(5, IF.getAdmin().getIdTecnicoAdmin());
			stmt.execute();
			stmt.close();

		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void Delete(){
		//Falta fazer
	}
}
