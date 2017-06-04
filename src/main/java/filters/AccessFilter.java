/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import dao.entity.User;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Andrei
 */
public class AccessFilter implements Filter {
    
    //private static Logger logger;
	
	//static {
	//	logger = Logger.getLogger(AccessFilter.class);
	//}

    public AccessFilter() {}

	public void destroy() {}

	/**
	 * Filters illegal access to resources. If the user tries to access secured
	 * page, his session becomes invalid and he is redirected to the index page.
	 */
	public void doFilter(ServletRequest request, ServletResponse response, 
						 FilterChain chain) {
		HttpServletRequest req = null;
		RequestDispatcher dispatcher = null;
		String regex1 = "admin/*";
		String regex2 = "WEB-INF/view/*";
		if (request instanceof HttpServletRequest){	        
	         req = (HttpServletRequest) request;
	         User user = (User) req.getSession().getAttribute("user");
	         String access = (String) req.getSession().getAttribute("access");
	         
	         if (user != null || "public".equals(access)) {
	        	 try {
	        		String URI = req.getRequestURI();
	        		if (URI.matches(regex1) || URI.matches(regex2))
	        			dispatcher = request.getRequestDispatcher("/index.jsp");
	        		request.setAttribute("access", null);
					chain.doFilter(request, response);
	        	 } catch (IOException e) {
					//logger.error("IOException - " + e.getMessage());
	        	 } catch (ServletException e) {
					//logger.error("ServletException - " + e.getMessage());
	        	 }
	         } else {
	        	 dispatcher = request.getRequestDispatcher("/index.jsp");
	        	 try {
					dispatcher.forward(request, response);
	        	 } catch (ServletException e) {
					//logger.error("ServletException - " + e.getMessage());
	        	 } catch (IOException e) {
					//logger.error("IOException - " + e.getMessage());
	        	 }
	         }
	    }
	}

	public void init(FilterConfig fConfig) throws ServletException {}

    @Override
    public boolean isLoggable(LogRecord record) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
