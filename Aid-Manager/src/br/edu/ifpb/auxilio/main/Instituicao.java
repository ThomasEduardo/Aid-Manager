package br.edu.ifpb.auxilio.main;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import br.edu.ifpb.auxilio.entidade.Auxilio;
import br.edu.ifpb.auxilio.entidade.DadosBancarios;
import br.edu.ifpb.auxilio.entidade.Discente;
import br.edu.ifpb.auxilio.entidade.Documento;
import br.edu.ifpb.auxilio.entidade.Edital;
import br.edu.ifpb.auxilio.entidade.Familiar;
import br.edu.ifpb.auxilio.entidade.InstituicaoFinanciadora;
import br.edu.ifpb.auxilio.entidade.PerfilSocioEconomico;
import br.edu.ifpb.auxilio.entidade.Pessoa;
import br.edu.ifpb.auxilio.entidade.Processo;
import br.edu.ifpb.auxilio.entidade.Servidor;
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
	

	AuxilioDAO e = new AuxilioDAO();
	InstituicaoFinanciadoraDAO i = new InstituicaoFinanciadoraDAO();
	ProcessoDAO p = new ProcessoDAO();
	

	
	Auxilio db = new Auxilio("Transporte",80.00,new java.util.Date(),new java.util.Date(),i.getById(1),p.getById(1));
	
    
     e.insert(db);

	

	
	
	
	
	
	

	
	
	}
}
