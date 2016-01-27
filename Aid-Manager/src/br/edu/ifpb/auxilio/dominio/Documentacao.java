package br.edu.ifpb.auxilio.dominio;

import java.io.File;

public class Documentacao {
	private int idDocumentacao;
	private String nomeDocumentacao;
	private String status;
	private File conteudo;
	private String obs;
	private Discente discente;
	
	// CONSTRUTOR
	public Documentacao(){
		setIdDocumentacao(0);
		setNomeDocumentacao("");
		setStatus("");
		setConteudo(null);
		setObs("");
		setDiscente(null);
	}
	
	public Documentacao(int idDocumentacao, String nomeDocumentacao,
			String status, File conteudo, String obs, Discente discente) {
		this.idDocumentacao = idDocumentacao;
		this.nomeDocumentacao = nomeDocumentacao;
		this.status = status;
		this.conteudo = conteudo;
		this.obs = obs;
		this.discente = discente;
	}
	
	public Documentacao(String nomeDocumentacao,
			String status, File conteudo, String obs, Discente discente) {
		this.nomeDocumentacao = nomeDocumentacao;
		this.status = status;
		this.conteudo = conteudo;
		this.obs = obs;
		this.discente = discente;
	}
	
	// GETTERS E SETTERS

	public int getIdDocumentacao() {
		return idDocumentacao;
	}

	public void setIdDocumentacao(int idDocumentacao) {
		this.idDocumentacao = idDocumentacao;
	}

	public String getNomeDocumentacao() {
		return nomeDocumentacao;
	}

	public void setNomeDocumentacao(String nomeDocumentacao) {
		this.nomeDocumentacao = nomeDocumentacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public File getConteudo() {
		return conteudo;
	}

	public void setConteudo(File conteudo) {
		this.conteudo = conteudo;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Discente getDiscente() {
		return discente;
	}

	public void setDiscente(Discente discente) {
		this.discente = discente;
	}
	
	public boolean equals(Documentacao d){
	  if(d instanceof Documentacao){
		if(this.getIdDocumentacao() == d.getIdDocumentacao()){
			if(this.getNomeDocumentacao() == d.getNomeDocumentacao()){
				if(this.getStatus() == d.getStatus()){
					if(this.getConteudo() == d.getConteudo()){
						if(this.getObs() == d.getObs()){
							if(this.getDiscente() == d.getDiscente()){
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