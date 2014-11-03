<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html">e-library</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li>
                    <a href="/index">Home</a>
                </li>
                <li>
                    <a href="/userPage">Userpage</a>
                </li>
                <li>
                    <a href="/adminPage">Adminpage</a>
                </li>
                <li >
                    <a href="/book">Add Book</a>
                </li>
                <li >
                    <a href="/author">Add Author</a>
                </li>
                <li >
                    <a href="/publisher">Add Publisher</a>
                </li>
                <li>
                    <form class="navbar-form navbar-right" action="/book/find" method="get">
                        <div class="form-group">
                            <input type="text" name="name" placeholder class="form-control">
                        </div>
                        <button type="submit" class="btn btn-success">Find book</button>
                    </form>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="/signOut">Sign up</a>
                </li>
                <li>
                    <a href="/signIn">Sign in</a>
                </li>
            </ul>
        </div>
        <!--/.navbar-collapse -->
    </div>
</div>