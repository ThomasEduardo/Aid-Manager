/**
 * 
 * @author FannyVieira, RaylaMedeiros, MateusOliveira
 *
 */
package br.edu.ifpb.auxilio.entidade;

public class Chat {
	
	
	private int idChat;
	private Pessoa remetente;
	private Pessoa destinatario;
	private String mensagem;
	
	
	/**
	 * 
	 *  Construtor da classe, que não recebe nenhum parâmetro,pois define os valores padrão.
	 * 
	 */
	
	public Chat(){
		setIdChat(0);
		setRemetente(null);
		setDestinatario(null);
		setMensagem("");
	}
	
	/** Construtor da classe, contendo todos os seus atributos
	 * 
	 * @param idChat define o id inicial da instância do chat
	 * @param remetente corresponde a instância da pessoa que envia as mensagens
	 * @param destinatario corresponde a instância da pessoa que recebe as mensagens
	 * @param mensagem define o conteúdo da mensagem

	 */
	
	public Chat(int idChat,Pessoa remetente,Pessoa destinatario,String mensagem){
		setIdChat(idChat);
		setRemetente(remetente);
		setDestinatario(destinatario);
		setMensagem(mensagem);
	}
	
	/** Construtor da classe,  que não contém o id
	 * 
	 * @param remetente corresponde a instância da pessoa que envia as mensagens
	 * @param destinatario corresponde a instância da pessoa que recebe as mensagens
	 * @param mensagem define o conteúdo da mensagem

	 */
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
