package br.edu.ifpb.auxilio.actions;

import java.sql.SQLException;

import br.edu.ifpb.auxilio.entidade.PerfilSocioEconomico;
import br.edu.ifpb.auxilio.service.bd.PerfilSocioEconomicoDAO;



public class ActionPerfilSocioEconomico {
	
	public int insert(PerfilSocioEconomico ps) throws SQLException {
		PerfilSocioEconomicoDAO p = new PerfilSocioEconomicoDAO();
		return p.insert(ps);

	}

}
