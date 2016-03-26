package br.edu.ifpb.auxilio.actions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.auxilio.entidade.PerfilSocioEconomico;
import br.edu.ifpb.auxilio.service.bd.PerfilSocioEconomicoDAO;



public class ActionPerfilSocioEconomico {
	
	private PerfilSocioEconomicoDAO p;
	
	public int insert(PerfilSocioEconomico ps) throws SQLException {
		return p.insert(ps);

	}
	public boolean update(PerfilSocioEconomico PSE) {
		
	}
	public List<PerfilSocioEconomico> getAll() throws SQLException {
		
	}
	public List<PerfilSocioEconomico> find(PerfilSocioEconomico pse) throws SQLException {
		
	}
	public PerfilSocioEconomico getById(int idPs){
		
	}
	public List<PerfilSocioEconomico> convertToList(ResultSet rs)
			throws SQLException {
		
	}

}
