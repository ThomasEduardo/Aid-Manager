package br.edu.ifpb.auxilio.actions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.auxilio.entidade.DadosBancarios;
import br.edu.ifpb.auxilio.service.bd.DadosBancariosDAO;



public class ActionDadosBancarios {
	
	private DadosBancariosDAO d;
	
	public int insert(DadosBancarios db) throws SQLException {
		return d.insert(db);

	}
	public boolean update(DadosBancarios db) throws SQLException {
		
	}
	public DadosBancarios getById(int idDb) throws SQLException{
		
	}
	
	public List<DadosBancarios> convertToList(ResultSet rs)
			throws SQLException {
		
	}
	public List<DadosBancarios> find(DadosBancarios db) throws SQLException {
		
	}
	public List<DadosBancarios> getAll() throws SQLException {
		
	}
	public double gastoMensal(DadosBancarios db) throws SQLException {
		
	}
	
}
