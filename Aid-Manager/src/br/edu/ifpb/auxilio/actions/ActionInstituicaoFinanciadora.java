package br.edu.ifpb.auxilio.actions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.auxilio.entidade.InstituicaoFinanciadora;
import br.edu.ifpb.auxilio.service.bd.InstituicaoFinanciadoraDAO;

public class ActionInstituicaoFinanciadora {
	
	InstituicaoFinanciadoraDAO i;
	
	public int insert(InstituicaoFinanciadora IF) throws SQLException{
		
		try{
			InstituicaoFinanciadoraDAO i = new InstituicaoFinanciadoraDAO();
			return i.insert(IF);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return 0;
		
	}
	public boolean update(InstituicaoFinanciadora IF) throws SQLException{
		
		try{
			
			return i.update(IF);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return false;
		
	}
	public InstituicaoFinanciadora getById (int idIf)throws SQLException{
		
		try{
			
			return i.getById(idIf);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
	}
	public List<InstituicaoFinanciadora> convertToList(ResultSet rs)
			throws SQLException {
		
		try{
			
			return i.convertToList(rs);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
	}
	public List<InstituicaoFinanciadora> find(InstituicaoFinanciadora instf) throws SQLException {
		try{
			
			return i.find(instf);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
	}
	public List<InstituicaoFinanciadora> getAll() throws SQLException {
		
		try{
			
			return i.getAll();
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
	}
	public List<InstituicaoFinanciadora> getAllByServidor(InstituicaoFinanciadora instf) throws SQLException {
		try{
			
			return i.getAllByServidor(instf);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
	}
	public List<InstituicaoFinanciadora> getAllByNome(InstituicaoFinanciadora instf) throws SQLException {
		try{
			
			return i.getAllByNome(instf);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
	}
	public void delete(String cnpj)throws SQLException{
		
		try{
			
			i.delete(cnpj);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
		
	}
	public int getId(String cnpj) throws SQLException {
		try{
			
			return i.getId(cnpj);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		return 0;
	}

}
