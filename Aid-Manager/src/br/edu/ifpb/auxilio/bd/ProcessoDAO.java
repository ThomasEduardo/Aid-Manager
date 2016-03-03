package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.ifpb.auxilio.dominio.Processo;

public class ProcessoDAO {
	private Connection conn;
	
	public ProcessoDAO(){
		conn = Conexao.getConnection();
		if(conn != null)
			System.out.println("Conexão estabelecida");
		else System.out.println("Erro na conexão com o BD");	
	}
	
	
	public void insert(Processo processo) {

		String sql = "INSERT INTO processo"
				+ " `idProcesso`, "
				+ " `data`, "
				+ " `obs`, "
				+ " `numProcesso`,"
				+ " `assunto`, "
				+ " `parecer`, "
				+ " `interessado`, "
				+ " `servidor`"
				+ "VALUES(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, processo.getIdProcesso());
			stmt.setDate(2, processo.getData() );
			stmt.setString(3, processo.getObs());
			stmt.setString(4, processo.getNumProcesso());
			stmt.setString(5, processo.getAssunto());
			stmt.setString(6, processo.getParecer());
			stmt.setInt(7, processo.getInteressado().getIdPessoa());
			stmt.setInt(8, processo.getServidor().getIdServidor());
			stmt.execute();
			stmt.close();
			
			//Ajeitar data
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}