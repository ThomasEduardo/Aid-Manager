package br.edu.ifpb.auxilio.service.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.auxilio.entidade.Chat;


public class ChatDAO {
	
	private Connection conn;
	
	public ChatDAO(){
		conn = Conexao.getConnection();
		if(conn != null)
			System.out.println("Conexão estabelecida");
		else System.out.println("Erro na conexão com o BD");	
	}
	
	public void insert(Chat chat) {

		String sql = "INSERT INTO chat( "
									+ " `remetente_id`, "
									+ " `destinatario_id`, "
									+ " `mensagem`)"
				+ " VALUES(?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);


			stmt.setInt(1, chat.getRemetente().getIdPessoa());
			stmt.setInt(2, chat.getDestinatario().getIdPessoa());
			stmt.setString(3, chat.getMensagem());
			
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	
	public boolean update(Chat chat) {
		String sql = "update chat set `remetente_id`=?,"
				+ "`destinatario_id`=?,"
				+ "`mensagem`=?"
				+ " WHERE id_chat = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			
			stmt.setInt(1, chat.getRemetente().getIdPessoa());
			stmt.setInt(2, chat.getDestinatario().getIdPessoa());
			stmt.setString(3, chat.getMensagem());
			stmt.setDouble(4, chat.getIdChat()); 

			stmt.execute();
			stmt.close();
			return true;

		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return false;
	}
	
	
	
	
	public Chat getById(int idChat) {
         
		

		Chat chat = new Chat();
		
		String sql = "select * from chat where id_chat = ?";
		
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idChat);
			ResultSet rs = stmt.executeQuery();
		
			List<Chat> chats = convertToList(rs);
			
			if (!chats.isEmpty()) {
				chat = chats.get(0);
			}
			
			
			return chat;
			
		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return null;
	}
	
	public List<Chat> convertToList(ResultSet rs)
			throws SQLException {

		List<Chat> chats = new ArrayList<Chat>();

		try {

			while (rs.next()) {

				Chat chat = new Chat ();
				
				chat.setIdChat(rs.getInt("id_chat"));
				chat.setMensagem(rs.getString("mensagem"));
				
				// Remetente
				
				PessoaDAO p = new PessoaDAO();
				chat.setRemetente(p.getById(rs.getInt("remetente_id")));
				
				//Destinatario
				chat.setDestinatario(p.getById(rs.getInt("destinatario_id")));
				

				chats.add(chat);
			}

		} catch (SQLException sqle) {
			
		}

		return chats;
	}
	

}
