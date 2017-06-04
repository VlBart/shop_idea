/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import java.util.List;

import dao.entity.Type;

/**
 *
 * @author Andrei
 */
public interface TypeDAO {
    /**
	 * Inserts type in database.
	 * 
	 * @param type
	 * @return
	 */
	public int insertType(Type type);
	
	/**
	 * Deletes type from database by id.
	 * 
	 * @param id
	 * @return
	 *          "true" if type has been deleted successful or "false" otherwise
	 */
	public boolean deleteType(int id);
	
	/**
	 * Finds type in database by id.
	 * 
	 * @param id
	 * @return type
	 */
	public Type findType(int id);

	
	/**
	 * 
	 * @param type
	 * @return type from database
	 */
	public List<Type> selectType();
    
}
