<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="headerAd.jsp" %>
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

<div class="wrapper row2">
    <h2>Suggest event</h2>

    <c:forEach var="dto" items="${sessionScope.LOADSUGG}" varStatus="counter">
        <c:if test="${not empty dto}">
            <tr>
                <td>Title Suggest Event: ${dto.titleSug}</td>
            </tr>
            <tr>
                <td>Time To Start: ${dto.timeStartSug}</td>
              
        </tr>
        <tr>
            <td>Time To End: ${dto.timeEndSug}</td>
          
        </tr>    
    </c:if>
</c:forEach>

</div>          









