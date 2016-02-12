package br.edu.ifpb.auxilio.main;

import br.edu.ifpb.auxilio.bd.PessoaDAO;
import br.edu.ifpb.auxilio.bd.ServidorDAO;
import br.edu.ifpb.auxilio.dominio.AssistenteSocial;
import br.edu.ifpb.auxilio.dominio.Pessoa;

import java.util.Scanner;
public class Instituicao {
	
public static void main(String[] args) {
	
	Pessoa pessoa;
	Scanner input = new Scanner(System.in);
	String matricula = input.nextLine();
    PessoaDAO p = new PessoaDAO();
    pessoa = p.getPessoa(matricula);
    pessoa.setRg("linda");
    p.update(pessoa);
	
	
	
	
	
	}
}
