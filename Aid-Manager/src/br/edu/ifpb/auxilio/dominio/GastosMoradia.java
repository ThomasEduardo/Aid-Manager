package br.edu.ifpb.auxilio.dominio;

public class GastosMoradia {
	
	
	private int idGastosMoradia;
	private double aluguel;
	private double condominio;
	private double luz;
	private double agua;
	private double telefone;
	private double financiamentoCasaPropria;
	//private PerfilSocioEconomico ps;
	
	public GastosMoradia(){
		
		setIdGastosMoradia(0);
		setAluguel(0);
		setCondominio(0);
		setLuz(0);
		setAgua(0);
		setTelefone(0);
		setFinanciamentoCasaPropria(0);
		
	}
	
	public GastosMoradia(int idGastosMoradia,double aluguel,double condominio,double luz,double agua,double telefone,double financiamentoCasaPropria){
		
		setIdGastosMoradia(idGastosMoradia);
		setAluguel(aluguel);
		setCondominio(condominio);
		setLuz(luz);
		setAgua(agua);
		setTelefone(telefone);
		setFinanciamentoCasaPropria(financiamentoCasaPropria);
		
	}
	
	public GastosMoradia(double aluguel,double condominio,double luz,double agua,double telefone,double financiamentoCasaPropria){
		
		setAluguel(aluguel);
		setCondominio(condominio);
		setLuz(luz);
		setAgua(agua);
		setTelefone(telefone);
		setFinanciamentoCasaPropria(financiamentoCasaPropria);
		
	}
	
	/*----------------- GETTERS E SETTERS ----------------*/
	
	public int getIdGastosMoradia() {
		return idGastosMoradia;
	}
	public void setIdGastosMoradia(int idGastosMoradia) {
		this.idGastosMoradia = idGastosMoradia;
	}
	public double getAluguel() {
		return aluguel;
	}
	public void setAluguel(double aluguel) {
		this.aluguel = aluguel;
	}
	public double getCondominio() {
		return condominio;
	}
	public void setCondominio(double condominio) {
		this.condominio = condominio;
	}
	public double getLuz() {
		return luz;
	}
	public void setLuz(double luz) {
		this.luz = luz;
	}
	public double getAgua() {
		return agua;
	}
	public void setAgua(double agua) {
		this.agua = agua;
	}
	public double getTelefone() {
		return telefone;
	}
	public void setTelefone(double telefone) {
		this.telefone = telefone;
	}
	public double getFinanciamentoCasaPropria() {
		return financiamentoCasaPropria;
	}
	public void setFinanciamentoCasaPropria(double financiamentoCasaPropria) {
		this.financiamentoCasaPropria = financiamentoCasaPropria;
	}
	
	public boolean equals(GastosMoradia gm){
		if(this.getAgua() == gm.getAgua()){
			if(this.getAluguel() == gm.getAluguel()){
				if(this.getCondominio() == gm.getCondominio()){
					if(this.getFinanciamentoCasaPropria() == gm.getFinanciamentoCasaPropria()){
						if(this.getLuz() == gm.getTelefone()){
								return true;
						}
					}
				}
			}
		}
		return false;
		
	}
	
	
	
}
