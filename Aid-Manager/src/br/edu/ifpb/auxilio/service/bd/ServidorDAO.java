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
import br.edu.ifpb.auxilio.entidade.Servidor;
// Atualizar atributos
public class ServidorDAO{
	//Precisa testar
	private Connection conn;
	
	public ServidorDAO(){
		conn = Conexao.getConnection();
		if(conn != null)
			System.out.println("Conexão estabelecida");
		else System.out.println("Erro na conexão com o BD");	
	}
	
	public void insert(Servidor servidor) {

		String sql = "insert into servidor ("
				+ "cargo_servidor,"
				+ "pessoa_id)"
				+ "values (?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, servidor.getCargoServidor());
			stmt.setInt   (2, servidor.getIdPessoa());
			
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	

	
	public Servidor getById(int idServidor) {
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
    
    
	 public void delete(String matricula){

	 }
	 
	public List<Servidor> find(Servidor servidor) throws SQLException {
			List<Servidor> servidores = null;

			PreparedStatement stmt = null;
			ResultSet rs = null;

			try {

				String sql = String.format("%s '%%%s%%'",
								"SELECT  cargo_servidor"
										+ "FROM servidor"
										+ "INNER JOIN pessoa"
										+ "ON pessoa.id_pessoa = servidor.pessoa_id"
							    + " WHERE pessoa.matricula LIKE",
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
			
			
		
		
}

