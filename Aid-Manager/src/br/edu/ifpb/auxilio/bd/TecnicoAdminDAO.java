package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import br.edu.ifpb.auxilio.dominio.TecnicoAdmin;

public class TecnicoAdminDAO extends ServidorDAO{
	
	/*Obs: A classe não têm o metodo Update porque o único atributo dela
	é o id,que não é conhecido pelo usuário.*/
	
	private Connection conn;
	
	public TecnicoAdminDAO() {
		conn = Conexao.getConnection();
		if (conn != null)
			System.out.println("Conexão estabelecida");
		else
			System.out.println("Erro na conexão com o BD");
	}

	public void insert(TecnicoAdmin tecnicoAdmin) {

		String sql = "insert into tecnicoAdmin (idServidor)values (?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, super.getIdServidor(tecnicoAdmin.getMatricula()));
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public TecnicoAdmin getObject(String matricula) {
		try {
			TecnicoAdmin tecnicoAdmin = new TecnicoAdmin();
			String sql = "select * from tecnicoAdmin where idServidor = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, super.getIdServidor(matricula));
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				tecnicoAdmin.setIdTecnicoAdmin(rs.getInt("idTecnicoAdmin"));
			}
			stmt.close();
			rs.close();

			return tecnicoAdmin;

		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return null;

	}
	
	/*public void delete(String matricula) {

	}*/
  
		
}
	


