package br.edu.ifpb.auxilio.dominio;

public class ResidentesMoradia {
	
	private int idRm;
	private String residentes;
	private PerfilSocioEconomico ps;
	
	public ResidentesMoradia(){
		
		setIdRm(0);
		setResidentes("");
		
	}
	
	public ResidentesMoradia(int idRm,String residentes){
		setIdRm(idRm);
		setResidentes(residentes);
	}
	
	public ResidentesMoradia(String residentes){
		
		setResidentes(residentes);
		
	}
	
	/*----------------- GETTERS E SETTERS ----------------*/
	
	public int getIdRm() {
		return idRm;
	}
	public void setIdRm(int idRm) {
		this.idRm = idRm;
	}
	public String getResidentes() {
		return residentes;
	}
	public void setResidentes(String residentes) {
		this.residentes = residentes;
	}
	public PerfilSocioEconomico getPs() {
		return ps;
	}

	public void setPs(PerfilSocioEconomico ps) {
		this.ps = ps;
	}
	
	public boolean equals(ResidentesMoradia rm){
		if(this.getResidentes() == rm.getResidentes()){
			if(this.getPs() == rm.getPs()){
					return true;
			}
		}
		return false;
		
	}

	
	

}
