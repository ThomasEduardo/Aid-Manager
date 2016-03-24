/**
 * 
 * @author FannyVieira, RaylaMedeiros, MateusOliveira
 *
 */

package br.edu.ifpb.auxilio.entidade;

import java.sql.SQLException;
import java.util.Date;

import br.edu.ifpb.auxilio.service.bd.ServidorDAO;

public class Servidor extends Pessoa{
	
	private int idServidor;
	private String cargoServidor;
	
	/**
	 * 
	 *  Construtor da classe, que não recebe nenhum parâmetro,pois define os valores padrão.
	 * 
	 */
	
	
	public Servidor(){
		super();
		setIdServidor(0);
		setCargoServidor("");
		
	}
	/**
	 * 
	 *  Construtor da classe, que contém todos os seus atributos e os da sua super classe
	 *  
	 *  @param idPessoa
	 *  @param nomePessoa
	 *  @param matricula
     *  @param dataNasc
	 *  @param senha
	 *  @param email
	 *  @param cpf
	 *  @param rg
	 *  @param sexo
	 *  @param idServidor
	 *  @param cargoServidor
	 *  
	 * 
	 */
	public Servidor(int idPessoa,String nomePessoa,String matricula,Date dataNasc,String senha,String email,String cpf,String rg,String sexo,int idServidor,String cargoServidor){
		super(idPessoa,nomePessoa,matricula,dataNasc,senha,email,cpf,rg,sexo);
		setIdServidor(idServidor);
		setCargoServidor(cargoServidor);
	
	}
	/**
	 * 
	 *  Construtor da classe, que não contém o id
	 *  
	 *  @param nomePessoa
	 *  @param matricula
     *  @param dataNasc
	 *  @param senha
	 *  @param email
	 *  @param cpf
	 *  @param rg
	 *  @param sexo
	 *  @param cargoServidor
	 *  
	 * 
	 */
	public Servidor(String nomePessoa,String matricula,Date dataNasc,String senha,String email,String cpf,String rg,String sexo,String cargoServidor){
		super(nomePessoa,matricula,dataNasc,senha,email,cpf,rg,sexo);
		setCargoServidor(cargoServidor);
	}
	
	/*----------------- GETTERS E SETTERS ----------------*/
	public int getIdServidor() {
		return idServidor;
	}
	public void setIdServidor(int idServidor) {
		this.idServidor = idServidor;
	}
	public String getCargoServidor() {
		return cargoServidor;
	}
	public void setCargoServidor(String cargoServidor) {
		this.cargoServidor = cargoServidor;
	}

	
	public boolean equals(Servidor s){
		if(s instanceof Servidor){
			if(super.equals(s)){
				if(this.getCargoServidor() == s.getCargoServidor()){
					return true;
				}
			}
		}
		return false;
		
	}

	
	

}
