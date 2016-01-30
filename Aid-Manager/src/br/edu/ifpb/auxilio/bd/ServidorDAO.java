package br.edu.ifpb.auxilio.bd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifpb.auxilio.dominio.Servidor;

public class ServidorDAO {
	
private Connection conn;
	
	public ServidorDAO(){
		conn = Conexao.getConnection();
		if(conn != null)
			System.out.println("Conex�o estabelecida");
		else System.out.println("Erro na conex�o com o BD");	
	}
	
	
	
	public void Cadastrar(Servidor servidor) {

		String sql = "insert into servidor (cargoServidor,idPessoa)values (?,?)";
		try {
			// prepared statement para inser��o
			PreparedStatement stmt = conn.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, servidor.getCargoServidor());
			stmt.setInt(2, getIdPessoa(servidor.getMatricula()));
			//Buscar informa��es sobre isso.

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
		String sql = "select idPessoa from pessoa where matricula = ?";
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
		
		
		}
	


