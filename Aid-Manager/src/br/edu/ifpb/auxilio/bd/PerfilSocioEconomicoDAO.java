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
					 " `situcao_renda_familiar`, " +
					 " `moradia`, " +
					 " `tipo_moradia`," +
					 " `tipo_residencia_familiar`, " +
					 " `tipo_trabalho`, " +
					 " `gastos_aluguel`, " +
					 " `gastos_condominio`, " + 
					 " `gastos_luz`, " +
					 " `gastos_agua`, " + 
					 " `gastos_telefone`, " +
					 " `obs`, " +
					 " `gastos_financiamento_casa_propria`, "	+
					 " `servidor_id`, " +
					 " `discente_id`" +
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
			stmt.setInt(13, PSE.getServidor().getIdServidor());
			stmt.setInt(14, PSE.getDiscente().getIdDiscente());
			
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	public boolean update(PerfilSocioEconomico PSE) {
		String sql = "update perfilSocioEconomico set" 
				     + "`situcao_renda_familiar`=?, " 
					 + " `moradia`=?, " 
				     + " `tipo_moradia`=?," 
					 + " `tipo_residencia_familiar`=?, " 
				     + " `tipo_Trabalho`=?, " 
					 + " `gastos_aluguel`=?, " 
				     + " `gastos_condominio`=?, " 
					 + " `gastos_luz`=?, " 
				     + " `gastos_agua`=?, " 
					 + " `gastos_telefone`=?, " 
				     + " `obs`=?, " 
					 + " `gastos_financiamento_casa_propria`=?, "	
				     + " `servidor_id`=?, " 
					 + " `discente_id`=?" 
				     + "  WHERE perfil_socio_id = ?";
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
			stmt.setInt(13, PSE.getServidor().getIdServidor());
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