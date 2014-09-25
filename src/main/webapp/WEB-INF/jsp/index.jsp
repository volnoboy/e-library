<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.library.controllers.HomeController" %>

<% boolean exits = false; %>
<div class="jumbotron">
    <div class="container">
        <form class="row">
            <c:forEach var="b" items="${book}">

                <div class="row-lg-4">
                    <label class="checkbox">
                        <input type="checkbox" value="option3">

                        <h3>${b.title} by ${b.authors} </h3>
                        <%exits = true;%>
                    </label>

                    <p><a class="btn btn-default" href="#">View details &raquo;</a></p>
                </div>
            </c:forEach>

            <% if (exits) { %>
            <button type="submit" class="btn btn-lg btn-primary">Order</button>
        </form>

        <ul id="pagination-flickr">
            <% if (HomeController.page >0) { %>
            <li class="next"><a href=${pagePrev}> Previous </a></li>
            <% } %>
            <li class="active"><%=HomeController.page %>
            </li>
            <% if (HomeController.page < HomeController.pageMax - 1) { %>
            <li class="next"><a href=${pageNext}>Next</a></li>
            <% } %>
        </ul>
        <% } %>


    </div>
</div>

