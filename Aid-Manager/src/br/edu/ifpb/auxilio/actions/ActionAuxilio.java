package br.edu.ifpb.auxilio.actions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.auxilio.entidade.Auxilio;
import br.edu.ifpb.auxilio.entidade.Discente;
import br.edu.ifpb.auxilio.service.bd.AuxilioDAO;



public class ActionAuxilio {
	
	private AuxilioDAO a;
	
	public int insert(Auxilio auxilio) throws SQLException {
		try{
			
			return a.insert(auxilio);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return 0;
	}
	
	public boolean update(Auxilio auxilio) throws SQLException{ 
		
		try{
			
			return a.update(auxilio);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return false;
		
	}
	
	public Auxilio getById(int idAuxilio) throws SQLException{
		try{
			
			return a.getById(idAuxilio);
			
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
		return null;
	}
	
	public List<Auxilio> getAll() throws SQLException {
		try{
			
			return a.getAll();
			
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
		return null;
		
	}
	
	public List<Auxilio> find(Auxilio auxilio) throws SQLException {
	
		try{
			
			return a.find(auxilio);
			
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
		return null;

	}
	
	public int qtdeAuxilios(Discente discente) throws SQLException{
		
		try{
			
			return a.qtdeAuxilios(discente);
			
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
		return 0;
		
	}
	
	public List<Auxilio> getAllByInstFinanc(Auxilio auxilio) throws SQLException {
		try{
			
			return a.getAllByInstFinanc(auxilio);
			
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
		return null;
	}
	
	public List<Auxilio> getAllByServidor(Auxilio auxilio) throws SQLException {
		
	}
	
	public List<Auxilio> discentesComtemplados(Auxilio auxilio) throws SQLException {
		
	}
	
	public List<Auxilio> convertToListQueryDiscentesContemp(ResultSet rs)
			throws SQLException {
		
	}
	
	public List<Auxilio> getDiscentesContempladosByTipoAux(String tipoAuxilio) throws SQLException {
		
	}
	public void delete (String numProcesso) throws SQLException{
		
	}

}

