/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import manager.ConfigurationManager;

/**
 *
 * @author Andrei
 */
public class LogoutCommand implements Command {
    
        @Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.setAttribute("user", null);
                session.setAttribute("ord", null);
                session.setAttribute("cost", null);
                session.setAttribute("amount", null);
		//session.setAttribute("userType", null);

		String page = ConfigurationManager.getInstance().getProperty(
				ConfigurationManager.INDEX_PAGE_PATH); 
		return page;
	}
    
}
