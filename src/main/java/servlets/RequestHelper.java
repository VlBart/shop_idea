/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import commands.*;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;




/**
 *
 * @author Vlad
 */
public class RequestHelper {
   private static RequestHelper instance = null;
	HashMap<String, Command> commands = new HashMap<String, Command>();
	
	private RequestHelper() {
		commands.put("login", new LoginCommand());
                commands.put("Init", new InitCommand());
                commands.put("Search", new SearchCommand());
                commands.put("SearchByName", new SearchByNameCommand());
                commands.put("findModel", new findModelCommand());
                commands.put("logout", new LogoutCommand());
                commands.put("Open", new OpenTablesCommand());
                commands.put("Options", new OptionCommand());
                commands.put("Models", new ModelsCommand());
                commands.put("Image", new ImageCommand());
                commands.put("Producers", new ProducerCommand());
                commands.put("Type", new TypeCommand());
                commands.put("Country", new countryCommand());
                commands.put("Sort", new sortCommand());
                commands.put("Basket", new BasketCommand());
				commands.put("BasketGuest", new BasketGuestCommand());
                commands.put("Orders", new OrderCommand());
                commands.put("Registration", new RegistrationCommand());
                commands.put("User", new UserCommand());
                commands.put("ChangeUser", new ChangeUserCommand());

	}
	
	/**
	 * Parses given request and finds "command" parameter in it. Than finds
	 * corresponding {@link Command} implementor and returns it.
	 * 
	 * @param request
	 *            request to parse.
	 * @return corresponding for this purposes {@link Command} implementor.
	 */
	public Command getCommand(HttpServletRequest request) { 
		 String action = request.getServletPath();
		 action = request.getParameter("command");
		 Command command = commands.get(action); 
		 if (command == null) { 
			 command = new NoCommand(); 
		 } 
		 return command; 
	}
	 
	/**
	 * Returns RequestHelper instance.
	 * 
	 * @return Ready-to-use RequestHelper
	 */
	public static RequestHelper getInstance() {
		if (instance == null) {
			 instance = new RequestHelper();
		 }
		 return instance;
	 } 
    
    
}
