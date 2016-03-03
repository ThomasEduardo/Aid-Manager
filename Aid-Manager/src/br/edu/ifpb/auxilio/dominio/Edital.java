package br.edu.ifpb.auxilio.dominio;

import java.util.Date;

public class Edital extends Processo {
	
	
	private int idEdital;
	private Date iniInscricoes;
	private Date fimInscricoes;
	private Date iniEntregaForm;
	private int ano;
	private Date fimForm;
	private String descricao;
	private String titulo;
	private double valorBolsaDiscente;
	private int vagasBolsistas;
	private String numEdital;
	
	
	
	
	
	public Edital() {
		super();
		setIdEdital(0);
		setIniInscricoes(null);
		setFimInscricoes(null);
		setIniEntregaForm(null);
		setFimForm(null);
		setAno(0);
		setDescricao("");
		setTitulo("");
		setValorBolsaDiscente(0);
		setVagasBolsistas(0);
		setNumEdital("");
	}
	public Edital(int idProcesso,Date data, String obs, String numProcesso, String assunto, Pessoa interessado,int idEdital,Date iniInscricoes,Date fimInscricoes,Date iniEntregaForm,Date fimForm,int ano,String descricao,String titulo,double valorBolsaDiscente,int vagasBolsistas,String numEdital,String parecer,Servidor servidor) {
		super(idProcesso,data, obs, numProcesso, assunto, interessado,parecer,servidor);
		setIdEdital(idEdital);
		setIniInscricoes(iniInscricoes);
		setFimInscricoes(fimInscricoes);
		setIniEntregaForm(iniEntregaForm);
		setFimForm(fimForm);
		setAno(ano);
		setDescricao(descricao);
		setTitulo(titulo);
		setValorBolsaDiscente(valorBolsaDiscente);
		setVagasBolsistas(vagasBolsistas);
		setNumEdital(numEdital);
		
	}
	public Edital(Date data, String obs, String numProcesso, String assunto, Pessoa interessado,Date iniInscricoes,Date fimInscricoes,Date iniEntregaForm,Date fimForm,int ano,String descricao,String titulo,double valorBolsaDiscente,int vagasBolsistas,String numEdital,String parecer,Servidor servidor) {
		super(data, obs, numProcesso, assunto, interessado,parecer,servidor);
		setIniInscricoes(iniInscricoes);
		setFimInscricoes(fimInscricoes);
		setIniEntregaForm(iniEntregaForm);
		setFimForm(fimForm);
		setAno(ano);
		setDescricao(descricao);
		setTitulo(titulo);
		setValorBolsaDiscente(valorBolsaDiscente);
		setVagasBolsistas(vagasBolsistas);
		setNumEdital(numEdital);
	}
	//------------------------------------------------------
	public int getIdEdital() {
		return idEdital;
	}
	public void setIdEdital(int idEdital) {
		this.idEdital = idEdital;
	}
	public Date getIniInscricoes() {
		return iniInscricoes;
	}
	public void setIniInscricoes(Date iniInscricoes) {
		this.iniInscricoes = iniInscricoes;
	}
	public Date getFimInscricoes() {
		return fimInscricoes;
	}
	public void setFimInscricoes(Date fimInscricoes) {
		this.fimInscricoes = fimInscricoes;
	}
	public Date getIniEntregaForm() {
		return iniEntregaForm;
	}
	public void setIniEntregaForm(Date iniEntregaForm) {
		this.iniEntregaForm = iniEntregaForm;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public Date getFimForm() {
		return fimForm;
	}
	public void setFimForm(Date fimForm) {
		this.fimForm = fimForm;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public double getValorBolsaDiscente() {
		return valorBolsaDiscente;
	}
	public void setValorBolsaDiscente(double valorBolsaDiscente) {
		this.valorBolsaDiscente = valorBolsaDiscente;
	}
	public int getVagasBolsistas() {
		return vagasBolsistas;
	}
	public void setVagasBolsistas(int vagasBolsistas) {
		this.vagasBolsistas = vagasBolsistas;
	}
	public String getNumEdital() {
		return numEdital;
	}
	public void setNumEdital(String numEdital) {
		this.numEdital = numEdital;
	}
//---------------------------------------------------------

	
	public boolean equals(Edital e) {
		if(e instanceof Edital){
			if(super.equals(e)){
				if(this.getIniInscricoes() == e.getIniInscricoes()){
					if(this.getFimInscricoes() == e.getFimInscricoes()){
						if(this.getIniEntregaForm() == e.getIniEntregaForm()){
							if(this.getFimForm() == e.getFimForm()){
								if(this.getAno() == e.getAno()){
									if(this.getDescricao() == e.getDescricao()){
										if(this.getTitulo() == e.getTitulo()){
											if(this.getValorBolsaDiscente() == e.getValorBolsaDiscente()){
												if(this.getVagasBolsistas() == e.getVagasBolsistas()){
													if(this.getNumEdital() == e.getNumEdital()){
															return true;
													}
												}
											}
										}
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
