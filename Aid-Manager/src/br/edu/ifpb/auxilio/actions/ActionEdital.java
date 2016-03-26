package br.edu.ifpb.auxilio.actions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.auxilio.entidade.Edital;
import br.edu.ifpb.auxilio.service.bd.EditalDAO;


public class ActionEdital {
	
	private EditalDAO e;
	
	public int insert(Edital edital) throws SQLException {
		return e.insert(edital);

	}
	public boolean update(Edital edital)throws SQLException {
		
	}
	public Edital getById(int idEdital)throws SQLException{
		
	}
	public List<Edital> convertToList(ResultSet rs)
			throws SQLException {
		
	}
	public List<Edital> find(Edital edital) throws SQLException {
		
	}
	public List<Edital> getAll() throws SQLException {
		
	}
	public List<Edital> getByAno(int ano) throws SQLException {
		
	}
	public List<Edital> getByServidor(int idServidor) throws SQLException {
		
	}
	public void delete(String numEdital)throws SQLException{
		
	}
	

}
