<%-- 
    Document   : contactPage
    Created on : 27.05.2012, 23:29:11
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
        <title>contactPage</title>
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
                                                <h3>О проекте</h3>
                                                <center>
                                                    <p>Учреждение образования</p>
                                                    <p>БЕЛОРУССКИЙ ГОСУДАРСТВЕННЫЙ УНИВЕРСИТЕТ</p> 
                                                    <p>ИНФОРМАТИКИ И РАДИОЭЛЕКТРОНИКИ</p>

                                                    <p>Факультет информационных технологий и управления</p>

                                                    <p>Кафедра информационных технологий автоматизированных систем</p>
                                                    <p>2017 год</p>
                                                    <p>Данный интернет-ресурс является курсовым проетом по дисциплине "БиБД".</p>
                                                    <p>Интернет-магазин игрушек для девочек разработан студентом группы 420601 Бартошом Владислав Ивановичом</p>
                                                        
                                                </center>
                                                   
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
