/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import java.util.List;
import java.util.Map;

import dao.entity.Model;

/**
 *
 * @author Andrei
 */

public interface ModelDAO {
    /**
	 * Inserts model in database.
	 * 
	 * @param model
	 * @return
	 */
	public int insertModel(Model model);
	
	/**
	 * Deletes model from database by id.
	 * 
	 * @param id
	 * @return
	 *          "true" if model has been deleted successful or "false" otherwise
	 */
	public boolean deleteModel(int id);
	
	/**
	 * Finds model in database by id.
	 * 
	 * @param id
	 * @return model
	 */
	public Model findModel(int id);
	
	/**
	 * Updates model in database.
	 * 
	 * @param model
	 * @return
	 */
	public int updateModel(Model model);
	
	/**
	 * 
	 * @param model
	 * @return model from database
	 */
	public List<Model> selectModel();
        /**
	 * Selects vacancies by searchParamMap and sorts by sortingBy.
	 * 
	 * @param sortingBy
	 * @param searchParamMap
	 * @return list fo vacancies
	 */
	public List<Model> selectModel(String sortingBy, 
					Map<String, String> searchParamMap);
        public List<Model> findByName(String name);
        
        public int updateImage(int id,String url);
    
}
