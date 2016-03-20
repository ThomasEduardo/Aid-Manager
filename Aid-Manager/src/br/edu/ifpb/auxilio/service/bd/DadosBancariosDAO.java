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



import br.edu.ifpb.auxilio.dominio.DadosBancarios;
import br.edu.ifpb.auxilio.dominio.Discente;



public class DadosBancariosDAO {
private Connection conn;
	
	public DadosBancariosDAO(){
		conn = Conexao.getConnection();
		if(conn != null)
			System.out.println("Conexão estabelecida");
		else System.out.println("Erro na conexão com o BD");	
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
	
	public List<DadosBancarios> find(DadosBancarios db) throws SQLException {
		List<DadosBancarios> dbs = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = String.format("%s '%%%s%%'",
							" SELECT  db.id_dados_bancarios,"
									+ "db.banco,"
									+ "db.agencia,"
									+ "db.obs,"
									+ "db.num_agencia,"
									+ "db.saldo,"
									+ "pessoa.nome_pessoa"
									+ " FROM dadosbancarios db"
									+ " INNER JOIN discente"
									+ " ON db.discente_id = discente.id_discente"
									+ " INNER JOIN pessoa"
									+ " ON pessoa.id_pessoa = discente.pessoa_id"	
						    + " WHERE pessoa.matricula LIKE",
							db.getDiscente().getMatricula());
 
			stmt = (PreparedStatement) conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			dbs = convertToList(rs);

		} catch (SQLException sqle) {
			throw new SQLException(sqle);
					
		} 

		return dbs;
	}
	
	public List<DadosBancarios> getAll() throws SQLException {
		List<DadosBancarios> dbs = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = String.format("%s",
						"SELECT       id_dados_bancarios,"
									+ "banco,"
									+ "agencia,"
									+ "num_agencia,"
									+ "saldo, "
									+ "obs,"
							        + "discente_id"
					     + " FROM dadosbancarios");

			stmt = (PreparedStatement) conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			dbs = convertToList(rs);

		} catch (SQLException sqle) {
			throw new SQLException(sqle);
		} 

		return dbs;
	}
		
	//Pegar os atributos de dadosBancarios pelo find
	public double gastoMensal(DadosBancarios db) throws SQLException {
		
		double gastoMensal = 0;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = String.format("%s '%%%s%%'",
							"SELECT EXTRACT(MONTH FROM CURDATE()) *( ? *80) as gasto_mensal");

 
			stmt = (PreparedStatement) conn.prepareStatement(sql);
			
			AuxilioDAO aux = new AuxilioDAO();
			
			stmt.setInt(1, aux.qtdeAuxilios(db.getDiscente()));
			
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				gastoMensal = rs.getDouble("gasto_mensal");
				
			}

		    stmt.close();
		    rs.close();
			
			

		} catch (SQLException sqle) {
			throw new SQLException(sqle);
					
		} 

		return gastoMensal;
	}
}
