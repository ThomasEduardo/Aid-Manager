package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifpb.auxilio.dominio.Familiar;



public class FamiliarDAO {
	private Connection conn;
	
	public FamiliarDAO(){
		conn = Conexao.getConnection();
		if(conn != null)
			System.out.println("Conexão estabelecida");
		else System.out.println("Erro na conexão com o BD");	
	}
	
	
	public void insert(Familiar familiar) {

		String sql = "INSERT INTO familiar "
				+ " `nome_familiar`, "
				+ " `idade_familiar`, "
				+ " `grau_de_instrucao`, "
				+ " `profissao`,"
				+ " `renda`, "
				+ " `doenca`, "
				+ " `perfil_socio_id`"
				+ "VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			
			stmt.setString(1, familiar.getNome() );
			stmt.setInt(2, familiar.getIdade());
			stmt.setInt(3, familiar.getGrauDeInstrucao());
			stmt.setString(4, familiar.getProfissao());
			stmt.setDouble(5, familiar.getRenda());
			stmt.setString(6, familiar.getDoenca());
			stmt.setInt(7, familiar.getPs().getIdPerfilSocio());
			
			
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	
	public boolean update(Familiar familiar) {
		
		
		String sql = "update familiar set "
				+ "nome_familiar = ? ,"
				+ "idade_familiar = ?,"
				+ "grau_de_instrucao = ?,"
				+ "profissao = ?,"
				+ "renda = ?,"
				+ "doenca = ?,"
				+ "perfil_socio_id = ?,"
				+ "WHERE id_familiar = ?";
		try {
			
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, familiar.getNome());
			stmt.setInt   (2, familiar.getIdade());
			stmt.setInt   (3, familiar.getGrauDeInstrucao());
			stmt.setString(4, familiar.getProfissao());
			stmt.setDouble(5, familiar.getRenda());
			stmt.setString(6, familiar.getDoenca());
			stmt.setInt   (7, familiar.getPs().getIdPerfilSocio());
			
			
			stmt.execute();
			stmt.close();
			
			
			return true;

		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return false;
	}
	
	public int getIdFamiliar(int idPerfilSocio) {
		
		try {
			
			int idFamiliar = 0;
			
			String sql = "select id_familiar from familiar where perfil_socio_id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idPerfilSocio);
			
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				idFamiliar = rs.getInt("idFamiliar");

			}
			
			
			stmt.close();
			rs.close();
			
			return idFamiliar;

		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}

		return 0;

	}

	public Familiar getObject(int idPerfilSocio) {
		try {
			
			Familiar familiar = new Familiar();
			
			String sql = "select * from familiar where perfil_socio_id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idPerfilSocio);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				familiar.setNome(rs.getString("nome_familiar"));
				familiar.setIdade(rs.getInt("idade_familiar"));
				familiar.setGrauDeInstrucao(rs.getInt("grau_de_instrucao"));
				familiar.setProfissao(rs.getString("profissao"));
				familiar.setRenda(rs.getDouble("renda"));
				familiar.setDoenca(rs.getString("doenca"));
				// stmt.setInt (6, crf.getPs().getIdPerfilSocio());

			}
			
			stmt.close();
			rs.close();
			
			return familiar;

		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return null;

	}
	
	
}