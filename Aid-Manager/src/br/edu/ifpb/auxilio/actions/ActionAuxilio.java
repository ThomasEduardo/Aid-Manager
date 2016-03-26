package br.edu.ifpb.auxilio.actions;

import java.sql.SQLException;

import br.edu.ifpb.auxilio.entidade.Auxilio;
import br.edu.ifpb.auxilio.service.bd.AuxilioDAO;



public class ActionAuxilio {
	
	public int insert(Auxilio auxilio) throws SQLException {
		AuxilioDAO a = new AuxilioDAO();
		return a.insert(auxilio);

	}

}
