/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dao.entity.Country;
import dao.entity.User;
import dao.factory.DAOFactory;
import dao.factory.MysqlDAOFactory;
import dao.interfaces.UserDAO;
import java.io.IOException;
import java.util.List;
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
public class RegistrationCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        String action = request.getParameter("action");
        if ("open".equals(action)){
            List<Country> countries = DictionaryLogic.getCountries();
            request.getSession().setAttribute("countries", countries);
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.REGISTRATION_PAGE_PATH);
        }
        else if("add".equals(action)){
            String fullName = request.getParameter("fullName");
            String username = request.getParameter("username");
            String password1 = request.getParameter("password1");
            String password2 = request.getParameter("password2");
            
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String idCountry = request.getParameter("idCountry");
            String address = request.getParameter("address");
            User user = new User();
            if ("".equals(fullName) || "".equals(username) || "".equals(password1) || "".equals(password2) || "".equals(email) || "".equals(address))
                return ConfigurationManager.getInstance().getProperty(ConfigurationManager.ERROR_PAGE_PATH);
            user.setAddress(address);
            user.setEmail(email);
            user.setFullName(fullName);
            user.setIdCountry(Integer.parseInt(idCountry));
            user.setPhone(phone);
            if (password1.equals(password2))
                user.setPassword(password1);
            else
                return ConfigurationManager.getInstance().getProperty(ConfigurationManager.PASSWORD_ERROR_PAGE_PATH);
            user.setUserName(username);
            user.setIsAdmin(Short.parseShort("1"));
            User foundUser = LoginLogic.foundUser(username);
            if (foundUser.getUserName() != null)
                return ConfigurationManager.getInstance().getProperty(ConfigurationManager.REGISTRATION_ERROR_PAGE_PATH);
            LoginLogic.insertUser(user);
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.REGISTRATION_SUCCESSFULLY_PAGE_PATH);
                
        }
        return page;
    }
    
}
