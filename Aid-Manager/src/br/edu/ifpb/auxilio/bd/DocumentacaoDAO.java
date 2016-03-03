package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.ifpb.auxilio.dominio.Documentacao;

public class DocumentacaoDAO {
private Connection conn;
	
	public DocumentacaoDAO(){
		conn = Conexao.getConnection();
		if(conn != null)
			System.out.println("Conexão estabelecida");
		else System.out.println("Erro na conexão com o BD");	
	}
	
	
	public void insert(Documentacao documentacao) {

		String sql = "INSERT INTO documentacao"
				+ " `idDocumentacao`, "
				+ " `nomeDocumentacao`, "
				+ " `status`, "
				+ " `obs`,"
				+ " `discente`"
				+ "VALUES(?,?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, documentacao.getIdDocumentacao());
			stmt.setString(2, documentacao.getNomeDocumentacao() );
			stmt.setString(3, documentacao.getStatus());
			stmt.setString(4, documentacao.getObs());
			stmt.setInt(5, documentacao.getDiscente().getIdDiscente());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
