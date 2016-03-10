package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





import br.edu.ifpb.auxilio.dominio.Pessoa;

public class PessoaDAO implements GenericIFDAO<String,Pessoa> {

	
	private Connection conn;
	
	public PessoaDAO(){
		conn = Conexao.getConnection();
		if(conn != null)
			System.out.println("Conexão estabelecida");
		else System.out.println("Erro na conexão com o BD");	
	}
	
	
	
	public void insert(Pessoa pessoa) {

		String sql = "insert into pessoa ("
				+ "nome_pessoa,"
				+ "matricula,"
				+ "data_nasc,"
				+ "senha,"
				+ "email,"
				+ "cpf,"
				+ "rg,"
				+ "sexo)"
				+ "values (?,?,?,?,?,?,?,?)";
		try {
			// prepared statement para inserção
			PreparedStatement stmt = conn.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, pessoa.getNomePessoa());
			stmt.setString(2, pessoa.getMatricula());
			stmt.setDate(3, (java.sql.Date) pessoa.getDataNasc());
			stmt.setString(4, pessoa.getSenha());
			stmt.setString(5, pessoa.getEmail());
			stmt.setString(6, pessoa.getCpf());
			stmt.setString(7, pessoa.getRg());
			stmt.setString(8, pessoa.getSexo());

			// executa
			stmt.execute();
			stmt.close();
			System.out.println("Cadastrado com sucesso!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public int getIdPessoa(String matricula){
		
		int idPessoa = 0; 
		String sql = "select id_pessoa from pessoa where matricula = ?";
		try{
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,matricula);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			 idPessoa = rs.getInt("idPessoa");
			}
		return idPessoa;
		}catch(Exception e){
		System.out.println("Exception is :"+e);
		}
		return 0;
     }
	
	public Pessoa getObject (int idPessoa){
		
		Pessoa pessoa = new Pessoa();
		String sql = "select * from pessoa where id_pessoa = ?";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idPessoa);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				pessoa.setIdPessoa(rs.getInt("id_pessoa"));
				pessoa.setNomePessoa(rs.getString("nome_pessoa"));
				pessoa.setRg(rs.getString("rg"));
				pessoa.setMatricula(rs.getString("matricula"));
				pessoa.setDataNasc(null); //Consertar
				pessoa.setSexo(rs.getString("sexo"));
				pessoa.setSenha(rs.getString("senha"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setCpf(rs.getString("cpf"));
			}
			return pessoa;
		}
		catch (Exception e){
			System.out.println("Exception is :"+e);
		}
		return null;
				
	}
	public void delete (String matricula){
		
		String sql =  "delete from pessoa where matricula = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, matricula);	
			System.out.println("Deletado com sucesso!");
					
		}catch(Exception e){
			System.out.println("Exception is :"+e);
		}
	}
	
	public boolean update(Pessoa p) {
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
			stmt.setDate(4, (java.sql.Date) p.getDataNasc());
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

}
