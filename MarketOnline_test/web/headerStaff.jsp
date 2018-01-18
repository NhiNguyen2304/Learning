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
          <li><i class="fa fa-sign-in"></i> <a href="test.jsp">Log out</a></li>
        <li><i class="fa fa-user"></i> <a href="#">Register</a></li>
      </ul>
    </div>
    <div class="fl_right">
      <ul class="nospace inline pushright">
          <li>Welcome ${sessionScope.LOGINNAMESESSION}</li>
        <li><i class="fa fa-phone"></i> +00 (123) 456 7890</li>
        <li><i class="fa fa-envelope-o"></i> nguyenphanthaonhi@gmail.com</li>
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
   <div class="one_quarter">
      <h6 class="title">Search Suggest Event</h6>
      <form method="POST" action="MainController">
        <fieldset>
          <input class="btmspace-15" type="text" name="txtSearch" placeholder="Search">
          <button type="submit" value="Search" name="action">Search</button><br/>
          <button type="submit" value="Load" name="action">View All Suggest</button><br/>
        </fieldset>
      </form>
    </div>
  <nav id="mainav" class="hoc clear"> 
    <!-- ################################################################################################ -->
    <ul class="clear">
      <li class="active"><a href="test.jsp">Home</a></li>
      <li><a class="drop" href="#">Pages</a>
        <ul>
          <li><a href="pages/gallery.html">Gallery</a></li>
          <li><a href="pages/full-width.html">Full Width</a></li> <%-- detail of event--%>
          <li><a href="pages/sidebar-left.html">Sidebar Left</a></li>
          <li><a href="pages/sidebar-right.html">Sidebar Right</a></li>
          <li><a href="pages/basic-grid.html">Basic Grid</a></li>
        </ul>
      </li>
      <li><a href="viewEvent_admin.jsp">Event</a></li>
      <li><a href="staffSuggest.jsp">Suggest Event</a></li>
      <li>
          
           <a href="loadSuggest.jsp">Suggested</a>   
      </li>
     
      <li><a href="#">Link Text</a></li>
      <li><a href="#">Link Text</a></li>
      
    </ul>
          
    <!-- ################################################################################################ -->
  </nav>
</div>