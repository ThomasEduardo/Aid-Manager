package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.ifpb.auxilio.dominio.Edital;

public class EditalDAO {
private Connection conn;
	
	public EditalDAO(){
		conn = Conexao.getConnection();
		if(conn != null)
			System.out.println("Conexão estabelecida");
		else System.out.println("Erro na conexão com o BD");	
	}
	
	
	public void insert(Edital edital) {

		String sql = "INSERT INTO edital"
				+ " `tipoAuxilio`, "
				+ " `valorAuxilio`, "
				+ " `validadeInicial`, "
				+ " `validadeFinal`,"
				+ " `idInstituicaoFinanciadora`, "
				+ " `idTecnicoAdmin`, "
				+ " `idProcesso`, "
				+ " `idProcesso`, "
				+ " `idProcesso`, "
				+ " `idProcesso`, "
				+ " `idDiscente`"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, edital.getIdEdital());
			stmt.setDate(2, edital.getIniInscricoes() );
			stmt.setDate(3, edital.getFimInscricoes());
			stmt.setDate(4, edital.getIniEntregaForm());
			stmt.setInt(5, edital.getAno());
			stmt.setDate(6, edital.getFimForm());
			stmt.setString(7, edital.getDescricao());
			stmt.setString(8, edital.getTitulo());
			stmt.setDouble(9, edital.getValorBolsaDiscente());
			stmt.setInt(10, edital.getVagasBolsistas());
			stmt.setString(11, edital.getNumEdital());
			stmt.execute();
			stmt.close();
			
			//Ajeitar datas
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
