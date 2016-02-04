package br.edu.ifpb.auxilio.dominio;

import java.util.Date;

public abstract class Servidor extends Pessoa{
	
	private int idServidor;
	private String cargoServidor;
	
	public Servidor(){
		super();
		setIdServidor(0);
		setCargoServidor("");
		
	}
	
	public Servidor(int idPessoa,String nomePessoa,String matricula,Date dataNasc,String senha,String email,String cpf,String rg,String sexo,int idServidor,String cargoServidor,Telefone t){
		super(idPessoa,nomePessoa,matricula,dataNasc,senha,email,cpf,rg,sexo,t);
		setIdServidor(idServidor);
		setCargoServidor(cargoServidor);
	
	}
	
	public Servidor(String nomePessoa,String matricula,Date dataNasc,String senha,String email,String cpf,String rg,String sexo,String cargoServidor,Telefone t){
		super(nomePessoa,matricula,dataNasc,senha,email,cpf,rg,sexo,t);
		setCargoServidor(cargoServidor);
		
	}
	
	/*----------------- GETTERS E SETTERS ----------------*/
	public int getIdServidor() {
		return idServidor;
	}
	public void setIdServidor(int idServidor) {
		this.idServidor = idServidor;
	}
	public String getCargoServidor() {
		return cargoServidor;
	}
	public void setCargoServidor(String cargoServidor) {
		this.cargoServidor = cargoServidor;
	}

	public boolean equals(Servidor s){
		if(s instanceof Servidor){
			if(super.equals(s)){
				if(this.getCargoServidor() == s.getCargoServidor()){
					return true;
				}
			}
		}
		return false;
		
	}
	
	
	

}
