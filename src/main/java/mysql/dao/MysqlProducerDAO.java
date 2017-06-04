/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql.dao;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dao.entity.Producer;
import dao.entity.Country;
import dao.interfaces.ProducerDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrei
 */
public class MysqlProducerDAO extends MysqlDAO implements ProducerDAO {
    private static final Logger logger;
    private final String SQL_INSERT = 
			"INSERT " +
			"INTO producers (name,email,phone,address,id_country) " +
			"VALUES (?, ?, ?, ?, ?)";	
	private final String SQL_DELETE =
			"DELETE FROM producers WHERE id=?";	
	private final String SQL_FIND = 
			"SELECT * FROM producers WHERE id=?";	
	private final String SQL_UPDATE = 
			"UPDATE producers " +
			"SET email=?, phone=?, name=?, address=?, id_country=? " +
			"WHERE id=?";	
	private final String SQL_SELECT_ALL = 
			"SELECT * " +
			"FROM producers,countries " +
			"WHERE  producers.id_country = countries.id ";	
	
	static {
		logger = Logger.getLogger(MysqlProducerDAO.class.getName());
	}

	@Override
	public int insertProducer(Producer producer) {
		int pkey = 0;
		try {
			statement = conn.prepareStatement(SQL_INSERT, 1);
			statement.setString(1, producer.getName());
			statement.setString(2, producer.getEmail());
			statement.setString(3, producer.getPhone());
			statement.setString(4, producer.getAddress());
                        statement.setInt(5, producer.getIdCountry());
			statement.executeUpdate();
			rs = statement.getGeneratedKeys();
			while (rs.next()) {
				pkey = rs.getInt(1);
			}		
			producer.setId(pkey);
			logger.log(Level.INFO, "New company has been added: {0}", producer);
			close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException - {0}", e.getMessage());
		}		
		return pkey;
	}

	@Override
	public boolean deleteProducer(int id) {
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
	public Producer findProducer(int id) {
		Producer producer = null;
		try {
			statement = conn.prepareStatement(SQL_FIND);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			while (rs.next()) {
				producer = new Producer();
                                producer.setId(rs.getInt(1));
				producer.setEmail(rs.getString(2));
				producer.setPhone(rs.getString(3));
				
				producer.setIdCountry(rs.getInt(4));
				producer.setName(rs.getString(5));
                                producer.setAddress(rs.getString(6));
			}
			close();
		} catch (SQLException e) {
			//logger.error("SQLExceptione - " + e.getMessage());
		}
		return producer;
	}

	@Override
	public int updateProducer(Producer producer) {
		int num = 0;
		try {
			statement = conn.prepareStatement(SQL_UPDATE);
			statement.setString(1, producer.getEmail());
			statement.setString(2, producer.getPhone());
			statement.setString(3, producer.getName());
                        statement.setString(4, producer.getAddress());
                        statement.setInt(5, producer.getIdCountry());
			statement.setInt(6, producer.getId());
			num = statement.executeUpdate();
			//logger.info(num + " company(es) has been updated");
			close();
		} catch (SQLException e) {
			//logger.error("SQLException - " + e.getMessage());
		}
		return num;
	}

	@Override
	public List<Producer> selectProducer() {
		List<Producer> result = new LinkedList<Producer>();
		int count = 0;
		try {
			statement = conn.prepareStatement(SQL_SELECT_ALL);
			rs = statement.executeQuery();
			while (rs.next()) {
				Producer resultProducer = new Producer();
				resultProducer.setId(rs.getInt(1));
				resultProducer.setEmail(rs.getString(3));
				resultProducer.setPhone(rs.getString(4));
				resultProducer.setName(rs.getString(2));
                                resultProducer.setAddress(rs.getString(5));
				
				//City resultCity = new City();
				//resultCity.setValue(rs.getString(8));
                                
                                Country resultCountry = new Country();
                                resultCountry.setValue(rs.getString(8));
                                
				//resultProducer.setCity(resultCity);
                                resultProducer.setCountry(resultCountry);
                                
				result.add(resultProducer);
				count++;
			}
			//logger.info(count + " company(es) has been selected");
			close();
		} catch (SQLException e) {
			//logger.error("SQLException - " + e.getMessage());
		}		
		return result;
	}
    
}
