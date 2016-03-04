package br.edu.ifpb.auxilio.dominio;


public class Documento {
	private int idDocumentacao;
	private String nomeDocumentacao;
	private String status;
	private String obs;
	private Discente discente;
	
	// CONSTRUTOR
	public Documento(){
		setIdDocumentacao(0);
		setNomeDocumentacao("");
		setStatus("");
		setObs("");
		setDiscente(null);
	}
	
	public Documento(int idDocumentacao, String nomeDocumentacao,
			String status, String obs, Discente discente) {
		this.idDocumentacao = idDocumentacao;
		this.nomeDocumentacao = nomeDocumentacao;
		this.status = status;
		this.obs = obs;
		this.discente = discente;
	}
	
	public Documento(String nomeDocumentacao,
			String status,String obs, Discente discente) {
		this.nomeDocumentacao = nomeDocumentacao;
		this.status = status;
		this.obs = obs;
		this.discente = discente;
	}
	
	// GETTERS E SETTERS

	public int getIdDocumentacao() {
		return idDocumentacao;
	}

	public void setIdDocumentacao(int idDocumentacao) {
		this.idDocumento = idDocumentacao;
	}

	public String getNomeDocumentacao() {
		return nomeDocumento;
	}

	public void setNomeDocumento(String nomeDocumentacao) {
		this.nomeDocumento = nomeDocumentacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
	
	public boolean equals(Documento d){
	  if(d instanceof Documento){
		if(this.getIdDocumentacao() == d.getIdDocumento()){
			if(this.getNomeDocumentacao() == d.getNomeDocumento()){
				if(this.getStatus() == d.getStatus()){
						if(this.getObs() == d.getObs()){
							if(this.getDiscente() == d.getDiscente()){
								return true;
							}
						}
					}
				}
			}
		}
	  return false;
		
	}

}