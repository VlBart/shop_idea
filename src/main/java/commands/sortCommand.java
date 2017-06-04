/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dao.entity.Model;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.ModelLogic;
import manager.ConfigurationManager;

/**
 *
 * @author Andrei
 */
public class sortCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        String attribute = request.getParameter("attribute");
        //Map<String, String> paramMap = new HashMap<String, String>();
        Map<String, String> paramMap = (HashMap<String, String>) request.getSession().getAttribute("paramMap");
        if (paramMap != null){
            List<Model> models = ModelLogic.searchModels(attribute, paramMap);
            request.getSession().setAttribute("models", models);
            page = ConfigurationManager.getInstance() 
                             .getProperty(ConfigurationManager.TOVAR_PAGE_PATH);
        }
        else{
                        Map<String, String> param = new HashMap<String, String>();
                        param.put("selectedProducer", "");
			param.put("selectedType", "");
			param.put("minPrice", "");
			param.put("maxPrice", "");
                        List<Model> models = ModelLogic.searchModels(attribute, param);
                        request.getSession().setAttribute("models", models);
                        page = ConfigurationManager.getInstance() 
                                         .getProperty(ConfigurationManager.TOVAR_PAGE_PATH);
        }

        return page;
    }
    
}
