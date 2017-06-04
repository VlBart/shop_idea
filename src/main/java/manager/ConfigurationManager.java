/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import java.util.ResourceBundle;

/**
 *
 * @author Vlad
 */
public class ConfigurationManager {
    
    private static ConfigurationManager instance;
	private ResourceBundle resourceBundle;
	
	private static final String BUNDLE_NAME = "config";
	public static final String TOVAR_PAGE_PATH = "TOVAR_PAGE_PATH";
	public static final String ERROR_PAGE_PATH = "ERROR_PAGE_PATH";
        public static final String INDEX_PAGE_PATH = "INDEX_PAGE_PATH";
	public static final String LOGIN_PAGE_PATH = "LOGIN_PAGE_PATH";
	public static final String MAIN_PAGE_PATH = "MAIN_PAGE_PATH";
	public static final String MENU_PAGE_PATH = "MENU_PAGE_PATH";
	public static final String OPTIONS_PAGE_PATH = "OPTIONS_PAGE_PATH";
	public static final String MODEL_FORM_PAGE_PATH = "MODEL_FORM_PAGE_PATH";
	public static final String ADD_MODEL_PAGE_PATH = "ADD_MODEL_PAGE_PATH";
	public static final String PRODUCER_FORM_PAGE_PATH = "PRODUCER_FORM_PAGE_PATH";
	public static final String CHANGE_PRODUCERS_PAGE_PATH = "CHANGE_PRODUCERS_PAGE_PATH";
	public static final String CHANGE_MODELS_PAGE_PATH = "CHANGE_MODELS_PAGE_PATH";
	public static final String ADD_PRODUCER_PAGE_PATH = "ADD_PRODUCER_PAGE_PATH";
	public static final String CHANGE_TYPE_PAGE_PATH = "CHANGE_TYPE_PAGE_PATH";
	public static final String CHANGE_DIAGONAL_PAGE_PATH = "CHANGE_DIAGONAL_PAGE_PATH";
	public static final String CHANGE_REFRESH_RATE_PAGE_PATH = "CHANGE_REFRESH_RATE_PAGE_PATH";
	public static final String CHANGE_RESOLUTION_PAGE_PATH = "CHANGE_RESOLUTION_PAGE_PATH";
	public static final String CHANGE_COUNTRY_PAGE_PATH = "CHANGE_COUNTRY_PAGE_PATH";
	public static final String CHANGE_CITY_PAGE_PATH = "CHANGE_CITY_PAGE_PATH";
	public static final String ORDERS_PAGE_PATH = "ORDERS_PAGE_PATH";
	public static final String CHANGE_ORDER_PAGE_PATH = "CHANGE_ORDER_PAGE_PATH";
	public static final String SEARCH_PAGE_PATH = "SEARCH_PAGE_PATH";
	public static final String REGISTRATION_PAGE_PATH = "REGISTRATION_PAGE_PATH";
	public static final String REGISTRATION_ERROR_PAGE_PATH = "REGISTRATION_ERROR_PAGE_PATH";
	public static final String REGISTRATION_SUCCESSFULLY_PAGE_PATH = "REGISTRATION_SUCCESSFULLY_PAGE_PATH";
	public static final String AUTORISATION_ERROR_PAGE_PATH = "AUTORISATION_ERROR_PAGE_PATH";
	public static final String PASSWORD_ERROR_PAGE_PATH = "PASSWORD_ERROR_PAGE_PATH"; 
	public static final String USERS_PAGE_PATH = "USERS_PAGE_PATH";
	public static final String USER_FORM_PAGE_PATH = "USER_FORM_PAGE_PATH";
	public static final String USER_PAGE_PATH = "USER_PAGE_PATH";
        public static final String GUEST_CONTACT_PAGE_PATH = "GUEST_CONTACT_PAGE_PATH";
	
	/**
	 * 
	 * @return Ready-to-use ConfigurationManager instance
	 */
	public static ConfigurationManager getInstance() { 
	    if (instance == null) { 
	    	instance = new ConfigurationManager(); 
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
