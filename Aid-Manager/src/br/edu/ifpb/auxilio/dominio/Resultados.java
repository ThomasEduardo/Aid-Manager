package br.edu.ifpb.auxilio.dominio;

import java.util.Date;

public class Resultados extends Processo {
	private int idResultados;
	private String tipoAuxilio;
	
	public Resultados() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Resultados(Date data, String obs, String numProcesso, String assunto, Pessoa interessado) {
		super(data, obs, numProcesso, assunto, interessado);
		// TODO Auto-generated constructor stub
	}
	public Resultados(int idProcesso, Date data, String obs, String numProcesso, String assunto, Pessoa interessado) {
		super(idProcesso, data, obs, numProcesso, assunto, interessado);
		// TODO Auto-generated constructor stub
	}
// ----------------------------------------------------------------------------------------------
	public int getIdResultados() {
		return idResultados;
	}
	public void setIdResultados(int idResultados) {
		this.idResultados = idResultados;
	}
	public String getTipoAuxilio() {
		return tipoAuxilio;
	}
	public void setTipoAuxilio(String tipoAuxilio) {
		this.tipoAuxilio = tipoAuxilio;
	}
	
//-------------------------------------------------------------------------------------------
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resultados other = (Resultados) obj;
		if (idResultados != other.idResultados)
			return false;
		if (tipoAuxilio == null) {
			if (other.tipoAuxilio != null)
				return false;
		} else if (!tipoAuxilio.equals(other.tipoAuxilio))
			return false;
		return true;
	}
		
	

}
