package br.edu.ifpb.auxilio.dominio;

import java.util.*;

public abstract class Processo {
	private Date data;
	private String obs;
	private String numProcesso;
	private String assunto;
	private Discente interessado;
	
	// CONSTRUTOR
	
	public Processo(Date data, String obs, String numProcesso, String assunto,
			Discente interessado) {
		super();
		this.data = data;
		this.obs = obs;
		this.numProcesso = numProcesso;
		this.assunto = assunto;
		this.interessado = interessado;
	}
	
	//GETTERS E SETTERS
	
	public Date getData() {
		return data;
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

	public Discente getInteressado() {
		return interessado;
	}

	public void setInteressado(Discente interessado) {
		this.interessado = interessado;
	}
	
}
