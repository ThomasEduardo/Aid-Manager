package br.edu.ifpb.auxilio.bd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifpb.auxilio.dominio.Servidor;

public class ServidorDAO extends PessoaDAO{
	
	private Connection conn;
	
	public ServidorDAO(){
		conn = Conexao.getConnection();
		if(conn != null)
			System.out.println("Conexão estabelecida");
		else System.out.println("Erro na conexão com o BD");	
	}
	
	public void insert(Servidor servidor) {

		String sql = "insert into servidor (cargoServidor,idPessoa)values (?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, servidor.getCargoServidor());
			stmt.setInt(2, getIdPessoa(servidor.getMatricula()));
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
    public int getIdServidor(String matricula) {

		int idServidor = 0;
		String sql = "select idServidor from servidor where idPessoa = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, super.getIdPessoa(matricula));
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				idServidor = rs.getInt("idServidor");
			}
			return idServidor;
		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return 0;
	}
	
	 public void delete(String matricula){
		String sql =  "delete from servidor where idPessoa = ?";
		
		try{
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, super.getIdPessoa(matricula));	
			st.execute();	
			st.close();
		}catch(Exception e){
			System.out.println("Exception is :"+e);
		}
	 }
		
		
		
}


