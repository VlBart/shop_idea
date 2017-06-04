<%-- 
    Document   : options
    Created on : 15.05.2012, 2:16:34
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
        <title>Options</title>
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

                                                <h3> ${model.producer.name}&nbsp${model.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h3>
                                                    <!-- <c:choose>
                                                        <c:when test="${!empty user}">
                                                            <a href="#">Добавить в корзину</a>
                                                        </c:when>
                                                     </c:choose>-->
          <img src="${model.imageURL}" width="400" height="300" alt="Фото отсутствует">
          <br>
          <br>
          <br>
       <table>
                      <!--tr><td>Тип:</td> <td>${model.type.value}</td></tr>
                      <tr><td>Диагональ:</td><td>${model.diagonal.value}"</td></tr>
                      <tr><td>Разрешение:</td> <td>${model.resolution.value}</td></tr>
                      <tr><td>Частота развертки:</td><td>${model.refreshRate.value}&nbsp;Гц</td></tr>
                      <tr><td>Количество USB:</td><td>${model.usbNumber}</td></tr>
                      <tr><td>Количество HDMI:</td><td>${model.hdmiNumber}</td></tr>
                      <tr><td>Потребляемая мощность:</td> <td>${model.pwr}&nbsp;Вт</td></tr>
                      <tr><td>Технология 3D:</td> 
                           <td><c:choose>
                            <c:when test="${model.webTv eq 2}">
                                 присутствует
                            </c:when>
                            <c:otherwise>отсутствует</c:otherwise>
                            </c:choose>
                          </td></tr>
                      <tr><td>Web TV:</td>
                          <td><c:choose>
                            <c:when test="${model.threeD eq 2}">
                                 присутствует
                            </c:when>
                            <c:otherwise>отсутствует</c:otherwise>
                            </c:choose>
                         </td></tr-->
                         <tr><td>Цена:</td><td>${model.price}&nbsp;бел.руб</td></tr>
         </table>
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
