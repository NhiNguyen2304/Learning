<%@page import="nhi.dtos.CategoryDTO"%>
<%@page import="nhi.daos.CategoryDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
Template Name: Lacegant
Author: <a href="http://www.os-templates.com/">OS Templates</a>
Author URI: http://www.os-templates.com/
Licence: Free to use under our free template licence terms
Licence URI: http://www.os-templates.com/template-terms
-->
<html>
    <head>
        <title>Lacegant</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <link href="layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
    </head>
    <body id="top">
        <!-- ################################################################################################ HEADER -->
        <!-- ################################################################################################ -->
        <!-- ################################################################################################ -->
        <div class="wrapper row0">
            <div id="topbar" class="hoc clear"> 
                <!-- ################################################################################################ -->

                <div class="fl_left">
                    <ul class="nospace inline pushright">
                        <li><i class="fa fa-sign-in"></i><a href="loginPage.jsp">Login</a></li>
                        <li><i class="fa fa-user"></i> <a href="register.jsp">Register</a></li>
                    </ul>
                </div>

                <div class="fl_right">
                    <ul class="nospace inline pushright">
                        <li><i class="fa fa-phone"></i> +00 (09) 67776167</li>
                        <li><i class="fa fa-envelope-o"></i>nguyenphanthaonhi@.com</li>
                    </ul>
                </div>
                <!-- ################################################################################################ -->
            </div>
        </div>
        <!-- ################################################################################################ -->
        <!-- ################################################################################################ -->
        <!-- ################################################################################################ -->
        <div class="wrapper row1">
            <header id="header" class="hoc clear"> 
                <!-- ################################################################################################ -->
                <div id="logo">
                    <h1><a href="index.html">Dream Market</a></h1>
                    <p>Dream can not come true unless you do</p>
                </div>
                <!-- ################################################################################################ -->
            </header>
        </div>
        <!-- ################################################################################################ -->
        <!-- ################################################################################################ -->
        <!-- ################################################################################################ -->
        <div class="wrapper row2">

            <%
                CategoryDAO categoryDAO = new CategoryDAO();
            %>

            <nav id="mainav" class="hoc clear"> 
                <!-- ################################################################################################ -->

                <ul class="clear">
                    <li class="active"><a href="test.jsp">Home</a></li>

                    <li><a class="drop" href="#">Pages</a>                          
                        <ul>

                            <%
                                for (CategoryDTO c : categoryDAO.getListCategories()) {
                            %>
                            <li><a href="springMarket.jsp?category=<%=c.getCategoryId()%>"><%=c.getCategoryName()%></a></li>
                                <%
                                    }
                                %>             

                        </ul>                           
                    </li>


                    <li><a class="drop" href="#">Dropdown</a>
                        <ul>
                            <li><a href="#">Spring</a></li>
                            <li><a class="drop" href="#">Summer</a>
                                <ul>
                                    <li><a href="#">SeaFood</a></li>
                                    <li><a href="#">Fruit</a></li>
                                    <li><a href="#">Coffee</a></li>
                                </ul>
                            </li>
                            <li><a href="#">Winter</a></li>
                        </ul>
                    </li>
                    <li><a href="service.jsp">Service</a></li>
                    <li><a href="test.jsp">About</a></li>
                    <li><a href="contact.jsp">Contact</a></li>
                </ul>
               


                <!-- ################################################################################################ -->
            </nav>
        </div>