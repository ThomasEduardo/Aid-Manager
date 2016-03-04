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
				+ " `banco`, "
				+ " `agencia`, "
				+ " `numAgencia`,"
				+ " `saldo`, "
				+ " `obs`"
				+ " `idDiscente`"
				+ "VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);


			stmt.setString(1, dadosBancarios.getBanco() );
			stmt.setString(2, dadosBancarios.getAgencia());
			stmt.setString(3, dadosBancarios.getNumAgencia());
			stmt.setDouble(4, dadosBancarios.getSaldo());
			stmt.setString(5, dadosBancarios.getObs());
			stmt.setInt(6, dadosBancarios.getDiscente().getIdDiscente());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public boolean update(DadosBancarios db) {
		String sql = "update dadosBancarios set "
				+ "banco = ? ,"
				+ "agencia = ?,"
				+ "numAgencia= ?,"
				+ "saldo=?,"
				+ "obs=?,"
				+ "idDiscente=?,"
				+ " WHERE idDadosBancarios = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, db.getBanco());
			stmt.setString(2, db.getAgencia());
			stmt.setString(3, db.getNumAgencia());
			stmt.setDouble(4, db.getSaldo()); 
			stmt.setString(5, db.getObs());
			stmt.setInt(6, db.getDiscente().getIdDiscente());

			stmt.execute();
			stmt.close();
			return true;

		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return false;
	}
}
