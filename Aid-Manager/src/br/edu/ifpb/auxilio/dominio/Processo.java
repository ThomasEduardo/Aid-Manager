/**
 * 
 * @author FannyVieira, RaylaMedeiros, MateusOliveira
 *
 */
package br.edu.ifpb.auxilio.dominio;

import java.util.*;

public class Processo {
	
	private int idProcesso;
	private Date dataRequisicao;
	private String obs;
	private String numProcesso;
	private String assunto;
	private String parecer;
	private Pessoa interessado;
	private Servidor servidor;
	
	/**
	 * 
	 *  Construtor da classe, que não contém todos o id 
	 *  
	 *  @param dataRequisicao
	 *  @param obs
	 *  @param numProcesso
	 *  @param assunto
	 *  @param interessado
	 *  @param parecer
	 *  @param servidor
	 */
	
	public Processo(Date dataRequisicao, String obs, String numProcesso, String assunto,
			Pessoa interessado,String parecer,Servidor servidor) {
		this.dataRequisicao = dataRequisicao;
		this.obs = obs;
		this.numProcesso = numProcesso;
		this.assunto = assunto;
		this.interessado = interessado;
		this.parecer = parecer;
		this.servidor = servidor;
	}
	
	/**
	 * 
	 *  Construtor da classe, que não recebe nenhum parâmetro,pois define os valores padrão.
	 * 
	 */
	
	public Processo(){
		setIdProcesso(0);
		setDataRequisicao(null);
		setObs("");
		setNumProcesso("");
		setInteressado(null);
		setParecer("");
		setServidor(null);
		
	}
	
	/**
	 * 
	 *  Construtor da classe, que contém todos os seus atributos 
	 *  
	 *  @param idProcesso
	 *  @param dataRequisicao
	 *  @param obs
	 *  @param numProcesso
	 *  @param assunto
	 *  @param interessado
	 *  @param parecer
	 *  @param servidor
	 */
	
	public Processo(int idProcesso,Date dataRequisicao, String obs, String numProcesso, String assunto,
			Pessoa interessado,String parecer,Servidor servidor) {
		this.dataRequisicao = dataRequisicao;
		this.obs = obs;
		this.numProcesso = numProcesso;
		this.assunto = assunto;
		this.interessado = interessado;
		this.parecer = parecer;
		this.servidor = servidor;
	}
	//GETTERS E SETTERS
	
	
	public Date getDataRequisicao() {
		return dataRequisicao;
	}

	public int getIdProcesso() {
		return idProcesso;
	}

	public void setIdProcesso(int idProcesso) {
		this.idProcesso = idProcesso;
	}

	public void setDataRequisicao(Date dataRequisicao) {
		this.dataRequisicao = dataRequisicao;
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
	public Servidor getServidor() {
		return servidor;
	}
	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public boolean equals(Processo p){
	if(p instanceof Processo){
		if(this.getDataRequisicao() == p.getDataRequisicao()){
			if(this.getObs() == p.getObs()){
				if(this.getNumProcesso() == p.getNumProcesso()){
					if(this.getAssunto() == p.getAssunto()){
						if(this.getInteressado() == p.getInteressado()){
							if(this.getParecer() == p.getParecer()){
								if(this.getServidor() == p.getServidor()){
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
