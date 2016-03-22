/**
 * 
 * @author FannyVieira, RaylaMedeiros, MateusOliveira
 *
 */

package br.edu.ifpb.auxilio.entidade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import br.edu.ifpb.auxilio.service.bd.PessoaDAO;
import br.edu.ifpb.auxilio.service.bd.ServidorDAO;



	public class Pessoa {
	
	    private int idPessoa;
		private String nomePessoa;
		private String rg;
		private String matricula;
		private Date dataNasc;
		private String sexo;
		private String senha;
		private String email;
		private String cpf;
		private ArrayList<String> telefones;
		
		/**
		 * 
		 *  Construtor da classe, que não recebe nenhum parâmetro,pois define os valores padrão.
		 * 
		 */
		
		public Pessoa(){

				setIdPessoa(0);
				setNomePessoa("");
				setRg("");
				setMatricula("");
				setSexo("");
				setSenha("");
				setEmail("");
				setCpf("");
				setTelefones(null);
				
			}
	
		/**
		 * 
		 *  Construtor da classe, que contém todos os seus atributos 
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
		 *  
		 * 
		 */
		public Pessoa(int idPessoa,String nomePessoa,String matricula,Date dataNasc,String senha,String email,String cpf,String rg,String sexo){
			
				setIdPessoa(idPessoa);
				setNomePessoa(nomePessoa);
				setRg(rg);
				setDataNasc(dataNasc);
				setMatricula(matricula);
				setSexo(sexo);
				setSenha(senha);
				setEmail(email);
				setCpf(cpf);
				
			
			}
		
		/**
		 * 
		 *  Construtor da classe, que não contém o id
		 *  
		 *  @param matricula
		 *  @param nomePessoa
		 *  @param dataNasc
		 *  @param senha
		 *  @param email
		 *  @param cpf
		 *  @param rg
		 *  @param sexo
		 *  
		 * 
		 */
			public Pessoa(String nomePessoa,String matricula,Date dataNasc,String senha,String email,String cpf,String rg,String sexo){
				
				setNomePessoa(nomePessoa);
				setRg(rg);
				setDataNasc(dataNasc);
				setMatricula(matricula);
				setSexo(sexo);
				setSenha(senha);
				setEmail(email);
				setCpf(cpf);
				
				
			}
	
	
	
			/*----------------- GETTERS E SETTERS ----------------*/

			public int getIdPessoa() {
				return idPessoa;
			}
			public void setIdPessoa(int idPessoa) {
				this.idPessoa = idPessoa;
			}
			public String getNomePessoa() {
				return nomePessoa;
			}
			public void setNomePessoa(String nomePessoa) {
				this.nomePessoa = nomePessoa;
			}
			public String getMatricula() {
				return matricula;
			}
			public void setMatricula(String matricula) {
				this.matricula = matricula;
			}
			public Date getDataNasc() {
				return dataNasc;
			}
			public void setDataNasc(Date dataNasc) {
				this.dataNasc = dataNasc;
			}
			public String getSenha() {
				return senha;
			}
			public void setSenha(String senha) {
				this.senha = senha;
			}
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public String getCpf() {
				return cpf;
			}
			public void setCpf(String cpf) {
				this.cpf = cpf;
			}
			public String getRg() {
				return rg;
			}
			public void setRg(String rg) {
				this.rg = rg;
			}
			public String getSexo() {
				return sexo;
			}
			public void setSexo(String sexo) {
				this.sexo = sexo;
			}
			public ArrayList<String> getTelefones() {
				return telefones;
			}

			public void setTelefones(ArrayList<String> telefones) {
				this.telefones = telefones;
			}

			
				public boolean equals(Pessoa P){
					if(P instanceof Pessoa){
						if(this.getNomePessoa() == P.getNomePessoa()){
							if(this.getDataNasc() == P.getDataNasc()){
								if(this.getCpf() == P.getCpf()){
									if(this.getEmail() == P.getEmail()){
										if(this.getMatricula() == P.getMatricula()){
											if(this.getSenha() == P.getSenha()){
												if(this.getRg() == P.getRg()){
													if(this.getSexo() == P.getSexo()){	
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
					return false;
				}

				
	 public int insert(Pessoa pessoa) throws SQLException {
					PessoaDAO p = new PessoaDAO();
					return p.insert(pessoa);
					
	}

		
}
