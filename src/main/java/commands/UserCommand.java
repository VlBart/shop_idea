/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dao.entity.User;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.LoginLogic;
import manager.ConfigurationManager;

/**
 *
 * @author Andrei
 */
public class UserCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        String action = request.getParameter("action"); 
        String idUser = request.getParameter("idUser");
        //String subcommand = request.getParameter("subcommand");
        //String cmd = request.getParameter("cmd");
        if ("delete".equals(action)){
            LoginLogic.deleteUser(Integer.parseInt(idUser));
            List<User> users = LoginLogic.getUser();
            request.getSession().setAttribute("users", users);
            return page = ConfigurationManager.getInstance() 
				.getProperty(ConfigurationManager.USERS_PAGE_PATH);
        }
        return page;
    }
    
}
