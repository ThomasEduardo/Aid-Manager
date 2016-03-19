package br.edu.ifpb.auxilio.main;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import br.edu.ifpb.auxilio.bd.AuxilioDAO;
import br.edu.ifpb.auxilio.bd.DadosBancariosDAO;
import br.edu.ifpb.auxilio.bd.DiscenteDAO;
import br.edu.ifpb.auxilio.bd.DocumentoDAO;
import br.edu.ifpb.auxilio.bd.EditalDAO;
import br.edu.ifpb.auxilio.bd.FamiliarDAO;
import br.edu.ifpb.auxilio.bd.InstituicaoFinanciadoraDAO;
import br.edu.ifpb.auxilio.bd.PerfilSocioEconomicoDAO;
import br.edu.ifpb.auxilio.bd.PessoaDAO;
import br.edu.ifpb.auxilio.bd.ProcessoDAO;
import br.edu.ifpb.auxilio.bd.ServidorDAO;
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



public class Instituicao {
	
public static void main(String[] args) throws SQLException {
	
	List<DadosBancarios> auxs = null;

	DadosBancariosDAO a = new DadosBancariosDAO();
	DiscenteDAO discente = new DiscenteDAO();
	DadosBancarios db = new DadosBancarios();
	db.setDiscente(discente.getById(1));
	auxs = a.find(db);
	
	System.out.println(auxs.size());	
	
	}
}
