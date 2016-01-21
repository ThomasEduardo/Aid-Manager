package br.edu.ifpb.auxilio.dominio;

public class Telefone {
	
	private int idTelefone;
	private String telefoneResidencial;
	private String telefoneCelular;
	private Pessoa pessoa;
	
	public Telefone(){
		
		setIdTelefone(0);
		setTelefoneResidencial("");
		setTelefoneCelular("");
		setPessoa(null);
		
	}
	 
	public Telefone(int idTelefone,String telefoneResidencial,String telefoneCelular,Pessoa p){
		
		setIdTelefone(0);
		setTelefoneResidencial(telefoneResidencial);
		setTelefoneCelular(telefoneCelular);
		setPessoa(p);
		
	}

	public Telefone(String telefoneResidencial,String telefoneCelular,Pessoa p){

		setTelefoneResidencial(telefoneResidencial);
		setTelefoneCelular(telefoneCelular);
		setPessoa(p);
		
		
	}
	
	/*----------------- GETTERS E SETTERS ----------------*/
	public int getIdTelefone() {
		return idTelefone;
	}
	public void setIdTelefone(int idTelefone) {
		this.idTelefone = idTelefone;
	}
	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}
	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}
	public String getTelefoneCelular() {
		return telefoneCelular;
	}
	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
	public boolean equals(Telefone t){
		if(t instanceof Telefone){
			if(this.getTelefoneCelular() == t.getTelefoneCelular()){
				if(this.getTelefoneResidencial() == t.getTelefoneResidencial()){
					if(this.getPessoa() == t.getPessoa()){
							return true;
					}
				}
			}
		}
		
		return false;
		
	}
	
	

}
