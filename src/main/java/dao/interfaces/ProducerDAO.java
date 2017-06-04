/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import java.util.List;

import dao.entity.Producer;

/**
 *
 * @author Andrei
 */
public interface ProducerDAO {
    /**
	 * Inserts producer in database.
	 * 
	 * @param producer
	 * @return
	 */
	public int insertProducer(Producer producer);
	
	/**
	 * Deletes producer from database by id.
	 * 
	 * @param id
	 * @return
	 *          "true" if producer has been deleted successful or "false" otherwise
	 */
	public boolean deleteProducer(int id);
	
	/**
	 * Finds producer in database by id.
	 * 
	 * @param id
	 * @return producer
	 */
	public Producer findProducer(int id);
	
	/**
	 * Updates producer in database.
	 * 
	 * @param producer
	 * @return
	 */
	public int updateProducer(Producer producer);
	
	/**
	 * 
	 * @param producer
	 * @return producer from database
	 */
	public List<Producer> selectProducer();
    
}
