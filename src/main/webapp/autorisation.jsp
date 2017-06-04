<%-- 
    Document   : autirisation
    Created on : 10.05.2012, 22:18:23
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
                                                <form name="loginForm" method="POST" action="ActionServlet">
                                                    <input type="hidden" name="command" value="login" />
                                                        <h3>Авторизация</h3>
                                                        <p>
                                                            <label>Логин:&nbsp;&nbsp;
                                                                <input required name="username" type="text" size="22"/>
                                                            <label/>
                                                        </p>
                                                        <p>
                                                            <label>Пароль:
                                                                <input required name="password" type="password" size="22"/>
                                                            <label/>
                                                        </p>
                                                        <p>

                                                            <a href="ActionServlet?command=Registration&action=open">Регистрация</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            <input id="okbutton" type="submit" value="Вход" />
                                                        </p>

                                            </form>
                                            
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
