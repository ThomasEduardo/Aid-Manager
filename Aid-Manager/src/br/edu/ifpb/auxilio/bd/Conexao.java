/**
 * 
 * @author FannyVieira, RaylaMedeiros, MateusOliveira
 *
 */

package br.edu.ifpb.auxilio.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	

	public static Connection getConnection() {
		Connection conn = null;
		try {
			// Carregando o driver JDBC para MySQL. Cada SGBD tem seu próprio driver
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/aidmanager", "root", "ifpbinfo");
			
		} catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	     catch(ClassNotFoundException e){  
	            throw new RuntimeException(e);  
	        } 
		
		return conn;
	}
}
