/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

import dao.factory.DAOFactory;
import dao.factory.MysqlDAOFactory;
import dao.entity.Model;

/**
 *
 * @author Andrei
 */
public class ModelLogic {
    
    	private static DAOFactory daoFactory = 
		MysqlDAOFactory.getDAOFactory(MysqlDAOFactory.MYSQL);
	

	public static List<Model> getModels() {
		List <Model> models = daoFactory.getModelDAO().selectModel();
		return models;
	}
	

	public static List<Model> getModels(String sortingBy) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("minPrice", "");		
		paramMap.put("maxPrice", "");
		paramMap.put("minDiag", "");
		paramMap.put("maxDiag", "");
		paramMap.put("selectedModel", "");
		paramMap.put("selectedProducer", "");
                paramMap.put("selectedResolution","");
                paramMap.put("selectedRefreshRate", "");
                paramMap.put("selectsdType", "");
                paramMap.put("threeD", "");
		paramMap.put("webTv", "");
		
		List <Model> models = 
				daoFactory.getModelDAO().selectModel(sortingBy, paramMap);
		for (Model model : models) {
                        model.setType(DictionaryLogic.findType(model.getIdType()));
                        model.setProducer(ProducerLogic.findProducer(model.getIdProducer()));
                        

		}
		return models;
	}
	

	public static void insertModel(Model model) {
		daoFactory.getModelDAO().insertModel(model);
	}
	

	public static void deleteModel(String id) {
		daoFactory.getModelDAO().deleteModel(Integer.parseInt(id));
	}
	

	public static List<Model> searchModels(String selectedCategory, Map<String, String> paramMap) {
		List<Model> models = 
				daoFactory.getModelDAO().selectModel(selectedCategory, paramMap);
		for (Model model : models) {
                        model.setType(DictionaryLogic.findType(model.getIdType()));
                        model.setProducer(ProducerLogic.findProducer(model.getIdProducer()));
		}
		return models;
	}
        
        public static List<Model> searchModelsByName(String name) {
		List<Model> models = 
				daoFactory.getModelDAO().findByName(name);
		for (Model model : models) {
                        model.setType(DictionaryLogic.findType(model.getIdType()));
                        model.setProducer(ProducerLogic.findProducer(model.getIdProducer()));
		}
		return models;
	}
        
        
	

	public static Model findModel(String modelId) {
		Model model = daoFactory.getModelDAO().findModel(Integer.parseInt(modelId));
                model.setType(DictionaryLogic.findType(model.getIdType()));
                model.setProducer(ProducerLogic.findProducer(model.getIdProducer()));
		return model;
	}
        
      public static void updateModel(Model model){
          daoFactory.getModelDAO().updateModel(model);
      } 
      
      public static void updateImage(int id, String url){
          daoFactory.getModelDAO().updateImage(id,url);
      }
    
}
