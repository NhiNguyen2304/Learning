<%@include file="header.jsp" %> 



<div class="body-load-suggest"> 
    <main class="hoc container clear">

        <div class="wrapper row3">
            <div class="sidebar one_quarter first"> 

                <h6>Tasks for ${sessionScope.LOGINNAMESESSION}</h6>
                <nav class="sdb_holder">
                    <ul>
                        <li><a href="staffSuggest.jsp">Suggest Event</a></li>
                        <li><a href="#">Your Work</a>
                            <ul>
                                <li><a href="viewOwnSugg.jsp">Your Suggest</a></li>
                           <li><a href="suggestJudged.jsp">Suggest judged</a></li>
                            </ul>
                        </li>

                    </ul>
                </nav>           
            </div>
        </div>

        <!--------------------------------->

        <h2>Suggest event</h2>
        <form action="MainController" method="post">
            <div class="center-main">
                <label for="name">Staff's Name</label>
                <input type="text" name="txtStaffName" value="${sessionScope.LOGINNAMESESSION}" size="10" readonly="true"/>


                <label for="name">Title<span>*</span></label>
                <input type="text" name="txtTitleSuggest" id="name" value="" size="30" required/>


                <label for="comment">Time to start</label>
                <input type="date" name="txtTimeStartSuggest" value="" size="30"/>
                <c:if test="${not empty requestScope.INVALID}">
                    <font color="red">
                    ${requestScope.INVALID.dateStartSugErr}
                    </font>
                </c:if>


                <label for="comment">Time to end</label>
                <input type="date" name="txtTimeEndSuggest" value="" size="30"/>
                <c:if test="${not empty requestScope.INVALID}">
                    <font color="red">
                    ${requestScope.INVALID.dateEndSuggEr}
                    </font>
                </c:if>
                &nbsp;
                <button type="submit" value="Suggest" name="action" class="btmspace-15">Suggest</button> 
                &nbsp;
                <button type="reset" name="action" class="btmspace-15">Reset</button> 
            </div>
        </form>
    </main>
</div>

<div class="wrapper row3">
    <main class="hoc container clear"> 

        <div class="content three_quarter"> 
            <!-- ################################################################################################ -->



            <!-- ################################################################################################ -->
        </div>
        <!-- ################################################################################################ -->
        <!-- / main body -->
        <div class="clear"></div>
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