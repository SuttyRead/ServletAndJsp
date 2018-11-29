<%--
  Created by IntelliJ IDEA.
  User: suttyread
  Date: 28.11.18
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="usersListTag" prefix="my" %>--%>
<%@ taglib prefix="my" uri="/WEB-INF/implicit.tld" %>
<%--<%@ taglib prefix = "c" uri = "javatpoint"%>--%>
<%--<%@ taglib prefix = "c" uri = "javatpoint"%>--%>
<%--<%@ taglib prefix="usertag"--%>
           <%--uri="usersTag" %>--%>
<html>
<head>
    <title>Title</title>
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
                <a class="nav-link" href="/main">Main</a>
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
Hello, admin

<my:myTag users="${users}" roles="${roles}"/>
<%--<my:userslist listOfUsers="${users}"/>--%>
<%--<c:Print users="${users}"/>--%>
<%--<usertag:Print users="${users}"/>--%>
</body>
</html>
