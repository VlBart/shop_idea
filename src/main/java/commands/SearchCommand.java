/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import manager.ConfigurationManager;
import dao.entity.Model;
import dao.entity.Producer;
import dao.entity.Type;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.DictionaryLogic;
import logic.ModelLogic;
import logic.ProducerLogic;




/**
 *
 * @author Andrei
 */
public class SearchCommand implements Command  {
        private HttpSession session = null;
    
        @Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = null;
		List<Producer> producers = ProducerLogic.getProducers();
                List<Type> types = DictionaryLogic.getType();
                session = request.getSession(true);
                session.setAttribute("types", types);
                session.setAttribute("producers", producers);
                request.getSession().removeAttribute("models");
 		if ("admin".equals(request.getParameter("subcommand")))
 			return ConfigurationManager.getInstance() 
 					.getProperty(ConfigurationManager.SEARCH_PAGE_PATH); 
		page = ConfigurationManager.getInstance() 
				.getProperty(ConfigurationManager.SEARCH_PAGE_PATH); 
		return page;
	}
    
    
}
