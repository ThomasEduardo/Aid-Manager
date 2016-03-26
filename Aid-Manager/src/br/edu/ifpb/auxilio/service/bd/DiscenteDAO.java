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









import br.edu.ifpb.auxilio.entidade.Discente;
import br.edu.ifpb.auxilio.entidade.Pessoa;





public class DiscenteDAO{
	
	private Connection conn;
	
	public DiscenteDAO(){
		conn = Conexao.getConnection();
		if(conn != null)
			System.out.println("ConexÃ£o estabelecida");
		else System.out.println("Erro na conexÃ£o com o BD");	
	}
	
	
	public void insert(Discente discente) {

		String sql = "INSERT INTO discente("
				+ "escola_origem,"
				+ "org_Expeditor,"
				+ "num_cartao_sus,"
				+ "estado_civil,"
				+ "curso,"
				+ "periodo_letivo,"
				+ "turno,"
				+ "endereco,"
				+ "cep,"
				+ "bairro,"
				+ "cidade,"
				+ "num_casa,"
				+ "ponto_ref,"
				+ "estado, "
				+ "motivo_solicitacao,"
				+ "pessoa_id) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, discente.getEscolaOrigem());
			stmt.setString(2, discente.getOrgExpeditor() );
			stmt.setString(3, discente.getNumCartaoSus());
			stmt.setString(4, discente.getEstadoCivil());
			stmt.setString(5, discente.getCurso());
			stmt.setInt   (6, discente.getPeriodoLetivo());
			stmt.setString(7, discente.getTurno());
			stmt.setString(8, discente.getEndereco());
			stmt.setString(9, discente.getCep());
			stmt.setString(10, discente.getBairro());
			stmt.setString(11, discente.getCidade());
			stmt.setInt   (12, discente.getNumCasa());
			stmt.setString(13, discente.getPontoRef());
			stmt.setString(14, discente.getEstado());
			stmt.setString(15, discente.getMotivoSolicitacao());
			stmt.setInt   (16, discente.getIdPessoa());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public boolean update(Discente discente){
		String sql = "update pessoa set "
			           + "escola_origem = ? ,"
				       + "org_expeditor = ?,"
				       + "num_cartao_sus  = ?,"
				       + "estado_civil =?,"
				       + "curso  = ?,"
				       + "periodo_letivo = ?,"
				       + "turno = ?,"
				       + "endereco = ?,"
				       + "cep = ?,"
				       + "bairro = ?,"
				       + "cidade = ?,"
				       + "num_casa = ?,"
				       + "ponto_ref = ?,"
				       + "estado = ?,"
				       + "motivo_solicitacao = ?,"
				       + "pessoa_id = ?"
				       + "WHERE id_discente = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, discente.getEscolaOrigem());
			stmt.setString(2, discente.getOrgExpeditor());
			stmt.setString(3, discente.getNumCartaoSus());
			stmt.setString(4, discente.getEstadoCivil());
			stmt.setString(5, discente.getCurso());
			stmt.setInt(6, discente.getPeriodoLetivo());
			stmt.setString(7, discente.getTurno());
			stmt.setString(8, discente.getEndereco());
			stmt.setString(9, discente.getCep());
			stmt.setString(10, discente.getBairro());
			stmt.setString(11, discente.getCidade());
			stmt.setInt(12, discente.getNumCasa());
			stmt.setString(13, discente.getPontoRef());
			stmt.setString(14, discente.getEstado());
			stmt.setString(15, discente.getMotivoSolicitacao());
			stmt.setInt(16, discente.getIdPessoa());
			stmt.setInt(17, discente.getIdDiscente());
			
			
			stmt.execute();
			stmt.close();
			return true;

		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return false;
		
	}
	
	public Discente getById(int idDiscente){
		
		try {
			Discente discente = new Discente();
	        
			String sql = "select * from discente where id_discente = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idDiscente);
			
			ResultSet rs = stmt.executeQuery();
			
			List<Discente> discentes = convertToList(rs);
			
			if (!discentes.isEmpty()) {
				discente = discentes.get(0);
			}
			
			stmt.close();
			rs.close();

			return discente;

		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return null;
	
	}
	
	public List<Discente> convertToList(ResultSet rs)
			throws SQLException {

		List<Discente> Discentes = new ArrayList<Discente>();

		try {

			while (rs.next()) {

				Discente discente = new Discente();
				
				discente.setIdDiscente(rs.getInt("id_discente"));
				discente.setEscolaOrigem(rs.getString("escola_origem"));
				discente.setOrgExpeditor(rs.getString("org_expeditor"));
				discente.setNumCartaoSus(("num_cartao_sus"));
				discente.setEstadoCivil(("estado_civil"));
				discente.setCurso(rs.getString("curso"));
				discente.setPeriodoLetivo(rs.getInt("periodo_letivo"));
				discente.setTurno(rs.getString("Turno"));
				discente.setEndereco(rs.getString("endereco"));
				discente.setCep(rs.getString("cep"));
				discente.setBairro(rs.getString("bairro"));
				discente.setCidade(rs.getString("cidade"));
				discente.setNumCasa(rs.getInt("num_casa"));
				discente.setPontoRef(rs.getString("ponto_ref"));
				discente.setEstado(rs.getString("estado"));
				discente.setMotivoSolicitacao(rs.getString("motivo_solicitacao"));
				
				// Pessoa
				PessoaDAO p = new PessoaDAO(); 
				Pessoa pessoa = p.getById(rs.getInt("pessoa_id"));
				
				
				discente.setIdPessoa(pessoa.getIdPessoa());
				discente.setNomePessoa(pessoa.getNomePessoa());
				discente.setCpf(pessoa.getCpf());
				discente.setEmail(pessoa.getEmail());
				discente.setDataNasc(pessoa.getDataNasc());
				discente.setMatricula(pessoa.getMatricula());
				discente.setRg(pessoa.getRg());
				discente.setSexo(pessoa.getSexo());
				discente.setSenha(pessoa.getSenha());


				
				

				Discentes.add(discente);
			}

		} catch (SQLException sqle) {
			
		}

		return Discentes;
	}
	
	public List<Discente> find(Discente discente) throws SQLException { //Usado para visualizar dados pessoais também
		List<Discente> discentes = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = String
					.format("%s '%%%s%%'",
							"SELECT  discente.id_discente,"
									+ " discente.escola_origem, "
									+ "discente.org_expeditor, "
									+ "discente.num_cartao_sus, "
									+ "discente.estado_civil,"
									+ "discente.curso , "
									+ "discente.periodo_letivo, "
									+ "discente.turno,"
									+ "discente.endereco, "
									+ "discente.cep,"
									+ "discente.bairro ,"
									+ "discente.cidade ,"
									+ "discente.num_casa ,"
									+ "discente.ponto_ref ,"
									+ "discente.estado ,"
									+ "discente.motivo_solicitacao ,"
									+ "discente.pessoa_id "
									+ "FROM discente "
									+ "INNER JOIN pessoa "
									+ "ON pessoa.id_pessoa = discente.pessoa_id "
						        + " WHERE pessoa.matricula LIKE",
							discente.getMatricula());

			stmt = (PreparedStatement) conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			discentes = convertToList(rs);

		} catch (SQLException sqle) {
			throw new SQLException(sqle);
					
		} 

		return discentes;
	}
	
	
	public List<Discente> getAll() throws SQLException {
		
		List<Discente> discentes = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {

			String sql = String
					.format("%s",
							"SELECT     id_discente, "
									+ " escola_origem, "
									+ "org_expeditor, "
									+ "num_cartao_sus, "
									+ "estado_civil,"
									+ "curso , "
									+ "periodo_letivo, "
									+ "turno,"
									+ "endereco, "
									+ "cep,"
									+ "bairro ,"
									+ "cidade ,"
									+ "num_casa ,"
									+ "ponto_ref ,"
									+ "estado ,"
									+ "motivo_solicitacao ,"
									+ "pessoa_id "
						    + " FROM `discente`");

			stmt = (PreparedStatement) conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql);
			
			discentes = convertToList(rs);

		} catch (SQLException sqle) {
			
			sqle.printStackTrace();
			
		}
		return discentes;
		
	}
 
    	
	
	 /**
	    * Função que retorna o id do discente,atráves da matrícula fornecida
	    * @author Fanny
	    * 
	    * */	
	
	 public int getId(String matricula) throws SQLException {
			
			int idDiscente  = 0;
			
			PessoaDAO p = new PessoaDAO();
		

			PreparedStatement stmt = null;
			ResultSet rs = null;

			try {
				
				String sql = String 
						.format("%s '%s'",
						"SELECT id_discente from discente where "
						+ "pessoa_id = ",
						 p.getId(matricula));

				stmt = (PreparedStatement) conn.prepareStatement(sql);

				rs = stmt.executeQuery(sql);

				while (rs.next()) {
	               idDiscente = rs.getInt("id_discente");
				}

			} catch (SQLException sqle) {

				sqle.printStackTrace();

			} 
			
			return idDiscente;
		}
		
    
    
    
    
	
	

}
