package br.edu.ifpb.auxilio.dominio;

import java.security.Timestamp;

public class AssistenteSocial extends Servidor {
	private int id_assistenteSocial;
	
	
public AssistenteSocial(int id_assistenteSocial, int idPessoa,String nomePessoa,
						String matricula,Timestamp dataNasc,String senha,String email,
						String cpf,String rg,String sexo,int idServidor,String cargoServidor){
	
	super(idPessoa,nomePessoa,matricula,dataNasc,senha,email,cpf,rg,sexo,idServidor,cargoServidor );
	setId_assistenteSocial(id_assistenteSocial);	
}
//-------------------------------------------------------------------------------
	public int getId_assistenteSocial() {
		return id_assistenteSocial;
	}

	public void setId_assistenteSocial(int id_assistenteSocial) {
		this.id_assistenteSocial = id_assistenteSocial;
	}
	

}
