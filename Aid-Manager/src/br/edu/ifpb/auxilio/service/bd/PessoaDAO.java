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

public class PessoaDAO {

	
	private Connection conn;
	
	public PessoaDAO(){
		conn = Conexao.getConnection();
		if(conn != null)
			System.out.println("ConexÃ£o estabelecida");
		else System.out.println("Erro na conexÃ£o com o BD");	
	}
	
	
	
	public int insert(Pessoa pessoa) throws SQLException {
		
		int idPessoa;

		String sql = String
				.format("%s %s ('%s', '%s','%s', '%s','%s','%s','%s','%s')",
				"INSERT INTO pessoa("
				+ " nome_pessoa,"
				+ " matricula,"
				+ " data_nasc,"
				+ " senha,"
				+ " email,"
				+ " cpf,"
				+ " rg,"
				+ " sexo)",
				"VALUES",
				pessoa.getNomePessoa(),
				pessoa.getMatricula(),
				new java.sql.Date(pessoa.getDataNasc().getTime()),
				pessoa.getSenha(),
				pessoa.getEmail(),
				pessoa.getCpf(),
				pessoa.getRg(),
				pessoa.getSexo());
		try {
			// prepared statement para inserÃ§Ã£o
			PreparedStatement stmt = conn.prepareStatement(sql);

			// seta os valores
			
			
			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			
			idPessoa = BancoUtil.getGenerateKey(stmt);

			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
          return idPessoa;
	}

	
	public Pessoa getById (int idPessoa) throws SQLException{
		
		Pessoa pessoa = new Pessoa();
		
		String sql = "select * from pessoa where id_pessoa = ?";
		
		try{
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idPessoa);

			ResultSet rs = stmt.executeQuery();
			
			List<Pessoa> pessoas = convertToList(rs);
			
			if (!pessoas.isEmpty()) {
				
				pessoa = pessoas.get(0);
				
			} 

			
			return pessoa;
		}
		catch (Exception e){
			
			System.out.println("Exception is :"+e);
			
		}
		
		return null;
				
	}
	public void delete (String matricula) throws SQLException{
		
		String sql =  "delete from pessoa where matricula = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, matricula);	
			System.out.println("Deletado com sucesso!");
					
		}catch(Exception e){
			System.out.println("Exception is :"+e);
		}
	}
	
	public boolean update(Pessoa p) throws SQLException{
		String sql = "update pessoa set "
				+ "nome_pessoa = ? ,"
				+ "rg = ?,"
				+ "matricula= ?,"
				+ "data_nasc=?,"
				+ "sexo=?,"
				+ "senha=?,"
				+ "email=?,"
				+ "cpf=? "
				+ "WHERE id_pessoa = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, p.getNomePessoa());
			stmt.setString(2, p.getRg());
			stmt.setString(3, p.getMatricula());
			stmt.setDate  (4,  new java.sql.Date(p.getDataNasc().getTime()));
			stmt.setString(5, p.getSexo());
			stmt.setString(6, p.getSenha());
			stmt.setString(7, p.getEmail());
			stmt.setString(8, p.getCpf());
			stmt.setInt(9, p.getIdPessoa());
			stmt.execute();
			return true;

		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return false;
	}
	
	
	
	public List<Pessoa> convertToList(ResultSet rs)
			throws SQLException {

		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		try {

			while (rs.next()) {

				Pessoa pessoa = new Pessoa();
				
				pessoa.setIdPessoa(rs.getInt("id_pessoa"));
				pessoa.setNomePessoa(rs.getString("nome_pessoa"));
				pessoa.setRg(rs.getString("rg"));
				pessoa.setMatricula(rs.getString("matricula"));
				pessoa.setDataNasc(rs.getDate("data_nasc")); 
				pessoa.setSexo(rs.getString("sexo"));
				pessoa.setSenha(rs.getString("senha"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setCpf(rs.getString("cpf"));
				
				
				

				pessoas.add(pessoa);
			}

		} catch (SQLException sqle) {
			
		}

		return pessoas;
	}
	//Verificar se a matricula já existe
	public boolean isMatriculaCadastrada(String matricula) throws SQLException {
		
		boolean isMatriculaCadastrada = false;

		PreparedStatement stmt = null;
		
		ResultSet rs = null;

		try {

			String sql = String
					.format("%s '%s'",
							"SELECT count(pessoa.id_pessoa) AS quant_pessoas "
								+ " FROM pessoa pessoa"
								+ " WHERE pessoa.matricula =",
							matricula);

			stmt = (PreparedStatement) conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql);
			
			int rowCount = rs.last() ? rs.getInt("quant_pessoas") : 0; 
			
			isMatriculaCadastrada = (rowCount != 0);

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} 
		
		return isMatriculaCadastrada;
	}
	
  public boolean isEmailCadastrado(String email) throws SQLException {
		
		boolean isEmailCadastrado = false;

		PreparedStatement stmt = null;
		
		ResultSet rs = null;

		try {

			String sql = String
					.format("%s '%s'",
							"SELECT count(pessoa.id_pessoa) AS quant_pessoas "
								+ " FROM pessoa pessoa"
								+ " WHERE pessoa.email =",
							email);

			stmt = (PreparedStatement) conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql);
			
			int rowCount = rs.last() ? rs.getInt("quant_pessoas") : 0; 
			
			isEmailCadastrado = (rowCount != 0);

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} 
		
		return isEmailCadastrado;
	}
	
	public List<Pessoa> find(Pessoa pessoa) throws SQLException {
		List<Pessoa> pessoas = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = String.format("%s '%%%s%%'",
							"SELECT   id_pessoa,  "
							        + "nome_pessoa, "
									+ "rg, "
									+ "matricula, "
									+ "data_nasc, "
									+ "sexo, "
									+ "senha, "
									+ "email, "
									+ "cpf "
									+ "FROM pessoa "
						    + " WHERE pessoa.matricula LIKE ",
							pessoa.getMatricula());
 
			stmt = (PreparedStatement) conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			pessoas = convertToList(rs);

		} catch (SQLException sqle) {
			throw new SQLException(sqle);
					
		} 

		return pessoas;
	}
	
	public List<Pessoa> getAll() throws SQLException {
		List<Pessoa> pessoas = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = String.format("%s",
						 "  SELECT    id_pessoa,  "
						            + "nome_pessoa,"
									+ "rg,"
									+ "matricula,"
									+ "data_nasc,"
									+ "sexo,"
									+ "senha,"
									+ "email,"
									+ "cpf "
									+ "FROM pessoa"); 

			stmt = (PreparedStatement) conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			pessoas = convertToList(rs);

		} catch (SQLException sqle) {
			throw new SQLException(sqle);
		} 

		return pessoas;
	}

}
