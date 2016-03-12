package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

		String sql = "INSERT INTO documento("
				+ " `nome_documento`, "
				+ " `status_documento`, "
				+ " `obs`,"
				+ " `discente_id`)"
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
				+ "status_documento = ?,"
				+ "obs = ?,"
				+ "discente_id = ? "
				+ "WHERE id_documento=? ";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, d.getNomeDocumento());
			stmt.setString(2, d.getStatus());
			stmt.setString(3, d.getObs());
			stmt.setInt   (4, d.getDiscente().getIdDiscente());
			stmt.setInt   (5, d.getIdDocumento());
			
			
			stmt.execute();
			stmt.close();
			return true;

		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return false;
		
		
	}
	
	
	
	
	public Documento getById (int idDocumento){
		

	    Documento documento = new Documento();
	    
		String sql = "select * from documento where id_documento = ?";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idDocumento);
			ResultSet rs = stmt.executeQuery();
			
			List<Documento> documentos = convertToList(rs);
			
			if (!documentos.isEmpty()) {
				documento = documentos.get(0);
			}
			
		}
		catch (Exception e){
			System.out.println("Exception is :"+e);
		}
		return documento;
				
	}
	
	public List<Documento> convertToList(ResultSet rs)
			throws SQLException {

		List<Documento> documentos = new ArrayList<Documento>();

		try {

			while (rs.next()) {

				Documento documento = new Documento();
				
				documento.setNomeDocumento(rs.getString("nome_documento"));
				documento.setStatus(rs.getString("status_documento"));
				documento.setObs(rs.getString("obs"));
				documento.setIdDocumento(rs.getInt("id_documento"));
				
				
				// Discente
				
				DiscenteDAO d = new DiscenteDAO();
				documento.setDiscente(d.getById(rs.getInt("discente_id")));
				

				documentos.add(documento);
			}

		} catch (SQLException sqle) {
		
			System.out.println("Exception is :"+sqle);
		}

		return documentos;
	}
	
	
}
