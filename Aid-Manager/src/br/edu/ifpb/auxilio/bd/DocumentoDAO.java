package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifpb.auxilio.dominio.Documento;



public class DocumentoDAO{
private Connection conn;
	
	public DocumentoDAO(){
		conn = Conexao.getConnection();
		if(conn != null)
			System.out.println("Conexão estabelecida");
		else System.out.println("Erro na conexão com o BD");	
	}
	
	
	public void insert(Documento documento) {

		String sql = "INSERT INTO documento"
				+ " `nome_documento`, "
				+ " `status_documento`, "
				+ " `obs`,"
				+ " `discente_id`"
				+ "VALUES(?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, documento.getNomeDocumento() );
			stmt.setString(2, documento.getStatus());
			stmt.setString(3, documento.getObs());
			stmt.setInt(4, documento.getDiscente().getIdDiscente());
			
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public boolean update(Documento d) {
		String sql = "update documento set "
				+ "nome_documento = ?,"
				+ "status_Documento=?,"
				+ "obs=?,"
				+ "discente_id=?"
				+ "where id_documento=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, d.getNomeDocumento());
			stmt.setString(2, d.getStatus());
			stmt.setString(3, d.getObs());
			stmt.setInt   (4, d.getDiscente().getIdDiscente());
			stmt.setInt(5, d.getIdDocumento());
			
			
			stmt.execute();
			stmt.close();
			return true;

		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return false;
	}
	
	
	public int getIdDocumento(int idDiscente) {

		int idDocumento = 0;
		String sql = "select id_documento from documento where discente_id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idDiscente);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				idDocumento = rs.getInt("id_documento");
			}
			return idDocumento;
		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return 0;
	}
	
	
	public Documento getObject (int idDiscente){
		
		Documento documento = new Documento();
		String sql = "select * from documento where discente_id = ?";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idDiscente);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				documento.setNomeDocumento(rs.getString("nome_documento"));
				documento.setStatus(rs.getString("status_documento"));
				documento.setObs(rs.getString("obs"));
				//d.getDiscente().getIdDiscente());
				documento.setIdDocumento(rs.getInt("id_documento"));
				
			}
			return documento;
		}
		catch (Exception e){
			System.out.println("Exception is :"+e);
		}
		return null;
				
	}
}
