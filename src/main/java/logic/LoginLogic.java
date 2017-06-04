/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;
import java.io.UnsupportedEncodingException;
import dao.entity.User;
import dao.factory.DAOFactory;
import dao.factory.MysqlDAOFactory;
import dao.interfaces.UserDAO;
import java.util.List;



/**
 * Class for checking username and password.
 *
 * @author Andrei
 */
public class LoginLogic {
    
    private static DAOFactory daoFactory = 
		MysqlDAOFactory.getDAOFactory(MysqlDAOFactory.MYSQL);
    
    /**
	 * Checks username and password.
	 * 
	 * @param username
	 * @param password
	 * @return user
	 * @throws UnsupportedEncodingException
	 */
	public static User checkLogin(String username, String password) 
			throws UnsupportedEncodingException {
		UserDAO userDAO = daoFactory.getUserDAO();
		
		User criteria = new User();
		criteria.setUserName(username);
		criteria.setPassword(password);
		
		User user = userDAO.selectUser(criteria);
		if (user.getUserName() == null) {
			return null;
		} else {
                        user.setCountry(DictionaryLogic.findCountry(user.getIdCountry()));
			return user;
		}
	}
        
        public static User foundUser(String username){
            return daoFactory.getUserDAO().foundUser(username);
        }
        
        public static void insertUser(User user){
            daoFactory.getUserDAO().insertUser(user);
        }
        public static void updateUser(User user){
            daoFactory.getUserDAO().updateUser(user);
        }
        public static List<User> getUser(){
           return daoFactory.getUserDAO().selectAllUser();
        }
        public static void deleteUser(int id){
            daoFactory.getUserDAO().deleteUser(id);
        }
    
}
