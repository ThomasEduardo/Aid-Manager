package br.edu.ifpb.auxilio.bd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.ifpb.auxilio.bd.Conexao;
import br.edu.ifpb.auxilio.dominio.Auxilio;


public class AuxilioDAO {
	
private Connection conn;
	
	public AuxilioDAO(){
		conn = Conexao.getConnection();
		if(conn != null)
			System.out.println("Conexão estabelecida");
		else System.out.println("Erro na conexão com o BD");	
	}
	
	
	public void insert(Auxilio auxilio) {

		String sql = "INSERT INTO auxilio "
				+ " `tipoAuxilio`, "
				+ " `valorAuxilio`, "
				+ " `validadeInicial`, "
				+ " `validadeFinal`,"
				+ " `idInstituicaoFinanciadora`, "
				+ " `idTecnicoAdmin`, "
				+ " `idProcesso`, "
				+ " `idDiscente`"
				+ "VALUES(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, auxilio.getTipoAuxilio());
			stmt.setDouble(2, auxilio.getValorAuxilio() );
			stmt.setDate  (3, auxilio.getValidadeInicial());
			stmt.setDate  (4, auxilio.getValidadeFinal());
			stmt.setInt   (5, auxilio.getIF().getIdIF());
			stmt.setInt   (6, auxilio.getT().getIdTecnicoAdmin());
			stmt.setInt   (7, auxilio.getP().getIdProcesso());
			stmt.setInt   (8, auxilio.getDiscente().getIdDiscente());
			stmt.execute();
			stmt.close();
			
			//Ajeitar datas
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	

}
