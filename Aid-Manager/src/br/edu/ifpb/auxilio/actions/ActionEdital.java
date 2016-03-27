package br.edu.ifpb.auxilio.actions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.auxilio.entidade.Edital;
import br.edu.ifpb.auxilio.service.bd.EditalDAO;


public class ActionEdital {
	
	private EditalDAO e;
	
	public int insert(Edital edital) throws SQLException {
		try{
			EditalDAO e = new EditalDAO();
			return e.insert(edital);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return 0;

	}
	public boolean update(Edital edital)throws SQLException {
		try{
			
			return e.update(edital);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return false;
		
	}
	public Edital getById(int idEdital)throws SQLException{
		try{
			
			return e.getById(idEdital);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
	}
	public List<Edital> convertToList(ResultSet rs)
			throws SQLException {
		
		try{
			
			return e.convertToList(rs);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
	}
	public List<Edital> find(Edital edital) throws SQLException {
		
		try{
			
			return e.find(edital);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
       
		
	}
	public List<Edital> getAll() throws SQLException {
		try{
			
			return e.getAll();
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
		
	}
	public List<Edital> getByAno(int ano) throws SQLException {
		
		try{
			
			return e.getByAno(ano);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
	}
	public List<Edital> getByServidor(int idServidor) throws SQLException {
		try{
			
			return e.getByServidor(idServidor);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
	}
	public void delete(String numEdital)throws SQLException{
		
		try{
			
		     e.delete(numEdital);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
	
		
	}
	

}
