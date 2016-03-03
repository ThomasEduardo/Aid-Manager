package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.ifpb.auxilio.dominio.ResidentesMoradia;

public class ResidentesMoradiaDAO {
	
	private Connection conn;
	
	public ResidentesMoradiaDAO(){
		conn = Conexao.getConnection();
		if(conn != null)
			System.out.println("Conexão estabelecida");
		else System.out.println("Erro na conexão com o BD");	
	}
	
	
	public void insert(ResidentesMoradia resMoradia) {

		String sql = "INSERT INTO residentesMoradia"
				+ " `idRm`, "
				+ " `residentes`, "
				+ " `ps`"
				+ "VALUES(?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, resMoradia.getIdRm());
			stmt.setString(2, resMoradia.getResidentes());
			stmt.setInt(3, resMoradia.getPs().getIdPerfilSocio());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
