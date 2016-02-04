package br.edu.ifpb.auxilio.dominio;

import java.util.Date;

public class Auxilio {
	
	private int idAuxilio;
	private String tipoAuxilio;
	private double valorAuxilio;
	private Date validadeInicial;
	private Date validadeFinal;
	private InstituicaoFinanciadora IF;
	private TecnicoAdmin t;
	private Processo p;
	
	public Auxilio(){
		setIdAuxilio(0);
		setTipoAuxilio("");
		setValorAuxilio(0);
		setIF(null);
		setT(null);
		setP(null);
	} 
	public Auxilio(int idAuxilio,String tipoAuxilio,double valorAuxilio,Date vI,Date vF,InstituicaoFinanciadora IF,TecnicoAdmin t,Processo p){
		setIdAuxilio(idAuxilio);
		setTipoAuxilio(tipoAuxilio);
		setValorAuxilio(valorAuxilio);
		setValidadeInicial(vI);
		setValidadeFinal(vF);
		setIF(IF);
		setT(t);
		setP(p);
	}
	
	public Auxilio(String tipoAuxilio,double valorAuxilio,Date vI,Date vF,InstituicaoFinanciadora IF,TecnicoAdmin t,Processo p){
		setTipoAuxilio(tipoAuxilio);
		setValorAuxilio(valorAuxilio);
		setValidadeInicial(vI);
		setValidadeFinal(vF);
		setIF(IF);
		setT(t);
		setP(p);
	}
	
	/*----------------- GETTERS E SETTERS ----------------*/
	public int getIdAuxilio() {
		return idAuxilio;
	}
	public void setIdAuxilio(int idAuxilio) {
		this.idAuxilio = idAuxilio;
	}
	public String getTipoAuxilio() {
		return tipoAuxilio;
	}
	public void setTipoAuxilio(String tipoAuxilio) {
		this.tipoAuxilio = tipoAuxilio;
	}
	public double getValorAuxilio() {
		return valorAuxilio;
	}
	public void setValorAuxilio(double valorAuxilio) {
		this.valorAuxilio = valorAuxilio;
	}
	public Date getValidadeInicial() {
		return validadeInicial;
	}
	public void setValidadeInicial(Date validadeInicial) {
		this.validadeInicial = validadeInicial;
	}
	public Date getValidadeFinal() {
		return validadeFinal;
	}
	public void setValidadeFinal(Date validadeFinal) {
		this.validadeFinal = validadeFinal;
	}
	public InstituicaoFinanciadora getIF() {
		return IF;
	}
	public void setIF(InstituicaoFinanciadora iF) {
		IF = iF;
	}
	public TecnicoAdmin getT() {
		return t;
	}
	public void setT(TecnicoAdmin t) {
		this.t = t;
	}
	public Processo getP() {
		return p;
	}
	public void setP(Processo p) {
		this.p = p;
	}
	public boolean equals(Auxilio aux){
		if(aux instanceof Auxilio){
			if(this.getTipoAuxilio() == aux.getTipoAuxilio()){
				if(this.getValidadeFinal() == aux.getValidadeFinal()){
					if(this.getValidadeInicial() == aux.getValidadeInicial()){
						if(this.getValorAuxilio() == aux.getValorAuxilio()){
							if(this.getIF() == aux.getIF()){
								if(this.getT() == aux.getT()){
									if(this.getP() == aux.getP()){
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
		
	}

	
	
	
	
	
	
	

}
