/**
 * 
 * @author FannyVieira, RaylaMedeiros, MateusOliveira
 *
 */

package br.edu.ifpb.auxilio.entidade;

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
	private String obs;
	private Servidor servidor;
	private Discente discente;
	
	
	
	/**
	 * 
	 *  Construtor da classe, que não recebe nenhum parâmetro,pois define os valores padrão.
	 * 
	 */
	
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
		setServidor(null);
		setDiscente(null);
		setObs("");
		
	}
	/**
	 * 
	 *  Construtor da classe, que contém todos os seus atributos 
	 *  
	 *  @param idPs
	 *  @param srf
	 *  @param moradia
	 *  @param situacaoMoradia
	 *  @param residenciaFamiliar
	 *  @param situacaoTrabalho
	 *  @param aluguel
	 *  @param condominio
	 *  @param luz
	 *  @param agua
	 *  @param telefone
	 *  @param financiamentoCasaPropria
	 *  @param servidor
	 *  @param d
	 *  
	 * 
	 */
	public PerfilSocioEconomico(int idPs,String srf,String moradia,String situacaoMoradia,String residenciaFamiliar,String situacaoTrabalho,double aluguel,double condominio,double luz,double agua,double telefone,double financiamentoCasaPropria,Servidor servidor,Discente d){
		
		
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
		setServidor(servidor);
		setDiscente(d);
		
	}
	/**
	 * 
	 *  Construtor da classe, que não contém o id
	 *  
	 *  @param srf
	 *  @param moradia
	 *  @param situacaoMoradia
	 *  @param residenciaFamiliar
	 *  @param situacaoTrabalho
	 *  @param aluguel
	 *  @param condominio
	 *  @param luz
	 *  @param agua
	 *  @param telefone
	 *  @param financiamentoCasaPropria
	 *  @param servidor
	 *  @param d
	 *  
	 * 
	 */
	public PerfilSocioEconomico(String srf,String moradia,String situacaoMoradia,String residenciaFamiliar,String situacaoTrabalho,double aluguel,double condominio,double luz,double agua,double telefone,double financiamentoCasaPropria,Servidor servidor,Discente d){
	
		
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
		setServidor(servidor);
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
	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}
	public Discente getDiscente() {
		return discente;
	}

	public void setDiscente(Discente discente) {
		this.discente = discente;
	}
	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
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
												if	(this.getServidor() == ps.getServidor()){
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
