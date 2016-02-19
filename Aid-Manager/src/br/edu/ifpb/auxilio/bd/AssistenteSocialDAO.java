package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifpb.auxilio.dominio.AssistenteSocial;


public class AssistenteSocialDAO extends ServidorDAO{
	
	private Connection conn;

	/*Obs: A classe n�o t�m o metodo Update porque o �nico atributo dela
	� o id,que n�o � conhecido pelo usu�rio.*/
	
	
	public AssistenteSocialDAO() {
		conn = Conexao.getConnection();
		if (conn != null)
			System.out.println("Conex�o estabelecida");
		else
			System.out.println("Erro na conex�o com o BD");
	}
	
	public void insert(AssistenteSocial as) {
	
		String sql = "insert into assistentesocial (idServidor)values (?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1,super.getIdServidor(as.getMatricula()));
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public AssistenteSocial getObject(String matricula){
		try{
		AssistenteSocial as = new AssistenteSocial();
		String sql = "select * from assistenteSocial where idServidor = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, super.getIdServidor(matricula));
		ResultSet rs = stmt.executeQuery();
		while (rs.next()){
           as.setId_assistenteSocial(rs.getInt("idAssistenteSocial"));			
		}
		stmt.close();
		rs.close();
		return as;
        
	}
		catch (Exception e){
			System.out.println("Exception is :"+e);
		}
		return null;
		
		
	}
	
	 public void delete(String matricula){
		 
		 
		 /*Delete From servidor idServidor = idServidor,j� que o trigger 
		 ficar� respons�vel por eliminar as camadas inferiores.*/
		 
		}
			
	
	

}
