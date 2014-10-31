<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <form class="form-signin">
        <h2 class="form-signin-heading">Add new book</h2>
        <input type="text" id="title" name="title" class="form-control" placeholder="Title">
        <input type="text" id="isbn" name="isbn" class="form-control" placeholder="ISBN">

        <p><select name="authors" id="authors">
            <c:forEach var="a" items="${authors}">
                <option value="${a.objectId}">${a}</option>
            </c:forEach>
        </select>
            <button type="submit" onclick="authorsInfo()"> Add Author</button>

        <p><select name="publishers" id="publishers">
            <c:forEach var="p" items="${publishers}">
                <option value="${p.objectId}">${p.name}</option>
            </c:forEach>

        </select>
            <button type="submit"> Add Publisher</button>
        </p>

        <button class="btn btn-lg btn-primary btn-block" type="submit" onclick="getData()">Add book</button>
    </form>
</div>

<script type="text/javascript">
    function getData( ) {
        var bookDTO = {};
        var authorIds= {};
        bookDTO['title'] = document.getElementById("title").value;
        bookDTO['isbn'] = document.getElementById("isbn").value;
        authorIds =$('#authors').val();
        bookDTO['authorIds'] = authorIds;
        bookDTO['publisherId'] = $('#publishers').val();
        $.ajax({
            url: '/book/save',
            type: 'POST',
            data: bookDTO
        });
    }

    function authorsInfo() {
        $.get('/author/');
    }


</script>