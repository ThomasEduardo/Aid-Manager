package br.edu.ifpb.auxilio.actions;

import java.sql.SQLException;

import br.edu.ifpb.auxilio.entidade.DadosBancarios;
import br.edu.ifpb.auxilio.service.bd.DadosBancariosDAO;



public class ActionDadosBancarios {
	
	public int insert(DadosBancarios db) throws SQLException {
		DadosBancariosDAO p = new DadosBancariosDAO();
		return p.insert(db);

	}

}
