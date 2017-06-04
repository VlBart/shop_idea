<%-- 
    Document   : changeProducers
    Created on : 15.05.2012, 0:48:16
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
        <title>changeProducer</title>
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
                                               
                                                <h3>Производители&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="ActionServlet?command=Producers&action=add">Добавить производителя</a></h3>
                                                 <div id="producer"">        
                                                 <table >
                                                          <tr><td>Производитель</td><td>Электронный адрес</td><td>Телефон</td><td>Страна</td><td>Адресс</td></tr>
                                                 <c:forEach var="producer" items="${producers}">
                                                            <tr>

                                                            <td><c:out value="${producer.name}"/></td><td><c:out value="${producer.email}"/></td><td><c:out value="${producer.phone}"/></td><td><c:out value="${producer.country.value}"/></td><td><c:out value="${producer.address}"/></td>
                                                            <td><a href="ActionServlet?command=Producers&idProducer=${producer.id}&action=delete">Удалить</a>
                                                            <a href="ActionServlet?command=Producers&idProducer=${producer.id}&action=change">Вправить</a></td>
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
