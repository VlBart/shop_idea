/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import java.util.List;

import dao.entity.Order;

/**
 *
 * @author Andrei
 */
public interface OrderDAO {
    
    /**
	 * Inserts order in database.
	 * 
	 * @param order
	 * @return
	 */
	public int insertOrder(Order order);
	
	/**
	 * Deletes order from database by id.
	 * 
	 * @param id
	 * @return
	 *          "true" if order has been deleted successful or "false" otherwise
	 */
	public boolean deleteOrder(int id);
	
	/**
	 * Finds order in database by id.
	 * 
	 * @param id
	 * @return order
	 */
	public Order findOrder(int id);
	
	/**
	 * Updates order in database.
	 * 
	 * @param order
	 * @return
	 */
	public int updateOrder(Order order);
	
	/**
	 * 
	 * @param order
	 * @return order from database
	 */
	public List<Order> selectOrder();
    
}
