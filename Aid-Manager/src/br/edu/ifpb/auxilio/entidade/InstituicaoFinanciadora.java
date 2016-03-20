/**
 * 
 * @author FannyVieira, RaylaMedeiros, MateusOliveira
 *
 */

package br.edu.ifpb.auxilio.entidade;

public class InstituicaoFinanciadora {
	
	private int idIF;
	private String nomeIF;
	private String cnpj;
	private double orcamentoAuxilio;
	private Servidor servidor; 
	
	
	/**
	 * 
	 *  Construtor da classe, que não recebe nenhum parâmetro,pois define os valores padrão.
	 * 
	 */
	
	public InstituicaoFinanciadora(){
		
		setIdIF(0);
		setNomeIF("");
		setCnpj("");
		setOrcamentoAuxilio(0);
		setServidor(null);
		
	}
	
	/**
	 * 
	 *  Construtor da classe, que contém todos os seus atributos 
	 *  
	 *  @param idIF
	 *  @param nomeIF
	 *  @param cnpj
	 *  @param orcamento
	 *  @param servidor
	 *  
	 * 
	 */
	
	public InstituicaoFinanciadora(int idIF,String nomeIF,String cnpj,double orcamento,Servidor servidor){		
		setIdIF(idIF);
		setNomeIF(nomeIF);
		setCnpj(cnpj);
		setOrcamentoAuxilio(orcamento);
		setServidor(servidor);
		
	}	
	/**
	 * 
	 *  Construtor da classe, que não contém o seu id
	 *  
	 *  @param nomeIF
	 *  @param cnpj
	 *  @param orcamento
	 *  @param servidor
	 *  
	 * 
	 */
	public InstituicaoFinanciadora(String nomeIF,String cnpj,double orcamento,Servidor servidor){
		
		setNomeIF(nomeIF);
		setCnpj(cnpj);
		setOrcamentoAuxilio(orcamento);
		setServidor(servidor);
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
	public double getOrcamentoAuxilio() {
		return orcamentoAuxilio;
	}
	public void setOrcamentoAuxilio(double orcamentoAuxilio) {
		this.orcamentoAuxilio = orcamentoAuxilio;
	}
	public Servidor getServidor() {
		return servidor;
	}
	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}
	
	
	public boolean equals(InstituicaoFinanciadora If){
		if(If instanceof InstituicaoFinanciadora){
			if(this.getNomeIF() == If.getNomeIF()){
				if(this.getCnpj() == If.getCnpj()){
					if(this.getOrcamentoAuxilio() == If.getOrcamentoAuxilio()){
						if(this.getServidor() == If.getServidor()){
								return true;
						}
					}
				}
			}
		}
		return false;
	}

	
	

}
