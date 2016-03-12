package br.edu.ifpb.auxilio.main;

import java.util.Date;

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
	
public static void main(String[] args) {
	
	

	ProcessoDAO dD = new ProcessoDAO();
	ServidorDAO s = new ServidorDAO();
	PessoaDAO pessoa = new PessoaDAO();
	Processo p  = new Processo(null, " ",
			"12345", "texxtar",
			pessoa.getById(1),"Em trânmite",s.getById(3));
	dD.insert(p);
	
	
	}
}
