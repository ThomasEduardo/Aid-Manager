package br.edu.ifpb.auxilio.actions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.auxilio.entidade.InstituicaoFinanciadora;
import br.edu.ifpb.auxilio.service.bd.InstituicaoFinanciadoraDAO;

public class ActionInstituicaoFinanciadora {
	
	private InstituicaoFinanciadoraDAO i;
	
	public int insert(InstituicaoFinanciadora IF) {
		
	}
	public boolean update(InstituicaoFinanciadora IF) {
		
	}
	public InstituicaoFinanciadora getById (int idIf){
		
	}
	public List<InstituicaoFinanciadora> convertToList(ResultSet rs)
			throws SQLException {
		
	}
	public List<InstituicaoFinanciadora> find(InstituicaoFinanciadora instf) throws SQLException {
		
	}
	public List<InstituicaoFinanciadora> getAll() throws SQLException {
		
	}
	public List<InstituicaoFinanciadora> getAllByServidor(InstituicaoFinanciadora instf) throws SQLException {
		
	}
	public List<InstituicaoFinanciadora> getAllByNome(InstituicaoFinanciadora instf) throws SQLException {
		
	}
	public void delete(String cnpj)throws SQLException{
		
	}

}
