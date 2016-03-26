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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.auxilio.entidade.Pessoa;
import br.edu.ifpb.auxilio.entidade.Servidor;
// Atualizar atributos
public class ServidorDAO{
	//Precisa testar
	private Connection conn;
	
	public ServidorDAO(){
		conn = Conexao.getConnection();
		if(conn != null)
			System.out.println("ConexÃ£o estabelecida");
		else System.out.println("Erro na conexÃ£o com o BD");	
	}
	
	public int insert(Servidor servidor) throws SQLException {
		
		int idServidor;
		
		

		String sql = "insert into servidor ("
				+ "cargo_servidor,"
				+ "pessoa_id)"
				+ "values (?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, servidor.getCargoServidor());
			stmt.setInt   (2, servidor.getIdPessoa());
			
			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			
			idServidor = BancoUtil.getGenerateKey(stmt);
			
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return idServidor;
	}
	

	
	public Servidor getById(int idServidor) throws SQLException  {
		try {
			
			Servidor servidor = new Servidor();
			
			String sql = "select * from servidor where id_servidor = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idServidor);
			
			ResultSet rs = stmt.executeQuery();
			
			List<Servidor> servidores = convertToList(rs);
			
			if (!servidores.isEmpty()) {
				
				servidor = servidores.get(0);
				
			} 
			
			stmt.close();
			rs.close();
			
			return servidor;

		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		
		return null;

	}
	
	
	public List<Servidor> convertToList(ResultSet rs)
			throws SQLException {

		List<Servidor> servidores = new ArrayList<Servidor>();

		try {

			while (rs.next()) {

				Servidor servidor = new Servidor();
				
				servidor.setIdServidor(rs.getInt("id_servidor"));
				servidor.setCargoServidor(rs.getString("cargo_servidor"));
				
				//Pessoa
				
				PessoaDAO p = new PessoaDAO();
				Pessoa pessoa = p.getById(rs.getInt("pessoa_id"));
	            
				servidor.setIdPessoa(pessoa.getIdPessoa());
				servidor.setNomePessoa(pessoa.getNomePessoa());
				servidor.setCpf(pessoa.getCpf());
				servidor.setEmail(pessoa.getEmail());
				servidor.setDataNasc(pessoa.getDataNasc());
				servidor.setMatricula(pessoa.getMatricula());
				servidor.setRg(pessoa.getRg());
				servidor.setSexo(pessoa.getSexo());
				servidor.setSenha(pessoa.getSenha());
				
				
				

				servidores.add(servidor);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
	}

		return servidores;
	}
    
    
	 public void delete(int idServidor)throws SQLException{
			String sql = "DELETE FROM servidor where id_servidor = "+idServidor;
		 try{
			 PreparedStatement stmt = conn.prepareStatement(sql);
			 stmt.execute();
			 stmt.close();
		 }
		 catch(SQLException e){
			 e.printStackTrace();
		 }

	 }
	 
	public List<Servidor> find(Servidor servidor) throws SQLException {
			List<Servidor> servidores = null;

			PreparedStatement stmt = null;
			ResultSet rs = null;

			try {

				String sql = String.format("%s '%%%s%%'",
								"SELECT  id_servidor, "
								        + "cargo_servidor, "
								        + "pessoa_id "
										+ "FROM servidor "
										+ "INNER JOIN pessoa "
										+ "ON pessoa.id_pessoa = servidor.pessoa_id "
							    + " WHERE pessoa.matricula LIKE ",
								servidor.getMatricula());
	 
				stmt = (PreparedStatement) conn.prepareStatement(sql);

				rs = stmt.executeQuery(sql);

				servidores = convertToList(rs);

			} catch (SQLException sqle) {
				throw new SQLException(sqle);
						
			} 

			return servidores;
		}
		
		public List<Servidor> getAll() throws SQLException {
			List<Servidor> servidores = null;

			PreparedStatement stmt = null;
			ResultSet rs = null;

			try {

				String sql = String.format("%s",
							 "  SELECT    cargo_servidor,"
								+ "FROM servidor"); 

				stmt = (PreparedStatement) conn.prepareStatement(sql);

				rs = stmt.executeQuery(sql);

				servidores = convertToList(rs);

			} catch (SQLException sqle) {
				throw new SQLException(sqle);
			} 

			return servidores;
		}
		
		
		
		
		public int qtdeDiscentesCadastrados() throws SQLException {

			int qtdeDiscentes = 0;
			
			PreparedStatement stmt = null;
			ResultSet rs = null;

			try {

				String sql = String
						.format("%s",
								"SELECT count(id_discente) quantidade_discentes_cadastrados from discente ");

				stmt = (PreparedStatement) conn.prepareStatement(sql);

				rs = stmt.executeQuery(sql);
				

					while (rs.next()) {
						
						qtdeDiscentes = rs.getInt("quantidade_discentes_cadastrados");
					}

				stmt.close();
				rs.close();

			} catch (SQLException sqle) {
				throw new SQLException(sqle);
						
			} 

			return qtdeDiscentes;
			
		}
		
		  /**
		    * Função que retorna o id do servidor,atráves da matrícula fornecida
		    * @author Fanny
		    * 
		    * */	
		
		 public int getId(String matricula) throws SQLException {
				
				int idServidor  = 0;
				
				PessoaDAO p = new PessoaDAO();
			

				PreparedStatement stmt = null;
				ResultSet rs = null;

				try {
					
					String sql = String 
							.format("%s '%s'",
							"SELECT id_servidor from servidor where "
							+ "pessoa_id = ",
							 p.getId(matricula));

					stmt = (PreparedStatement) conn.prepareStatement(sql);

					rs = stmt.executeQuery(sql);

					while (rs.next()) {
		               idServidor = rs.getInt("id_servidor");
					}

				} catch (SQLException sqle) {

					sqle.printStackTrace();

				} 
				
				return idServidor;
			}
		 
		 public boolean update(Servidor s) throws SQLException{
				String sql = "update servidor set "
						+ "cargo_servidor = ? "
						+ "WHERE id_servidor = ?";
				try {
					PreparedStatement stmt = conn.prepareStatement(sql);
					
					stmt.setString(1, s.getCargoServidor());
					stmt.setInt(2, s.getIdServidor());
					
					stmt.execute();
					return true;

				} catch (Exception e) {
					System.out.println("Exception is :" + e);
				}
				return false;
			}
			
			
			
		
		
}


