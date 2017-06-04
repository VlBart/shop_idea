<%-- 
    Document   : userForm
    Created on : 23.05.2012, 6:58:35
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
        <title>userForm</title>
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
                                               
                                                <h3>Изменение личных данных</h3>
                                                 <div id="info">
                                                      <form action="ActionServlet" method="post" accept-charset="utf-8">
                                                     <table align="center" cellspacing="10px">
                                                         <tr>
                                                            <td><c:out value="ФИО:"/></td>
                                                            <td><input required type="text" name="name" value="${user.fullName}" size=40/></td>    
                                                        </tr>
                                                        <tr>
                                                            <td><c:out value="Электронный адресс:"/></td>
                                                            <td><input required type="text" name="email" value="${user.email}" size="40"></td>
                                                        </tr>
                                                        <tr>
                                                            <td><c:out value="Телефон:"/></td>
                                                            <td><input required type="tel" pattern="[0-9]-[0-9]{3}-[0-9]{3}" name="phone" value="${user.phone}" size="10"><br>
                                                             Введите телефон в формате x-xxx-xxx, где вместо x 
                                                             должна быть цифра:</td>
                                                        </tr>
                                                        <tr>
                                                            <td><c:out value="Страна:" /></td>
                                                                <td>
                                                                        <select name="idCountry" size="1">
                                                                            <option value="${user.idCountry}"><c:out value="${user.country.value}" /></option>
                                                                                <c:forEach var="country" items="${countries}">
                                                                                        <option value="${country.id }">${country.value}</option>	
                                                                                </c:forEach>
                                                                        </select>				
                                                                </td>
                                                        </tr>
                                                       <tr>
                                                            <td><c:out value="Адресс:"/></td>
                                                            <td><input required type="text"  name="address" value="<c:out value="${user.address}"/>" size="40"></td>
                                                        </tr>
                                                         <tr>
                                                                <th colspan="2">
                                                                        <hr />
                                                                        <br>
                                                                        <input type="hidden" name="command" value="ChangeUser">
                                                                        <input type="hidden" name="action" value="update">
                                                                        <input type="hidden" name="idUser" value="${user.id}">
                                                                        <input type="hidden" name="username" value="${user.userName}">
                                                                        <input type="hidden" name="password" value="${user.password}">

                                                                        <input type="submit" value=<c:out value="Изменить" /> />
                                                                </th>
                                                        </tr>
                                                    </table>
                                                  </form>
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
