package br.edu.ifpb.auxilio.bd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.auxilio.dominio.Familiar;
import br.edu.ifpb.auxilio.dominio.Processo;
import br.edu.ifpb.auxilio.dominio.Servidor;

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
				+ "tipo_pessoa,"
				+ "pessoa_id)"
				+ "values (?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, servidor.getCargoServidor());
			stmt.setString(2, servidor.getTipoServidor());
			stmt.setInt(3, servidor.getIdPessoa());
			
			
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
				servidor.setTipoServidor(rs.getString("tipo_servidor"));
				
				/*Pessoa
				
				PessoaDAO p = new PessoaDAO();
	            setPs(p.getById(rs.getInt("perfil_socio_id")));*/
				
				
				

				servidores.add(servidor);
			}

		} catch (SQLException sqle) {
			
	}

		return servidores;
	}
    
    
	 public void delete(String matricula){

	 }
		
		
		
}


