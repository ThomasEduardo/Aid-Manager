package br.edu.ifpb.auxilio.main;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import br.edu.ifpb.auxilio.dominio.Auxilio;
import br.edu.ifpb.auxilio.dominio.DadosBancarios;
import br.edu.ifpb.auxilio.dominio.Discente;
import br.edu.ifpb.auxilio.dominio.Documento;
import br.edu.ifpb.auxilio.dominio.Edital;
import br.edu.ifpb.auxilio.dominio.Familiar;
import br.edu.ifpb.auxilio.dominio.PerfilSocioEconomico;
import br.edu.ifpb.auxilio.dominio.Pessoa;
import br.edu.ifpb.auxilio.dominio.Processo;
import br.edu.ifpb.auxilio.dominio.Servidor;
import br.edu.ifpb.auxilio.service.bd.AuxilioDAO;
import br.edu.ifpb.auxilio.service.bd.DadosBancariosDAO;
import br.edu.ifpb.auxilio.service.bd.DiscenteDAO;
import br.edu.ifpb.auxilio.service.bd.DocumentoDAO;
import br.edu.ifpb.auxilio.service.bd.EditalDAO;
import br.edu.ifpb.auxilio.service.bd.FamiliarDAO;
import br.edu.ifpb.auxilio.service.bd.InstituicaoFinanciadoraDAO;
import br.edu.ifpb.auxilio.service.bd.PerfilSocioEconomicoDAO;
import br.edu.ifpb.auxilio.service.bd.PessoaDAO;
import br.edu.ifpb.auxilio.service.bd.ProcessoDAO;
import br.edu.ifpb.auxilio.service.bd.ServidorDAO;



public class Instituicao {
	
public static void main(String[] args) throws SQLException {
	
	List<Discente> auxs = null;

	DiscenteDAO e = new DiscenteDAO();
     Discente db = new Discente();
	db.setMatricula("123");
	auxs = e.find(db);
	
	System.out.println(auxs.size());	
	
	}
}
