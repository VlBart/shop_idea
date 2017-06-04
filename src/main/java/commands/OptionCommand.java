/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dao.entity.Model;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.ModelLogic;
import manager.ConfigurationManager;

/**
 *
 * @author Andrei
 */
public class OptionCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        String subcommand = request.getParameter("idModel");
        if (subcommand != null){
            Model model = ModelLogic.findModel(subcommand);
            request.getSession().setAttribute("model", model);
            
        }
        return ConfigurationManager.getInstance() 
				.getProperty(ConfigurationManager.OPTIONS_PAGE_PATH);
    }
    
    
}
