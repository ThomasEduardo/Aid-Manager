/**
 * 
 * @author FannyVieira, RaylaMedeiros, MateusOliveira
 *
 */

package br.edu.ifpb.auxilio.entidade;

public class DadosBancarios {
	
	private int idDadosBancarios;
	private String banco;
	private String agencia;
	private String numAgencia;
	private double saldo;
	private String obs;
	private Discente Discente;
	
	
	/**
	 * 
	 *  Construtor da classe, que não recebe nenhum parâmetro,pois define os valores padrão.
	 * 
	 */
	
	public DadosBancarios(){
		
		setIdDadosBancarios(0);
		setBanco("");
		setAgencia("");
		setNumAgencia("");
		setSaldo(0);
		setDiscente(null);
		setObs("");
		
		
	}
	
	/** Construtor da classe, contendo todos os seus atributos
	 * 
	 * @param idDadosBancarios
	 * @param banco
	 * @param numAgencia 
	 * @param saldo
	 * @param d
	 */
	public DadosBancarios(int idDB,String banco,String agencia,String numAgencia,double saldo,Discente d){
		
		setIdDadosBancarios(idDB);
		setBanco(banco);
		setAgencia(agencia);
		setNumAgencia(numAgencia);
		setSaldo(saldo);
		setDiscente(d);
	}
	
	/** Construtor da classe, que não contém o id dos dados bancários
	 * 
	 * @param idDadosBancarios
	 * @param banco
	 * @param numAgencia 
	 * @param saldo
	 * @param d
	 */

	public DadosBancarios(String banco,String agencia,String numAgencia,double saldo,Discente d){
		
		setBanco(banco);
		setAgencia(agencia);
		setNumAgencia(numAgencia);
		setSaldo(saldo);
		setDiscente(d);
		
	}
	
	/*----------------- GETTERS E SETTERS ----------------*/
	public int getIdDadosBancarios() {
		return idDadosBancarios;
	}
	public void setIdDadosBancarios(int idDadosBancarios) {
		this.idDadosBancarios = idDadosBancarios;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getNumAgencia() {
		return numAgencia;
	}
	public void setNumAgencia(String numAgencia) {
		this.numAgencia = numAgencia;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Discente getDiscente() {
		return Discente;
	}

	public void setDiscente(Discente discente) {
		Discente = discente;
	}
	
	public boolean equals(DadosBancarios db){
		if(this.getNumAgencia() == db.getNumAgencia()){
			if(this.getBanco() == db.getBanco()){
				if(this.getAgencia() == db.getAgencia()){
					if(this.getSaldo() == db.getSaldo()){
						if(this.getDiscente() == db.getDiscente()){
								return true;
						}
					}
				}
			}
		}
		return false;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	

	

}
