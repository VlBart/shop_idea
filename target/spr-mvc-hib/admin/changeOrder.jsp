<%-- 
    Document   : changeOrder
    Created on : 20.05.2012, 5:35:05
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
        <title>changeOrder</title>
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
                                               
                                                <h3>Текущие заказы</h3>
                                                 <div id="type" >        
                                                      <table >
                                                                  <tr><td>Игрушка</td><td>Количество</td><td>Цена</td><td>Пользователь</td><td>Дата заказа</td></tr>
                                                         <c:forEach var="order" items="${orders}">
                                                                    <tr>

                                                                    <td><c:out value="${order.producer.name}"/>&nbsp;<c:out value="${order.model.name}"/></td><td><c:out value="${order.amount}"/></td><td><c:out value="${order.price}"/></td><td><c:out value="${order.user.fullName}"/></td><td><c:out value="${order.date}"/></td>
                                                                    <td><a href="ActionServlet?command=Orders&idOrder=${order.id}&action=delete">Удалить</a>
                                                                    <a href="ActionServlet?command=Orders&idOrder=${order.id}&action=delete">Выполнить</a></td>
                                                                </tr>

                                                        </c:forEach>
                                                     </table>
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
