package br.edu.ifpb.auxilio.actions;

import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.List;

import br.edu.ifpb.auxilio.entidade.Processo;
import br.edu.ifpb.auxilio.service.bd.ProcessoDAO;

public class ActionProcesso {
	
	
	ProcessoDAO p;
	
	public int insert(Processo processo) throws SQLException {
		
		try{
			ProcessoDAO p = new ProcessoDAO();
			return p.insert(processo);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return 0;
	}
	
	public boolean update(Processo processo) throws SQLException{
		
		try{
			
			return p.update(processo);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return false;
	}
	public Processo getById(int idProcesso)  throws SQLException {
		
		
		try{
			
			return p.getById(idProcesso);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
	}
	public List<Processo> convertToList(ResultSet rs)
			throws SQLException {
		
		try{
			
			return p.convertToList(rs);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
	}
	public List<Processo> find(Processo processo) throws SQLException {
		
		try{
			
			return p.find(processo);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
	}
	public List<Processo> getAll() throws SQLException {
		
		try{
			
			return p.getAll();
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
	}
	public List<Processo> getAllByNumProcesso(int idServidor,String numProcesso) throws SQLException {
		
		try{
			
			return p.getAllByNumProcesso(idServidor, numProcesso);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
	}
	public void delete(String numProcesso)throws SQLException{
		
		
		try{
			
			p.delete(numProcesso);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
		
	}
	public int getId(String numProcesso) throws SQLException {
		
		
		try{
			
			return p.getId(numProcesso);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return 0;
		  
	}

}
