package br.edu.ifpb.auxilio.actions;

import java.sql.SQLException;

import br.edu.ifpb.auxilio.entidade.Servidor;
import br.edu.ifpb.auxilio.service.bd.ServidorDAO;

public class ActionServidor {
	
	public void insert(Servidor servidor) throws SQLException {
		ServidorDAO s = new ServidorDAO();
		s.insert(servidor);
		
	}

}
