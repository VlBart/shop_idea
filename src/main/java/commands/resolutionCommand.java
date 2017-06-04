/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

/*import dao.entity.Resolution;
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
/*public class resolutionCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        
        
        if ("delete".equals(action)){
            String idResolution = request.getParameter("idResolution");
            DictionaryLogic.deleteResolution(idResolution);
            List<Resolution> resolutions = DictionaryLogic.getResolution();
            request.getSession().setAttribute("resolutions", resolutions);
        }
        else if ("add".equals(action)){
            String nameResolution = request.getParameter("nameResolution");
            Resolution resolution = new Resolution();
            resolution.setValue(nameResolution);
            DictionaryLogic.insertResolution(resolution);
            List<Resolution> resolutions = DictionaryLogic.getResolution();
            request.getSession().setAttribute("resolutions", resolutions);
        }
        return ConfigurationManager.getInstance() 
				.getProperty(ConfigurationManager.CHANGE_RESOLUTION_PAGE_PATH);
    }
    
}*/
