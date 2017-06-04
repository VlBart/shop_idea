/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dao.entity.Country;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.DictionaryLogic;
import manager.ConfigurationManager;

/**
 *
 * @author Andrei
 */
public class countryCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        
        
        if ("delete".equals(action)){
            String idCountry = request.getParameter("idCountry");
            DictionaryLogic.deleteCountry(idCountry);
            List<Country> countries = DictionaryLogic.getCountries();
            request.getSession().setAttribute("countries", countries);
        }
        else if ("add".equals(action)){
            String nameCountry = request.getParameter("nameCountry");
            Country country = new Country();
            country.setValue(nameCountry);
            DictionaryLogic.insertCountry(country);
            List<Country> countries = DictionaryLogic.getCountries();
            request.getSession().setAttribute("countries", countries);
        }
        return ConfigurationManager.getInstance() 
				.getProperty(ConfigurationManager.CHANGE_COUNTRY_PAGE_PATH);
    }
    
    
}
