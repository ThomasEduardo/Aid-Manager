package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifpb.auxilio.dominio.DadosBancarios;


public class DadosBancariosDAO {
private Connection conn;
	
	public DadosBancariosDAO(){
		conn = Conexao.getConnection();
		if(conn != null)
			System.out.println("Conex�o estabelecida");
		else System.out.println("Erro na conex�o com o BD");	
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
	
	
	public int getIdDadosBancarios(String numAgencia) {

		int idDb = 0;
		String sql = "select idDadosBancarios from dadosBancarios where numAgencia = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, numAgencia);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				idDb = rs.getInt("idDb");
			}
			return idDb;
		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return 0;
	}
	
	
	public DadosBancarios getObject(String numAgencia) {
         
		DadosBancarios db = new DadosBancarios();
		String sql = "select * from dadosBancarios where numAgencia = ?";
		
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, numAgencia);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				db.setBanco(rs.getString("banco"));
				db.setAgencia(rs.getString("agencia"));
				db.setNumAgencia(rs.getString("numAgencia"));
				db.setSaldo(rs.getDouble("saldo")); 
				db.setObs(rs.getString("obs"));
				//stmt.setInt(6, db.getDiscente().getIdDiscente());
			}
			return db;
		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return null;
	}
	
	
	
	
	
}