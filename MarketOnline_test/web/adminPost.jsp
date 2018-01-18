<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %> 
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row3">
    <main class="hoc container clear"> 
        <!-- main body -->
        <!-- ################################################################################################ -->
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
        <!-- ################################################################################################ -->
        <!-- ################################################################################################ -->





        <h2>Post event</h2>
        <form action="MainController" method="POST">
            <div class="center-main">
                <label for="name">Kind Of Event</label>

                   <select name="listKind">
                    <option value="1-Spring Market">Spring Market</option>
                    <option value="2-Summer Market">Summer Market</option>
                    <option value="3-Winter Market">Winter Market</option>
                </select>

                <label for="name">Title<span>*</span></label>
                <input type="text" name="txtTitle" id="name" value="${requestScope.INFO.titleSug}" size="22" required/>


                <label for="name">Time to start</label>
                <input type="date" name="txtTimeStart" value="${requestScope.INFO.timeStartSug}" size="22"/>
                <c:if test="${not empty requestScope.INVALID}">
                    <font color="red">
                    ${requestScope.INVALID.dateStartErr}
                    </font>
                </c:if>

                <label for="name">Time to end</label>
                <input type="date" name="txtTimeEnd" value="${requestScope.INFO.timeEndSug}" size="22"/>
                <c:if test="${not empty requestScope.INVALID}">
                    <font color="red">
                    ${requestScope.INVALID.dateEndErr}
                    </font>
                </c:if>


                <label for="name">Place</label>
                <input type="text" name="txtPlace"/>

                <label for="name">Image</label>
               
                <input type="text" name="txtImage"/>



                <label for="name">Status</label>
                <input type="text" name="txtStatus"/>


                <label for="comment">Content</label>
                <textarea name="txtContent" cols="25" rows="10"></textarea>


                &nbsp;
                <button type="submit"  name="action" value="Post" class="btmspace-15">POST EVENT</button> 
                &nbsp;
                <button type="reset" name="action" class="btmspace-15">Reset</button> 
            </div>
        </form>



    </main>
</div>


<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>
<!-- JAVASCRIPTS -->
<script src="../layout/scripts/jquery.min.js"></script>
<script src="../layout/scripts/jquery.backtotop.js"></script>
<script src="../layout/scripts/jquery.mobilemenu.js"></script>
<!-- IE9 Placeholder Support -->
<script src="../layout/scripts/jquery.placeholder.min.js"></script>
<!-- / IE9 Placeholder Support -->
</body>
</html>