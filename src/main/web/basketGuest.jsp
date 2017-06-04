<%-- 
    Document   : basket
    Created on : 19.05.2012, 5:22:13
    Author     : Andrei
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="view" value="/WEB-INF/listTovar.jsp" scope="session" />
 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>basket</title>
    </head>
    <body>

                               <h3>Текущий заказ</h3>
                                    <table>
                                        <hr />
                                    <tr>
                                        <td>Количество<br> товаров&nbsp;</td>
                                        <td>
                                            <c:choose>
                                            <c:when test="${empty  amount}">
                                                0 
                                            </c:when>
                                            <c:otherwise>${amount}</c:otherwise>
                                            </c:choose>
                                        </td>
                                    </tr>
                                        <tr>
                                            <td>Общая сумма:&nbsp;</td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${empty  cost}">
                                                        0&nbsp;<br>бел.руб. 
                                                    </c:when>
                                                        <c:otherwise>${cost}&nbsp;<br>бел.руб</c:otherwise>
                                                </c:choose>
                                            </td>
                                        </tr>
                                           <th colspan="2">
                                               <hr />
                                               <a href="ordersGuest.jsp">Оформить заказ >></a>
                                           </th>

                                    </table>
    </body>
</html>
