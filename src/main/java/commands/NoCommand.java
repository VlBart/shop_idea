/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import manager.ConfigurationManager;

/**
 *
 * This command redirects to index, main or admin page.
 * 
 * @author Andrei
 */
public class NoCommand implements Command{
    
        /**
	 * Returns index, main or admin page.
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = null;
		if ("admin".equals(request.getSession().getAttribute("userType")))
			page = ConfigurationManager.getInstance() 
					.getProperty(ConfigurationManager.MAIN_PAGE_PATH);
		else if ("custom".equals(request.getSession().getAttribute("userType")))
			page = ConfigurationManager.getInstance() 
					.getProperty(ConfigurationManager.MAIN_PAGE_PATH);
		else
			page = ConfigurationManager.getInstance() 
					.getProperty(ConfigurationManager.ERROR_PAGE_PATH); 
		return page;
	} 
}
