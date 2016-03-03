package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.ifpb.auxilio.dominio.PerfilSocioEconomico;

public class PerfilSocioEconomicoDAO {
	private Connection conn;

	public PerfilSocioEconomicoDAO() {
		conn = Conexao.getConnection();
		if (conn != null)
			System.out.println("Conexão estabelecida");
		else
			System.out.println("Erro na conexão com o BD");
	}

	public void insert(PerfilSocioEconomico PSE) {

		String sql = "INSERT INTO perfilSocioEconomico" +
					 " `idPerfilSocio`, " +
					 " `situcaoRendaFamiliar`, " +
					 " `moradia`, " +
					 " `situacaoMoradia`," +
					 " `residenciaFamiliar`, " +
					 " `aluguel`, " +
					 " `condominio`, " + 
					 " `luz`, " +
					 " 'agua', " + 
					 " 'telefone', " +
					 " 'financiamentoCasaPropria', "	+
					 " 'as', " +
					 " 'discente'" +
					 "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, PSE.getIdPerfilSocio());
			stmt.setString(2, PSE.getSituacaoRendaFamiliar());
			stmt.setString(3, PSE.getMoradia());
			stmt.setString(4, PSE.getSituacaoMoradia());
			stmt.setString(5, PSE.getResidenciaFamiliar());
			stmt.setString(6, PSE.getSituacaoTrabalho());
			stmt.setDouble(7, PSE.getAluguel());
			stmt.setDouble(8, PSE.getCondominio());
			stmt.setDouble(9, PSE.getLuz());
			stmt.setDouble(10, PSE.getAgua());
			stmt.setDouble(11, PSE.getTelefone());
			stmt.setInt(12, PSE.getAs().getId_assistenteSocial());
			stmt.setInt(13, PSE.getDiscente().getIdDiscente());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}