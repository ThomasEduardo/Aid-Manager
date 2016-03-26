package br.edu.ifpb.auxilio.actions;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.auxilio.entidade.Discente;
import br.edu.ifpb.auxilio.service.bd.DiscenteDAO;



public class ActionDiscente {
	
	private DiscenteDAO d;
	
	public int insert(Discente discente) throws SQLException {

		try{
			
			return d.insert(discente);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return 0;
		
	}
	
	public boolean update(Discente discente)throws SQLException{
		
		try{
			
			return d.update(discente);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return false;
		
	}
	public Discente getById(int idDiscente)throws SQLException{
		
		try{
			
			return d.getById(idDiscente);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
	}
	public List<Discente> find(Discente discente) throws SQLException {
		
		try{
			
			return d.find(discente);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
	}
	public List<Discente> getAll() throws SQLException {
		
		try{
			
			return d.getAll();
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
	}
	public int getId(String matricula) throws SQLException {
		
		try{
			
			return d.getId(matricula);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return 0;
		 
	}
	public void delete(int idDiscente)throws SQLException{
		
		try{
			
			d.delete(idDiscente);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
		
	}
	

}
