package commands;


import dao.entity.Model;
import dao.entity.Order;
import dao.entity.Producer;
import dao.entity.User;
import logic.ModelLogic;
import logic.OrderLogic;
import logic.ProducerLogic;
import manager.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class BasketGuestCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        String page = null;
        String action = request.getParameter("action");
        if ("add".equals(action)){
            User user = (User)request.getSession().getAttribute("user");
            String idModel = (String) request.getParameter("idModel");
            Model model = ModelLogic.findModel(idModel);
            Order ord = OrderLogic.builtOrder(model);
            Producer producer = ProducerLogic.findProducer(model.getIdProducer());
            Date date = new Date();
            String dt = date.toString();
            ord.setDate(dt);
            ord.setUser(user);
            ord.setProducer(producer);
            List<Order> orders = (List<Order>)request.getSession().getAttribute("ord");
            if (orders == null || orders.isEmpty()){
                orders = new LinkedList<Order>();
            }
            boolean b = false;
            for (Order order: orders){
                if (order.getModel().getName().equals(ord.getModel().getName())){
                    order.setAmount(order.getAmount()+1);
                    order.setCost(order.getPrice()*order.getAmount());
                    b = true;
                    break;
                }
            }
            if (!b){
                orders.add(ord);
            }

            int cost = 0;
            int amount = 0;
            for (Order order: orders){
                amount = amount + order.getAmount();
                cost = cost + order.getCost();
            }
            request.getSession().setAttribute("amount", amount);
            request.getSession().setAttribute("cost", cost);
            request.getSession().setAttribute("ord", orders);
            page = ConfigurationManager.getInstance()
                    .getProperty(ConfigurationManager.TOVAR_PAGE_PATH);
        }
        else if ("delete".equals(action)){
            List<Order> orders = (List<Order>)request.getSession().getAttribute("ord");
            String model = request.getParameter("model");
            for (Order order: orders){
                if (order.getModel().getName().equals(model)){
                    if (order.getAmount() == 1)
                        orders.remove(order);
                    else {
                        order.setAmount(order.getAmount()-1);
                        order.setCost(order.getPrice()*order.getAmount());
                    }
                    break;
                }
            }
            int cost = 0;
            int amount = 0;
            for (Order order: orders){
                amount = amount + order.getAmount();
                cost = cost + order.getCost();
            }
            request.getSession().setAttribute("amount", amount);
            request.getSession().setAttribute("cost", cost);
            request.getSession().setAttribute("ord", orders);
            page = ConfigurationManager.getInstance()
                    .getProperty(ConfigurationManager.ORDERS_PAGE_PATH);

        }
        else if ("submit".equals(action)){
            List<Order> orders = (List<Order>)request.getSession().getAttribute("ord");
            for (Order order: orders)
                OrderLogic.insertOrder(order);
            request.getSession().setAttribute("amount", null);
            request.getSession().setAttribute("cost", null);
            request.getSession().setAttribute("ord", null);
            page = ConfigurationManager.getInstance()
                    .getProperty(ConfigurationManager.GUEST_CONTACT_PAGE_PATH);

        }
        return page;
    }
}
