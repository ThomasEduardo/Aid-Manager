package br.edu.ifpb.auxilio.dominio;

public class SituacaoSaude {
	
	private int idSituacaoSaude;
	private String membro;
	private String doenca;
	//private PerfilSocioEconomico ps;
	
	public SituacaoSaude(){
		
		setIdSituacaoSaude(0);
		setMembro("");
		setDoenca("");
		
	}
	public SituacaoSaude(int idSituacaoSaude,String membro,String doenca){
		
		setIdSituacaoSaude(idSituacaoSaude);
		setMembro(membro);
		setDoenca(doenca);
		
	}
	public SituacaoSaude(String membro,String doenca){
	
	setMembro(membro);
	setDoenca(doenca);
	
	}
	
	
	
	
	/*----------------- GETTERS E SETTERS ----------------*/
	
	public int getIdSituacaoSaude() {
		return idSituacaoSaude;
	}
	public void setIdSituacaoSaude(int idSituacaoSaude) {
		this.idSituacaoSaude = idSituacaoSaude;
	}
	public String getMembro() {
		return membro;
	}
	public void setMembro(String membro) {
		this.membro = membro;
	}
	public String getDoenca() {
		return doenca;
	}
	public void setDoenca(String doenca) {
		this.doenca = doenca;
	}
	
	public boolean equals(SituacaoSaude s){
		if(this.getDoenca() == s.getDoenca()){
			if(this.getMembro() == s.getMembro()){
					return true;
			}
		}
		return false;
		
	}
	
	

}
