<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add User</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Servlet and Jsp</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Main</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/home">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/login">Login</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/users">User list</a>
            </li>
        </ul>

        <div class="navbar-text mr-3">${name}</div>
        ${login},
        <a href="/logout">Logout</a>
    </div>
</nav>
<h1>Add User</h1>
<form action="/" method="post">
    Login<input type="text" name="login"> <br>
    Password<input type="password" name="password"> <br>
    Password again<input type="password" name="password-2"> <br>
    Email<input type="email" name="email"> <br>
    First name<input type="text" name="first_name"> <br>
    Last name<input type="text" name="last_name"> <br>
    Birthday<input type="text" name="birthday"> <br>
    Role<select name="role" id="role">
    <option value="USER">USER</option>
    <option value="ADMIN">ADMIN</option>
</select>
</form>
</body>
</html>