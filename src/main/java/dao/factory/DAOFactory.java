/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.factory;


import dao.interfaces.*;

/**
 *
 * @author Andrei
 */
public abstract class DAOFactory {
        public static final int MYSQL = 1;
        
	public abstract UserDAO getUserDAO();
        
        public abstract CountryDAO getCountryDAO();
        
        
        public abstract ModelDAO getModelDAO();
        
        public abstract OrderDAO getOrderDAO();
        public abstract OrderDAO getGuestOrderDAO();
        
        public abstract ProducerDAO getProducerDAO();
        
        public abstract TypeDAO getTypeDAO();
        
        
        public static DAOFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
		case MYSQL:
			return new MysqlDAOFactory();
		default:
			return null;
		}
	
    
}
}
