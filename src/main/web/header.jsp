<%-- 
    Document   : header
    Created on : 09.05.2017, 6:12:46
    Author     : Vlad
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--<style text="css">
.head {
    position: relative;    border: solid 4px #aaf;		
    margin-left: 1%;
    margin-right: 1%;
    height: 150px;
    background-color: #f9f9f9;
}
.menu{
    position: absolute;
    border: solid 4px #aaf;
    margin-left: 1%;
    width: 200px;
    height: 500px;
    background-color: #f9f9f9;
    padding-left: 10px;
    padding-top: 10px;
    
}
.reg{
    position: absolute;
    right: 20px;
    top: 20px;
    border: solid 4px #aaf;
    width: 200px;
    margin-left: auto;
}
.list{
   margin-left: 5%;
   margin-top: 5%;
   border: solid 4px #aaf;
   
}
.centerText{
    position: absolute;
    margin-right: 20%;
    margin-left: 20%;
    margin-top: 20px;
}
.rightHead{
    position: absolute;
    top: 5px;
    right: 20px;
    height: 20px;
}
.rightList{
    position: absolute;
    margin-top: 20px;
    margin-right: 1%;
    margin-left: 60%;
}
.basket{
    position: absolute;
    margin-top: 20px;
    padding: 10px;
    right: 20px;
    
    border: solid 4px #aaf;
}



            
            </style>
-->
    <head>
        
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/css.css" type="text/css" media="screen,projection,tv">
        <link rel="stylesheet" href="style/style-print.css" type="text/css" media="print">
        <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <title>Internet shop</title>
    </head>

        <div id="header">
		<div id="header-in">
			<ul id="navigation">
                        
                            <c:choose>
                            <c:when test="${empty user}">
                                <li id="sitemap"><a href="autorisation.jsp">Войти</a></li>
                            </c:when>
                                <c:otherwise>
                                     <li id="sitemap"><a href="userPage.jsp">Личный кабинет</a>|</li>
                                      <li id="envelope"><a href="ActionServlet?command=logout">Выйти</a></li>
                                 
                                </c:otherwise>
                            </c:choose>
		</ul>
		<!-- Your website name  -->
		<h1><a href="index.jsp">Интернет-магазин игрушек для девочек</a></h1>
		<!-- Your website name end -->
		
			<!-- Your slogan -->
			
			<!-- Your slogan end -->		
		</div>
	</div>
        <!-- Header end -->
	
	<!-- Menu -->
	<div id="menu-box" class="cleaning-box">
	<a href="#skip-menu" class="hidden">Skip menu</a>
		<ul id="menu">
			<li><a href="ActionServlet?command=Init">Список товаров</a></li>
			<li><a href="ActionServlet?command=Search">Поиск по цене</a></li>
                        <li><a href="ActionServlet?command=SearchByName">Поиск по названию</a></li>
			<li><a href="contactPage.jsp">Справка</a></li>
		</ul>
	</div>
	<!-- Menu end -->
            
        