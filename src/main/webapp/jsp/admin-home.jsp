<%--
  Created by IntelliJ IDEA.
  User: suttyread
  Date: 28.11.18
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://rborulchenko.com/tags" prefix="myTags" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>
<%@ include file = "header.jsp" %>

Hello, admin

<a href="/add">Add new User</a>

<div class="col-sm-offset-3 col-sm-6 err-message">
    <c:if test="${successfullDelete == 1}">
        <div class="alert alert-success" role="alert">
            User was successfully delete!
        </div>
    </c:if>
</div>

<myTags:printTable userList="${users}"/>

</body>
</html>
