<%-- 
    Document   : changeDiagonal
    Created on : 17.05.2012, 8:34:10
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
        <title>Возраст</title>
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
                                               
                                                <h3>Возраст</h3>
                                                 <div id="type" >        
                                                      <form action="ActionServlet?command=Diagonal&action=add" method="post">
                                                           <table>
                                                           <tr>
                                                           <td style="width: 40px"><input type="number" name="nameDiagonal" min=0 value="" size="3"/></td>
                                                                    <td><input type="submit" value="Добавить"/></td>    
                                                           </tr>
                                                           </table>
                                                            </form>
                                                       <table cellspacing="5px">
                                                             <c:forEach var="diagonal" items="${diagonals}">
                                                                        <tr>

                                                                        <td style="width: 60px">${diagonal.value}&nbsp;+
                                                                        <td><a href="ActionServlet?command=Diagonal&idDiagonal=${diagonal.id}&action=delete">Удалить</a></td>
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
