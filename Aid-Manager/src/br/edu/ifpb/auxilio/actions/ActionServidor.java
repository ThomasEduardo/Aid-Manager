package br.edu.ifpb.auxilio.actions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.auxilio.entidade.Servidor;
import br.edu.ifpb.auxilio.service.bd.ServidorDAO;

public class ActionServidor {
	
	
	private ServidorDAO s;
	
	public void insert(Servidor servidor) throws SQLException {
		s.insert(servidor);
		
	}
	
	
	public int getId(String numProcesso) throws SQLException {
		  
	}
	
	
	public List<Servidor> convertToList(ResultSet rs)
			throws SQLException {
		
	}
	
	
	public void delete(int idServidor)throws SQLException{
		 
	}
	
	
	public List<Servidor> find(Servidor servidor) throws SQLException {
		
	}
	
	
	public List<Servidor> getAll() throws SQLException {
		
	}
	
	public int qtdeDiscentesCadastrados() throws SQLException {
		
	}
	
	
	public int getId(String matricula) throws SQLException {
		
	}
	
	public boolean update(Servidor s) throws SQLException{
		
	}
	 

}
