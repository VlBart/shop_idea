/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;


import dao.entity.Country;
import dao.entity.Producer;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.DictionaryLogic;
import logic.ProducerLogic;
import manager.ConfigurationManager;

/**
 *
 * @author Andrei
 */
public class ProducerCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
         String page = null;
        String action = request.getParameter("action"); 
        String idProducer = request.getParameter("idProducer");
        String subcommand = request.getParameter("subcommand");
        String cmd = request.getParameter("cmd");
        if ("delete".equals(action)){
            ProducerLogic.deleteProducer(idProducer);
            List<Producer> producers = ProducerLogic.getProducers();
            request.getSession().setAttribute("producers", producers);
            return page = ConfigurationManager.getInstance() 
				.getProperty(ConfigurationManager.CHANGE_PRODUCERS_PAGE_PATH);
            
        }else if ("change".equals(action)){
            List<Country> countries = DictionaryLogic.getCountries();
            //List<City> cities = DictionaryLogic.getCities();
            request.setAttribute("countries", countries);
            //request.setAttribute("cities", cities);
            Producer producer = ProducerLogic.findProducer(Integer.parseInt(idProducer));
            request.setAttribute("producer", producer);
            
            
                
            return page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.PRODUCER_FORM_PAGE_PATH);
            
        }else if ("add".equals(action)){
           List<Country> countries = DictionaryLogic.getCountries();
            //List<City> cities = DictionaryLogic.getCities();
            request.setAttribute("countries", countries);
            //request.setAttribute("cities", cities);
            //Producer producer = ProducerLogic.findProducer(Integer.parseInt(idProducer));
            //request.setAttribute("producer", producer);
            return page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ADD_PRODUCER_PAGE_PATH);
        }
        if ("submit".equals(subcommand)){
                    String idCountry = request.getParameter("idCountry");
                    String address = request.getParameter("address");
                    String name = request.getParameter("name");
                    String email = request.getParameter("email");
                    String phone = request.getParameter("phone");
                    Producer resultProducer = new Producer();
                    if (idProducer!=null)
                        resultProducer.setId(Integer.parseInt(idProducer));
                    resultProducer.setAddress(address);
                    resultProducer.setIdCountry(Integer.parseInt(idCountry));
                    resultProducer.setName(name);
                    resultProducer.setPhone(phone);
                    resultProducer.setEmail(email);
                    if ("update".equals(cmd))
                         ProducerLogic.updateProducer(resultProducer);
                    else if ("insert".equals(cmd))
                         ProducerLogic.insertProducer(resultProducer);
                    List<Producer> producers = ProducerLogic.getProducers();
                    request.getSession().setAttribute("producers", producers);
                    return page = ConfigurationManager.getInstance() 
                                        .getProperty(ConfigurationManager.CHANGE_PRODUCERS_PAGE_PATH);
                    
                    
                    
                    
                }

   
        return page;
    }
    
}
