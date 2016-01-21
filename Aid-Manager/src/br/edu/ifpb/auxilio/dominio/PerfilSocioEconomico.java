package br.edu.ifpb.auxilio.dominio;

public class PerfilSocioEconomico {
	
	private int idPerfilSocio;
	private String situacaoRendaFamiliar;
	private String moradia;
	private String situacaoMoradia;
	private String residenciaFamiliar;
	private String situacaoTrabalho;
	
	public PerfilSocioEconomico(){
		
		setIdPerfilSocio(0);
		setSituacaoRendaFamiliar("");
		setMoradia("");
		setSituacaoMoradia("");
		setResidenciaFamiliar("");
		setSituacaoTrabalho("");
		
	}
	
	public PerfilSocioEconomico(int idPs,String srf,String moradia,String situacaoMoradia,String residenciaFamiliar,String situacaoTrabalho){
		
		
		setIdPerfilSocio(idPs);
		setSituacaoRendaFamiliar(srf);
		setMoradia(moradia);
		setSituacaoMoradia(situacaoMoradia);
		setResidenciaFamiliar(residenciaFamiliar);
		setSituacaoTrabalho(situacaoTrabalho);
		
	}
	
	public PerfilSocioEconomico(String srf,String moradia,String situacaoMoradia,String residenciaFamiliar,String situacaoTrabalho){
	
		
		setSituacaoRendaFamiliar(srf);
		setMoradia(moradia);
		setSituacaoMoradia(situacaoMoradia);
		setResidenciaFamiliar(residenciaFamiliar);
		setSituacaoTrabalho(situacaoTrabalho);
		
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
	
	public boolean equals(PerfilSocioEconomico ps){
		if(this.getMoradia() == ps.getMoradia()){
			if(this.getResidenciaFamiliar() == ps.getResidenciaFamiliar()){
				if(this.getSituacaoMoradia() == ps.getSituacaoMoradia()){
					if(this.getSituacaoRendaFamiliar() == ps.getSituacaoRendaFamiliar()){
						if(this.getSituacaoTrabalho() == ps.getSituacaoTrabalho()){
								return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	

}
