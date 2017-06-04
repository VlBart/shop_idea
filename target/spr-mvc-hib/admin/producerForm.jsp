<%-- 
    Document   : producerForm
    Created on : 17.05.2012, 3:09:33
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
        <title>producerForm</title>
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
                                               
                                                <h3>Изменение производителя</h3>
                                                 <div id="producer"">
                                                      <form action="ActionServlet" method="post">
                                                     <table align="center" cellspacing="10px">
                                                         <tr>
                                                            <td><c:out value="Название:"/></td>
                                                            <td><input type="text" name="name" value="${producer.name}" size=10/></td>    
                                                        </tr>
                                                        <tr>
                                                            <td><c:out value="Электронный адресс:"/></td>
                                                            <td><input type="text" name="email" value="${producer.email}" size="20"></td>
                                                        </tr>
                                                        <tr>
                                                            <td><c:out value="Телефон:"/></td>
                                                            <td><input type="text" name="phone" value="${producer.phone}" size="10"></td>
                                                        </tr>
                                                        <tr>
                                                            <td><c:out value="Страна:" /></td>
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
                                                            <td><c:out value="Адресс:"/></td>
                                                            <td><input type="text" name="address" value="${producer.address}" size="40"></td>
                                                        </tr>
                                                         <tr>
                                                                <th colspan="2">
                                                                        <hr />
                                                                        <input type="hidden" name="command" value="Producers">
                                                                        <input type="hidden" name="cmd" value="update">
                                                                        <input type="hidden" name="idProducer" value="${producer.id}">
                                                                        <input type="hidden" name="subcommand" value="submit">

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
