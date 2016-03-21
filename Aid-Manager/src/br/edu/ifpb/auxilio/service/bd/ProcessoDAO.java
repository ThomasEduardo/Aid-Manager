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

import br.edu.ifpb.auxilio.entidade.Pessoa;
import br.edu.ifpb.auxilio.entidade.Processo;

public class ProcessoDAO {
	private Connection conn;
	
	public ProcessoDAO(){
		conn = Conexao.getConnection();
		if(conn != null)
			System.out.println("Conexão estabelecida");
		else System.out.println("Erro na conexão com o BD");	
	}
	
	
	public void insert(Processo processo) {

		String sql = "INSERT INTO processo("
				+ " `data_requisicao`, "
				+ " `obs`, "
				+ " `num_processo`,"
				+ " `assunto`, "
				+ " `parecer`, "
				+ " `interessado_id`, "
				+ " `servidor_id`)"
				+ "VALUES(?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setDate(1, null);
			stmt.setString(2, processo.getObs());
			stmt.setString(3, processo.getNumProcesso());
			stmt.setString(4, processo.getAssunto());
			stmt.setString(5, processo.getParecer());
			stmt.setInt(6, processo.getInteressado().getIdPessoa());
			stmt.setInt(7, processo.getServidor().getIdServidor());
			
			stmt.execute();
			stmt.close();
			
			//Ajeitar data
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public boolean update(Processo processo) {
		String sql = "update processo set"
				+ " `data_requisicao` = ?, "
				+ " `obs`=?, "
				+ " `num_processo`=?,"
				+ " `assunto`=?, "
				+ " `parecer`=?, "
				+ " `interessado_id`=?, "
				+ " `servidor_id`=? "
				+ "WHERE id_processo = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setDate(1, null);
			stmt.setString(2, processo.getObs());
			stmt.setString(3, processo.getNumProcesso());
			stmt.setString(4, processo.getAssunto());
			stmt.setString(5, processo.getParecer());
			stmt.setInt(6, processo.getInteressado().getIdPessoa());
			stmt.setInt(7, processo.getServidor().getIdServidor());
			stmt.setInt(8, processo.getIdProcesso());
			stmt.execute();
			stmt.close();
			return true;

		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return false;
	}
	
	public Processo getById(int idProcesso) {
		try {
			
			Processo processo = new Processo();
			
			String sql = "select * from processo where id_processo = ?"; //consertar
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idProcesso);
			
			ResultSet rs = stmt.executeQuery();
			
			List<Processo> processos = convertToList(rs);
			
			if (!processos.isEmpty()) {
				
				processo = processos.get(0);
				
			} 
			
			stmt.close();
			rs.close();
			
			return processo;

		} catch (Exception e) { 
			
			System.out.println("Exception is :" + e);
			
		}
		
		return null;

	}
	
	public List<Processo> convertToList(ResultSet rs)
			throws SQLException {

		List<Processo> processos = new ArrayList<Processo>();

		try {

			while (rs.next()) {

				Processo processo = new Processo();
				
				processo.setIdProcesso(rs.getInt("id_processo"));
				processo.setDataRequisicao(null); //consertar
				processo.setObs(rs.getString("obs"));
				processo.setNumProcesso(rs.getString("num_processo"));
				processo.setAssunto(rs.getString("assunto"));
				processo.setParecer(rs.getString("parecer"));
				
				// Interessado
				
				PessoaDAO p = new PessoaDAO();
				processo.setInteressado(p.getById(rs.getInt("interessado_id")));
				
				//Servidor
				
				ServidorDAO s = new ServidorDAO();
				processo.setServidor(s.getById(rs.getInt("servidor_id")));
				

				processos.add(processo);
			}

		} catch (SQLException sqle) {
			throw new RuntimeException(sqle);
		}

		return processos;
	}
	
	
	public List<Processo> find(Processo processo) throws SQLException {
		List<Processo> processos = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = String.format("%s '%%%s%%'",
							"SELECT     processo.id_processo, "
							        + " processo.`data_requisicao`, "
									+ " processo.`obs`, "
									+ " processo.`num_processo`,"
									+ " processo.`assunto`, "
									+ " processo.`parecer`,"
									+ " processo.servidor_id,"
									+ " processo.interessado_id "
									+ "FROM processo "
									+ "INNER JOIN pessoa interessado "
									+ "ON interessado.id_pessoa = processo.interessado_id "
						    + " WHERE interessado.matricula LIKE ",
							processo.getInteressado().getMatricula());
 
			stmt = (PreparedStatement) conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			processos = convertToList(rs);

		} catch (SQLException sqle) {
			throw new SQLException(sqle);
					
		} 

		return processos;
	}
	
	public List<Processo> getAll() throws SQLException {
		List<Processo> processos = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = String.format("%s",
						 "  SELECT    id_processo, "
						            + "`data_requisicao`, "
									+ " `obs`, "
									+ " `num_processo`,"
									+ " `assunto`, "
									+ " `parecer`,"
									+ " servidor_id,"
									+ " interessado_id "
									+ "FROM processo ");
			

			stmt = (PreparedStatement) conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			processos = convertToList(rs);
			
			stmt.close();
			rs.close();

		} catch (SQLException sqle) {
			throw new SQLException(sqle);
		} 

		return processos;
	}
	
	//Ver tanto os processos do servidor quanto de discente
	public List<Processo> consultarProcesso(Pessoa pessoa) throws SQLException {
		
		List<Processo> processos = null;
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {

			String sql = String
					.format("%s %s",
							"SELECT  processo.id_processo,"
							+ "processo.data_requisicao,"
							+ "processo.obs,"
							+ "processo.num_processo,"
							+ "processo.assunto,"
							+ "processo.parecer,"
							+ "pessoa.nome_pessoa,"
							+ "pessoa.matricula,"
							+ "processo.interessado_id, "
							+ "processo.servidor_id "
							+ "FROM processo "
							+ "INNER JOIN pessoa "
							+ "ON processo.interessado_id = pessoa.id_pessoa "
							+ "INNER JOIN servidor "
							+ "ON processo.servidor_id = servidor.id_servidor "
							+ "WHERE pessoa.matricula = ", pessoa.getMatricula());

			stmt = (PreparedStatement) conn.prepareStatement(sql);
			

			rs = stmt.executeQuery(sql);
			
			processos = convertToList(rs);
			
			
			stmt.close();
			rs.close();

		} catch (SQLException sqle) {
			
			sqle.printStackTrace();
			
		}
		return processos;
		
	}
	
	
	

}