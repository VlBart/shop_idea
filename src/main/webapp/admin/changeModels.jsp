<%-- 
    Document   : changeModels
    Created on : 15.05.2012, 1:43:03
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
        <title>JSP Page</title>
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
                                               
                                                <h3>Модели&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="ActionServlet?command=Models&action=add">Добавить модель</a></h3>
                                                 <div id="model" >        
                                                  <table >
                                                      <tr>
                                                          <td>Модель</td>
                                                          <td></td>
                                                          <td><center>Изображение</center></td>
                                                      </tr>
                                                      <tr>


                                                     <c:forEach var="model" items="${models}">
                                                             <tr>
                                                             <td><b ${model.id}">${model.producer.name}<br><c:out value="${model.name}"/></td></b>
                                                                <td><a href="ActionServlet?command=Models&idModel=${model.id}&action=delete">Удалить</a>&nbsp;<a href="ActionServlet?command=Models&idModel=${model.id}&action=change">Вправить</a></td>
                                                                <td>
                                                                    <center><img src="${model.imageURL}" width="150" height="110" alt="Not found"/></center>
                                                                    <form name="sendform" enctype="multipart/form-data"action="ActionServlet?command=Image&idModel=${model.id}" method="post">
                                                                        <table>
                                                                            <tr>
                                                                                <td>
                                                                      <input type="File" name="file_send"><br><br>
                                                                                </td>
                                                                                <td>    
                                                                      <input type="submit" value="Изменить изображение">
                                                                                </td>
                                                                        </tr>
                                                                        </table>
                                                                    </form>
                                                                </td>
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
