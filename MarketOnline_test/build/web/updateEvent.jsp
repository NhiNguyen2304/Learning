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
        <!-- ################################################################################################ -->
        <!-- ################################################################################################ -->





        <h2>Post event</h2>
        <form action="MainController" method="POST">
            <div class="center-main">
                <label for="name">Kind Of Event</label>
                <input type="text" name="txtKindEvent" value="${requestScope.DTO.kindOfEvent}" size="22" required readonly="true"/>
              

                <label for="name">Title<span>*</span></label>
                <input type="text" name="txtTitle" id="name" value="${requestScope.DTO.title}" size="22" required readonly="true"/>


                <label for="name">Time to start</label>
                <input type="date" name="txtTimeStart" value="${requestScope.DTO.dateStart}" size="22"/>


                <label for="name">Time to end</label>
                <input type="date" name="txtTimeEnd" value="${requestScope.DTO.dateEnd}" size="22"/>


                <label for="name">Place</label>
                <input type="text" name="txtPlace" value="${requestScope.DTO.place}"/>
                
                <label for="name">Image</label>
                <input type="file" name="filebox" value="" /><br/>
              
                

                <label for="name">Status</label>
                <input type="text" name="txtStatus" value="${requestScope.DTO.status}"/>


                <label for="comment">Content</label>
                <textarea name="txtContent" cols="25" rows="10" value="${requestScope.DTO.content}"></textarea>


                &nbsp;
                <button type="submit"  name="action" value="Update" class="btmspace-15">Update Event</button> 
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