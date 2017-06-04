/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql.dao;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dao.entity.Type;
import dao.interfaces.TypeDAO;

/**
 *
 * @author Andrei
 */
public class MysqlTypeDAO extends MysqlDAO implements TypeDAO {
    
    private final String SQL_INSERT = 
			"INSERT INTO type (value) VALUES (?)";	
	private final String SQL_DELETE =
			"DELETE FROM type WHERE id=?";	
	private final String SQL_FIND = 
			"SELECT * FROM type WHERE id=?";		
	private final String SQL_SELECT_ALL = 
			"SELECT * FROM type";	
	
	/*static {
		logger = Logger.getLogger(MysqlLanguageDAO.class);
	}*/

	@Override
	public int insertType(Type type) {
		int pkey = 0;
		try {
			statement = conn.prepareStatement(SQL_INSERT, 1);
			if (!"".equals(type.getValue()))
				statement.setString(1, type.getValue());
			statement.executeUpdate();
			rs = statement.getGeneratedKeys();
			while (rs.next()) {
				pkey = rs.getInt(1);
			}			
			type.setId(pkey);
			//logger.info("New language has been added: " + language);
			close();
		} catch (SQLException e) {
			//logger.error("SQLException - " + e.getMessage());
		}		
		return pkey;
	}

	@Override
	public boolean deleteType(int id) {
		boolean result = false;
		try {
			statement = conn.prepareStatement(SQL_DELETE);
			statement.setInt(1, id);
			result = statement.execute();
			close();
		} catch (SQLException e) {
			//logger.error("SQLException - " + e.getMessage());
		}
		return result;
	}

	@Override
	public Type findType(int id) {
		Type tp = null;
		try {
			statement = conn.prepareStatement(SQL_FIND);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			while (rs.next()) {
				tp = new Type();
				tp.setId(rs.getInt(1));
				tp.setValue(rs.getString(2));
			}
			close();
		} catch (SQLException e) {
			//logger.error("SQLException" + e.getMessage());
		}
		return tp;
	}

	@Override
	public List<Type> selectType() {
		List<Type> result = new LinkedList<Type>();
		int count = 0;
		try {
			statement = conn.prepareStatement(SQL_SELECT_ALL);
			rs = statement.executeQuery();
			while (rs.next()) {
				Type resultType = new Type();
				resultType.setId(rs.getInt(1));
				resultType.setValue(rs.getString(2));
	
				result.add(resultType);
				count++;
			}
			//logger.info(count + " language(s) has been selected");
			close();
		} catch (SQLException e) {
			//logger.error("SQLException" + e.getMessage());
		}		
		return result;
	}
    
}
