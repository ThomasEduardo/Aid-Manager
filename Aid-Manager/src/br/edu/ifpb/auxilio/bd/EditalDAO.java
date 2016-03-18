package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.auxilio.dominio.DadosBancarios;
import br.edu.ifpb.auxilio.dominio.Edital;


public class EditalDAO {
	//Metodos estão com problema devido a relação
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

			stmt.setDate(1, new java.sql.Date(edital.getIniInscricoes().getTime()));
			stmt.setDate(2, new java.sql.Date(edital.getFimInscricoes().getTime()));
			stmt.setDate(3, new java.sql.Date(edital.getIniEntregaForm().getTime()));
			stmt.setInt (4, edital.getAno());
			stmt.setDate(5, new java.sql.Date(edital.getFimForm().getTime()));
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
				+ "`processo_id=?` "
				+ "WHERE id_edital = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setDate(1, new java.sql.Date(edital.getIniInscricoes().getTime()));
			stmt.setDate(2, new java.sql.Date(edital.getFimInscricoes().getTime()));
			stmt.setDate(3, new java.sql.Date(edital.getIniEntregaForm().getTime()));
			stmt.setInt(4, edital.getAno());
			stmt.setDate(5, new java.sql.Date(edital.getFimForm().getTime()));
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
	
	
	public Edital getById(int idEdital){
		try{
		Edital edital = new Edital();
		
		String sql = "select * from edital where id_edital = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, idEdital);
		
		ResultSet rs = stmt.executeQuery();
		
		List<Edital> editais = convertToList(rs);
		
		if (!editais.isEmpty()) {
			
			edital = editais.get(0);
			
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
	
	public List<Edital> convertToList(ResultSet rs)
			throws SQLException {

		List<Edital> editais = new ArrayList<Edital>();

		try {

			while (rs.next()) {

				Edital edital = new  Edital();
				
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
				
				/* Processo
				
				ProcessoDAO p = new ProcessoDAO();
				edital.setProcesso(p.getById(rs.getInt("processo_id")));*/
				

				editais.add(edital);
			}

		} catch (SQLException sqle) {
			System.out.println("Exception is :"+sqle);
		}

		return editais;
	}
	

}
