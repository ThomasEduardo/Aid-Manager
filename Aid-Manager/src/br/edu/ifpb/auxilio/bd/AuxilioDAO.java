package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.auxilio.bd.Conexao;
import br.edu.ifpb.auxilio.dominio.Auxilio;


public class AuxilioDAO{
	
private Connection conn;
	
	public AuxilioDAO(){
		conn = Conexao.getConnection();
		if(conn != null)
			System.out.println("Conexão estabelecida");
		else System.out.println("Erro na conexão com o BD");	
	}
	
	
	public void insert(Auxilio auxilio) {

		String sql = "INSERT INTO auxilio( "
				+ " `tipo_Auxilio`, "
				+ " `valor_Auxilio`, "
				+ " `validade_Inicial`, "
				+ " `validade_Final`,"
				+ " `instituicaoFinanciadora_id`, "
				+ " `processo_id`)"
				+ "VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, auxilio.getTipoAuxilio());
			stmt.setDouble(2, auxilio.getValorAuxilio() );
			stmt.setDate  (3, null);
			stmt.setDate  (4, null);
			stmt.setInt   (5, auxilio.getIF().getIdIF());
         	stmt.setInt   (6, auxilio.getP().getIdProcesso());
         	
         	
			stmt.execute();
			stmt.close();
			
			//Ajeitar datas
		} catch (SQLException e) { 
			
			throw new RuntimeException(e);
			
		}

	}
	
	public boolean update(Auxilio auxilio) { 
		
		String sql = "update pessoa set "
				+ " `tipo_auxilio`=?, "
				+ " `valor_auxilio`=?, "
				+ " `validade_inicial`=?, "
				+ " `validade_final`=?,"
				+ " `instituicaoFinanciadora_id`=?, "
				+ " `processo_id`=? "
				+ "WHERE id_auxilio = ?";
		try {
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			
			stmt.setString(1, auxilio.getTipoAuxilio());
			stmt.setDouble(2, auxilio.getValorAuxilio() );
			//stmt.setDate(3, auxilio.getValidadeInicial());
			//stmt.setDate(4, auxilio.getValidadeFinal());
			stmt.setInt   (5, auxilio.getIF().getIdIF());
			stmt.setInt   (6, auxilio.getP().getIdProcesso());
			stmt.setInt   (7, auxilio.getIdAuxilio());
			
			
			stmt.execute();
			stmt.close();
			return true;

		} catch (Exception e) {
			
			System.out.println("Exception is :" + e);
			
		}
		
		return false;
		
	}
	
	
	
	public Auxilio getById(int idAuxilio) {
		
		try {

			Auxilio auxilio = new Auxilio();
			String sql = "select * from auxilio "
						+ "where id_auxilio = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idAuxilio);
			
			ResultSet rs = stmt.executeQuery();
			

			List<Auxilio> auxilios  = convertToList(rs);
			
			if (!auxilios.isEmpty()) {
				auxilio = auxilios.get(0);
			}
			
			
			stmt.close();
			rs.close();
			
			return auxilio;

		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		
		return null;

	}
	
	
	
	public List<Auxilio> convertToList(ResultSet rs)
			throws SQLException {

		List<Auxilio> auxilios = new ArrayList<Auxilio>();

		try {

			while (rs.next()) {

				Auxilio auxilio = new Auxilio();
				auxilio.setIdAuxilio(rs.getInt("id_auxilio"));
				auxilio.setTipoAuxilio(rs.getString("tipo_auxilio"));
				auxilio.setValorAuxilio(rs.getDouble("valor_auxilio"));
				auxilio.setValidadeInicial(rs.getDate("validade_inicial"));
				auxilio.setValidadeFinal(rs.getDate("validade_final"));
				
				// Instituicao Financiadora 
				
				InstituicaoFinanciadoraDAO IF = new InstituicaoFinanciadoraDAO();
				auxilio.setIF(IF.getById(rs.getInt("instituicaoFinanciadora_id")));
				

				auxilios.add(auxilio);
			}

		} catch (SQLException sqle) {
			
		}

		return auxilios;
	}
	

}
