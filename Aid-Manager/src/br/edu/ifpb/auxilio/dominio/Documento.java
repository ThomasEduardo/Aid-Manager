/**
 * 
 * @author FannyVieira, RaylaMedeiros, MateusOliveira
 *
 */

package br.edu.ifpb.auxilio.dominio;


public class Documento {
	private int idDocumento;
	private String nomeDocumento;
	private String status;
	private String obs;
	private Discente discente;
	
	/**
	 * 
	 *  Construtor da classe, que não recebe nenhum parâmetro,pois define os valores padrão.
	 * 
	 */
	
	public Documento(){
		setIdDocumento(0);
		setNomeDocumento("");
		setStatus("");
		setObs("");
		setDiscente(null);
	}
	
	
	/**
	 * 
	 *  Construtor da classe, que contém todos os seus atributos
	 *  
	 *  @param idDocumento
	 *  @param nomeDocumento
	 *  @param status
	 *  @param obs
	 *  @param discente
	 * 
	 */
	
	
	public Documento(int idDocumento, String nomeDocumento,
			String status, String obs, Discente discente) {
		this.idDocumento = idDocumento;
		this.nomeDocumento = nomeDocumento;
		this.status = status;
		this.obs = obs;
		this.discente = discente;
	}
	
	/**
	 * 
	 *  Construtor da classe, que não contém o id do documento
	 *  
	 *  @param nomeDocumento
	 *  @param status
	 *  @param obs
	 *  @param discente
	 * 
	 */
	public Documento(String nomeDocumento,
			String status,String obs, Discente discente) {
		this.nomeDocumento = nomeDocumento;
		this.status = status;
		this.obs = obs;
		this.discente = discente;
	}
	
	// GETTERS E SETTERS

	public int getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getNomeDocumento() {
		return nomeDocumento;
	}

	public void setNomeDocumento(String nomeDocumento) {
		this.nomeDocumento = nomeDocumento;
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
		if(this.getIdDocumento() == d.getIdDocumento()){
			if(this.getNomeDocumento() == d.getNomeDocumento()){
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