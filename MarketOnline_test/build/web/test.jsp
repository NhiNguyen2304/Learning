<%-- 
    Document   : test
    Created on : Dec 7, 2017, 2:03:56 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="one_quarter">
      <h6 class="title">Search Event</h6>
      <form method="POST" action="MainController">
        <fieldset>
          <input class="btmspace-15" type="text" name="txtSearchEvent" placeholder="Search">
          <button type="submit" value="SearchEvent" name="action">Search</button><br/>
        </fieldset>
      </form>
    </div>
        <%@include file="processing.jsp" %>
        <%@include file="detail.jsp" %>
        <%@include file="footer.jsp" %>
    </body>
</html>
