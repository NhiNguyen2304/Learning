<%-- 
    Document   : aaaa
    Created on : Dec 14, 2017, 4:18:19 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE html>



<!-- for start load all suggest-->
<div class="body-load-suggest"> 
    <main class="hoc container clear">
        <div class="left-search">
            <h6 class="title">Search Suggest Event</h6>
            <form action="MainController" method="POST">
                <fieldset>
                    <button type="submit" value="Count" name="action" class="btmspace-15">Find the best Aggressive</button><br/>
                    <input type="hidden" name="txtUsername" value="${sessionScope.LOGINNAMESESSION}"/>
                </fieldset>
            </form>

        </div>
        <div class="wrapper row3">
            <div class="sidebar one_quarter first"> 
                <!-- ################################################################################################ -->
                <h6>Tasks for ${sessionScope.LOGINNAMESESSION}</h6>
                <nav class="sdb_holder">
                       <c:if test="${sessionScope.ROLE eq 'admin'}">
                        <ul>
                            <li><a href="loadSuggest.jsp">Suggested</a></li>
                            <li><a href="viewEvent.jsp">Event</a>
                                <ul>
                                    <li><a href="suggestJudged.jsp">Suggest judged</a></li>
                                </ul>
                            </li>
                            <li><a href="adminPost.jsp">Post</a>
                            </li>
                            <li><a href="statistic.jsp">Load Statistic</a></li>
                        </ul>
                    </c:if>
                    <c:if test="${sessionScope.ROLE eq 'staff'}">
                        <ul>
                            <li><a href="staffSuggest.jsp">Suggest Event</a></li>
                            <li><a href="#">Your Work</a>
                                <ul>
                                    <li><a href="suggestJudged.jsp">Suggest judged</a></li>

                                    <li><a href="viewOwnSugg.jsp">Your Suggest</a></li>

                                </ul>
                            </li>

                            </li>

                        </ul>
                    </c:if>  
                </nav>


                <!-- ################################################################################################ -->
            </div>
        </div>


        <h2 id="title-load-suggest">Your Suggest Event</h2>
        
        <c:if test="${not empty requestScope.COUNT}">
            <table border="1" id="suggest table">
                <thead>

                    <tr>
                        <th>No</th>
                        <th>Staff</th>
                        <th>Number of Suggest</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="list" items="${requestScope.COUNT}" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${sessionScope.LOGINNAMESESSION}</td>
                            <td>${list}</td>              
                        </tr>  

                    </c:forEach>

                </tbody>
            </table>
        </c:if>




    </main>






</div>


<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>
<!-- JAVASCRIPTS -->
<script src="../layout/scripts/jquery.min.js"></script>
<script src="../layout/scripts/jquery.backtotop.js"></script>
<script src="../layout/scripts/jquery.mobilemenu.js"></script>
<!-- IE9 Placeholder Support -->
<script src="../layout/scripts/jquery.placeholder.min.js"></script>