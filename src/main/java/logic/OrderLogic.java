/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dao.entity.Model;
import java.util.List;

import dao.entity.Order;
import dao.factory.DAOFactory;
import dao.factory.MysqlDAOFactory;

/**
 *
 * @author Andrei
 */
public class OrderLogic {
    
    private static DAOFactory daoFactory = 
			MysqlDAOFactory.getDAOFactory(MysqlDAOFactory.MYSQL);
	

	public static List<Order> getOrder() {
		return daoFactory.getOrderDAO().selectOrder();
	}
	

	public static void deleteOrder(String id) {
		daoFactory.getOrderDAO().deleteOrder(Integer.parseInt(id));
		
        }
        
        public static Order builtOrder(Model model){
            Order order = new Order();
            order.setAmount(1);
            order.setIdModel(model.getId());
            order.setModel(model);
            order.setPrice(model.getPrice());
            order.setProducer(model.getProducer());
            order.setIdProducer(model.getProducer().getId());
            order.setCost(model.getPrice());
            return order;
        }
        public static void insertOrder(Order order){
            daoFactory.getOrderDAO().insertOrder(order);
        } 
        
        public static void insertGuestOrder(Order order){
            daoFactory.getGuestOrderDAO().insertOrder(order);
        } 

}
