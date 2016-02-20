package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.ifpb.auxilio.dominio.Discente;


public class DiscenteDAO extends PessoaDAO {
	
	private Connection conn;
	
	public DiscenteDAO(){
		conn = Conexao.getConnection();
		if(conn != null)
			System.out.println("Conexão estabelecida");
		else System.out.println("Erro na conexão com o BD");	
	}
	
	
	public void insert(Discente discente) {

		String sql = "INSERT INTO discente(escolaOrigem,orgExpeditor,"
				+ "numCartaoSus,estadoCivil,idade, curso,periodoLetivo,turno,"
				+ "endereco,cep,bairro,cidade,"
				+ "numCasa,pontoRef,estado, motivoSolicitacao,idPessoa,idResultados) "
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
	
	
	
	
	
	
	

}
