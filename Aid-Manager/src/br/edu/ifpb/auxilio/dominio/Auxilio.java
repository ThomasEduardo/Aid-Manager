package br.edu.ifpb.auxilio.dominio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Auxilio {
	
	private int idAuxilio;
	private String tipoAuxilio;
	private double valorAuxilio;
	private Date validadeInicial;
	private Date validadeFinal;
	private InstituicaoFinanciadora IF;
	private Processo p;
	
	public Auxilio(){
		setIdAuxilio(0);
		setTipoAuxilio("");
		setValorAuxilio(0);
		setIF(null);
		setP(null);
		
	} 
	public Auxilio(int idAuxilio,String tipoAuxilio,double valorAuxilio,Date vI,Date vF,InstituicaoFinanciadora IF,Processo p){
		setIdAuxilio(idAuxilio);
		setTipoAuxilio(tipoAuxilio);
		setValorAuxilio(valorAuxilio);
		setValidadeInicial(vI);
		setValidadeFinal(vF);
		setIF(IF);
		setP(p);
	}
	
	public Auxilio(String tipoAuxilio,double valorAuxilio,Date vI,Date vF,InstituicaoFinanciadora IF,Processo p){
		setTipoAuxilio(tipoAuxilio);
		setValorAuxilio(valorAuxilio);
		setValidadeInicial(vI);
		setValidadeFinal(vF);
		setIF(IF);
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
									if(this.getP() == aux.getP()){
												return true;
										}
									}
								}
							}
						}
					}
				}
		return false;
		
	}
	
	public void insert(Auxilio aux) throws SQLException{
		
	}

	public boolean update(Auxilio aux) throws SQLException{
		return false;
	}

	public List<Auxilio> getAll() throws SQLException{
		return null;
	}

	public 	Auxilio getById(int idAucilio) throws SQLException{
		return null;	
	}

	public List<Auxilio> find(Auxilio Auxilio) throws SQLException{
		return null;
	}

	public List<Auxilio> convertToList(ResultSet rs) throws SQLException{
		return null;
	}
	
	
	
	
	
	
	
	

}
