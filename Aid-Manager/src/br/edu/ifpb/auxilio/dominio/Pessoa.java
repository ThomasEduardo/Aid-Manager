package br.edu.ifpb.auxilio.dominio;

import java.util.Date;



	public abstract class Pessoa {
	
	    private int idPessoa;
		private String nomePessoa;
		private String rg;
		private String matricula;
		private Date dataNasc;
		private String sexo;
		private String senha;
		private String email;
		private String cpf;
		
		
		public Pessoa(){

				setIdPessoa(0);
				setNomePessoa("");
				setRg("");
				setMatricula("");
				setSexo("");
				setSenha("");
				setEmail("");
				setCpf("");
				
			}
	
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


		
}
