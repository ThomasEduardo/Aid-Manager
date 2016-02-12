package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifpb.auxilio.dominio.Pessoa;

public class AssistenteSocialDAO {
	private Connection conn;

	public AssistenteSocialDAO() {
		conn = Conexao.getConnection();
		if (conn != null)
			System.out.println("Conexão estabelecida");
		else
			System.out.println("Erro na conexão com o BD");
	}

	public void Cadastrar(Pessoa pessoa) {

		String sql = "insert into assistentesocial (idServidor)values (?)";
		try {
			// prepared statement para inserção
			PreparedStatement stmt = conn.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, pessoa.getNomePessoa());
			stmt.setString(2, pessoa.getMatricula());
			stmt.setDate(3, (java.sql.Date) pessoa.getDataNasc());
			stmt.setString(4, pessoa.getSenha());
			stmt.setString(5, pessoa.getEmail());
			stmt.setString(6, pessoa.getCpf());
			stmt.setString(7, pessoa.getRg());
			stmt.setString(8, pessoa.getSexo());

			// executa
			stmt.execute();
			stmt.close();
			System.out.println("Cadastrado com sucesso!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int getIdServidor(String matricula) {

		int idPessoa = 0;
		int idServidor = 0;
		String sql1 = "select idPessoa from pessoa where matricula = ?";
		String sql2 = "select idServidor from servidor where idPessoa = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql1);
			stmt.setString(1, matricula);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				idPessoa = rs.getInt("idPessoa");
			}
			PreparedStatement st = conn.prepareStatement(sql2);
			st.setInt(1, idPessoa);
			ResultSet r = st.executeQuery();
			while (r.next()) {
				idServidor = r.getInt("idServidor");
			}
			return idServidor;
		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return 0;
	}

}
