package br.edu.ifpb.auxilio.actions;

import java.sql.SQLException;

import br.edu.ifpb.auxilio.entidade.Pessoa;
import br.edu.ifpb.auxilio.service.bd.PessoaDAO;

public class ActionPessoa {
	
	
	public int insert(Pessoa pessoa) throws SQLException {
		PessoaDAO p = new PessoaDAO();
		return p.insert(pessoa);

	}

	public int getIsAuthorized(String Matricula, String senha)
			throws SQLException {
		PessoaDAO p = new PessoaDAO();
		return p.getIsAuthorized(Matricula, senha);

}

}
