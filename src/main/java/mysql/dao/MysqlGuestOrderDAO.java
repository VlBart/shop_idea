/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql.dao;

import dao.entity.Model;
import dao.entity.Order;
import dao.entity.Producer;
import dao.interfaces.OrderDAO;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MysqlGuestOrderDAO extends MysqlDAO implements OrderDAO {

    private final String SQL_INSERT =
            "INSERT " +
                    "INTO guestorders (amount,price,id_model,data,id_producer) " +
                    "VALUES (?, ?, ?, ?, ?)";
    private final String SQL_DELETE =
            "DELETE FROM guestorders WHERE id=?";
    private final String SQL_FIND =
            "SELECT * FROM guestorders WHERE id=?";
    private final String SQL_UPDATE =
            "UPDATE orders " +
                    "SET amount=?, price=?,id_model=?, data=?, id_producer=?" +
                    "WHERE id=?";
    private final String SQL_SELECT_ALL =
            "SELECT orders.id,orders.amount,orders.price,orders.data,models.model,producers.name " +
                    "FROM models,users,orders,producers " +
                    "WHERE  orders.id_model = models.id and orders.id_producer=producers.id";


    Logger logger = Logger.getLogger(MysqlGuestOrderDAO.class.getName());


    @Override
    public int insertOrder(Order order) {
        int pkey = 0;
        try {
            statement = conn.prepareStatement(SQL_INSERT, 1);
            statement.setInt(1, order.getAmount());
            statement.setInt(2, order.getPrice());
            statement.setInt(3, order.getIdModel());
            statement.setString(4, order.getDate());
            statement.setInt(5, order.getIdProducer());
            statement.executeUpdate();
            rs = statement.getGeneratedKeys();
            while (rs.next()) {
                pkey = rs.getInt(1);
            }
            order.setId(pkey);
            //logger.info("New company has been added: " + company);
            close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "SQLException - " + e.getMessage());
        }
        return pkey;
    }

    @Override
    public boolean deleteOrder(int id) {
        boolean result = false;
        try {
            statement = conn.prepareStatement(SQL_DELETE);
            statement.setInt(1, id);
            result = statement.execute();
            close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "SQLException - " + e.getMessage());
        }
        return result;
    }

    @Override
    public Order findOrder(int id) {
        Order order = null;
        try {
            statement = conn.prepareStatement(SQL_FIND);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                order = new Order();
                order.setId(rs.getInt(1));
                order.setAmount(rs.getInt(2));
                order.setPrice(rs.getInt(3));
                order.setIdModel(rs.getInt(4));
                order.setDate(rs.getString(5));

            }
            close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "SQLException - " + e.getMessage());
        }
        return order;
    }

    @Override
    public int updateOrder(Order order) {
        int num = 0;
        try {
            statement = conn.prepareStatement(SQL_UPDATE);
            statement.setInt(1, order.getAmount());
            statement.setInt(2, order.getPrice());
            statement.setInt(3, order.getIdModel());
            statement.setString(4, order.getDate());
            statement.setInt(5, order.getId());
            num = statement.executeUpdate();
            //logger.info(num + " company(es) has been updated");
            close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "SQLException - " + e.getMessage());
        }
        return num;
    }

    @Override
    public List<Order> selectOrder() {
        List<Order> result = new LinkedList<Order>();
        int count = 0;
        try {
            statement = conn.prepareStatement(SQL_SELECT_ALL);
            rs = statement.executeQuery();
            while (rs.next()) {
                Order resultOrder = new Order();
                resultOrder.setId(rs.getInt(1));
                resultOrder.setAmount(rs.getInt(2));
                resultOrder.setPrice(rs.getInt(3));
                resultOrder.setDate(rs.getString(4));

                Model resultModel = new Model();
                resultModel.setName(rs.getString(5));

                Producer resultProducer = new Producer();
                resultProducer.setName(rs.getString(6));

                resultOrder.setModel(resultModel);
                resultOrder.setProducer(resultProducer);


                result.add(resultOrder);
                count++;
            }
            //logger.info(count + " company(es) has been selected");
            close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "SQLException - " + e.getMessage());
        }
        return result;
    }


}
