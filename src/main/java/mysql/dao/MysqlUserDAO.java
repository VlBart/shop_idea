/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql.dao;
import dao.entity.Country;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

// org.apache.log4j.Logger;


import dao.entity.User;
import dao.interfaces.UserDAO;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Andrei
 */
public class MysqlUserDAO extends MysqlDAO implements UserDAO {
        private static final Logger logger = Logger.getLogger(MysqlUserDAO.class.getName());
        private final String SQL_INSERT = 
			"INSERT INTO users (username, password, full_name, email, phone, is_admin, id_country, address) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private final String SQL_DELETE =
			"DELETE FROM users WHERE id=?";
	private final String SQL_FIND = 
			"SELECT * FROM users WHERE id=?";
	private final String SQL_UPDATE = 
			"UPDATE users SET email=?, full_name=?, phone=?, address=?, id_country=? WHERE id=?";
	private final String SQL_SELECT = 
			"SELECT * FROM users " +
			"WHERE username=? AND password=? ";
        private final String SQL_FOUND =
                        "SELECT * FROM users WHERE username=?";
        private final String SQL_SELECT_ALL =
                        "SELECT * FROM users, countries WHERE users.id_country = countries.id ";
	
	
	//public MysqlUserDAO() {}

	@Override
	public int insertUser(User user) {
		int numUser = 0;
		try {
			statement = conn.prepareStatement(SQL_INSERT, 1);
			statement.setString(1, user.getUserName());
			statement.setString(2, user.getPassword());
                        statement.setString(3, user.getFullName());
                        statement.setString(4, user.getEmail());
                        statement.setString(5, user.getPhone());
                        statement.setShort(6, user.getIsAdmin());
                        statement.setInt(7, user.getIdCountry());
                        statement.setString(8, user.getAddress());
			numUser = statement.executeUpdate();
			//logger.info("New user has been added");
			close();
		} catch (Exception e) {
			logger.log(Level.SEVERE,"SQLException - " + e.getMessage());
		}		
		return numUser;
	}
	
	@Override
	public boolean deleteUser(int id) {
		boolean flag;
		try {
			statement = conn.prepareStatement(SQL_DELETE);
			statement.setInt(1, id);
			flag = statement.execute();
			//logger.info("User with id=" + id + " has been deleted");
			close();
		} catch (SQLException e) {
			//logger.error("SQLException - " + e.getMessage());;
			flag = false;
		}		
		return flag;	
	}
	
	@Override
	public User findUser(int id) {
		User user = new User();
		try {
			statement = conn.prepareStatement(SQL_FIND);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			user = buildUser(rs);
			close();
		} catch (SQLException e) {
			//logger.error("SQLException" + e.getMessage());;
		}		
		return user;
	}
	
        @Override
        public User foundUser(String username) {
		User user = new User();
		try {
			statement = conn.prepareStatement(SQL_FOUND);
			statement.setString(1, username);
			rs = statement.executeQuery();
			user = buildUser(rs);
			close();
		} catch (SQLException e) {
			//logger.error("SQLException" + e.getMessage());;
		}		
		return user;
	}
        
	@Override
	public User selectUser(User user) {
		User resultUser = new User();
		try {
			statement = conn.prepareStatement(SQL_SELECT);
			statement.setString(1, user.getUserName());
			statement.setString(2, user.getPassword());
			rs = statement.executeQuery();
			resultUser = buildUser(rs);
			close();
		} catch (SQLException e) {
			//logger.error("SQLException - " + e.getMessage());
		}		
		return resultUser;
	}
        
        @Override
        public List<User> selectAllUser(){
            List<User> result = new LinkedList<User>();
            try {
			statement = conn.prepareStatement(SQL_SELECT_ALL);
			rs = statement.executeQuery();
			while (rs.next()) {
				User resultUser = new User();
				resultUser.setId(rs.getInt(1));
				resultUser.setFullName(rs.getString(2));
				resultUser.setEmail(rs.getString(3));
				resultUser.setPhone(rs.getString(4));
                                resultUser.setUserName(rs.getString(5));
                                resultUser.setPassword(rs.getString(6));
                                resultUser.setIsAdmin(rs.getShort(7));
                                resultUser.setAddress(rs.getString(8));
				
				Country resultCountry = new Country();
				resultCountry.setValue(rs.getString(11));
                                
                                resultUser.setCountry(resultCountry);
                               
                                
				result.add(resultUser);

			}
			//logger.info(count + " company(es) has been selected");
			close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE,"SQLException - " + e.getMessage());
		}		
		return result;
        }

	@Override
	public int updateUser(User user) {
		int num = 0;
		try {
			statement = conn.prepareStatement(SQL_UPDATE);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getFullName());
			statement.setString(3, user.getPhone());
                        statement.setString(4, user.getAddress());
                        statement.setInt(5, user.getIdCountry());
                        statement.setInt(6, user.getId());
			num = statement.executeUpdate();
			//logger.info(num + " user(s) has been updated");
			close();
		} catch (SQLException e) {
			//logger.error("SQLException - " + e.getMessage());
		}
		return num;
	}
	
	private User buildUser(ResultSet rs) {
		int count = 0;
		User resultUser = new User();
		//Calendar calendar = Calendar.getInstance();
		//DateFormat date = DateFormat.getDateInstance(3, new Locale("ru"));
		try {
			if (rs.next()) {
				resultUser.setId(rs.getInt(1));
                                resultUser.setFullName(rs.getString(2));
                                resultUser.setEmail(rs.getString(3));
                                resultUser.setPhone(rs.getString(4));
				resultUser.setUserName(rs.getString(5));
				resultUser.setPassword(rs.getString(6));
				resultUser.setIsAdmin(rs.getShort(7));
                                //resultUser.setIdCity(rs.getInt(8));
				resultUser.setIdCountry(rs.getInt(9));
                                resultUser.setAddress(rs.getString(8));
				
				/*Address address = new Address();
				address.setId(rs.getInt(10));
				address.setCountry(rs.getString(11));
				address.setCity(rs.getString(12));
				address.setStreet(rs.getString(13));
				address.setBuilding(rs.getString(14));
				address.setRoom(rs.getString(15));
				resultUser.setAddress(address);*/
				count++;
			}
		} catch (SQLException e) {
			// Insert Logger
			//logger.error(e);
		}
		return resultUser;
	}
    
}
