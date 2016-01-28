package br.edu.ifpb.auxilio.dominio;

import java.util.*;

public abstract class Processo {
	
	private int idProcesso;
	private Date data;
	private String obs;
	private String numProcesso;
	private String assunto;
	private String parecer;
	private Pessoa interessado;
	
	
	public Processo(Date data, String obs, String numProcesso, String assunto,
			Pessoa interessado,String parecer) {
		this.data = data;
		this.obs = obs;
		this.numProcesso = numProcesso;
		this.assunto = assunto;
		this.interessado = interessado;
		this.parecer = parecer;
	}
	
	public Processo(){
		setIdProcesso(0);
		setData(null);
		setObs("");
		setNumProcesso("");
		setInteressado(null);
		setParecer("");
		
	}
	
	public Processo(int idProcesso,Date data, String obs, String numProcesso, String assunto,
			Pessoa interessado,String parecer) {
		this.data = data;
		this.obs = obs;
		this.numProcesso = numProcesso;
		this.assunto = assunto;
		this.interessado = interessado;
		this.parecer = parecer;
	}
	//GETTERS E SETTERS
	
	
	public Date getData() {
		return data;
	}

	public int getIdProcesso() {
		return idProcesso;
	}

	public void setIdProcesso(int idProcesso) {
		this.idProcesso = idProcesso;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getNumProcesso() {
		return numProcesso;
	}

	public void setNumProcesso(String numProcesso) {
		this.numProcesso = numProcesso;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public Pessoa getInteressado() {
		return interessado;
	}

	public void setInteressado(Pessoa interessado) {
		this.interessado = interessado;
	}
	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	public boolean equals(Processo p){
	if(p instanceof Processo){
		if(this.getData() == p.getData()){
			if(this.getObs() == p.getObs()){
				if(this.getNumProcesso() == p.getNumProcesso()){
					if(this.getAssunto() == p.getAssunto()){
						if(this.getInteressado() == p.getInteressado()){
							if(this.getParecer() == p.getParecer()){
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
}
