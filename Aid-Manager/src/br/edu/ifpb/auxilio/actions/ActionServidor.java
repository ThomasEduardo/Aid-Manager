package br.edu.ifpb.auxilio.actions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.auxilio.entidade.Servidor;
import br.edu.ifpb.auxilio.service.bd.ServidorDAO;

public class ActionServidor {
	
	
	private ServidorDAO s;
	
	public int insert(Servidor servidor) throws SQLException {
		try{
			
			return s.insert(servidor);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return 0;
		
	}
	
	
	public int getId(String matricula) throws SQLException {
		
		try{
			
			return s.getId(matricula);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return 0;
		  
	}
	
	
	public List<Servidor> convertToList(ResultSet rs)
			throws SQLException {
		try{
			
			return s.convertToList(rs);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
	}
	
	
	public void delete(int idServidor)throws SQLException{
		try{
			
			s.delete(idServidor);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
			
		 
	}
	
	
	public List<Servidor> find(Servidor servidor) throws SQLException {
		
		try{
			
			return s.find(servidor);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
	}
	
	
	public List<Servidor> getAll() throws SQLException {
		
		try{
			
			return s.getAll();
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
	}
	
	public int qtdeDiscentesCadastrados() throws SQLException {
		try{
			
			return s.qtdeDiscentesCadastrados();
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return 0;
	}
	
	
	
	public boolean update(Servidor servidor) throws SQLException{
		try{
			
			return  s.update(servidor); 
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return false;
		
	}
	 

}
