<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="form-signin" >
    <h2 class="form-signin-heading">Add new author</h2>
    <input type="text" id="firstname" name="firstname" class="form-control" placeholder="Firstname">
    <input type="text" id="lastname" name="lastname" class="form-control" placeholder="Lastname">
    <button class="btn btn-lg btn-primary btn-block" type="submit"  onclick="save()">Add author</button>
</form>

<div> <p> List of authors</p>
<ol>
    <c:forEach var="a" items="${authors}">
<li> ${a.firstname}  ${a.lastname}</li>
    </c:forEach>
</ol>
</div>


<script type="text/javascript">
    function save() {
        var author = {};
        author['firstname'] = document.getElementById("firstname").value;
        author['lastname'] = document.getElementById("lastname").value;
        $.ajax({
            url: '/author/save',
            type: 'POST',
            data: author
        });
    }
</script>