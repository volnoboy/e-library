<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <div class="form-signin">
        <h2 class="form-signin-heading">Add new book</h2>
        <input type="text" id="title" name="title" class="form-control" placeholder="Title">
        <input type="text" id="isbn" name="isbn" class="form-control" placeholder="ISBN">

        <p>Author - <select name="authors" id="authors">
            <c:forEach var="a" items="${authors}">
                <option value="${a.objectId}">${a}</option>
            </c:forEach>
        </select></p>

        <p>Publisher - <select name="publishers" id="publishers">
            <c:forEach var="p" items="${publishers}">
                <option value="${p.objectId}">${p.name}</option>
            </c:forEach>
        </select></p>

        <button class="btn btn-lg btn-primary btn-block" type="submit" onclick="getData()" >Add book</button>
    </div>


<script type="text/javascript">
    function getData( ) {
        var bookDTO = {};
        var authorIds= {};
        bookDTO['title'] = $('#title').val();
        bookDTO['isbn'] = $('#isbn').val();
        authorIds =$('#authors').val();
        bookDTO['authorIds'] = authorIds;
        bookDTO['publisherId'] = $('#publishers').val();
        $.ajax({
            url: '/bookRest/save',
            type: 'POST',
            data: bookDTO,
            success: function(id){
                document.location.href = "/book/"+id;
            }
        });
    }
</script>