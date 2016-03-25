package br.edu.ifpb.auxilio.actions;

import java.sql.SQLException;

import br.edu.ifpb.auxilio.entidade.Discente;
import br.edu.ifpb.auxilio.service.bd.DiscenteDAO;



public class ActionDiscente {
	
	public void insert(Discente discente) throws SQLException {
		DiscenteDAO d = new DiscenteDAO();
		d.insert(discente);
		
	}

}
