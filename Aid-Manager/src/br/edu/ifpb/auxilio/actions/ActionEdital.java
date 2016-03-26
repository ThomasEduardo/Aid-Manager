package br.edu.ifpb.auxilio.actions;

import java.sql.SQLException;

import br.edu.ifpb.auxilio.entidade.Edital;
import br.edu.ifpb.auxilio.service.bd.EditalDAO;


public class ActionEdital {
	
	public int insert(Edital edital) throws SQLException {
		EditalDAO p = new EditalDAO();
		return p.insert(edital);

	}

}
