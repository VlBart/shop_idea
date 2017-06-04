/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;



import dao.entity.Country;
import dao.entity.Type;
import dao.factory.DAOFactory;
import dao.factory.MysqlDAOFactory;

/**
 *
 * @author Andrei
 */
public class DictionaryLogic {
    
        private static DAOFactory daoFactory = 
                    MysqlDAOFactory.getDAOFactory(MysqlDAOFactory.MYSQL);
        
	

	public static List<Country> getCountries() {
		return daoFactory.getCountryDAO().selectCountry();
	}
	

      
        
        public static List<Type> getType(){
            return daoFactory.getTypeDAO().selectType();
        }
	


	
	public static void insertCountry(Country country){
            daoFactory.getCountryDAO().insertCountry(country);
        }

        
        public static void insertType(Type type){
            daoFactory.getTypeDAO().insertType(type);
        }
        
	
	public static void deleteCountry(String id){
            daoFactory.getCountryDAO().deleteCountry(Integer.parseInt(id));
        }
        
        
        public static void deleteType(String id){
            daoFactory.getTypeDAO().deleteType(Integer.parseInt(id));
        }
	
	
        public static Country findCountry(int id) {
            return daoFactory.getCountryDAO().findCountry(id);
        }
        
        
        public static Type findType(int id){
            return daoFactory.getTypeDAO().findType(id);
        }
        
        
}
