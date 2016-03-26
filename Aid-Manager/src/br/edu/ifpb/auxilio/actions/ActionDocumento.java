package br.edu.ifpb.auxilio.actions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.auxilio.entidade.Documento;
import br.edu.ifpb.auxilio.service.bd.DocumentoDAO;



public class ActionDocumento {
	
	private DocumentoDAO d;
	
	public int insert(Documento documento) throws SQLException {
		try{
			
			return d.insert(documento);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return 0;


	}
	
	public boolean update(Documento documento) throws SQLException{
		try{
			
			return d.update(documento);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return false;
		
	}
	public Documento getById (int idDocumento)throws SQLException{
		
		try{
			
			return d.getById(idDocumento);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
	}
	public List<Documento> convertToList(ResultSet rs)
			throws SQLException {
		try{
			
			return d.convertToList(rs);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
	}
	public List<Documento> getAll() throws SQLException {
		try{
			
			return d.getAll();
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
	}
	
	
	public List<Documento> find(Documento documento) throws SQLException { 
		
		try{
			
			return d.find(documento);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
	}
	
			
}
