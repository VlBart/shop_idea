/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import dao.entity.Model;
import java.util.LinkedList;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.ModelLogic;
import manager.ConfigurationManager;

/**
 *
 * @author Andrei
 */
public class InitCommand implements Command {
    
    private HttpSession session = null;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){

        List<Model> models = new LinkedList<Model>();
        models = ModelLogic.getModels(); 
        session = request.getSession(true);
	session.setAttribute("models", models);
        Map<String, String> paramMap = (Map<String, String>) request.getSession().getAttribute("paramMap");
        if (paramMap != null)
            request.getSession().removeAttribute("paramMap");
        return ConfigurationManager.getInstance() 
	    			.getProperty(ConfigurationManager.TOVAR_PAGE_PATH);
    }
    
    
}
