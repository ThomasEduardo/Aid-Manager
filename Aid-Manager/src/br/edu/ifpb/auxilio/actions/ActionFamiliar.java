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
		try{
			
			return f.insert(familiar);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return 0;

	}
	public boolean update(Familiar familiar) throws SQLException{
		try{
			
			return f.update(familiar);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return false;
		
		
	}
	public Familiar getById(int idFamiliar) throws SQLException{
		
		try{
			
			return f.getById(idFamiliar);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
	}
	public List<Familiar> convertToList(ResultSet rs)
			throws SQLException {
		
		try{
			
			return f.convertToList(rs);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
	}
	public List<Familiar> find(Familiar familiar) throws SQLException {
		
		try{
			
			return f.find(familiar);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
	}
	public List<Familiar> getAll() throws SQLException {
		try{
			
			return f.getAll();
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
	}
	public int qtdeFamiliares(Discente discente) throws SQLException{
		
		try{
			
			return f.qtdeFamiliares(discente);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return 0;
		
	}
	public double somaRenda(Discente discente) throws SQLException{
		
		try{
			
			return f.somaRenda(discente);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return 0;
		
	}
	public List<Discente> calculoRendaFamiliar() throws SQLException{
	
		try{
			
			return f.calculoRendaFamiliar();
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
	}

}
