package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.ifpb.auxilio.dominio.ResidentesMoradia;
import br.edu.ifpb.auxilio.dominio.Resultados;

public class ResultadosDAO {
	private Connection conn;
	
	public ResultadosDAO(){
		conn = Conexao.getConnection();
		if(conn != null)
			System.out.println("Conexão estabelecida");
		else System.out.println("Erro na conexão com o BD");	
	}
	
	
	public void insert(Resultados resultados) {

		String sql = "INSERT INTO resultados"
				+ " `tipoAuxilio`"
				+ " `idProcesso`"
				+ "VALUES(?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, resultados.getTipoAuxilio());
			stmt.setInt   (2, resultados.getIdProcesso());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public boolean update(Resultados resultados) {
		String sql = "update resultados set"
				+ " `tipoAuxilio` =?"
				+ " `idProcesso`=?"
				+ "  WHERE idResultados = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, resultados.getTipoAuxilio());
			stmt.setInt(2, resultados.getIdProcesso());
			stmt.setInt(3, resultados.getIdResultados());
			stmt.execute();
			stmt.close();
			return true;
	
		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return false;
	}
	
}
