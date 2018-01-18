<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>
<div class="wrapper row4">
  <footer id="footer" class="hoc clear"> 
    <!-- ################################################################################################ -->
    
  
    <div class="one_quarter">
      <h6 class="title">Login</h6>
      <p class="btmspace-30">Dream can not come true unless you do</p>
      <c:if test="${sessionScope.ROLE eq 'admin'}">
          
     
      <form method="POST" action="MainController">
        <fieldset>
         
            <input class="btmspace-15" type="text" name="txtUsername" placeholder="Username" required value="${param.txtUsername}">
            <c:if test="${not empty requestScope.INVALID}">
                <font color="red">
                ${requestScope.INVALID.usernameErr}
                ${requestScope.INVALID.usernameExisted}
                </font>
            </c:if>
            <input class="btmspace-15" type="password" name="txtPassword" placeholder="Password" required>
            <c:if test="${not empty requestScope.INVALID}">
                <font color="red">
                ${requestScope.INVALID.passwordErr}
                </font>
            </c:if>
            <input class="btmspace-15" type="password" name="txtConfirm" placeholder="Confirm Password" required>
            <c:if test="${not empty requestScope.INVALID}">
                <font color="red">
                ${requestScope.INVALID.confirmErr}
                </font>
            </c:if>
                <input class="btmspace-15" type="text" name="txtFullname" placeholder="Fullname" required value="${param.txtFullname}">
            <input class="btmspace-15" type="text" name="txtRole" placeholder="Role" value="staff" readonly="true">
            
          
          <button type="submit" value="Register" name="action">Register</button><br/>
          <button type="reset" value="Reset" name="action">Reset</button>
        </fieldset>
      </form>
             </c:if> 
    </div>
  
    <!-- ################################################################################################ -->
  </footer>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row5">
  <div id="copyright" class="hoc clear"> 
    <!-- ################################################################################################ -->
    <p class="fl_left">Copyright &copy; 2015 - All Rights Reserved - <a href="#">Domain Name</a></p>
    <p class="fl_right">Template by <a target="_blank" href="http://www.os-templates.com/" title="Free Website Templates">OS Templates</a></p>
    <!-- ################################################################################################ -->
  </div>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
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