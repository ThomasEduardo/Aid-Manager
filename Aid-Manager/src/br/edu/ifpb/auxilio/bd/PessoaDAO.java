package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import br.edu.ifpb.auxilio.dominio.Pessoa;

public class PessoaDAO {

	
	private Connection conn;
	
	public PessoaDAO(){
		conn = Conexao.getConnection();
		if(conn != null)
			System.out.println("Conexão estabelecida");
		else System.out.println("Erro na conexão com o BD");	
	}
	
	
	
	public void Cadastrar(Pessoa pessoa) {

		String sql = "insert into pessoa (nomePessoa,matricula,dataNasc,senha,email,cpf,rg,sexo)values (?,?,?,?,?,?,?,?)";
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
	
	
	public void remover (String matricula){
		
		String sql =  "delete from pessoa where matricula = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, matricula);	
			System.out.println("Deletado com sucesso!");
					
		}catch(Exception e){
			System.out.println("Exception is :"+e);
		}
		
		
		
	}
	
}
