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

		String sql = "insert into servidor ("
				+ "cargo_servidor,"
				+ "tipo_pessoa,"
				+ "pessoa_id)"
				+ "values (?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, servidor.getCargoServidor());
			stmt.setString(2, servidor.getTipoServidor());
			stmt.setInt(3, getIdPessoa(servidor.getMatricula()));
			
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
    public int getIdServidor(String matricula) {

		int idServidor = 0;
		String sql = "select id_servidor from servidor where pessoa_id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, super.getIdPessoa(matricula));
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				idServidor = rs.getInt("id_servidor");
			}
			return idServidor;
		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return 0;
	}
	
	 public void delete(String matricula){
		String sql =  "delete from servidor where pessoa_id = ?";
		
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


