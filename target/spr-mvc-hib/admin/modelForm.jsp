<%-- 
    Document   : modelForm
    Created on : 15.05.2012, 4:49:03
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
        <title>modelForm</title>
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
                                               
                                                <h3>Диагональ</h3>
                                                 <div id="type" >        
                                                      <form action="ActionServlet" method="post" accept-charset="utf-8">
                                                            <table align="center" cellspacing="10px">
                                                            <tr>
                                                            <td width="100px"><c:out value="Производитель:"  />: </td>
                                                                    <td>
                                                                            <select name="idProducer" size="1">
                                                                                <option value="${model.idProducer}"><c:out value="${model.producer.email}"/></option>
                                                                                    <c:forEach var="producer" items="${producers }">
                                                                                            <option value="${producer.id }">${producer.name }</option>	
                                                                                    </c:forEach>
                                                                            </select>
                                                                    </td>
                                                            </tr>
                                                            <tr>
                                                                <td><c:out value="Название:"/></td>
                                                                <td><input type="text" name="modelName" value="${model.name}" size=15/></td>
                                                            </tr>
                                                            <tr>
                                                                    <td><c:out value="Тип:" /></td>
                                                                    <td>
                                                                            <select name="idType" size="1">
                                                                                <option value="${model.idType}"><c:out value="${model.type.value}" /></option>
                                                                                    <c:forEach var="type" items="${types}">
                                                                                            <option value="${type.id }">${type.value}</option>	
                                                                                    </c:forEach>
                                                                            </select>				
                                                                    </td>
                                                            </tr>
                                                                <tr>
                                                                    <td><c:out value="Возраст:" /></td>
                                                                    <td><input type="number" min="0" max="150" name="age_for" value="3"  size=1/>&nbsp +</td>
                                                                </tr>
                                                            <tr>
                                                                <td><c:out value="Количество:" /></td>
                                                                <td width="200px">
                                                                        <input type="number" min="0" name="amount" value="${model.amount}" size=5 />
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                    <td><c:out value="Цена:" /></td>
                                                                    <td width="200px">
                                                                        <input type="number" min="0" name="price" value="${model.price}" size=5 />&nbsp;бел.руб.
                                                                    </td>
                                                            </tr>
                                                            <tr>
                                                                    <th colspan="2">
                                                                            <hr />
                                                                            <br>
                                                                            <input type="hidden" name="command" value="Models">
                                                                            <input type="hidden" name="cmd" value="update">
                                                                            <input type="hidden" name="idModel" value="${model.id}">
                                                                            <input type="hidden" name="subcommand" value="update">

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
