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
			System.out.println("Conexão estabelecida");
		else System.out.println("Erro na conexão com o BD");	
	}
	
	
	public void insert(DadosBancarios dadosBancarios) {

		String sql = "INSERT INTO dadosBancarios "
				+ " `banco`, "
				+ " `agencia`, "
				+ " `num_agencia`,"
				+ " `saldo`, "
				+ " `obs`"
				+ " `discente_id`"
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
				+ "num_agencia= ?,"
				+ "saldo=?,"
				+ "obs=?,"
				+ "discente_id=?,"
				+ " WHERE id_dados_bancarios = ?";
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
		String sql = "select id_dados_bancarios from dadosBancarios where num_agencia = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, numAgencia);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				idDb = rs.getInt("id_dados_bancarios");
			}
			return idDb;
		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return 0;
	}
	
	
	public DadosBancarios getObject(int idDb) {
         
		
		DiscenteDAO d = new DiscenteDAO();
		DadosBancarios db = new DadosBancarios();
		String sql = "select * from dadosBancarios where id_dados_bancarios = ?";
		
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idDb);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				db.setIdDadosBancarios(rs.getInt("id_dados_bancarios"));
				db.setBanco(rs.getString("banco"));
				db.setAgencia(rs.getString("agencia"));
				db.setNumAgencia(rs.getString("num_agencia"));
				db.setSaldo(rs.getDouble("saldo")); 
				db.setObs(rs.getString("obs"));
				db.setDiscente(d.getObject(rs.getInt("discente_id")));
			}
			return db;
		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return null;
	}
	
	
	
	
	
}
