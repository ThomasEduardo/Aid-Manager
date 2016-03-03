package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.ifpb.auxilio.dominio.DadosBancarios;

public class DadosBancariosDAO {
private Connection conn;
	
	public DadosBancariosDAO(){
		conn = Conexao.getConnection();
		if(conn != null)
			System.out.println("Conexão estabelecida");
		else System.out.println("Erro na conexão com o BD");	
	}
	
	
	public void insert(DadosBancarios dadosBancarios) {

		String sql = "INSERT INTO dadosBancarios "
				+ " `idDadosBancarios`, "
				+ " `banco`, "
				+ " `agencia`, "
				+ " `numAgencia`,"
				+ " `saldo`, "
				+ " `discente`"
				+ "VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, dadosBancarios.getIdDadosBancarios());
			stmt.setString(2, dadosBancarios.getBanco() );
			stmt.setString(3, dadosBancarios.getAgencia());
			stmt.setString(4, dadosBancarios.getNumAgencia());
			stmt.setDouble(5, dadosBancarios.getSaldo());
			stmt.setInt(6, dadosBancarios.getDiscente().getIdDiscente());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
