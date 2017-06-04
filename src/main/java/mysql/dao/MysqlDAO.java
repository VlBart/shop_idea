/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import dao.factory.MysqlDAOFactory;

/**
 *
 * @author Andrei
 */
public class MysqlDAO {
        protected Connection conn = null;
	protected PreparedStatement statement = null;
	protected ResultSet rs = null;
	//protected static Logger logger;

	public MysqlDAO() {
		try {
			this.conn = MysqlDAOFactory.getDataSource().getConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());;
		}
	}
	
	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (statement != null)
				statement.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println("SQLException - " + e.getMessage());
		}
	} 
}
