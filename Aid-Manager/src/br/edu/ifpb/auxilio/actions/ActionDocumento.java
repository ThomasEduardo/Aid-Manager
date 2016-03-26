package br.edu.ifpb.auxilio.actions;

import java.sql.SQLException;

import br.edu.ifpb.auxilio.entidade.Documento;
import br.edu.ifpb.auxilio.service.bd.DocumentoDAO;



public class ActionDocumento {
	
	public int insert(Documento documento) throws SQLException {
		DocumentoDAO d = new DocumentoDAO();
		return d.insert(documento);

	}

}
