package br.edu.ifpb.auxilio.dominio;

public class Chat {
	
	
	private int idChat;
	private Pessoa remetente;
	private Pessoa destinatario;
	private String mensagem;
	
	public Chat(){
		setIdChat(0);
		setRemetente(null);
		setDestinatario(null);
		setMensagem("");
	}
	
	public Chat(int idChat,Pessoa remetente,Pessoa destinatario,String mensagem){
		setIdChat(idChat);
		setRemetente(remetente);
		setDestinatario(destinatario);
		setMensagem(mensagem);
	}
	
	public Chat(Pessoa remetente,Pessoa destinatario,String mensagem){
		setRemetente(remetente);
		setDestinatario(destinatario);
		setMensagem(mensagem);
	}
	
	
	public int getIdChat() {
		return idChat;
	}
	public void setIdChat(int idChat) {
		this.idChat = idChat;
	}
	public Pessoa getRemetente() {
		return remetente;
	}
	public void setRemetente(Pessoa remetente) {
		this.remetente = remetente;
	}
	public Pessoa getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(Pessoa destinatario) {
		this.destinatario = destinatario;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	} 

}
