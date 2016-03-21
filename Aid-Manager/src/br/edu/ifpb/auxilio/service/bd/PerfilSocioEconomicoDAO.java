/**
 * 
 * @author FannyVieira, RaylaMedeiros, MateusOliveira
 *
 */
package br.edu.ifpb.auxilio.service.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




import br.edu.ifpb.auxilio.entidade.PerfilSocioEconomico;

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

		String sql = "INSERT INTO perfilSocioEconomico(" +
					 " `situacao_renda_familiar`, " +
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
					 " `discente_id`)" +
					 "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
				     + "`situacao_renda_familiar`=?, " 
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
					 + " `discente_id`=? " 
				     + "  WHERE id_perfil_socio = ?";
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

	
	public PerfilSocioEconomico getById(int idPs){
		try{
		
		PerfilSocioEconomico ps = new PerfilSocioEconomico();
		
		String sql = "select * from perfilSocioEconomico "
				     + "where id_perfil_socio = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, idPs);
		
		ResultSet rs = stmt.executeQuery();
		
		List<PerfilSocioEconomico> pse = convertToList(rs);
		
		if (!pse.isEmpty()) {
			
			ps = pse.get(0);
			
		} 
		
		stmt.close();
		rs.close();
		
		return ps;
		
	    }
		catch (Exception e){
			
			System.out.println("Exception is :"+e);
			
		}
		return null;
		
     }
	public List<PerfilSocioEconomico> convertToList(ResultSet rs)
			throws SQLException {

		List<PerfilSocioEconomico> ps = new ArrayList<PerfilSocioEconomico>();

		try {

			while (rs.next()) {

				PerfilSocioEconomico pse = new  PerfilSocioEconomico();
				
				pse.setIdPerfilSocio(rs.getInt("id_perfil_socio"));
				pse.setSituacaoRendaFamiliar(rs.getString("situacao_renda_familiar"));
				pse.setMoradia(rs.getString("moradia"));
				pse.setSituacaoMoradia(rs.getString("tipo_moradia"));
				pse.setResidenciaFamiliar(rs.getString("tipo_residencia_familiar"));
				pse.setSituacaoTrabalho(rs.getString("tipo_trabalho"));
				pse.setAluguel(rs.getDouble("gastos_Aluguel"));
				pse.setCondominio(rs.getDouble("gastos_condominio"));
				pse.setLuz(rs.getDouble("gastos_luz"));
			    pse.setAgua(rs.getDouble("gastos_agua"));
				pse.setTelefone(rs.getDouble("gastos_telefone"));
				pse.setObs(rs.getString("obs"));
				pse.setFinanciamentoCasaPropria(rs.getDouble("gastos_financiamento_casa_propria"));
				
				
				// Servidor
				
				ServidorDAO s = new ServidorDAO();
				pse.setServidor(s.getById(rs.getInt("servidor_id")));
				
				//Discente
				
				DiscenteDAO d = new DiscenteDAO();
				pse.setDiscente(d.getById(rs.getInt("discente_id")));
				
				

				ps.add(pse);
			}

		} catch (SQLException sqle) {
			
		}

		return ps;
	}
	
	
	public List<PerfilSocioEconomico> find(PerfilSocioEconomico pse) throws SQLException {
		List<PerfilSocioEconomico> pses = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = String.format("%s '%%%s%%'",
							"SELECT     ps.id_perfil_socio, "
									+ " ps.`situacao_renda_familiar`, " 
									+ " ps.`moradia`, " 
									+ " ps.`tipo_moradia`," 
									+ " ps.`tipo_residencia_familiar`, " 
									+ " ps.`tipo_Trabalho`, " 
									+ " ps.`gastos_aluguel`, " 
									+ " ps.`gastos_condominio`, " 
									+ " ps.`gastos_luz`, " 
									+ " ps.`gastos_agua`, " 
									+ " ps.`gastos_telefone`, " 
									+ " ps.`obs`, " 
									+ " ps.`gastos_financiamento_casa_propria`,"
									+ " ps.servidor_id,"
									+ " ps.discente_id"
									+ " FROM perfilSocioEconomico ps"
									+ " INNER JOIN discente"
									+ " ON discente.id_discente =  ps.discente_id"
									+ " INNER JOIN pessoa"
									+ " ON pessoa.id_pessoa =  discente.pessoa_id"	
						    + " WHERE pessoa.matricula LIKE",
							pse.getDiscente().getMatricula());
 
			stmt = (PreparedStatement) conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			pses = convertToList(rs);

		} catch (SQLException sqle) {
			throw new SQLException(sqle);
					
		} 

		return pses;
	}
	
	public List<PerfilSocioEconomico> getAll() throws SQLException {
		List<PerfilSocioEconomico> instfs = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = String.format("%s",
						 "  SELECT `id_perfil_socio`,"
						 + " `situacao_renda_Familiar`, "
						 + " `moradia`, "
						 + " `tipo_moradia`,"
						 + " `tipo_residencia_familiar`, "
						 + " `tipo_trabalho`, "
						 + " `gastos_aluguel`,"
						 + " `gastos_condominio`, "
						 + " `gastos_luz`, "
						 + " `gastos_agua`, "
						 + " `gastos_telefone`,"
						 + " `obs`, "
						 + " `gastos_financiamento_casa_propria`, "
						 + " `servidor_id`, "
						 + " `discente_id` "
						 + "FROM `perfilsocioeconomico`"); 

			stmt = (PreparedStatement) conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			instfs = convertToList(rs);

		} catch (SQLException sqle) {
			throw new SQLException(sqle);
		} 

		return instfs;
	}
}