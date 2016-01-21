package br.edu.ifpb.auxilio.dominio;

public class InstituicaoFinanciadora {
	
	private int idIF;
	private String nomeIF;
	private String cnpj;
	private double orcamento;
	private TecnicoAdmin admin;
	
	public InstituicaoFinanciadora(){
		
		setIdIF(0);
		setNomeIF("");
		setCnpj("");
		setOrcamento(0);
		setAdmin(null);
		
	}
	
	public InstituicaoFinanciadora(int idIF,String nomeIF,String cnpj,double orcamento,TecnicoAdmin tecnico){
			
		setIdIF(idIF);
		setNomeIF(nomeIF);
		setCnpj(cnpj);
		setOrcamento(orcamento);
		setAdmin(tecnico);
		
	}	
	
	public InstituicaoFinanciadora(String nomeIF,String cnpj,double orcamento,TecnicoAdmin tecnico){
		
		
	}
	
	
	/*----------------- GETTERS E SETTERS ----------------*/
	
	public int getIdIF() {
		return idIF;
	}
	public void setIdIF(int idIF) {
		this.idIF = idIF;
	}
	public String getNomeIF() {
		return nomeIF;
	}
	public void setNomeIF(String nomeIF) {
		this.nomeIF = nomeIF;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public double getOrcamento() {
		return orcamento;
	}
	public void setOrcamento(double orcamento) {
		this.orcamento = orcamento;
	}
	public TecnicoAdmin getAdmin() {
		return admin;
	}
	public void setAdmin(TecnicoAdmin admin) {
		this.admin = admin;
	}
	
	
	public boolean equals(InstituicaoFinanciadora If){
		if(If instanceof InstituicaoFinanciadora){
			if(this.getNomeIF() == If.getNomeIF()){
				if(this.getCnpj() == If.getCnpj()){
					if(this.getOrcamento() == If.getOrcamento()){
						if(this.getAdmin() == If.getAdmin()){
								return true;
						}
					}
				}
			}
		}
		return false;
	}

	
	

}
