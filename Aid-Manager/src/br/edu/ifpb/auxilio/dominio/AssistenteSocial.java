package br.edu.ifpb.auxilio.dominio;

import java.util.Date;

public class AssistenteSocial extends Servidor {
	private int id_assistenteSocial;

	
	public AssistenteSocial(){
		super();
       setId_assistenteSocial(0);	
    }
	
	public AssistenteSocial(String nomePessoa,String matricula,Date dataNasc,String senha,String email,
						String cpf,String rg,String sexo,String cargoServidor){
	
	super(nomePessoa,matricula,dataNasc,senha,email,cpf,rg,sexo,cargoServidor);	
	}
//------------------------------GETTERS E SETTERS -------------------------------------------------//
	public int getId_assistenteSocial() {
		return id_assistenteSocial;
	}

	public void setId_assistenteSocial(int id_assistenteSocial) {
		this.id_assistenteSocial = id_assistenteSocial;
	}
	

}
