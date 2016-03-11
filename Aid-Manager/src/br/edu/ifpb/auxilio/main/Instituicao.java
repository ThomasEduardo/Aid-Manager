package br.edu.ifpb.auxilio.main;

import br.edu.ifpb.auxilio.bd.AuxilioDAO;
import br.edu.ifpb.auxilio.bd.InstituicaoFinanciadoraDAO;

import br.edu.ifpb.auxilio.bd.ProcessoDAO;

import br.edu.ifpb.auxilio.dominio.Auxilio;



public class Instituicao {
	
public static void main(String[] args) {
	
	

	AuxilioDAO aux = new AuxilioDAO();
	Auxilio a = aux.getById(1);
	a.setTipoAuxilio("Transporte");
	aux.update(a);
	
	
	
	}
}
