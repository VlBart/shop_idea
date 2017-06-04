/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;


import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.util.logging.Level;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import commands.Command;
import java.util.logging.Logger;
import manager.ConfigurationManager;
import manager.MessageManager;

/**
 *
 * @author Vlad
 */

@WebServlet(name = "ActionServlet", urlPatterns = {"/ActionServlet"})
//@MultipartConfig
public class ActionServlet extends HttpServlet {
        
        private static final Logger log = Logger.getLogger(ActionServlet.class.getName());
  	private static final long serialVersionUID = 1L;
	private MessageManager msgManager = MessageManager.getInstance();
	private ConfigurationManager cfgManager = ConfigurationManager.getInstance();

	
    public ActionServlet() throws MalformedURLException {
        super();
    } 
    @Override
    public void init() throws ServletException {
		super.init();
                
    }
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
               String page = null;
		try {
			Command command = RequestHelper.getInstance().getCommand(request);
			page = command.execute(request,response);
                        
		} catch (Exception e) {
			log.log(Level.INFO, "{0} - {1}", new Object[]{e.getClass(), e.getStackTrace()});
			request.setAttribute("errorMessage", e.getClass() + " - " + e.getMessage());
			page = cfgManager.getProperty(ConfigurationManager.ERROR_PAGE_PATH);
		} 
                finally {		 
			dispatch(request, response, page);
                    
		}
        } finally {            
            out.close();
        }
    }
        
        protected void dispatch(HttpServletRequest request, HttpServletResponse response, String page) {
		RequestDispatcher dispatcher = 	
				getServletContext().getRequestDispatcher(page);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			request.setAttribute("errorMessage", msgManager.getProperty( 
					MessageManager.SERVLET_EXCEPTION_ERROR_MESSAGE)); 
			page = cfgManager.getProperty(ConfigurationManager.ERROR_PAGE_PATH);
		} 
                catch (IOException e) {
			request.setAttribute("errorMessage", msgManager.getProperty(
					MessageManager.IO_EXCEPTION_ERROR_MESSAGE));
			page = cfgManager.getProperty(ConfigurationManager.ERROR_PAGE_PATH);
		}
	}
        
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "ActionServlet";
    }
    

}
