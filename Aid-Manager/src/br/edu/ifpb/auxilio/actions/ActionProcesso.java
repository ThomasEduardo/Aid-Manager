package br.edu.ifpb.auxilio.actions;

import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.List;

import br.edu.ifpb.auxilio.entidade.Processo;
import br.edu.ifpb.auxilio.service.bd.ProcessoDAO;

public class ActionProcesso {
	
	
	private ProcessoDAO p;
	
	public int insert(Processo processo) throws SQLException {
		return p.insert(processo);

	}
	
	public boolean update(Processo processo) {
		
	}
	public Processo getById(int idProcesso) {
		
	}
	public List<Processo> convertToList(ResultSet rs)
			throws SQLException {
		
	}
	public List<Processo> find(Processo processo) throws SQLException {
		
	}
	public List<Processo> getAll() throws SQLException {
		
	}
	public List<Processo> getAllByNumProcesso(int idServidor,String numProcesso) throws SQLException {
		
	}
	public void delete(String numProcesso)throws SQLException{
		
	}
	public int getId(String numProcesso) throws SQLException {
		  
	}

}
