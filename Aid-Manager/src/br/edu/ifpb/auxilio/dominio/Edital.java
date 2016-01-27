package br.edu.ifpb.auxilio.dominio;

import java.util.Date;

public class Edital extends Processo {
	private int idEdital;
	private Date iniInscricoes;
	private Date FimInscricoes;
	private Date iniEntregaForm;
	private int ano;
	private Date fimForm;
	private String descricao;
	private String titulo;
	private double ValorBolsaDiscente;
	private int VagasBolsistas;
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
	public Edital(Date data, String obs, String numProcesso, String assunto, Pessoa interessado,int idEdital,Date iniInscricoes,Date fimInscricoes,Date iniEntregaForm,Date fimForm,int ano,String descricao,String titulo,double valorBolsaDiscente,int vagasBolsistas,String numEdital) {
		super(data, obs, numProcesso, assunto, interessado);
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
	public Edital(int idProcesso, Date data, String obs, String numProcesso, String assunto, Pessoa interessado,Date iniInscricoes,Date fimInscricoes,Date iniEntregaForm,Date fimForm,int ano,String descricao,String titulo,double valorBolsaDiscente,int vagasBolsistas,String numEdital) {
		super(idProcesso, data, obs, numProcesso, assunto, interessado);
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
		return FimInscricoes;
	}
	public void setFimInscricoes(Date fimInscricoes) {
		FimInscricoes = fimInscricoes;
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
		return ValorBolsaDiscente;
	}
	public void setValorBolsaDiscente(double valorBolsaDiscente) {
		ValorBolsaDiscente = valorBolsaDiscente;
	}
	public int getVagasBolsistas() {
		return VagasBolsistas;
	}
	public void setVagasBolsistas(int vagasBolsistas) {
		VagasBolsistas = vagasBolsistas;
	}
	public String getNumEdital() {
		return numEdital;
	}
	public void setNumEdital(String numEdital) {
		this.numEdital = numEdital;
	}
//---------------------------------------------------------

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edital other = (Edital) obj;
		if (FimInscricoes == null) {
			if (other.FimInscricoes != null)
				return false;
		} else if (!FimInscricoes.equals(other.FimInscricoes))
			return false;
		if (VagasBolsistas != other.VagasBolsistas)
			return false;
		if (Double.doubleToLongBits(ValorBolsaDiscente) != Double.doubleToLongBits(other.ValorBolsaDiscente))
			return false;
		if (ano != other.ano)
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (fimForm == null) {
			if (other.fimForm != null)
				return false;
		} else if (!fimForm.equals(other.fimForm))
			return false;
		if (idEdital != other.idEdital)
			return false;
		if (iniEntregaForm == null) {
			if (other.iniEntregaForm != null)
				return false;
		} else if (!iniEntregaForm.equals(other.iniEntregaForm))
			return false;
		if (iniInscricoes == null) {
			if (other.iniInscricoes != null)
				return false;
		} else if (!iniInscricoes.equals(other.iniInscricoes))
			return false;
		if (numEdital == null) {
			if (other.numEdital != null)
				return false;
		} else if (!numEdital.equals(other.numEdital))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	
}
