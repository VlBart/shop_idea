<%-- 
    Document   : registrationPage
    Created on : 21.05.2012, 1:01:36
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
        <title>registrationPage</title>
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
                                                <h3>Регистрация</h3>
                                                <div id="registration">
                                                <form action="ActionServlet" method="post" accept-charset="utf-8">
                                                   <table align="center" cellspacing="10px">
                                                     <tr>
                                                        <td><c:out value="ФИО:*"/></td>
                                                        <td><input required type="text"  name="fullName" value="" size=25/></td>    
                                                    </tr>
                                                     <tr>
                                                        <td><c:out value="Логин:*"/></td>
                                                        <td><input required type="text" pattern="^[A-Za-z0-9]+$" name="username" value="" size=25/><br>
                                                            Логин может содержать только буквы латинского алфавита и цифры
                                                        </td>    
                                                    </tr>
                                                     <tr>
                                                        <td><c:out value="Пароль:*"/></td>
                                                        <td><input required type="password" name="password1" value="" size=25/></td>    
                                                    </tr>
                                                    <tr>
                                                        <td><c:out value="Повторите пароль:*"/></td>
                                                        <td><input required type="password" name="password2" value="" size=25/></td>
                                                    </tr>
                                                    <tr>
                                                        <td><c:out value="Электронный адресс:*"/></td>
                                                        <td><input required type="text" name="email" value="" size="20"></td>
                                                    </tr>
                                                    <tr>
                                                        <td><c:out value="Телефон:"/></td>
                                                        <td><input type="tel" pattern="[0-9]-[0-9]{3}-[0-9]{3}" name="phone" value="" size="10"><br>
                                                            Введите телефон в формате x-xxx-xxx, где вместо x 
    должна быть цифра:</td>
                                                    </tr>
                                                    <tr>
                                                        <td><c:out value="Страна:*" /></td>
                                                            <td>
                                                                    <select name="idCountry" size="1">
                                                                        <option value="${producer.idCountry}"><c:out value="${producer.country.value}" /></option>
                                                                            <c:forEach var="country" items="${countries}">
                                                                                    <option value="${country.id }">${country.value}</option>	
                                                                            </c:forEach>
                                                                    </select>				
                                                            </td>
                                                    </tr>
                                                    <tr>
                                                        <td><c:out value="Адресс доставки:*"/></td>
                                                        <td><input required type="text"  name="address" value="" size="40"></td>
                                                    </tr>
                                                     <tr>
                                                            <th colspan="2">
                                                                    <hr />
                                                                    <br>
                                                                    <input type="hidden" name="command" value="Registration">
                                                                    <input type="hidden" name="action" value="add">

                                                                    <input type="submit" value=<c:out value="Зарегистрироваться" /> />
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
