<%-- 
    Document   : userPage
    Created on : 11.05.2012, 22:32:02
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
        <title>User Page</title>
    </head>
    <body>
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
                                               
                                                <h3>Информация о пользователе</h3>
                                                 <div id="info">        
                                                <table >
                                                    <tr>
                                                        <td><c:out value="Имя пользователя:"/></td>
                                                        <td><c:out value="${user.fullName}"/></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Электронный адресс:</td>
                                                        <td><c:out value="${user.email}"/></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Телефон:</td>
                                                        <td><c:out value="${user.phone}"/></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Место проживания:</td>
                                                        <td><c:out value="${user.address}"/></td>
                                                    </tr>
                                                    <tr>
                                                    <th colspan="2">
                                                        <a href="ActionServlet?command=ChangeUser&action=open">ИЗМЕНИТЬ ДАННЫЕ</a>
                                                    </th>
                                                    </tr>
                                                    

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
