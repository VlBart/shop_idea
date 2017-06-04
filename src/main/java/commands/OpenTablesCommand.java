/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;


import dao.entity.Country;
import dao.entity.Model;
import dao.entity.Order;
import dao.entity.Producer;
import dao.entity.Type;
import dao.entity.User;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.DictionaryLogic;
import logic.LoginLogic;
import logic.ModelLogic;
import logic.OrderLogic;
import logic.ProducerLogic;
import manager.ConfigurationManager;

/**
 *
 * @author Andrei
 */
public class OpenTablesCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        String tables = request.getParameter("tables");
        String page = null;
        if ("producers".equals(tables)){
            List<Producer> producers = ProducerLogic.getProducers();
            request.getSession().setAttribute("producers", producers);
            page = ConfigurationManager.getInstance() 
				.getProperty(ConfigurationManager.CHANGE_PRODUCERS_PAGE_PATH);
            
            
        }
        else if ("models".equals(tables)){
            List<Model> models = ModelLogic.getModels();
            request.getSession().setAttribute("models", models);
            page = ConfigurationManager.getInstance() 
				.getProperty(ConfigurationManager.CHANGE_MODELS_PAGE_PATH);
        }
        else if ("type".equals(tables)){
            List<Type> types = DictionaryLogic.getType();
            request.getSession().setAttribute("types", types);
            page = ConfigurationManager.getInstance() 
				.getProperty(ConfigurationManager.CHANGE_TYPE_PAGE_PATH);
        }
        
        else if ("country".equals(tables)){
            List<Country> countries = DictionaryLogic.getCountries();
            request.getSession().setAttribute("countries", countries);
            page = ConfigurationManager.getInstance() 
				.getProperty(ConfigurationManager.CHANGE_COUNTRY_PAGE_PATH);
            
        }
        else if ("orders".equals(tables)){
            List<Order> orders = OrderLogic.getOrder();
            request.getSession().setAttribute("orders", orders);
            page = ConfigurationManager.getInstance() 
				.getProperty(ConfigurationManager.CHANGE_ORDER_PAGE_PATH);
        }
        else if ("users".equals(tables)){
            List<User> users = LoginLogic.getUser();
            request.getSession().setAttribute("users", users);
            page = ConfigurationManager.getInstance() 
				.getProperty(ConfigurationManager.USERS_PAGE_PATH);
        }
        
        return page;
    }
    
    
}
