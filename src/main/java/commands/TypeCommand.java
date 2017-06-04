/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dao.entity.Type;
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
public class TypeCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        
        
        if ("delete".equals(action)){
            String idType = request.getParameter("idType");
            DictionaryLogic.deleteType(idType);
            List<Type> types = DictionaryLogic.getType();
            request.getSession().setAttribute("types", types);
        }
        else if ("add".equals(action)){
            String nameType = request.getParameter("nameType");
            Type type = new Type();
            type.setValue(nameType);
            DictionaryLogic.insertType(type);
            List<Type> types = DictionaryLogic.getType();
            request.getSession().setAttribute("types", types);
        }
        return ConfigurationManager.getInstance() 
				.getProperty(ConfigurationManager.CHANGE_TYPE_PAGE_PATH);
    }
    
}
