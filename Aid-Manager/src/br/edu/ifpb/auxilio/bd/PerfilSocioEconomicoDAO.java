package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.ifpb.auxilio.dominio.InstituicaoFinanciadora;
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
					 " `situcaoRendaFamiliar`, " +
					 " `moradia`, " +
					 " `situacaoMoradia`," +
					 " `residenciaFamiliar`, " +
					 " `situacaoTrabalho`, " +
					 " `aluguel`, " +
					 " `condominio`, " + 
					 " `luz`, " +
					 " `agua`, " + 
					 " `telefone`, " +
					 " `obs`, " +
					 " `financiamentoCasaPropria`, "	+
					 " `idassistenteSocial`, " +
					 " `idDiscente`" +
					 "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
					
					
			stmt.setString(1, PSE.getSituacaoRendaFamiliar());
			stmt.setString(2, PSE.getMoradia());
			stmt.setString(3, PSE.getSituacaoMoradia());
			stmt.setString(4, PSE.getResidenciaFamiliar());
			stmt.setString(5, PSE.getSituacaoTrabalho());
			stmt.setDouble(6, PSE.getAluguel());
			stmt.setDouble(7, PSE.getCondominio());
			stmt.setDouble(8, PSE.getLuz());
			stmt.setDouble(9, PSE.getAgua());
			stmt.setDouble(10, PSE.getTelefone());
			stmt.setString(11, PSE.getObs());
			stmt.setDouble(12,PSE.getFinanciamentoCasaPropria());
			stmt.setInt(13, PSE.getAs().getId_assistenteSocial());
			stmt.setInt(14, PSE.getDiscente().getIdDiscente());
			
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	public boolean update(PerfilSocioEconomico PSE) {
		String sql = "update perfilSocioEconomico set" 
				     + "`situcaoRendaFamiliar`=?, " 
					 + " `moradia`=?, " 
				     + " `situacaoMoradia`=?," 
					 + " `residenciaFamiliar`=?, " 
				     + " `situacaoTrabalho`=?, " 
					 + " `aluguel`=?, " 
				     + " `condominio`=?, " 
					 + " `luz`=?, " 
				     + " `agua`=?, " 
					 + " `telefone`=?, " 
				     + " `obs`=?, " 
					 + " `financiamentoCasaPropria`=?, "	
				     + " `idassistenteSocial`=?, " 
					 + " `idDiscente`=?" 
				     + "  WHERE idPerfilSocio = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, PSE.getSituacaoRendaFamiliar());
			stmt.setString(2, PSE.getMoradia());
			stmt.setString(3, PSE.getSituacaoMoradia());
			stmt.setString(4, PSE.getResidenciaFamiliar());
			stmt.setString(5, PSE.getSituacaoTrabalho());
			stmt.setDouble(6, PSE.getAluguel());
			stmt.setDouble(7, PSE.getCondominio());
			stmt.setDouble(8, PSE.getLuz());
			stmt.setDouble(9, PSE.getAgua());
			stmt.setDouble(10, PSE.getTelefone());
			stmt.setString(11, PSE.getObs());
			stmt.setDouble(12,PSE.getFinanciamentoCasaPropria());
			stmt.setInt(13, PSE.getAs().getId_assistenteSocial());
			stmt.setInt(14, PSE.getDiscente().getIdDiscente());
			stmt.setInt(15, PSE.getIdPerfilSocio());
			stmt.execute();
			stmt.close();
			return true;

		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return false;
	}
	

}