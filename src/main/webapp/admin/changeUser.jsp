<%-- 
    Document   : changeUser
    Created on : 23.05.2012, 6:31:31
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
        <title>changeUser</title>
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
                                               
                                                <h3>Пользователи</h3>
                                                 <div id="producer"">        
                                                 <table >
                                                          <tr><td>Пользователь</td></tr>
                                                 <c:forEach var="usr" items="${users}">
                                                            <tr>

                                                            <td>${usr.fullName}</td><td>${usr.email}</td><td>${usr.phone}</td><td>${usr.country.value}<br>${usr.address}</td>
                                                            <td><a href="ActionServlet?command=User&idUser=${usr.id}&action=delete">Удалить</a>
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
