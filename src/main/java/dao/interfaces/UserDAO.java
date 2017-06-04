/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;
import dao.entity.User;
import java.util.List;

/**
 *
 * Interface for accessing and managing users in database
 * @author Andrei
 */
public interface UserDAO {
    /**
	 * Inserts user in database.
	 * 
	 * @param user
	 * @return
	 */
	public int insertUser(User user);
	
	/**
	 * Deletes user from database by id.
	 * 
	 * @param id
	 * @return
	 *          "true" if user has been deleted successful or "false" otherwise
	 */
	public boolean deleteUser(int id);
	
	/**
	 * Finds user in database by id.
	 * 
	 * @param id
	 * @return user
	 */
	public User findUser(int id);
	
	/**
	 * Updates user in database.
	 * 
	 * @param user
	 * @return
	 */
	public int updateUser(User user);
	
	/**
	 * 
	 * @param user
	 * @return user from database
	 */
	public User selectUser(User user);
        
        
        public User foundUser(String username);
        
        public List<User> selectAllUser();
}
    
