package br.edu.ifpb.auxilio.dominio;

import java.util.Date;

public class Discente extends Pessoa {
	
	private int idDiscente;
	private String escolaOrigem;
	private String orgExpeditor;
	private String numCartaoSus;
	private String estadoCivil;
	private String Curso;
	private int periodoLetivo;
	private String turno;
	private String endereco;
	private String cep;
	private String bairro;
	private String cidade;
	private int numCasa;
	private String pontoRef;
	private String estado;
	private String motivoSolicitacao;
	
	
	
	public Discente(){
		
		super();
		setIdDiscente(0);
		setEscolaOrigem("");
		setOrgExpeditor("");
		setNumCartaoSus("");
		setEstadoCivil("");
		setCurso("");
		setPeriodoLetivo(0);
		setTurno("");
		setEndereco("");
		setCep("");
		setBairro("");
		setCidade("");
		setNumCasa(0);
		setPontoRef("");
		setEstado("");

		
	}
	public Discente(int idPessoa,String nomePessoa,String matricula,Date dataNasc,String senha,String email,String cpf,String rg,String sexo,int idDiscente,String numCartaoSus,String estadoCivil,String curso,int PeriodoLetivo,String turno,String escolaOrigem,String orgExpeditor,int idade,int periodoLetivo,String endereco,String cep,String bairro,String estado,String cidade,int numCasa,String pontoRef,Auxilio aux){
		super(idPessoa,nomePessoa,matricula,dataNasc,senha,email,cpf,rg,sexo);
		setIdDiscente(idDiscente);
		setEscolaOrigem(escolaOrigem);
		setOrgExpeditor(orgExpeditor);
		setNumCartaoSus(numCartaoSus);
		setEstadoCivil(estadoCivil);
		setCurso(curso);
		setPeriodoLetivo(periodoLetivo);
		setTurno(turno);
		setEndereco(endereco);
		setCep(cep);
		setBairro(bairro);
		setCidade(cidade);
		setNumCasa(numCasa);
		setPontoRef(pontoRef);
		setEstado(estado);
		
	}
	public Discente(String nomePessoa,String matricula,Date dataNasc,String senha,String email,String cpf,String rg,String sexo,String numCartaoSus,String estadoCivil,String curso,int PeriodoLetivo,String turno,String escolaOrigem,String orgExpeditor,int idade,int periodoLetivo,String endereco,String cep,String bairro,String estado,String cidade,int numCasa,String pontoRef){
		super(nomePessoa,matricula,dataNasc,senha,email,cpf,rg,sexo);
		setEscolaOrigem(escolaOrigem);
		setOrgExpeditor(orgExpeditor);
		setNumCartaoSus(numCartaoSus);
		setEstadoCivil(estadoCivil);
		setCurso(curso);
		setPeriodoLetivo(periodoLetivo);
		setTurno(turno);
		setEndereco(endereco);
		setCep(cep);
		setBairro(bairro);
		setCidade(cidade);
		setNumCasa(numCasa);
		setPontoRef(pontoRef);
		setEstado(estado);
		
	}
	
	
	/*------------------- GETTERS E SETTERS ---------------------*/
	public int getIdDiscente() {
		return idDiscente;
	}
	public void setIdDiscente(int idDiscente) {
		this.idDiscente = idDiscente;
	}
	public String getEscolaOrigem() {
		return escolaOrigem;
	}
	public void setEscolaOrigem(String escolaOrigem) {
		this.escolaOrigem = escolaOrigem;
	}
	public String getOrgExpeditor() {
		return orgExpeditor;
	}
	public void setOrgExpeditor(String orgExpeditor) {
		this.orgExpeditor = orgExpeditor;
	}
	public String getNumCartaoSus() {
		return numCartaoSus;
	}
	public void setNumCartaoSus(String numCartaoSus) {
		this.numCartaoSus = numCartaoSus;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getCurso() {
		return Curso;
	}
	public void setCurso(String curso) {
		Curso = curso;
	}
	public int getPeriodoLetivo() {
		return periodoLetivo;
	}
	public void setPeriodoLetivo(int periodoLetivo) {
		this.periodoLetivo = periodoLetivo;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public int getNumCasa() {
		return numCasa;
	}
	public void setNumCasa(int numCasa) {
		this.numCasa = numCasa;
	}
	public String getPontoRef() {
		return pontoRef;
	}
	public void setPontoRef(String pontoRef) {
		this.pontoRef = pontoRef;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMotivoSolicitacao() {
		return motivoSolicitacao;
	}
	public void setMotivoSolicitacao(String motivoSolicitacao) {
		this.motivoSolicitacao = motivoSolicitacao;
	}
	
	public boolean equals(Discente d){
		if (d instanceof Discente) {
			if (super.equals(d)) {
				if (this.getEscolaOrigem() == d.getEscolaOrigem()) {
					if (this.getOrgExpeditor() == d.getOrgExpeditor()) {
						if (this.getEstadoCivil() == d.getEstadoCivil()) {
								if (this.getCurso() == d.getCurso()) {
									if (this.getPeriodoLetivo() == d.getPeriodoLetivo()) {
										if (this.getTurno() == d.getTurno()) {
											if (this.getEndereco() == d.getEndereco()) {
															if (this.getCep() == d.getCep()) {
																if (this.getBairro() == d.getBairro()) {
																	if (this.getCidade() == d.getCidade()) {
																		if (this.getNumCasa() == d.getNumCasa()) {
																			if (this.getPontoRef() == d.getPontoRef()) {
																				if (this.getEstado() == d.getEstado()) {
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
									}
								}
							}
		
		return false;
	}
	
	
	
}
