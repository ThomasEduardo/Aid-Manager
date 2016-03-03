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
				+ " `idCrf`, "
				+ " `nome`, "
				+ " `idade`, "
				+ " `grauDeInstrucao`, "
				+ " `profissao`,"
				+ " `renda`, "
				+ " `ps`"
				+ "VALUES(?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, CRF.getIdCrf());
			stmt.setString(2, CRF.getNome() );
			stmt.setInt(3, CRF.getIdade());
			stmt.setInt(4, CRF.getGrauDeInstrucao());
			stmt.setString(5, CRF.getProfissao());
			stmt.setDouble(6, CRF.getRenda());
			stmt.setInt(7, CRF.getPs().getIdPerfilSocio());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}