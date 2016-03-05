package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import br.edu.ifpb.auxilio.dominio.Edital;


public class EditalDAO {
private Connection conn;
	
	public EditalDAO(){
		conn = Conexao.getConnection();
		if(conn != null)
			System.out.println("Conexão estabelecida");
		else System.out.println("Erro na conexão com o BD");	
	}
	
	
	public void insert(Edital edital) {

		String sql = "INSERT INTO `edital`("
				+ "`ini_inscricoes`, "
				+ "`fim_inscricoes`,"
				+ "`ini_entrega_form`,"
				+ "`ano`, "
				+ "`fim_form`, "
				+ "`descricao`, "
				+ "`titulo`, "
				+ "`valor_bolsa_discente`, "
				+ "`vagas_bolsistas`, "
				+ "`num_edital`, "
				+ "`processo_id`)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			//stmt.setDate(1, edital.getIniInscricoes() );
			//stmt.setDate(2, edital.getFimInscricoes());
			//stmt.setDate(3, edital.getIniEntregaForm());
			stmt.setInt(4, edital.getAno());
			//stmt.setDate(5, edital.getFimForm());
			stmt.setString(6, edital.getDescricao());
			stmt.setString(7, edital.getTitulo());
			stmt.setDouble(8, edital.getValorBolsaDiscente());
			stmt.setInt(9, edital.getVagasBolsistas());
			stmt.setString(10, edital.getNumEdital());
			stmt.setInt(11, edital.getIdProcesso());
			stmt.execute();
			stmt.close();
			
			//Ajeitar datas
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public boolean update(Edital edital) {
		String sql = "update edital set "
				+ "`ini_inscricoes` =?, "
				+ "`fim_inscricoes`=?,"
				+ "`ini_entrega_form`=?,"
				+ "`ano`=?, "
				+ "`fim_form`=?, "
				+ "`descricao`=?, "
				+ "`titulo`=?, "
				+ "`valor_bolsa_discente`=?, "
				+ "`vagas_bolsistas`=?, "
				+ "`num_edital`=?, "
				+ "`processo_id=?`"
				+ "WHERE id_edital = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			//stmt.setDate(1, edital.getIniInscricoes() );
			//stmt.setDate(2, edital.getFimInscricoes());
			//stmt.setDate(3, edital.getIniEntregaForm());
			stmt.setInt(4, edital.getAno());
			//stmt.setDate(5, edital.getFimForm());
			stmt.setString(6, edital.getDescricao());
			stmt.setString(7, edital.getTitulo());
			stmt.setDouble(8, edital.getValorBolsaDiscente());
			stmt.setInt(9, edital.getVagasBolsistas());
			stmt.setString(10, edital.getNumEdital());
			stmt.setInt(11, edital.getIdProcesso());
			stmt.setInt(12, edital.getIdEdital());
			stmt.execute();
			stmt.close();
			return true;

		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return false;
	}
	
	public Edital getObject(String numEdital){
		try{
		Edital edital = new Edital();
		String sql = "select * from edital where num_edital = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, numEdital);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()){
			
			edital.setIniInscricoes(rs.getDate("ini_inscricoes"));
			edital.setFimInscricoes(rs.getDate("fim_inscricoes"));
			edital.setIniEntregaForm(rs.getDate("ini_entrega_form"));
			edital.setAno(rs.getInt("ano"));
			edital.setFimForm(rs.getDate("fim_form"));
			edital.setDescricao(rs.getString("descricao"));
			edital.setTitulo(rs.getString("titulo"));
			edital.setValorBolsaDiscente(rs.getDouble("valor_bolsa_discente"));
			edital.setVagasBolsistas(rs.getInt("vagas_bolsistas"));
			edital.setNumEdital(rs.getString("num_edital"));
			//stmt.setInt(11, edital.getIdProcesso());	
			
		}
		stmt.close();
		rs.close();
		return edital;
        
	}
		catch (Exception e){
			System.out.println("Exception is :"+e);
		}
		return null;
		
		
	}
	
	public int getIdEdital(String numEdital) {
		try {
			int idEdital = 0;
			String sql = "select id_edital from edital where num_edital = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, numEdital);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				idEdital = rs.getInt("id_edital");

			}
			stmt.close();
			rs.close();
			return idEdital;

		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		
		return 0;

	}
}
