package br.edu.ifpb.auxilio.bd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifpb.auxilio.bd.Conexao;
import br.edu.ifpb.auxilio.dominio.Auxilio;


public class AuxilioDAO implements GenericIFDAO<String,Auxilio>{
	
private Connection conn;
	
	public AuxilioDAO(){
		conn = Conexao.getConnection();
		if(conn != null)
			System.out.println("Conexão estabelecida");
		else System.out.println("Erro na conexão com o BD");	
	}
	
	
	public void insert(Auxilio auxilio) {

		String sql = "INSERT INTO auxilio "
				+ " `tipo_Auxilio`, "
				+ " `valor_Auxilio`, "
				+ " `validade_Inicial`, "
				+ " `validade_Final`,"
				+ " `instituicaoFinanciadora_id`, "
				+ " `processo_id`"
				+ "VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, auxilio.getTipoAuxilio());
			stmt.setDouble(2, auxilio.getValorAuxilio() );
			//stmt.setDate(3, auxilio.getValidadeInicial());
			//stmt.setDate(4, auxilio.getValidadeFinal());
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
				+ " `processo_id`=?, "
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
	
	public Auxilio getObject(int idAuxilio){
		try{
		
		PessoaDAO p = new PessoaDAO();	
		Auxilio auxilio = new Auxilio();
		String sql = "select * from auxilio "
				     + "where id_auxilio = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, idAuxilio);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()){
           auxilio.setIdAuxilio(rs.getInt("id_auxilio"));
           auxilio.setTipoAuxilio(rs.getString("tipo_auxilio"));	
           auxilio.setValorAuxilio(rs.getDouble("valor_auxilio"));	
           auxilio.setValidadeInicial(rs.getDate("validade_inicial"));	
           auxilio.setValidadeFinal(rs.getDate("validade_final"));	
          //auxilio.setInstituicaoFinanciadora(rs.getInt("id_auxilio"));	
          //Processo
		}
		stmt.close();
		rs.close();
		return auxilio;
        
	}
		catch (Exception e){
			System.out.println("Exception is :"+e);
		}
		return null;
		
     }
	
	public int getIdAuxilio(String numProcesso){
		int idAuxilio = 0;
		String sql = "Select id_auxilio "
				+ "from auxilio "
				+ "inner join processo"
				+ "on processo.id_processo = auxilio.processo_id"
				+ "and processo.num_processo = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, numProcesso);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				idAuxilio = rs.getInt("id_auxilio");
			}
	        rs.close();
			stmt.execute();
			stmt.close();
			return idAuxilio;

		} catch (Exception e) {
			System.out.println("Exception is :" + e);
		}
		return 0;
	}
}
