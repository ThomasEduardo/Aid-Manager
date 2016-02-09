package br.edu.ifpb.auxilio.dominio;

public class PerfilSocioEconomico {
	
	private int idPerfilSocio;
	private String situacaoRendaFamiliar;
	private String moradia;
	private String situacaoMoradia;
	private String residenciaFamiliar;
	private String situacaoTrabalho;
	private double aluguel;
	private double condominio;
	private double luz;
	private double agua;
	private double telefone;
	private double financiamentoCasaPropria;
	private AssistenteSocial as;
	private Discente Discente;
	
	public PerfilSocioEconomico(){
		
		setIdPerfilSocio(0);
		setSituacaoRendaFamiliar("");
		setMoradia("");
		setSituacaoMoradia("");
		setResidenciaFamiliar("");
		setSituacaoTrabalho("");
		setAluguel(0);
		setCondominio(0);
		setLuz(0);
		setAgua(0);
		setTelefone(0);
		setFinanciamentoCasaPropria(0);
		setAs(null);
		setDiscente(null);
		
	}
	
	public PerfilSocioEconomico(int idPs,String srf,String moradia,String situacaoMoradia,String residenciaFamiliar,String situacaoTrabalho,double aluguel,double condominio,double luz,double agua,double telefone,double financiamentoCasaPropria,AssistenteSocial as,Discente d){
		
		
		setIdPerfilSocio(idPs);
		setSituacaoRendaFamiliar(srf);
		setMoradia(moradia);
		setSituacaoMoradia(situacaoMoradia);
		setResidenciaFamiliar(residenciaFamiliar);
		setSituacaoTrabalho(situacaoTrabalho);
		setAluguel(aluguel);
		setCondominio(condominio);
		setLuz(luz);
		setAgua(agua);
		setTelefone(telefone);
		setFinanciamentoCasaPropria(financiamentoCasaPropria);
		setAs(as);
		setDiscente(d);
		
	}
	
	public PerfilSocioEconomico(String srf,String moradia,String situacaoMoradia,String residenciaFamiliar,String situacaoTrabalho,double aluguel,double condominio,double luz,double agua,double telefone,double financiamentoCasaPropria,AssistenteSocial as,Discente d){
	
		
		setSituacaoRendaFamiliar(srf);
		setMoradia(moradia);
		setSituacaoMoradia(situacaoMoradia);
		setResidenciaFamiliar(residenciaFamiliar);
		setSituacaoTrabalho(situacaoTrabalho);
		setAluguel(aluguel);
		setCondominio(condominio);
		setLuz(luz);
		setAgua(agua);
		setTelefone(telefone);
		setFinanciamentoCasaPropria(financiamentoCasaPropria);
		setAs(as);
		setDiscente(d);
		
	}

	/*----------------- GETTERS E SETTERS ----------------*/
	
	public int getIdPerfilSocio() {
		return idPerfilSocio;
	}

	public void setIdPerfilSocio(int idPerfilSocio) {
		this.idPerfilSocio = idPerfilSocio;
	}

	public String getSituacaoRendaFamiliar() {
		return situacaoRendaFamiliar;
	}

	public void setSituacaoRendaFamiliar(String situacaoRendaFamiliar) {
		this.situacaoRendaFamiliar = situacaoRendaFamiliar;
	}

	public String getMoradia() {
		return moradia;
	}

	public void setMoradia(String moradia) {
		this.moradia = moradia;
	}

	public String getSituacaoMoradia() {
		return situacaoMoradia;
	}

	public void setSituacaoMoradia(String situacaoMoradia) {
		this.situacaoMoradia = situacaoMoradia;
	}

	public String getResidenciaFamiliar() {
		return residenciaFamiliar;
	}

	public void setResidenciaFamiliar(String residenciaFamiliar) {
		this.residenciaFamiliar = residenciaFamiliar;
	}

	public String getSituacaoTrabalho() {
		return situacaoTrabalho;
	}

	public void setSituacaoTrabalho(String situacaoTrabalho) {
		this.situacaoTrabalho = situacaoTrabalho;
	}
	public double getAluguel() {
		return aluguel;
	}

	public void setAluguel(double aluguel) {
		this.aluguel = aluguel;
	}

	public double getCondominio() {
		return condominio;
	}

	public void setCondominio(double condominio) {
		this.condominio = condominio;
	}

	public double getLuz() {
		return luz;
	}

	public void setLuz(double luz) {
		this.luz = luz;
	}

	public double getAgua() {
		return agua;
	}

	public void setAgua(double agua) {
		this.agua = agua;
	}

	public double getTelefone() {
		return telefone;
	}

	public void setTelefone(double telefone) {
		this.telefone = telefone;
	}

	public double getFinanciamentoCasaPropria() {
		return financiamentoCasaPropria;
	}

	public void setFinanciamentoCasaPropria(double financiamentoCasaPropria) {
		this.financiamentoCasaPropria = financiamentoCasaPropria;
	}
	public AssistenteSocial getAs() {
		return as;
	}

	public void setAs(AssistenteSocial as) {
		this.as = as;
	}
	public Discente getDiscente() {
		return Discente;
	}

	public void setDiscente(Discente discente) {
		Discente = discente;
	}

	public boolean equals(PerfilSocioEconomico ps){
		if(this.getMoradia() == ps.getMoradia()){
			if(this.getResidenciaFamiliar() == ps.getResidenciaFamiliar()){
				if(this.getSituacaoMoradia() == ps.getSituacaoMoradia()){
					if(this.getSituacaoRendaFamiliar() == ps.getSituacaoRendaFamiliar()){
						if(this.getSituacaoTrabalho() == ps.getSituacaoTrabalho()){
							if(this.getAluguel() == ps.getAluguel()){
								if(this.getCondominio() == ps.getCondominio()){
									if(this.getLuz() == ps.getLuz()){
										if(this.getAgua() == ps.getAgua()){
											if(this.getTelefone() == ps.getTelefone()){
												if	(this.getAs() == ps.getAs()){
													if(this.getDiscente() == ps.getDiscente()){
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
