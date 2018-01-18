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


<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>
<!-- JAVASCRIPTS -->
<script src="../layout/scripts/jquery.min.js"></script>
<script src="../layout/scripts/jquery.backtotop.js"></script>
<script src="../layout/scripts/jquery.mobilemenu.js"></script>
<!-- IE9 Placeholder Support -->
<script src="../layout/scripts/jquery.placeholder.min.js"></script>