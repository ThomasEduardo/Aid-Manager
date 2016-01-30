package br.edu.ifpb.main;

import br.edu.ifpb.auxilio.bd.PessoaDAO;
import br.edu.ifpb.auxilio.bd.ServidorDAO;
import br.edu.ifpb.auxilio.dominio.AssistenteSocial;

public class Instituicao {
	
public static void main(String[] args) {
	
	
	ServidorDAO s = new ServidorDAO();
	PessoaDAO pessoa = new PessoaDAO();
	AssistenteSocial a = new AssistenteSocial("Rayla","20141004029",null,"123","rayla.medeiiros@gmail.com","121.333.111-22","4.999.259","feminino","assistente social");
	pessoa.Cadastrar(a);
	s.Cadastrar(a);
	
	
	
	
	}
}
