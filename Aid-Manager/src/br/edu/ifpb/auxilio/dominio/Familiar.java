package br.edu.ifpb.auxilio.dominio;

public class Familiar {
	
	private int idCrf;
	private String nome;
	private int idade;
	private int grauDeInstrucao;
	private String profissao;
	private double renda;
	private String doenca;

	private PerfilSocioEconomico ps;
	
	public Familiar(){
		
		setIdCrf(0);
		setNome("");
		setIdade(0);
		setGrauDeInstrucao(0);
		setProfissao("");
		setRenda(0);
		setDoenca("");
		setPs(null);
		
	}
	
	public Familiar(int idCrf,String nome,int idade,int grauInstrucao,String profissao,double renda,String doenca,PerfilSocioEconomico Ps){
		
		
		setIdCrf(idCrf);
		setNome(nome);
		setIdade(idade);
		setGrauDeInstrucao(grauInstrucao);
		setProfissao(profissao);
		setRenda(renda);
		setDoenca(doenca);
		setPs(Ps);
		
	}
	
	public Familiar(String nome,int idade,int grauInstrucao,String profissao,double renda,String doenca,PerfilSocioEconomico ps){
		
		setNome(nome);
		setIdade(idade);
		setGrauDeInstrucao(grauInstrucao);
		setProfissao(profissao);
		setRenda(renda);
		setDoenca(doenca);
		setPs(ps);
		
	}
	
	/*----------------- GETTERS E SETTERS ----------------*/
	
	public int getIdCrf() {
		return idCrf;
	}
	public void setIdCrf(int idCrf) {
		this.idCrf = idCrf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public int getGrauDeInstrucao() {
		return grauDeInstrucao;
	}
	public void setGrauDeInstrucao(int grauDeInstrucao) {
		this.grauDeInstrucao = grauDeInstrucao;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public double getRenda() {
		return renda;
	}
	public void setRenda(double renda) {
		this.renda = renda;
	}
	public PerfilSocioEconomico getPs() {
		return ps;
	}
	public void setPs(PerfilSocioEconomico ps) {
		this.ps = ps;
	}
	public String getDoenca() {
		return doenca;
	}

	public void setDoenca(String doenca) {
		this.doenca = doenca;
	}
	
	public boolean equals(Familiar crm){
		if(this.getNome() == crm.getNome()){
			if(this.getProfissao() == crm.getProfissao()){
				if(this.getRenda() == crm.getRenda()){
					if(this.getIdade() == crm.getIdade()){
						if(this.getGrauDeInstrucao() == crm.getGrauDeInstrucao()){
							if(this.getDoenca() == crm.getDoenca()){
								if(this.getPs() == crm.getPs()){
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
