package br.edu.ifpb.auxilio.dominio;

public class ComposicaoRendaFamiliar {
	
	private int idCrf;
	private String nome;
	private int idade;
	private int grauDeInstrucao;
	private String profissao;
	private double renda;
	private PerfilSocioEconomico ps;
	
	public ComposicaoRendaFamiliar(){
		
		setIdCrf(0);
		setNome("");
		setIdade(0);
		setGrauDeInstrucao(0);
		setProfissao("");
		setRenda(0);
		setPs(null);
		
	}
	
	public ComposicaoRendaFamiliar(int idCrf,String nome,int idade,int grauInstrucao,String profissao,double renda,PerfilSocioEconomico Ps){
		
		
		setIdCrf(idCrf);
		setNome(nome);
		setIdade(idade);
		setGrauDeInstrucao(grauInstrucao);
		setProfissao(profissao);
		setRenda(renda);
		setPs(Ps);
		
	}
	
	public ComposicaoRendaFamiliar(String nome,int idade,int grauInstrucao,String profissao,double renda,PerfilSocioEconomico ps){
		
		setNome(nome);
		setIdade(idade);
		setGrauDeInstrucao(grauInstrucao);
		setProfissao(profissao);
		setRenda(renda);
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
	
	public boolean equals(ComposicaoRendaFamiliar crm){
		if(this.getNome() == crm.getNome()){
			if(this.getProfissao() == crm.getProfissao()){
				if(this.getRenda() == crm.getRenda()){
					if(this.getIdade() == crm.getIdade()){
						if(this.getGrauDeInstrucao() == crm.getGrauDeInstrucao()){
							if(this.getPs() == crm.getPs()){
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
