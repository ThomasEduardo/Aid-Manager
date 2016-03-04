package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifpb.auxilio.dominio.Discente;
import br.edu.ifpb.auxilio.dominio.Pessoa;
import br.edu.ifpb.auxilio.dominio.TecnicoAdmin;


public class DiscenteDAO extends PessoaDAO {
	
	private Connection conn;
	
	public DiscenteDAO(){
		conn = Conexao.getConnection();
		if(conn != null)
			System.out.println("Conexão estabelecida");
		else System.out.println("Erro na conexão com o BD");	
	}
	
	
	public void insert(Discente discente) {

		String sql = "INSERT INTO discente("
				+ "escolaOrigem,"
				+ "orgExpeditor,"
				+ "numCartaoSus,"
				+ "estadoCivil,"
				+ "idade,"
				+ "curso,"
				+ "periodoLetivo,"
				+ "turno,"
				+ "endereco,"
				+ "cep,"
				+ "bairro,"
				+ "cidade,"
				+ "numCasa,"
				+ "pontoRef,"
				+ "estado, "
				+ "motivoSolicitacao,"
				+ "idPessoa,"
				+ "idResultados) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, discente.getEscolaOrigem());
			stmt.setString(2, discente.getOrgExpeditor() );
			stmt.setString(3, discente.getNumCartaoSus());
			stmt.setString(4, discente.getEstadoCivil());
			stmt.setInt   (5, discente.getIdade());
			stmt.setString(6, discente.getCurso());
			stmt.setInt   (7, discente.getPeriodoLetivo());
			stmt.setString(8, discente.getTurno());
			stmt.setString(9, discente.getEndereco());
			stmt.setString(10, discente.getCep());
			stmt.setString(11, discente.getBairro());
			stmt.setString(12, discente.getCidade());
			stmt.setInt   (13, discente.getNumCasa());
			stmt.setString(14, discente.getPontoRef());
			stmt.setString(15, discente.getEstado());
			stmt.setString(16, discente.getMotivoSolicitacao());
			stmt.setInt   (17, getIdPessoa(discente.getMatricula()));
			//stmt.setInt   (18, discente.getResultados().getNumProcesso());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public boolean update(Discente discente){
		String sql = "update pessoa set escolaOrigem = ? ,"
				       + "orgExpeditor = ?,"
				       + "numCartaoSus  = ?,"
				       + "estadoCivil =?,"
				       + "idade = ?,"
				       + "curso  = ?,"
				       + "periodoLetivo = ?,"
				       + "turno = ? "
				       + "endereco = ?"
				       + "cep = ? "
				       + "bairro = ?"
				       + "cidade = ?"
				       + "numCasa = ?"
				       + "pontoRef = ?"
				       + "estado = ?"
				       + "motivoSolicitacao = ?"
				       + "idPessoa = ?"
				       + "idResultados = ?"
				       + "WHERE idDiscente = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, discente.getEscolaOrigem());
			stmt.setString(2, discente.getOrgExpeditor());
			stmt.setString(3, discente.getNumCartaoSus());
			stmt.setString(4, discente.getEstadoCivil());
			stmt.setInt(5, discente.getIdade());
			stmt.setString(6, discente.getCurso());
			stmt.setInt(7, discente.getPeriodoLetivo());
			stmt.setString(8, discente.getTurno());
			stmt.setString(9, discente.getEndereco());
			stmt.setString(10, discente.getCep());
			stmt.setString(11, discente.getBairro());
			stmt.setString(12, discente.getCidade());
			stmt.setInt(13, discente.getNumCasa());
			stmt.setString(14, discente.getPontoRef());
			stmt.setString(15, discente.getEstado());
			stmt.setString(15, discente.getMotivoSolicitacao());
			stmt.setInt(16, discente.getIdPessoa());
			stmt.setInt(17, discente.getResultados().getIdResultados());
			stmt.setInt(18, discente.getIdDiscente());
			stmt.execute();
			return true;

		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return false;
		
	}
	
	public Discente getObject(String matricula) {
		
		try {
			Discente discente = new Discente();
	        Pessoa pessoa = new Pessoa();
	        
			String sql = "select * from discente where idPessoa = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, super.getIdPessoa(matricula));
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				discente.setIdDiscente(rs.getInt("idDiscente"));
				discente.setEscolaOrigem(rs.getString("escolaOrigem"));
				discente.setOrgExpeditor(rs.getString("orgExpeditor"));
				discente.setNumCartaoSus(("numCartaoSus"));
				discente.setEstadoCivil(("estadoCivil"));
				discente.setIdade(rs.getInt("idade"));
				discente.setCurso(rs.getString("curso"));
				discente.setPeriodoLetivo(rs.getInt("periodoLetivo"));
				discente.setTurno(rs.getString("Turno"));
				discente.setEndereco(rs.getString("endereco"));
				discente.setCep(rs.getString("cep"));
				discente.setBairro(rs.getString("bairro"));
				discente.setCidade(rs.getString("cidade"));
				discente.setNumCasa(rs.getInt("numCasa"));
				discente.setPontoRef(rs.getString("pontoRef"));
				discente.setEstado(rs.getString("estado"));
				discente.setMotivoSolicitacao(rs.getString("motivoSolicitacao"));
				//Falta pessoa e resultados
			}
			stmt.close();
			rs.close();

			return discente;

		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return null;

		
		
		
	}
	
	
	
	
	

}
