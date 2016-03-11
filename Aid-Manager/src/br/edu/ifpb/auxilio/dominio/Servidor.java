package br.edu.ifpb.auxilio.dominio;

import java.util.Date;

public class Servidor extends Pessoa{
	
	private int idServidor;
	private String cargoServidor;
	private String tipoServidor;
	
	public Servidor(){
		super();
		setIdServidor(0);
		setCargoServidor("");
		setTipoServidor("");
		
	}
	
	public Servidor(int idPessoa,String nomePessoa,String matricula,Date dataNasc,String senha,String email,String cpf,String rg,String sexo,int idServidor,String cargoServidor,String tipoServidor){
		super(idPessoa,nomePessoa,matricula,dataNasc,senha,email,cpf,rg,sexo);
		setIdServidor(idServidor);
		setCargoServidor(cargoServidor);
		setTipoServidor(tipoServidor);
	
	}
	
	public Servidor(String nomePessoa,String matricula,Date dataNasc,String senha,String email,String cpf,String rg,String sexo,String cargoServidor,String tipoServidor){
		super(nomePessoa,matricula,dataNasc,senha,email,cpf,rg,sexo);
		setCargoServidor(cargoServidor);
		setTipoServidor(tipoServidor);
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
	public String getTipoServidor() {
		return tipoServidor;
	}

	public void setTipoServidor(String tipoServidor) {
		this.tipoServidor = tipoServidor;
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
