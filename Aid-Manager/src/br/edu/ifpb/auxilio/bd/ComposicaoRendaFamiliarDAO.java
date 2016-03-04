package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}