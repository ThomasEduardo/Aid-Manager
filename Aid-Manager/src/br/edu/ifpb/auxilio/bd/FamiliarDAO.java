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
	
	
	public void insert(Familiar f) {

		String sql = "INSERT INTO composicaoRendaFamiliar "
				+ " `nome`, "
				+ " `idade`, "
				+ " `grauDeInstrucao`, "
				+ " `profissao`,"
				+ " `renda`, "
				+ " `idPerfilSocio`"
				+ "VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			
			stmt.setString(1, f.getNome() );
			stmt.setInt(2, f.getIdade());
			stmt.setInt(3, f.getGrauDeInstrucao());
			stmt.setString(4, f.getProfissao());
			stmt.setDouble(5, f.getRenda());
			stmt.setInt(6, f.getPs().getIdPerfilSocio());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	
	public boolean update(Familiar f) {
		String sql = "update composicaoRendaFamiliar set "
				+ "nome = ? ,"
				+ "idade = ?,"
				+ "grauDeInstrucao = ?,"
				+ "profissao = ?,"
				+ "renda = ?,"
				+ "idPerfilSocio = ?,"
				+ "WHERE idCrf = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, f.getNome());
			stmt.setInt   (2, f.getIdade());
			stmt.setInt   (3, f.getGrauDeInstrucao());
			stmt.setString(4, f.getProfissao());
			stmt.setDouble(5, f.getRenda());
			stmt.setInt   (6, f.getPs().getIdPerfilSocio());
			stmt.execute();
			stmt.close();
			return true;

		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return false;
	}
	
	public int getIdCrf(int idPerfilSocio) {
		try {
			int idCrf = 0;
			String sql = "select idCrf from composicaoRendaFamiliar where idPerfilSocio = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idPerfilSocio);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				idCrf = rs.getInt("idCrf");

			}
			stmt.close();
			rs.close();
			return idCrf;

		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}

		return 0;

	}

	public Familiar getObject(int idPerfilSocio) {
		try {
			Familiar crf = new Familiar();
			String sql = "select * from composicarRendaFamiliar where idPerfilSocio = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idPerfilSocio);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				crf.setNome(rs.getString("nome"));
				crf.setIdade(rs.getInt("idade"));
				crf.setGrauDeInstrucao(rs.getInt("grauDeInstrucao"));
				crf.setProfissao(rs.getString("grauDeInstrucao"));
				crf.setRenda(rs.getDouble("renda"));
				// stmt.setInt (6, crf.getPs().getIdPerfilSocio());

			}
			stmt.close();
			rs.close();
			return crf;

		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return null;

	}
	
	
}