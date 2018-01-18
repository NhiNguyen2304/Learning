<%-- 
    Document   : aaaa
    Created on : Dec 14, 2017, 4:18:19 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>


<div class="body-load-suggest"> 
    <main class="hoc container clear">
        <div class="left-search">
            <h6 class="title">Search Event</h6>
            <form method="POST" action="MainController">
                <fieldset>
                    <input class="btmspace-15" type="text" name="txtSearchEvent" placeholder="Search" required>
                    <button type="submit" value="SearchEvent" name="action" class="btmspace-15">Search</button>              
                </fieldset>
            </form> 
        </div>
        
        
         <div class="wrapper row3">
         <div class="sidebar one_quarter first"> 
            <!-- ################################################################################################ -->
            <h6>Tasks for ${sessionScope.LOGINNAMESESSION}</h6>
            <nav class="sdb_holder">
                <ul>
                    <li><a href="loadSuggest.jsp">Suggested</a></li>
                    <li><a href="viewEvent.jsp">Event</a>
                        <ul>
                            <li><a href="#">Navigation - Level 2</a></li>
                            <li><a href="#">Navigation - Level 2</a></li>
                        </ul>
                    </li>
                    <li><a href="adminPost.jsp">Post</a>
                        
                    </li>
                  
                </ul>
            </nav>

            
            <!-- ################################################################################################ -->
        </div>
    </div>
        
        
        
         <h2 id="title-load-suggest">Event</h2>
        <c:if test="${not empty requestScope.LOADEVENT}">
            <table border="1" id="suggest table">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Kind Of Event</th>
                        <th>Title</th>
                        <th>Time to Start</th>
                        <th>Time to End</th>
                        <th>Content</th>
                        <th>Status</th>
                        <th>Place</th>
                        <th>Update</th>

                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="dto" items="${requestScope.LOADEVENT}" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${dto.kindOfEvent}</td>
                            <td>${dto.title}</td>
                            <td>${dto.dateStart}</td>              
                            <td>${dto.dateEnd}</td>
                            <td>${dto.content}</td>
                            <td>${dto.status}</td>
                            <td>${dto.place}</td>
                    <form action="MainController" method="POST">
                        <td>
                            <input type="hidden" name="txtTitle" value="${dto.title}"/>
                            <input type="submit" name="action" value="Edit"/>
                        </td>
                    </form>



                        </tr>  

                    </c:forEach>

                </tbody>
            </table>
        </c:if>

    </main>
</div>





       