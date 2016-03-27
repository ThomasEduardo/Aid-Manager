package br.edu.ifpb.auxilio.actions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.auxilio.entidade.Pessoa;
import br.edu.ifpb.auxilio.service.bd.PessoaDAO;

public class ActionPessoa {
	
	PessoaDAO p;
	
	public int insert(Pessoa pessoa) throws SQLException {
		try{
			return p.insert(pessoa);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
        return 0;
	}

	public int getIsAuthorized(String Matricula, String senha)
			throws SQLException {
		try{
			return p.getIsAuthorized(Matricula, senha);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return 0;

	}
	public int IsAuthorized(String Matricula, String senha)
			throws SQLException {
			try{
				return p.IsAuthorized(Matricula, senha);
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			return 0;

	}
	
	public Pessoa getById (int idPessoa) throws SQLException{
		 try{
			 PessoaDAO p = new PessoaDAO();
			 return p.getById(idPessoa);
		 }
		 catch(SQLException e){
				e.printStackTrace();
		}
		 return null;
	}
	
	public void delete (String matricula) throws SQLException{
		try{
			p.delete(matricula);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		
	}
	
	public boolean update(Pessoa pessoa) throws SQLException{
		try{
			return p.update(pessoa);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return false;
		
	}
	
	public List<Pessoa> convertToList(ResultSet rs)
			throws SQLException {
		try{
			return p.convertToList(rs);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean isMatriculaCadastrada(String matricula) throws SQLException {
		try{
			return p.isMatriculaCadastrada(matricula);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return false;
		
	}
	
	public List<Pessoa> find(Pessoa pessoa) throws SQLException {
		try{
			return p.find(pessoa);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	public List<Pessoa> getAll() throws SQLException {
		try{
			return p.getAll();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
		
	}
	

	public int getId(String matricula) throws SQLException {
		try{
			PessoaDAO p = new PessoaDAO();
			return p.getId(matricula);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
		
	}
}
