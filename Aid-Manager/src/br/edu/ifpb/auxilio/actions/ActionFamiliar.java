package br.edu.ifpb.auxilio.actions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.auxilio.entidade.Discente;
import br.edu.ifpb.auxilio.entidade.Familiar;
import br.edu.ifpb.auxilio.service.bd.FamiliarDAO;

public class ActionFamiliar {
	
	private FamiliarDAO f;
	
	public int insert(Familiar familiar) throws SQLException {
		return f.insert(familiar);

	}
	public boolean update(Familiar familiar) throws SQLException{
		
	}
	public Familiar getById(int idFamiliar) throws SQLException{
		
	}
	public List<Familiar> convertToList(ResultSet rs)
			throws SQLException {
		
	}
	public List<Familiar> find(Familiar familiar) throws SQLException {
		
	}
	public List<Familiar> getAll() throws SQLException {
		
	}
	public int qtdeFamiliares(Discente discente) throws SQLException{
		
	}
	public double somaRenda(Discente discente) throws SQLException{
		
	}
	public List<Discente> calculoRendaFamiliar() throws SQLException{
		
	}

}
