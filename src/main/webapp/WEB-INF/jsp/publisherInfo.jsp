<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="form-signin" >
    <h2 class="form-signin-heading">Add new publisher</h2>
    <input type="text" id="name" name="name" class="form-control" placeholder="Name">
    <button class="btn btn-lg btn-primary btn-block" type="submit"  onclick="save()">Add book</button>
</form>

<div> <p> List of publishers</p>
    <ol>
        <c:forEach var="p" items="${publishers}">
            <li> ${p.name}</li>
        </c:forEach>
    </ol>
</div>


<script type="text/javascript">
    function save() {
        var publisher = {};
        publisher['name'] = document.getElementById("name").value;

        $.ajax({
            url: '/publisher/save',
            type: 'POST',
            data: publisher
        });
    }
</script>