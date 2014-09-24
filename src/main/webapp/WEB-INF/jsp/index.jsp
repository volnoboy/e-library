<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.library.controllers.HomeController" %>


<div class="jumbotron">
    <div class="container">
        <form class="row">
     <c:forEach var="b" items="${book}">
    <div class="row-lg-4">
    <label class="checkbox">
    <input type="checkbox"  value="option3">
    <h3>${b.title} by ${b.authors} </h3>

    </label>

    <p><a class="btn btn-default" href="#">View details &raquo;</a></p>
    </div>
     </c:forEach>
            <button type="submit" class="btn btn-lg btn-primary">Order</button>
        </form>
    </div>
</div>

<ul id="pagination-flickr">
    <li class="next"><a href=${pagePrev} >  Previous </a></li>
    <li class="active"><%=HomeController.page %></li>
    <li class="next"><a href=${pageNext}>Next</a></li>
</ul>