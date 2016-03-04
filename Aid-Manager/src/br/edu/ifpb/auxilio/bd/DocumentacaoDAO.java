package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
				+ " `nomeDocumentacao`, "
				+ " `status_Documento`, "
				+ " `obs`,"
				+ " `idDiscente`"
				+ "VALUES(?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, documentacao.getNomeDocumentacao() );
			stmt.setString(2, documentacao.getStatus());
			stmt.setString(3, documentacao.getObs());
			stmt.setInt(4, documentacao.getDiscente().getIdDiscente());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public boolean update(Documentacao d) {
		String sql = "update pessoa set "
				+ "nomeDocumentacao = ?,"
				+ "status_Documento=?,"
				+ "obs=?,"
				+ "idDiscente=?"
				+ "where idDocumentacao=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, d.getNomeDocumentacao());
			stmt.setString(2, d.getStatus());
			stmt.setString(3, d.getObs());
			stmt.setInt   (4, d.getDiscente().getIdDiscente());
			stmt.setInt(5, d.getIdDocumentacao());
			stmt.execute();
			stmt.close();
			return true;

		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return false;
	}
	
	
	public int getIdDocumentacao(int idDiscente) {

		int idDocumentacao = 0;
		String sql = "select idDocumentacao from documentacao where idDiscente = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idDiscente);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				idDocumentacao = rs.getInt("idDocumentacao");
			}
			return idDocumentacao;
		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return 0;
	}
	
	
	public Documentacao getObject (int idDiscente){
		
		Documentacao documentacao = new Documentacao();
		String sql = "select * from documentacao where idDiscente = ?";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idDiscente);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				documentacao.setNomeDocumentacao(rs.getString("nomeDocumentacao"));
				documentacao.setStatus(rs.getString("status_Documento"));
				documentacao.setObs(rs.getString("obs"));
				//d.getDiscente().getIdDiscente());
				documentacao.setIdDocumentacao(rs.getInt("idDocumentacao"));
				
			}
			return documentacao;
		}
		catch (Exception e){
			System.out.println("Exception is :"+e);
		}
		return null;
				
	}
}
