package br.edu.ifpb.auxilio.actions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.auxilio.entidade.Documento;
import br.edu.ifpb.auxilio.service.bd.DocumentoDAO;



public class ActionDocumento {
	
	private DocumentoDAO d;
	
	public int insert(Documento documento) throws SQLException {
		return d.insert(documento);

	}
	
	public boolean update(Documento d) throws SQLException{
		
	}
	public Documento getById (int idDocumento)throws SQLException{
		
	}
	public List<Documento> convertToList(ResultSet rs)
			throws SQLException {
		
	}
	public List<Documento> getAll() throws SQLException {
		
	}
	public List<Documento> find(Documento documento) throws SQLException { 
		
	}
	
			
}
