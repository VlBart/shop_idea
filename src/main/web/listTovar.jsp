<%-- 
    Document   : listTovar
    Created on : 08.05.2012, 0:41:07
    Author     : Andrei
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="view" value="/WEB-INF/listTovar.jsp" scope="session" />
 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>listTovar</title>
    </head>
    <body>
  
        
        <h3> Отсортировать по:&nbsp;&nbsp; 
        <a href="ActionServlet?command=Sort&attribute=price">Цене</a>&nbsp;&nbsp;
        <a href="ActionServlet?command=Sort&attribute=producer">Названию</a>&nbsp;&nbsp;
        </h3><br>
          <table>
             <c:forEach var="model" items="${models}">

                 <tr>
                   <td><img src="${model.imageURL}" width="155" height="101" alt="Not found" /></td>
                        <td><a href="#">${model.producer.name} &nbsp; ${model.model}</a><br><br>
                        <td>${model.price} бел.руб.</td>
                       
                             <c:choose>
                            <c:when test="${!empty user}">
                                 <td>
                                 <a href="ActionServlet?command=Basket&action=add&idModel=${model.id}">В корзину</a>
                                  </td>
                            </c:when>
                            <c:otherwise>
                                <td>
                                 <a href="ActionServlet?command=BasketGuest&action=add&idModel=${model.id}">В корзину</a>
                                  </td>
                                </c:otherwise>
                            </c:choose>
                           
                       
                    </tr>

            </c:forEach>
         </table>

          

    </body>
</html>
 