package br.edu.ifpb.auxilio.dominio;

import java.util.Date;

	public class Resultados extends Processo {
		private int idResultados;
		private String tipoAuxilio;
	
		public Resultados() {
			super();
			setIdResultados(0);
			setTipoAuxilio("");
			
		}
		public Resultados(Date data, String obs, String numProcesso, String assunto, Pessoa interessado,int idResultados,String tipoAuxilio,String parecer,Servidor servidor) {
			super(data, obs, numProcesso, assunto, interessado,parecer,servidor);
			setIdResultados(idResultados);
			setTipoAuxilio(tipoAuxilio);
		}
		public Resultados(int idProcesso, Date data, String obs, String numProcesso, String assunto, Pessoa interessado,String tipoAuxilio,String parecer,Servidor servidor) {
			super(idProcesso, data, obs, numProcesso, assunto, interessado,parecer,servidor);
			setTipoAuxilio(tipoAuxilio);
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
	
	
		public boolean equals(Resultados r) {
				if(r instanceof Resultados){
					if(super.equals(r)){
						if(this.getIdResultados() == r.getIdResultados()){
							if(this.getTipoAuxilio() == r.getTipoAuxilio()){
								return true;
							}
						}
					}
					return false;	
				}
				return false;
		}
		
	

}
