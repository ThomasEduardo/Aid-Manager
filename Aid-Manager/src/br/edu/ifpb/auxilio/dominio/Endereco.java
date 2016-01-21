package br.edu.ifpb.auxilio.dominio;

public class Endereco {
	
	private int idEndereco;
	private String rua;
	private String cep;
	private String bairro;
	private String cidade;
	private int numCasa;
	private String pontoRef;
	private String estado;
	private Pessoa pessoa;
	
	public Endereco(){
		setIdEndereco(0);
		setRua("");
		setCep("");
		setBairro("");
		setCidade("");
		setNumCasa(0);
		setPontoRef("");
		setEstado("");
		setPessoa(null);
		
	}
	
	public Endereco(int idEndereco,String rua,String cep,String bairro,String cidade,int numCasa,String pontoRef,String estado,Pessoa p){
		
		setIdEndereco(idEndereco);
		setRua(rua);
		setCep(cep);
		setBairro(bairro);
		setCidade(cidade);
		setNumCasa(numCasa);
		setPontoRef(pontoRef);
		setEstado(estado);
		setPessoa(p);
		
	}
	public Endereco(String rua,String cep,String bairro,String cidade,int numCasa,String pontoRef,String estado,Pessoa p){
		
		setRua(rua);
		setCep(cep);
		setBairro(bairro);
		setCidade(cidade);
		setNumCasa(numCasa);
		setPontoRef(pontoRef);
		setEstado(estado);
		setPessoa(p);
		
	}
	
	
	/*----------------- GETTERS E SETTERS ----------------*/
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public int getNumCasa() {
		return numCasa;
	}
	public void setNumCasa(int numCasa) {
		this.numCasa = numCasa;
	}
	public String getPontoRef() {
		return pontoRef;
	}
	public void setPontoRef(String pontoRef) {
		this.pontoRef = pontoRef;
	}
	public int getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
	public boolean equals(Endereco e){
		if(e instanceof Endereco){
			if(this.getRua() == e.getRua()){
				if(this.getCep() == e.getCep()){
					if(this.getBairro() == e.getBairro()){
						if(this.getCidade() == e.getCidade()){
							if(this.getNumCasa() == e.getNumCasa()){
								if(this.getPontoRef() == e.getPontoRef()){
								    if(this.getEstado() == e.getEstado()){
								    	if(this.getPessoa() == e.getPessoa()){
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
