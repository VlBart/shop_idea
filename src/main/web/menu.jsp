<%-- 
    Document   : body
    Created on : 10.05.2012, 22:24:05
    Author     : Andrei
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/jquery.dropDown.pack.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $('ul#nav').NavDropDown({
            duration:300, 
            hoverElement:'li',
            hoverClass:'hover',
            dropHolder:'div',
            showEffect:'slide' // slide, fade, slide&fade
        });                
    }); 
</script>

     <!-- Right column -->
	<div id="content-box-in-right">
		<div id="content-box-in-right-in">
                    
                         <div class="sidenav">
                             <h3>Каталог товаров</h3>

			<ul>
                            <li><a href="ActionServlet?command=findModel&selectedProducer=Danier&subcommand=search" title="Антидоты ">Детская бытовая техника </a></li>
                            <li><a href="ActionServlet?command=findModel&selectedProducer=Magniflex&subcommand=search" title="Миорелаксанты ">Куклы для девочек </a></li>
                            <li><a href="ActionServlet?command=findModel&selectedProducer=Kwizda&subcommand=search" title="Снотворные средства">Детские кухни</a></li>
                            <li><a href="ActionServlet?command=findModel&selectedProducer=Panasonic&subcommand=search" title="Цефалоспорины ">Коляски для кукол </a></li>
                            <li><a href="ActionServlet?command=findModel&selectedProducer=Sony&subcommand=search" title="Холинолитические средств">Игрушечная посуда</a></li>
                            <!--li><a href="ActionServlet?command=findModel&selectedProducer=Sharp&subcommand=search" title="Противовоспалительные средства">Противовоспалительные средства</a></li>
                            <li><a href="ActionServlet?command=findModel&selectedProducer=Toshiba&subcommand=search" title="Миотические средства">Миотические средства</a></li>
                            <li><a href="ActionServlet?command=findModel&selectedProducer=BBK&subcommand=search" title="Психостимулирующие средства">Психостимулирующие средства</a></li-->
                        </ul>
                        <br />
                        <br />
                         </div>
                         
                         <c:choose>
                             <c:when test="${user.isAdmin eq 2}">
                                
                                <div class="sidenav">
                                    <ul id="nav">
                                        <li>
                                    <!--<h3>Таблицы</h3>-->
                                    <a href="#">Таблицы</a>
                                    <div>
                                        <ul>
                                            <li><a href="ActionServlet?command=Open&tables=producers">Производители<br>(поставщики)</a></li>
                                            <li><a href="ActionServlet?command=Open&tables=models">Игрушки</a></li>
                                            <li><a href="ActionServlet?command=Open&tables=type">Тип</a></li>
                                            <li><a href="ActionServlet?command=Open&tables=diagonal">Возраст</a></li>
                                            <li><a href="ActionServlet?command=Open&tables=resolution">Предназначение</a></li>
                                            <li><a href="ActionServlet?command=Open&tables=country">Страны</a></li>
                                            <li><a href="ActionServlet?command=Open&tables=orders">Заказы</a></li>
                                            <li><a href="ActionServlet?command=Open&tables=users">Пользователи</a></li>
                                        </ul> 
                                    </div>
                                        </li>
                                    </ul>
                                    <br />
                                    <br />
                                </div>
                             </c:when>
                        </c:choose>
                    <div class="sidenav">
                         <c:choose>
                            <c:when test="${!empty user}">

                               <%@ include file="/basket.jsp" %> 

                            </c:when>
                            <c:otherwise>
                                <%@ include file="/basketGuest.jsp" %>
                            </c:otherwise>
                        </c:choose>    
                   </div>
                             
		
                         
				
				
            </div>
	</div>
			<div class="cleaner">&nbsp;</div>
			<!-- Right column end -->


