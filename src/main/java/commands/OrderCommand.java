/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dao.entity.Order;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.OrderLogic;
import manager.ConfigurationManager;

/**
 *
 * @author Andrei
 */
public class OrderCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String action = request.getParameter("action"); 
        String idOrder = request.getParameter("idOrder");
        if ("delete".equals(action)){
            OrderLogic.deleteOrder(idOrder);
            List<Order> orders = OrderLogic.getOrder();
            request.getSession().setAttribute("orders", orders);
        }
            return ConfigurationManager.getInstance() 
				.getProperty(ConfigurationManager.CHANGE_ORDER_PAGE_PATH);
            
        
    }
}
