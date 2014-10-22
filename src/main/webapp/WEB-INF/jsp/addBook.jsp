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
        var author = {};
        author['firstname'] = document.getElementById("authors").value;
        author['lastname'] = document.getElementById("authors").value;

        var book = {};
        book['title'] = document.getElementById("title").value;
        book['isbn'] = document.getElementById("isbn").value;
        book['authors'] = [author];
        book['publisher'] = document.getElementById("publisher").value;

        console.log("Post book: " + JSON.stringify(book));
        $.ajax({
            url: '/book/save',
            type: 'POST',
            data: book
        });

    }
</script>