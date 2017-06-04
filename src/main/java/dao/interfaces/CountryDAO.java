/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import java.util.List;

import dao.entity.Country;

/**
 *
 * @author Andrei
 */
public interface CountryDAO {
    
    /**
	 * Inserts country in database.
	 * 
	 * @param country
	 * @return
	 */
	public int insertCountry(Country country);
	
	/**
	 * Deletes country from database by id.
	 * 
	 * @param id
	 * @return
	 *          "true" if country has been deleted successful or "false" otherwise
	 */
	public boolean deleteCountry(int id);
	
	/**
	 * Finds country in database by id.
	 * 
	 * @param id
	 * @return country
	 */
	public Country findCountry(int id);
	
	
	/**
	 * 
	 * @param country
	 * @return country from database
	 */
	public List<Country> selectCountry();
    
}
