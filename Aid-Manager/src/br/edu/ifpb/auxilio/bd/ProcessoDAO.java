package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

			//stmt.setDate(1, processo.getDataRequisicao() );
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
				+ " `servidor_id`=?,"
				+ "WHERE id_processo = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			//stmt.setDate(1, processo.getDataRequisicao() );
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
	
}