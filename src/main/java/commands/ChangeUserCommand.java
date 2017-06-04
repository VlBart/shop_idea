/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dao.entity.Country;
import dao.entity.User;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.DictionaryLogic;
import logic.LoginLogic;
import manager.ConfigurationManager;

/**
 *
 * @author Andrei
 */
public class ChangeUserCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        String page = null;
        String action = request.getParameter("action"); 
        String idUser = request.getParameter("idUser");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("open".equals(action)){
            List<Country> countries = DictionaryLogic.getCountries();
            request.getSession().setAttribute("countries", countries);
            page = ConfigurationManager.getInstance() 
				.getProperty(ConfigurationManager.USER_FORM_PAGE_PATH);
        }
        else if ("update".equals(action)){
            String fullName = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String idCountry = request.getParameter("idCountry");
            String address = request.getParameter("address");
            User user = new User();
            user.setAddress(address);
            user.setIdCountry(Integer.parseInt(idCountry));
            user.setFullName(fullName);
            user.setEmail(email);
            user.setPhone(phone);
            user.setId(Integer.parseInt(idUser));
            LoginLogic.updateUser(user);
            User resultUser = null;
            try {
                resultUser = LoginLogic.checkLogin(username, password);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(ChangeUserCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getSession().setAttribute("user", resultUser);
            page = ConfigurationManager.getInstance() 
				.getProperty(ConfigurationManager.USER_PAGE_PATH);
        }
        
        
        return page;
    }
    
}
