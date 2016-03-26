package br.edu.ifpb.auxilio.actions;

import java.sql.SQLException;


import br.edu.ifpb.auxilio.entidade.Processo;
import br.edu.ifpb.auxilio.service.bd.ProcessoDAO;

public class ActionProcesso {
	
	public int insert(Processo processo) throws SQLException {
		ProcessoDAO p = new ProcessoDAO();
		return p.insert(processo);

	}

}
