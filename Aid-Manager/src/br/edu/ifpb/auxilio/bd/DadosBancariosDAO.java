package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.edu.ifpb.auxilio.dominio.DadosBancarios;
;


public class DadosBancariosDAO {
private Connection conn;
	
	public DadosBancariosDAO(){
		conn = Conexao.getConnection();
		if(conn != null)
			System.out.println("Conex�o estabelecida");
		else System.out.println("Erro na conex�o com o BD");	
	}
	
	
	public void insert(DadosBancarios dadosBancarios) {

		String sql = "INSERT INTO dadosBancarios( "
				+ " `banco`, "
				+ " `agencia`, "
				+ " `num_agencia`,"
				+ " `saldo`, "
				+ " `obs`,"
				+ " `discente_id`)"
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
				+ "discente_id=?"
				+ " WHERE id_dados_bancarios = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, db.getBanco());
			stmt.setString(2, db.getAgencia());
			stmt.setString(3, db.getNumAgencia());
			stmt.setDouble(4, db.getSaldo()); 
			stmt.setString(5, db.getObs());
			stmt.setInt(6, db.getDiscente().getIdDiscente());
			stmt.setInt(7, db.getIdDadosBancarios());

			stmt.execute();
			stmt.close();
			return true;

		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return false;
	}
	
	
	
	
	public DadosBancarios getById(int idDb) {
         
		

		DadosBancarios db = new DadosBancarios();
		String sql = "select * from dadosBancarios where id_dados_bancarios = ?";
		
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idDb);
			ResultSet rs = stmt.executeQuery();
		
			List<DadosBancarios> dbs = convertToList(rs);
			
			if (!dbs.isEmpty()) {
				db = dbs.get(0);
			}
			
			
			return db;
			
		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return null;
	}
	
	public List<DadosBancarios> convertToList(ResultSet rs)
			throws SQLException {

		List<DadosBancarios> DadosBancarios = new ArrayList<DadosBancarios>();

		try {

			while (rs.next()) {

				DadosBancarios db = new DadosBancarios ();
				
				db.setIdDadosBancarios(rs.getInt("id_dados_bancarios"));
				db.setBanco(rs.getString("banco"));
				db.setAgencia(rs.getString("agencia"));
				db.setNumAgencia(rs.getString("num_agencia"));
				db.setSaldo(rs.getDouble("saldo")); 
				db.setObs(rs.getString("obs"));
				
				// Discente
				
				DiscenteDAO d = new DiscenteDAO();
				db.setDiscente(d.getById(rs.getInt("discente_id")));
				

				DadosBancarios.add(db);
			}

		} catch (SQLException sqle) {
			
		}

		return DadosBancarios;
	}
	
	
	
	
	
}
