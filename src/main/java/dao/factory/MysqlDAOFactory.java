/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.factory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



import dao.interfaces.*;
import mysql.dao.*;

/**
 *
 * @author Andrei
 */

    public class MysqlDAOFactory extends DAOFactory {
	private static DataSource source = null;
	/**
	 * 
	 * @return Ready-to-use DataSource instance
	 */
	public static DataSource getDataSource() {
		if (source == null) {
			try {
				Context initCtx = new InitialContext();
				Context envCtx = (Context) initCtx.lookup("java:comp/env");
				source = (DataSource) envCtx.lookup("jdbc/shop_db");
				//logger.info("Connection pool has been created");
			} catch (NamingException e) {
				//logger.error("NamingException - " + e.getMessage());
			}	
		}
		return source;
	}

	@Override
	public UserDAO getUserDAO() {
		return new MysqlUserDAO();
	}
        
        
        @Override
        public CountryDAO getCountryDAO(){
            return new MysqlCountryDAO();
        }
        
        @Override
        public ModelDAO getModelDAO(){
            return new MysqlModelDAO();
        }
        
        @Override
        public OrderDAO getOrderDAO(){
            return new MysqlOrderDAO();
        }
        
        public OrderDAO getGuestOrderDAO(){
            return new MysqlGuestOrderDAO();
        }
        
        @Override
        public ProducerDAO getProducerDAO(){
            return new MysqlProducerDAO();
        }
       
        @Override
        public TypeDAO getTypeDAO(){
            return new MysqlTypeDAO();
        }
    
}
