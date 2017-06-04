/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import java.net.MalformedURLException;
import java.util.ResourceBundle;

/**
 *Contains String key to messages.
 * 
 * @author Andrei
 */
public class MessageManager {
    private static MessageManager instance; 
	private ResourceBundle resourceBundle; 
	
	private static final String BUNDLE_NAME = 
			"sysmessages";
  	public static final String LOGIN_ERROR_MESSAGE = "LOGIN_ERROR_MESSAGE"; 	
  	public static final String SERVLET_EXCEPTION_ERROR_MESSAGE =  
  			"SERVLET_EXCEPTION_ERROR_MESSAGE"; 
  	public static final String IO_EXCEPTION_ERROR_MESSAGE 
  			= "IO_EXCEPTION_ERROR_MESSAGE"; 
   
  	public static MessageManager getInstance() throws MalformedURLException {
  		if (instance == null) { 
  			instance = new MessageManager();

			instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
    } 
    return instance; 
  } 
	  
	/**
	 * 
	 * @param key
	 * @return String path by String key
	 */	
	public String getProperty(String key) { 
		return (String) resourceBundle.getObject(key); 
	} 
    
}
