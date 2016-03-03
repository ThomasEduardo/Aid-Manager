package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
				+ " `idResultados`, "
				+ " `tipoAuxilio`"
				+ "VALUES(?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, resultados.getIdResultados());
			stmt.setString(2, resultados.getTipoAuxilio() );
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
