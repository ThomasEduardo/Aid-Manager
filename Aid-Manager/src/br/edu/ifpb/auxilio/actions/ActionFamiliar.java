package br.edu.ifpb.auxilio.actions;

import java.sql.SQLException;

import br.edu.ifpb.auxilio.entidade.Familiar;
import br.edu.ifpb.auxilio.service.bd.FamiliarDAO;

public class ActionFamiliar {
	
	public int insert(Familiar familiar) throws SQLException {

		FamiliarDAO a = new FamiliarDAO();
		return a.insert(familiar);

	}

}
