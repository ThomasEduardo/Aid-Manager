package br.edu.ifpb.auxilio.dominio;

public class Discente extends Pessoa {
	
	private int idDiscente;
	private String escolaOrigem;
	private String orgExpeditor;
	private String numCartaoSus;
	private String estadoCivil;
	private int idade;
	private String Curso;
	private int periodoLetivo;
	private String turno;
	private Auxilio aux;
	private DadosBancarios db;
	private PerfilSocioEconomico ps;
	
	
	public Discente(){
		
		setIdDiscente(0);
		setEscolaOrigem("");
		setOrgExpeditor("");
		setNumCartaoSus("");
		setEstadoCivil("");
		setIdade(0);
		setCurso("");
		setPeriodoLetivo(0);
		setTurno("");
		setAux(null);
		setDb(null);
		setPs(null);
		
	}
	public Discente(int idDiscente,String numCartaoSus,String estadoCivil,int Idade,String curso,int PeriodoLetivo,String turno,Auxilio aux,DadosBancarios db,PerfilSocioEconomico ps,String escolaOrigem,String orgExpeditor,int idade,int periodoLetivo){
		
		setIdDiscente(idDiscente);
		setEscolaOrigem(escolaOrigem);
		setOrgExpeditor(orgExpeditor);
		setNumCartaoSus(numCartaoSus);
		setEstadoCivil(estadoCivil);
		setIdade(idade);
		setCurso(curso);
		setPeriodoLetivo(periodoLetivo);
		setTurno(turno);
		setAux(aux);
		setDb(db);
		setPs(ps);
		
	}
	public Discente(String numCartaoSus,String estadoCivil,int Idade,String curso,int PeriodoLetivo,String turno,Auxilio aux,DadosBancarios db,PerfilSocioEconomico ps,String escolaOrigem,String orgExpeditor,int idade,int periodoLetivo){
		
		setEscolaOrigem(escolaOrigem);
		setOrgExpeditor(orgExpeditor);
		setNumCartaoSus(numCartaoSus);
		setEstadoCivil(estadoCivil);
		setIdade(idade);
		setCurso(curso);
		setPeriodoLetivo(periodoLetivo);
		setTurno(turno);
		setAux(aux);
		setDb(db);
		setPs(ps);
		
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
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
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
	public Auxilio getAux() {
		return aux;
	}
	public void setAux(Auxilio aux) {
		this.aux = aux;
	}
	public DadosBancarios getDb() {
		return db;
	}
	public void setDb(DadosBancarios db) {
		this.db = db;
	}
	public PerfilSocioEconomico getPs() {
		return ps;
	}
	public void setPs(PerfilSocioEconomico ps) {
		this.ps = ps;
	}
	
	public boolean equals(Discente d){
		if(d instanceof Discente){
				if(this.getEscolaOrigem() == d.getEscolaOrigem()){
					if(this.getOrgExpeditor() == d.getOrgExpeditor()){
							if(this.getEstadoCivil() == d.getEstadoCivil()){
								if(this.getIdade() == d.getIdade()){
									if(this.getCurso() == d.getCurso()){
										if(this.getPeriodoLetivo() == d.getPeriodoLetivo()){
											if(this.getTurno() == d.getTurno()){
												if(this.getAux() == d.getAux()){
													if(this.getDb() == d.getDb()){
														if(this.getPs() == d.getPs()){
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
		
		return false;
	}
	
	
	
	
	
	

}
