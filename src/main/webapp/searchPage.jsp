<%-- 
    Document   : searchPage
    Created on : 09.05.2012, 21:41:29
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
        <title>Search</title>
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
                                                <div id="search">
                                                

                                            <form action="ActionServlet" method="post">
                                                <table align="center" cellspacing="10px">
                                                        
                                                        <tr>
                                                                <td><c:out value="Цена:" /></td>
                                                                <td width="200px">
                                                                    <c:out value="от" />&nbsp;<input type="text" name="minPrice" value="" size=5 />
                                                                    <c:out value="до"/>&nbsp;<input type="text" name="maxPrice" value="" size=5 /> бел.руб
                                                                </td>
                                                        </tr>
                                                        <tr>
                                                                <th colspan="2" height="30">
                                                                        <hr />
                                                                        <br>
                                                                        <input type="hidden" name="command" value="findModel">
                                                                        <input type="hidden" name="subcommand" value="search">
                                                                        <input id="okbutton" type="submit"  value="Поиск" />
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
