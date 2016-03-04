package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifpb.auxilio.dominio.ComposicaoRendaFamiliar;



public class ComposicaoRendaFamiliarDAO {
	private Connection conn;
	
	public ComposicaoRendaFamiliarDAO(){
		conn = Conexao.getConnection();
		if(conn != null)
			System.out.println("Conexão estabelecida");
		else System.out.println("Erro na conexão com o BD");	
	}
	
	
	public void insert(ComposicaoRendaFamiliar CRF) {

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

			
			stmt.setString(1, CRF.getNome() );
			stmt.setInt(2, CRF.getIdade());
			stmt.setInt(3, CRF.getGrauDeInstrucao());
			stmt.setString(4, CRF.getProfissao());
			stmt.setDouble(5, CRF.getRenda());
			stmt.setInt(6, CRF.getPs().getIdPerfilSocio());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	
	public boolean update(ComposicaoRendaFamiliar crf) {
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
			stmt.setString(1, crf.getNome());
			stmt.setInt   (2, crf.getIdade());
			stmt.setInt   (3, crf.getGrauDeInstrucao());
			stmt.setString(4, crf.getProfissao());
			stmt.setDouble(5, crf.getRenda());
			stmt.setInt   (6, crf.getPs().getIdPerfilSocio());
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

	public ComposicaoRendaFamiliar getObject(int idPerfilSocio) {
		try {
			ComposicaoRendaFamiliar crf = new ComposicaoRendaFamiliar();
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