/**
 * 
 * @author FannyVieira, RaylaMedeiros, MateusOliveira
 *
 */
package br.edu.ifpb.auxilio.bd;

import java.sql.SQLException;


public interface GenericIFDAO<PK,T> {
	
	
	
	public T getObject(PK pk) throws SQLException;
	
	public void insert(T entity) throws SQLException;

	public boolean update(T entity) throws SQLException;
		
	public void delete(PK pk) throws SQLException;
	

}
