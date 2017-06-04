/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author Andrei
 */
public class SetCharFilter implements Filter {
    	private static final Logger logger = Logger.getLogger(SetCharFilter.class.getName()) ;

        public SetCharFilter() {}

    @Override
	public void destroy() {}

	/**
	 * Reset encoding of request
	 */
    @Override
	public void doFilter(ServletRequest request, ServletResponse response, 
						 FilterChain chain) {
		String encoding = request.getCharacterEncoding();
		if (!"utf8".equalsIgnoreCase(encoding))
			try {
                      
				request.setCharacterEncoding("utf8");
                                response.setCharacterEncoding("utf8");
			} catch (UnsupportedEncodingException e) {
				logger.log(Level.SEVERE,"UnsupportedEncodingException - " + e.getMessage());
			}
		try {
			chain.doFilter(request, response);
		} catch (IOException e) {
			logger.log(Level.SEVERE,"IOException - " + e.getMessage());
		} catch (ServletException e) {
			logger.log(Level.SEVERE,"ServletException - " + e.getMessage());
		}
	}

    @Override
	public void init(FilterConfig fConfig) throws ServletException {}




   
}
