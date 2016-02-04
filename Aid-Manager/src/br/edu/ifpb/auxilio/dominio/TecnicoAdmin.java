package br.edu.ifpb.auxilio.dominio;

import java.util.Date;

public class TecnicoAdmin extends Servidor {
	
	private int idTecnicoAdmin;
	
	public TecnicoAdmin(){
		super();
		setIdTecnicoAdmin(0);
		
	}
	
	public TecnicoAdmin(String nomePessoa,String matricula,Date dataNasc,String senha,String email,String cpf,String rg,String sexo,String cargoServidor,int idTecnicoAdmin){
		super(nomePessoa,matricula,dataNasc,senha,email,cpf,rg,sexo,cargoServidor);
		setIdTecnicoAdmin(idTecnicoAdmin);
		
	}
	
	/*----------------- GETTERS E SETTERS ----------------*/
	public int getIdTecnicoAdmin() {
		return idTecnicoAdmin;
	}

	public void setIdTecnicoAdmin(int idTecnicoAdmin) {
		this.idTecnicoAdmin = idTecnicoAdmin;
	}
	
		
	public boolean equals(TecnicoAdmin t){
			if(t instanceof TecnicoAdmin){
				if(super.equals(t)){
					if(this.getIdTecnicoAdmin() == t.getIdTecnicoAdmin()){
						return true;
					}
				}
			}
		return false;
	}
	

}
