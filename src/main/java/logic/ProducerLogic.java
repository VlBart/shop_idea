/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;

import dao.factory.DAOFactory;
import dao.factory.MysqlDAOFactory;
import dao.entity.Producer;

/**
 *
 * @author Andrei
 */
public class ProducerLogic {
    
    private static DAOFactory daoFactory = 
		MysqlDAOFactory.getDAOFactory(MysqlDAOFactory.MYSQL);
	

	public static List<Producer> getProducers() {
		List <Producer> producers = daoFactory.getProducerDAO().selectProducer();
		return producers;
	}
	


	public static void insertProducer(Producer producer) {
		daoFactory.getProducerDAO().insertProducer(producer);
	}
	

	public static void deleteProducer(String id) {
		daoFactory.getProducerDAO().deleteProducer(Integer.parseInt(id));
	}
	

	
	public static Producer findProducer(int producerId) {
		Producer producer = daoFactory.getProducerDAO().findProducer(producerId);
                producer.setCountry(DictionaryLogic.findCountry(producer.getIdCountry()));
		return producer;
	}
        public static void updateProducer(Producer producer){
            daoFactory.getProducerDAO().updateProducer(producer);
        }
    
}
