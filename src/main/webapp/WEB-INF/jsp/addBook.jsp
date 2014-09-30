<div class="container">

    <form class="form-signin" >
        <h2 class="form-signin-heading">Add new book</h2>
        <input type="text" id="title" name="title" class="form-control" placeholder="Title">
        <input type="text" id="isbn" name="isbn" class="form-control" placeholder="ISBN">
        <input type="text" id="authors" name="authors" class="form-control" placeholder="Authors">
        <input type="text" id="publisher" name="publisher" class="form-control" placeholder="Publisher">

        <button class="btn btn-lg btn-primary btn-block" type="submit"  onclick="getData()">Add book</button>
    </form>


</div>
<script type="text/javascript">
    function getData() {
        $.ajax({
            url: '/book/save',
            type: 'POST',
            data:  {
                title:document.getElementById("title").value,
                isbn:document.getElementById("isbn").value,
                firstname :document.getElementById("authors").value.split(';')[0],
                lastname:document.getElementById("authors").value.split(';')[1],
                publisher:document.getElementById("publisher").value
            }
        });
    }
</script>