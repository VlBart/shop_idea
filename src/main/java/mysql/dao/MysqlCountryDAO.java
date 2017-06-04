/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql.dao;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


import dao.entity.Country;
import dao.interfaces.CountryDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrei
 */
public class MysqlCountryDAO extends MysqlDAO implements CountryDAO{
        private final String SQL_INSERT = 
			"INSERT INTO countries (value) VALUES (?)";	
	private final String SQL_DELETE =
			"DELETE FROM countries WHERE id=?";	
	private final String SQL_FIND = 
			"SELECT * FROM countries WHERE id=?";		
	private final String SQL_SELECT_ALL = 
			"SELECT * FROM countries";	
	
	
	Logger logger = Logger.getLogger(MysqlCountryDAO.class.getName());
	

	@Override
	public int insertCountry(Country country) {
		int pkey = 0;
		try {
			statement = conn.prepareStatement(SQL_INSERT, 1);
			if (!"".equals(country.getValue()))
				statement.setString(1, country.getValue());
			statement.executeUpdate();
			rs = statement.getGeneratedKeys();
			while (rs.next()) {
				pkey = rs.getInt(1);
			}			
			country.setId(pkey);
			//logger.info("New language has been added: " + language);
			close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE,"SQLException - " + e.getMessage());
		}		
		return pkey;
	}

	@Override
	public boolean deleteCountry(int id) {
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
	public Country findCountry(int id) {
		Country cntr = null;
		try {
			statement = conn.prepareStatement(SQL_FIND);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			while (rs.next()) {
				cntr = new Country();
				cntr.setId(rs.getInt(1));
				cntr.setValue(rs.getString(2));
			}
			close();
		} catch (SQLException e) {
			//logger.error("SQLException" + e.getMessage());
		}
		return cntr;
	}

	@Override
	public List<Country> selectCountry() {
		List<Country> result = new LinkedList<Country>();
		int count = 0;
		try {
			statement = conn.prepareStatement(SQL_SELECT_ALL);
			rs = statement.executeQuery();
			while (rs.next()) {
				Country resultCntr = new Country();
				resultCntr.setId(rs.getInt(1));
				resultCntr.setValue(rs.getString(2));
	
				result.add(resultCntr);
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
