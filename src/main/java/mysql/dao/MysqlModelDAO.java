/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql.dao;

import java.sql.SQLException;
import java.util.LinkedList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import dao.entity.Model;
import dao.entity.Producer;
import dao.entity.Type;
import dao.interfaces.ModelDAO;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Andrei
 */
public class MysqlModelDAO extends MysqlDAO implements ModelDAO {
    
    private final String SQL_INSERT = 
			"INSERT " +
			"INTO models (id_type,price,name,amount,"
                        +"image_url,id_producer,age_for) " +
			"VALUES (?, ?, ?, ?, ?, ?, ?)";		
	private final String SQL_DELETE =
			"DELETE FROM models WHERE id=?";	
	private final String SQL_FIND = 
			"SELECT * FROM models WHERE id=?";	
	private final String SQL_UPDATE = 
			"UPDATE models " +
			"SET id_type = ?,price = ?,name = ?,amount = ?,image_url = ?,id_producer = ?,age_for = ? " +
			"WHERE id=?";
        private final String UPDATE_IMG = 
                        "UPDATE models SET image_url=? WHERE id=?";
	private final String SQL_SELECT_ALL = 
			"SELECT models.id,models.price,models.name,models.amount,models.image_url,models.age_for,producers.name,"
                        + "type.value FROM models,type,producers " +
			"WHERE models.id_type = type.id and " +
                         "models.id_producer = producers.id";
        private final String SQL_SELECT_LINK = 
			"SELECT * " + 
                        "FROM models,type,producers " +
			"WHERE models.id_type = type.id and " +
                              "models.id_producer = producers.id";
	private final String SORT_BY_PRICE = " ORDER BY models.price";
	private final String SORT_BY_PRODUCER = " ORDER BY producers.name";	
	private final String MIN_PRICE = "models.price >= ? AND ";
	private final String MAX_PRICE = "models.price <= ? AND ";
	private final String LIKE_PRODUCER = "producers.name LIKE ? AND ";
        private final String LIKE_TYPE = "type.value LIKE ?  ";

	
        Logger logger = Logger.getLogger(MysqlModelDAO.class.getName());


	@Override
	public int insertModel(Model model) {
		int pkey = 0;
		try {
			statement = conn.prepareStatement(SQL_INSERT, 1);
                        statement.setInt(1, model.getIdType());
                        statement.setInt(2, model.getPrice());
                        statement.setString(3, model.getName());
                        statement.setInt(4, model.getAmount());
                        statement.setString(5, model.getImageURL());
                        statement.setInt(6, model.getIdProducer());
                        statement.setInt(7, model.getAge_for());
                        
			statement.executeUpdate();
			rs = statement.getGeneratedKeys();
			while (rs.next()) {
				pkey = rs.getInt(1);
			}		
			model.setId(pkey);
			//logger.info("New company has been added: " + company);
			close();
		} catch (Exception e) {
			logger.log(Level.SEVERE,"SQLException - " + e.getMessage());
		}		
		return pkey;
	}

	@Override
	public boolean deleteModel(int id) {
		boolean result = false;
		try {
			statement = conn.prepareStatement(SQL_DELETE);
			statement.setInt(1, id);
			result = statement.execute();
			close();
		} catch (SQLException e) {
			//logger.error("SQLException - " + e.getMessage());
		}
		return result;
	}

	@Override
	public Model findModel(int id) {
		Model model = null;
		try {
			statement = conn.prepareStatement(SQL_FIND);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			while (rs.next()) {
				model = new Model();
								model.setId(rs.getInt(1));
                                model.setIdType(rs.getInt(2));
                                model.setPrice(rs.getInt(3));
                                model.setName(rs.getString(4));
                                model.setAmount(rs.getInt(5));
                                model.setImageURL(rs.getString(6));
                                model.setIdProducer(rs.getInt(7));
                                model.setAge_for(rs.getInt(8));
                                
                                
			}
			close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE,"SQLExceptione - " + e.getMessage());
		}
		return model;
	}

	@Override
	public int updateModel(Model model) {
		int num = 0;
		try {
			statement = conn.prepareStatement(SQL_UPDATE);
                        statement.setInt(1, model.getIdType());
                        statement.setInt(2, model.getPrice());
                        statement.setString(3, model.getName());
                        statement.setInt(4, model.getAmount());
                        statement.setString(5, model.getImageURL());
                        statement.setInt(6, model.getIdProducer());
                        statement.setInt(7, model.getAge_for());
						statement.setInt(8, model.getId());
			num = statement.executeUpdate();
			//logger.info(num + " company(es) has been updated");
			close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE,"SQLException - " + e.getMessage());
		}
		return num;
	}
        @Override
        public int updateImage(int id,String url){
           int num = 0;
		try {
			statement = conn.prepareStatement(UPDATE_IMG);
                        statement.setString(1, url);
                        statement.setInt(2, id);
			num = statement.executeUpdate();
			//logger.info(num + " company(es) has been updated");
			close();
		} catch (SQLException e) {
			//logger.error("SQLException - " + e.getMessage());
		}
		return num; 
        }

	@Override
	public List<Model> selectModel() {
		List<Model> result = new LinkedList<Model>();
		int count = 0;
		try {
			statement = conn.prepareStatement(SQL_SELECT_ALL);
			rs = statement.executeQuery();
			while (rs.next()) {
				Model resultModel = new Model();
                                
                                Producer resultProducer = new Producer();
				resultProducer.setName(rs.getString(7));
                                
                                Type resultType = new Type();
                                resultType.setValue(rs.getString(8));
                                
				resultModel.setType(resultType);
                                resultModel.setId(rs.getInt(1));
                                resultModel.setPrice(rs.getInt(2));
                                resultModel.setName(rs.getString(3));
                                resultModel.setAmount(rs.getInt(4));
                                resultModel.setImageURL(rs.getString(5));
                                resultModel.setProducer(resultProducer);
                                resultModel.setAge_for(rs.getInt(6));
                      
                                
				result.add(resultModel);
				count++;
			}
			logger.info(count + " company(es) has been selected");
			close();
		} catch (Exception e) {
			logger.log(Level.SEVERE,"SQLException - " + e.getMessage());
		}		
		return result;
	}
    
        
        	private List<Model> buildModel(ResultSet rs) {
		List<Model> result = new ArrayList<Model>();
		int count = 0;
		try {
			while (rs.next()) {
				Model resultModel = new Model();
                                resultModel.setId(rs.getInt(1));
                                resultModel.setIdType(rs.getInt(2));
                                resultModel.setPrice(rs.getInt(3));
                                resultModel.setName(rs.getString(4));
                                resultModel.setAmount(rs.getInt(5));
                                resultModel.setImageURL(rs.getString(6));
                                resultModel.setIdProducer(rs.getInt(7));
                                resultModel.setAge_for(rs.getInt(8));
				
				result.add(resultModel);
				count++;
			}
			//logger.info(count + " vacancy(es) has been selected");
		} catch (SQLException e) {
			//logger.error("SQLException - " + e.getMessage());
		}
		return result;
	}
                
        @Override
	public List<Model> selectModel(String sortingBy, 
                                                Map<String, String> paramMap) {
		List<Model> result = new ArrayList<Model>();
		String sqlSearch = SQL_SELECT_LINK;
		sqlSearch += " AND " +
				MIN_PRICE + MAX_PRICE + LIKE_PRODUCER + LIKE_TYPE ;
		if ("producer".equals(sortingBy)) 
			sqlSearch += SORT_BY_PRODUCER;
		if ("price".equals(sortingBy)) 
			sqlSearch += SORT_BY_PRICE;	
		try {
			statement = conn.prepareStatement(sqlSearch);			
			if (!"".equals(paramMap.get("minPrice")) && null!=paramMap.get("minPrice"))
				statement.setInt(1, Integer.parseInt(paramMap.get("minPrice")));
			else
				statement.setInt(1, 0);
			if (!"".equals(paramMap.get("maxPrice"))&& null!=paramMap.get("maxPrice"))
				statement.setInt(2, Integer.parseInt(paramMap.get("maxPrice")));
			else
				statement.setInt(2, 9999999);
			//if (!"".equals(paramMap.get("selectedModel")))
				//statement.setString(5, paramMap.get("selectedModel"));
			//else
			//statement.setString(5, "%");
			if (!"".equals(paramMap.get("selectedProducer"))&& null!=paramMap.get("selectedProducer"))
				statement.setString(3, paramMap.get("selectedProducer"));
			else
				statement.setString(3, "%");
                        if (!"".equals(paramMap.get("selectedType"))&& null!=paramMap.get("selectedType"))
				statement.setString(4, paramMap.get("selectedType"));
			else
				statement.setString(4, "%");
			rs = statement.executeQuery();
			result = buildModel(rs);
			close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE,"SQLException - " + e.getMessage());
		}		
		return result;
	} 
        
        @Override
	public List<Model> findByName(String name) {
		List<Model> result = new ArrayList<Model>();
		String sqlSearch = SQL_SELECT_LINK;
		sqlSearch += " AND  models.name like '%" + name + "%'";
        try {
            statement = conn.prepareStatement(sqlSearch);
            rs = statement.executeQuery();
            result = buildModel(rs);
            close();
        } catch (SQLException ex) {
            Logger.getLogger(MysqlModelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
				
		return result;
	}
                
	
}
