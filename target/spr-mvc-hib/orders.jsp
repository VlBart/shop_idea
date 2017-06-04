<%-- 
    Document   : orders
    Created on : 20.05.2012, 3:43:40
    Author     : Andrei
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>orders</title>
    </head>
    <body>
       <div id="main">
            <%@ include file="/header.jsp" %>
            
                    
            
       <hr class="noscreen" />

            <div id="skip-menu"></div>

                    <div id="content">

                            <!-- Content box with white background and gray border -->
                            <div id="content-box">

                                    <!-- Left column -->
                                    <div id="content-box-in-left">
                                            <div id="content-box-in-left-in">
                                               
                                                <h3>Корзина заказов</h3>
                                                <div id="orders">
                                                 <c:choose>
                                                     <c:when test="${!empty ord}">


                                                        <table>
                                                            <c:forEach var="order" items="${ord}">
                                                                <tr>
                                                                <td>${order.producer.email}&nbsp;${order.model.name}</td><td>${order.amount}&nbsp;шт.</td><td>${order.cost}&nbsp;бел.руб</td>
                                                                <td><a href="ActionServlet?command=Basket&action=delete&model=${order.model.name}">Удалить</a></td>
                                                                </tr>
                                                            </c:forEach>
                                                                <tr><td></td><td>Общая стоимость:</td><td>${cost}&nbsp;бел.руб.</td></tr>
                                                                
                                                                <tr>
                                                               
                                                                <th colspan="4"> 
                                                                <hr/>
                                                                <br><a href="ActionServlet?command=Basket&action=submit">ЗАКАЗАТЬ</a></th>
                                                                </tr>
                                                        </table>
                                                     </c:when>
                                                        <c:otherwise>Корзина пуста</c:otherwise>
                                                 </c:choose>
                                                        </div>
                                            </div>
                                    </div>
                                    
                <hr class="noscreen" />
		<%@ include file="/menu.jsp" %>	
			
		</div>
		<!-- Content box with white background and gray border end -->
	</div>

        <hr class="noscreen" />

         <%@ include file="/footer.jsp" %>
        </div>
    </body>
</html>
