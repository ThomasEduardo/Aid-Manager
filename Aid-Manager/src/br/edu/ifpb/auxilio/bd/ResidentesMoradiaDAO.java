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
				+ " `residentes`, "
				+ " `idPerfilSocio`"
				+ "VALUES(?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);


			stmt.setString(1, resMoradia.getResidentes());
			stmt.setInt(2, resMoradia.getPs().getIdPerfilSocio());
			
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}


	public boolean update(ResidentesMoradia rm) {
		String sql = "update residentesMoradia set"
				+ " `residentes` =?, "
				+ " `idPerfilSocio`=?"
				+ "  WHERE idResidentesMoradia = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, rm.getResidentes());
			stmt.setInt(2, rm.getPs().getIdPerfilSocio());
			stmt.setInt(3, rm.getIdRm());
			stmt.execute();
			stmt.close();
			return true;
	
		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return false;
	}
	

}
