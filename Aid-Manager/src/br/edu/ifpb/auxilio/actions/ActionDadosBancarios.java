package br.edu.ifpb.auxilio.actions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.auxilio.entidade.DadosBancarios;
import br.edu.ifpb.auxilio.service.bd.DadosBancariosDAO;



public class ActionDadosBancarios {
	
	private DadosBancariosDAO d;
	
	public int insert(DadosBancarios db) throws SQLException {
		try{
			
			return d.insert(db);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return 0;
		

	}
	public boolean update(DadosBancarios db) throws SQLException {
		try{
			
			return d.update(db);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return false;
		
	}
	
	
	public DadosBancarios getById(int idDb) throws SQLException{
		try{
			
			return d.getById(idDb);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
	
	
	}
	
	public List<DadosBancarios> convertToList(ResultSet rs)
			throws SQLException {
		
		try{
			
			return d.convertToList(rs);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
	}
	public List<DadosBancarios> find(DadosBancarios db) throws SQLException {
		
		try{
			
			return d.find(db);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
	}
	public List<DadosBancarios> getAll() throws SQLException {
		try{
			
			return d.getAll();
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
	}
	public double gastoMensal(DadosBancarios db) throws SQLException {
		try{
			
			return d.gastoMensal(db);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return 0;
		
	}
	
}
