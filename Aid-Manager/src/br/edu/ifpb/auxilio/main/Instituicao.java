package br.edu.ifpb.auxilio.main;

import br.edu.ifpb.auxilio.bd.AssistenteSocialDAO;
import br.edu.ifpb.auxilio.bd.PessoaDAO;
import br.edu.ifpb.auxilio.bd.ServidorDAO;
import br.edu.ifpb.auxilio.dominio.AssistenteSocial;
import br.edu.ifpb.auxilio.dominio.Pessoa;

import java.util.Date;
import java.util.Scanner;
public class Instituicao {
	
public static void main(String[] args) {
	
	PessoaDAO pessoa = new PessoaDAO();
	ServidorDAO s = new ServidorDAO();
	AssistenteSocialDAO a = new AssistenteSocialDAO();
    AssistenteSocial as = new AssistenteSocial("Rayla","20141004029",null,"123","rayla.medeiiros@gmail.com","701.199.264-23","3.999.259","feminino","Assistente Social");   
    pessoa.insert(as);
    s.insert(as);
    a.insert(as);
    
	
	
	
	
	}
}
