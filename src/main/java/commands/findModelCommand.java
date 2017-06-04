/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dao.entity.Model;
import dao.entity.Producer;
import dao.entity.Type;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import logic.DictionaryLogic;
import logic.ModelLogic;
import logic.ProducerLogic;
import manager.ConfigurationManager;

/**
 *
 * @author Vlad
 */
public class findModelCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;	
        String subcommand = request.getParameter("subcommand");
		if ("search".equals(subcommand)) {
			Map<String, String> paramMap = new HashMap<String, String>();
			String t = request.getParameter("selectedType");
			
			paramMap.put("selectedProducer", request.getParameter("selectedProducer"));
			paramMap.put("selectedType", request.getParameter("selectedType"));
			paramMap.put("minPrice", request.getParameter("minPrice"));
			paramMap.put("maxPrice", request.getParameter("maxPrice"));
			List<Model> models = ModelLogic.searchModels("", paramMap);
			request.getSession().setAttribute("models", models);
                        request.getSession().setAttribute("paramMap", paramMap);
                        page = ConfigurationManager.getInstance() 
				.getProperty(ConfigurationManager.TOVAR_PAGE_PATH);
		}else if ("searchByName".equals(subcommand)) {

                        List<Model> models = ModelLogic.searchModelsByName(request.getParameter("name"));
			request.getSession().setAttribute("models", models);
                        page = ConfigurationManager.getInstance() 
				.getProperty(ConfigurationManager.TOVAR_PAGE_PATH);
                } 
            return page;    
    }
    
    
}
