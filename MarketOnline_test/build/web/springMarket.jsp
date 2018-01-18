<%@page import="nhi.dtos.PostInformationDTO"%>
<%@page import="nhi.daos.PostInformationDAO"%>
<%@include file="header.jsp" %>

<div class="wrapper row3">
    <main class="hoc container clear"> 
        <!-- main body -->
        <!-- ################################################################################################ -->
        <div class="content"> 
            <form action="MainController" method="POST">
                <select name="listSort">
                    <option value="1">Spring Market</option>
                    <option value="2">Summer Market</option>
                    <option value="3">Winter Market</option>
                </select>
                <button type="submit"  name="action" value="Sort" class="btmspace-15">SORT EVENT</button> 
            </form>

            <!-- ################################################################################################ -->
            <div id="gallery">
                <figure>

                    <c:if test="${not empty requestScope.LISTE}">
                          
                        <c:forEach items="${requestScope.LISTE}" var="dto">
                            <header class="heading">${dto.kindOfEvent}</header>
                            <ul class="nospace clear">  
                              
                                <li class="one_quarter first">
                                    <a href="farmer.jsp"><img src="${dto.img}" alt="${dto.title}"></a>
                                    <div class="txtwrap">
                                        <p>${dto.title}</p>  
                                        <p>Start:${dto.dateStart}</p>
                                        <p>End:${dto.dateEnd}</p>
                                        <p>Status:${dto.status}</p>
                                        <p>${dto.content}</p>

                                    </div>
                                </li>
                            </ul>
                        </c:forEach>

                    </c:if>
                    
                    <%--
                    <%
                        PostInformationDAO dao = new PostInformationDAO();
                        String categoryId = null;
                        if (request.getParameter("category") != null) {
                            categoryId = request.getParameter("category");
                        }
                    %>                  

                    <%
                        for (PostInformationDTO dto : dao.getListEventByCategory(Long.parseLong(categoryId))) {
                    %>
                    <ul class="nospace clear">  
                        <header class="heading"><%=dto.getKindOfEvent()%></header>
                        <li class="one_quarter first">
                            <a href="farmer.jsp"><img src="<%=dto.getImg()%>" alt="<%=dto.getTitle()%>"></a>
                            <div class="txtwrap">
                                <p><%=dto.getTitle()%></p>  
                                <p>Start:<%=dto.getDateStart()%></p>
                                <p>End:<%=dto.getDateEnd()%></p>
                                <p>Status:<%=dto.getStatus()%></p>
                                <p><%= dto.getContent()%></p>

                            </div>
                        </li>
                    </ul>
                    <%
                        }
                    %> --%>

                    <figcaption>Gallery Description Goes Here</figcaption>
                </figure>
            </div>
            <!-- ################################################################################################ -->
            <!-- ################################################################################################ -->
            <nav class="pagination">
                <ul>
                    <li><a href="#">&laquo; Previous</a></li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><strong>&hellip;</strong></li>
                    <li><a href="#">6</a></li>
                    <li class="current"><strong>7</strong></li>
                    <li><a href="#">8</a></li>
                    <li><a href="#">9</a></li>
                    <li><strong>&hellip;</strong></li>
                    <li><a href="#">14</a></li>
                    <li><a href="#">15</a></li>
                    <li><a href="#">Next &raquo;</a></li>
                </ul>
            </nav>
            <!-- ################################################################################################ -->
        </div>
        <!-- ################################################################################################ -->
        <!-- / main body -->
        <div class="clear"></div>
    </main>
</div>