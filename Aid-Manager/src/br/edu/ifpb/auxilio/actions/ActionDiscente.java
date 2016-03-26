package br.edu.ifpb.auxilio.actions;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.auxilio.entidade.Discente;
import br.edu.ifpb.auxilio.service.bd.DiscenteDAO;



public class ActionDiscente {
	
	private DiscenteDAO d;
	
	public void insert(Discente discente) throws SQLException {
		d.insert(discente);
		
	}
	
	public boolean update(Discente discente)throws SQLException{
		
	}
	public Discente getById(int idDiscente)throws SQLException{
		
	}
	public List<Discente> find(Discente discente) throws SQLException {
		
	}
	public List<Discente> getAll() throws SQLException {
		
	}
	public int getId(String matricula) throws SQLException {
		 
	}
	public void delete(int idDiscente)throws SQLException{
		
	}
	

}
