package br.edu.ifpb.auxilio.actions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.auxilio.entidade.PerfilSocioEconomico;
import br.edu.ifpb.auxilio.service.bd.PerfilSocioEconomicoDAO;



public class ActionPerfilSocioEconomico {
	
	private PerfilSocioEconomicoDAO p;
	
	public int insert(PerfilSocioEconomico ps) throws SQLException {
		try{
			
			return p.insert(ps);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return 0;

	}
	public boolean update(PerfilSocioEconomico PSE) throws SQLException {
		
		try{
			
			return p.update(PSE);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return false;
		
	}
	public List<PerfilSocioEconomico> getAll() throws SQLException {
		
		try{
			
			return p.getAll();
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
	}
	public List<PerfilSocioEconomico> find(PerfilSocioEconomico pse) throws SQLException {
		
		try{
		
			return  p.find(pse);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
		
	}
	public PerfilSocioEconomico getById(int idPs) throws SQLException {
		
		try{
			
			return p.getById(idPs);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
	}
	public List<PerfilSocioEconomico> convertToList(ResultSet rs)
			throws SQLException {
		
		
		try{
			
			return p.convertToList(rs);
		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
       return null;
		
		
	}

}
