package br.edu.ifpb.auxilio.dominio;

public class DadosBancarios {
	
	private int idDadosBancarios;
	private String banco;
	private String agencia;
	private String numAgencia;
	
	public DadosBancarios(){
		
		setIdDadosBancarios(0);
		setBanco("");
		setAgencia("");
		setNumAgencia("");
		
	}
	
	public DadosBancarios(int idDB,String banco,String agencia,String numAgencia){
		
		setIdDadosBancarios(idDB);
		setBanco(banco);
		setAgencia(agencia);
		setNumAgencia(numAgencia);
		
	}
	
	public DadosBancarios(String banco,String agencia,String numAgencia){
		
		setBanco(banco);
		setAgencia(agencia);
		setNumAgencia(numAgencia);
		
	}
	
	/*----------------- GETTERS E SETTERS ----------------*/
	public int getIdDadosBancarios() {
		return idDadosBancarios;
	}
	public void setIdDadosBancarios(int idDadosBancarios) {
		this.idDadosBancarios = idDadosBancarios;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getNumAgencia() {
		return numAgencia;
	}
	public void setNumAgencia(String numAgencia) {
		this.numAgencia = numAgencia;
	}
	
	public boolean equals(DadosBancarios db){
		if(this.getNumAgencia() == db.getNumAgencia()){
			if(this.getBanco() == db.getBanco()){
				if(this.getAgencia() == db.getAgencia()){
						return true;
				}
			}
		}
		return false;
	}

}
