/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import dao.entity.User;
import javax.servlet.http.HttpServletResponse;
import logic.LoginLogic;
import manager.ConfigurationManager;
import manager.MessageManager;


/**
 *  This command realizes login.
 *
 * @author Andrei
 */
public class LoginCommand implements Command {
        private static final String PARAM_NAME_USERNAME= "username"; 
	private static final String PARAM_NAME_PASSWORD = "password"; 
	private HttpSession session = null;
	   
	/**
	 * Checks username and password, and return main page. 
	 */
        @Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws MalformedURLException {
		String page = null; 
		String username = request.getParameter(PARAM_NAME_USERNAME); 
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		
		User user = null;
		try {
			user = LoginLogic.checkLogin(username, pass);
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		}
		if (user != null) { 
			session = request.getSession(true);
			session.setAttribute("user", user);
                        page = ConfigurationManager.getInstance() 
						.getProperty(ConfigurationManager.INDEX_PAGE_PATH);
	     } else { 
	    	request.setAttribute("errorMessage", MessageManager.getInstance() 
	    				.getProperty(MessageManager.LOGIN_ERROR_MESSAGE)); 
	    	page = ConfigurationManager.getInstance() 
	    			.getProperty(ConfigurationManager.AUTORISATION_ERROR_PAGE_PATH); 
	    } 
	    return page; 
    }
}
