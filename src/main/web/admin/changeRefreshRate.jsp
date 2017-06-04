<%-- 
    Document   : changeRefreshRate
    Created on : 17.05.2012, 9:02:36
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
        <title>changeRefreshRate</title>
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
                                               
                                                <h3>Частота развертки</h3>
                                                 <div id="type" >        
                                                      <form action="ActionServlet?command=RefreshRate&action=add" method="post">
                                                                       <table>
                                                                       <tr>
                                                                                <td style="width: 40px"><input type="number" min="0" name="nameRefreshRate" value="" size=20/></td>
                                                                                <td><input type="submit" value="Добавить"/></td>    
                                                                       </tr>
                                                                       </table>
                                                                        </form>
                                                                   <table cellspacing="5px">
                                                                         <c:forEach var="refreshRate" items="${refreshRates}">
                                                                                    <tr>

                                                                                    <td style="width: 60px">${refreshRate.value}&nbsp;Гц
                                                                                    <td><a href="ActionServlet?command=RefreshRate&idRefreshRate=${refreshRate.id}&action=delete">Удалить</a></td>
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
