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
        <form method="POST" action="MainController">
            <fieldset>
                <input class="btmspace-15" type="text" name="txtSearch" placeholder="Search" required>
                <button type="submit" value="SearchSuggest" name="action" class="btmspace-15">Search</button>              
            </fieldset>
        </form> 
        <form action="MainController" method="POST">
            <fieldset>
            <button type="submit" value="Load" name="action" class="btmspace-15">All Suggest Commited</button><br/>
            </fieldset>
             <br/>
            <br/>
             <br/>
            <br/>
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
        <br/>
        <br/>
        <br/>
        
        <!-- button view all suggest-->
         <h2 id="title-load-suggest">Suggest Event</h2>
        <c:if test="${not empty requestScope.LOADSUGG}">
           
            <table border="1" id="suggest table">
                <thead>
                 
                    <tr>
                        <th>No</th>
                        <th>Title</th>
                        <th>Time to Start</th>
                        <th>Time to end</th>
                        <th>Staff's Name</th>
                        <th>Post</th>
                        <th>Disagree</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="dto" items="${requestScope.LOADSUGG}" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${dto.titleSug}</td>
                            <td>${dto.timeStartSug}</td>              
                            <td>${dto.timeEndSug}</td>
                            <td>${dto.maker}</td>
                            <c:if test="${empty requestScope.JUDGE}">
                        <form action="MainController" method="POST">
                            <td>
                                <input type="hidden" name="txtTitileSug" value="${dto.titleSug}"/>
                                 <input type="hidden" name="txtTimeStart" value="${dto.timeStartSug}"/>
                                  <input type="hidden" name="txtTimeEnd" value="${dto.timeEndSug}"/>
                                <button type="submit" value="Agree" name="action">Agree</button>
                            </td>
                        </form>  
                        <form action="MainController" method="POST">
                            <td>
                                <input type="hidden" name="txtTitleSug" value="${dto.titleSug}"/>
                             
                                <button type="submit" value="Disagree" name="action">Disagree</button>
                                <input type="text" name="txtNote" size="15"/>
                            </td>
                        </form>

                        <form action="MainController" method="POST">
                            <td>
                                <input type="hidden" name="txtUsername" value="${dto.maker}">
                                <input type="hidden" name="txtTitleSug" value="${dto.titleSug}"/>
                                <button type="submit" value="Delete" name="action">Delete</button>
                            </td>
                        </form>
                    </c:if>
                    <c:if test="${not empty requestScope.JUDGE}">
                        <td>${requestScope.JUDGE}</td>
                        <td>${requestScope.JUDGE}</td>
                    </c:if>
                    </tr>  

                </c:forEach>

                </tbody>
            </table>
        </c:if>

        <!-- For search Page-->      
        <c:if test="${not empty requestScope.SEARCHINFO}">
            <table border="1" id="suggest table">
                <thead>
                  
                    <tr>
                        <th>No</th>
                        <th>Title</th>
                        <th>Time to Start</th>
                        <th>Time to end</th>
                        <th>Staff's Name</th>
                        <th>Post</th>
                        <th>Disagree</th>
                        <th>Delete</th>
                      
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="dto" items="${requestScope.SEARCHINFO}" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${dto.titleSug}</td>
                            <td>${dto.timeStartSug}</td>              
                            <td>${dto.timeEndSug}</td>
                            <td>${dto.maker}</td>
                    
                        <form action="MainController" method="POST">
                            <td>
                                <input type="hidden" name="txtTitileSug" value="${dto.titleSug}"/>
                                <button type="submit" value="Agree" name="action">Agree</button>
                            </td>
                        </form>  
                        <form action="MainController" method="POST">
                            <td>
                                <input type="hidden" name="txtTitleSug" value="${dto.titleSug}"/>
                                <button type="submit" value="Disagree" name="action">Disagree</button>
                                <input type="text" name="txtNote" size="15"/>
                            </td>
                        </form>

                        <form action="MainController" method="POST">
                            <td>
                                <input type="hidden" name="txtTitleSug" value="${dto.titleSug}"/>
                                <button type="submit" value="Delete" name="action">Delete</button>
                            </td>
                        </form>
                    
                   
                    </tr>  

                </c:forEach>

                </tbody>
            </table>

        </c:if>

        
        
    </main>
    
    
    
    
       

    </div>

</body>

<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>
<!-- JAVASCRIPTS -->
<script src="../layout/scripts/jquery.min.js"></script>
<script src="../layout/scripts/jquery.backtotop.js"></script>
<script src="../layout/scripts/jquery.mobilemenu.js"></script>
<!-- IE9 Placeholder Support -->
<script src="../layout/scripts/jquery.placeholder.min.js"></script>