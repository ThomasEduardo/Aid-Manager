package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




import br.edu.ifpb.auxilio.dominio.Discente;
import br.edu.ifpb.auxilio.dominio.Edital;
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

		String sql = "INSERT INTO familiar("
				+ " `nome_familiar`, "
				+ " `idade_familiar`, "
				+ " `grau_de_instrucao`, "
				+ " `profissao`,"
				+ " `renda`, "
				+ " `doenca`, "
				+ " `perfil_socio_id`)"
				+ "VALUES(?,?,?,?,?,?,?)";
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
				+ "perfil_socio_id = ? "
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
			stmt.setInt   (8, familiar.getIdCrf());
			
			
			stmt.execute();
			stmt.close();
			
			
			return true;

		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return false;
	}
	


	public Familiar getById(int idFamiliar) {
		try {
			
			Familiar familiar = new Familiar();
			
			String sql = "select * from familiar where id_familiar = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idFamiliar);
			
			ResultSet rs = stmt.executeQuery();
			
			List<Familiar> familiares = convertToList(rs);
			
			if (!familiares.isEmpty()) {
				
				familiar = familiares.get(0);
				
			} 
			
			stmt.close();
			rs.close();
			
			return familiar;

		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return null;

	}
	
	
	public List<Familiar> convertToList(ResultSet rs)
			throws SQLException {

		List<Familiar> familiares = new ArrayList<Familiar>();

		try {

			while (rs.next()) {

				Familiar familiar = new  Familiar();
				
				familiar.setIdCrf(rs.getInt("id_familiar"));
				familiar.setNome(rs.getString("nome_familiar"));
				familiar.setIdade(rs.getInt("idade_familiar"));
				familiar.setGrauDeInstrucao(rs.getInt("grau_de_instrucao"));
				familiar.setProfissao(rs.getString("profissao"));
				familiar.setRenda(rs.getDouble("renda"));
				familiar.setDoenca(rs.getString("doenca"));
				
				// PerfilSocioEconomico
				
				PerfilSocioEconomicoDAO p = new PerfilSocioEconomicoDAO();
				familiar.setPs(p.getById(rs.getInt("perfil_socio_id")));
				

				familiares.add(familiar);
			}

		} catch (SQLException sqle) {
			
		}

		return familiares;
	}
	
	
	public List<Familiar> find(Familiar familiar) throws SQLException {
		List<Familiar> familiares = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = String.format("%s '%%%s%%'",
							" SELECT  familiar.nome_familiar,"
									+ "familiar.idade_familiar,"
									+ "familiar.grau_de_instrucao,"
									+ "familiar.profissao ,"
									+ "familiar.renda,"
									+ "familiar.doenca"
									+ "FROM familiar"
									+ "INNER JOIN perfilSocioEconomico ps"
									+ "ON ps.id_perfil_socio = familiar.perfil_socio_id"
									+ "INNER JOIN discente"
									+ "ON discente.id_discente = ps.discente_id"
									+ "INNER JOIN pessoa"
									+ "ON pessoa.id_pessoa = discente.pessoa_id"
						    + " WHERE pessoa.matricula LIKE",
							familiar.getPs().getDiscente().getMatricula());
 
			stmt = (PreparedStatement) conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			familiares = convertToList(rs);

		} catch (SQLException sqle) {
			throw new SQLException(sqle);
					
		} 

		return familiares;
	}
	
	public List<Familiar> getAll() throws SQLException {
		List<Familiar> familiares = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = String.format("%s",
						"SELECT      id_familiar,"
						            + "nome_familiar,"
									+ "idade_familiar,"
									+ "grau_de_instrucao,"
									+ "profissao ,"
									+ "renda,"
									+ "doenca "
									+ "FROM familiar"); 

			stmt = (PreparedStatement) conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			familiares = convertToList(rs);

		} catch (SQLException sqle) {
			throw new SQLException(sqle);
		} 

		return familiares;
	}
	
	/*
	public boolean calculoRendaFamiliarDiscentes(){
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {

			String sql = String.format("%s","SELECT COUNT(familiar.id_familiar),"
											+ " SUM(familiar.renda)"
											+ " INTO @qtd_moradores,"
											+ " @renda_total"
											+ " FROM familiar "
											+ "	INNER JOIN perfilSocioEconomico ps"
											+ " ON ps.id_perfil_socio = familiar.perfil_socio_id"
											+ " INNER JOIN discente "
											+ " ON discente.id_discente = ps.discente_id"
											+ " INNER JOIN pessoa"
											+ " ON pessoa.id_pessoa = discente.pessoa_id"
											+ " WHERE pessoa.matricula = ? and ((@renda_total/@qtd_moradores) <= 1320)");
			stmt = (PreparedStatement) conn.prepareStatement(sql);

			stmt.setString(1,discente.getMatricula());
			
			stmt.execute();
			stmt.close();
			
			return true;
		
		}Ver depois*/

		
		
	}
