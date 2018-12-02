<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit User</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>

<%@ include file = "header.jsp" %>



<h1>Edit User</h1>
<form method="post" class="form-horizontal" action="/edit">
    <input type="hidden" name="id" value="${someUser.id}">
    <input type="hidden" name="action" value="${someUser.id == null ? 'create' : 'update'}">
    <div class="form-group">
        <label class="control-label col-sm-3"
               for="login">Login:</label>
        <div class="col-sm-6">
            <input
            <c:if test="${someUser.id != null}">
                    readonly="readonly" </c:if>
                    type="text"
                    class="form-control"
                    id="login"
                    placeholder="Enter login"
                    name="login"
                    value="${someUser.login}">
        </div>

        <div class="col-sm-offset-3 col-sm-6 err-message">
            <c:if test="${loginMessage != null}">
                <c:out value="${loginMessage}"/>
            </c:if>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-3"
               for="password">Password:</label>
        <div class="col-sm-6">
            <input type="password" class="form-control" id="password"
                   placeholder="Enter password" name="password"
                   value="${someUser.password}">
        </div>
        <div class="col-sm-offset-3 col-sm-6 err-message">
            <c:if test="${passwordNotEquals != null}">
                <div class="alert alert-danger" role="alert">
                    Password don't match!
                </div>
            </c:if>
            <div class="col-sm-offset-3 col-sm-6 err-message">
                <c:if test="${passwordNotPattern != null}">
                    <div class="alert alert-danger" role="alert">
                        This login doesn't match pattern
                        (?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$
                        Lowercase and uppercase Latin letters, numbers, special characters. Minimum 8 characters
                    </div>
                </c:if>
            </div>
        </div>
    </div>



    <div class="form-group">
        <label class="control-label col-sm-3"
               for="confirmPassword">Confirm Password:</label>
        <div class="col-sm-6">
            <input type="password" class="form-control" id="confirmPassword"
                   placeholder="Confirm password" name="confirmPassword" value="${someUser.password}">
        </div>
        <div class="col-sm-offset-3 col-sm-6 err-message">
            <c:if test="${confirmPasswordMessage != null}">
                <c:out value="${confirmPasswordMessage}"/>
            </c:if>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-3"
               for="email">Email:</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="email"
                   placeholder="Enter email" name="email"
                   value="${someUser.email}">
        </div>
        <div class="col-sm-offset-3 col-sm-6 err-message">
            <c:if test="${emailNotPattern != null}">
                <div class="alert alert-danger" role="alert">
                    This email doesn't match pattern
                    \w+([\.-]?\w+)*@\w+([\.-]?\w+)*\.\w{2,4}
                </div>
            </c:if>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-3"
               for="First Name">First Name:</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="First Name"
                   placeholder="Enter first name" name="firstName"
                   value="${someUser.firstName}">
        </div>
        <div class="col-sm-offset-3 col-sm-6 err-message">
            <c:if test="${firstNameMessage != null}">
                <c:out value="${firstNameMessage}"/>
            </c:if>
        </div>

    </div>
    <div class="form-group">
        <label class="control-label col-sm-3"
               for="Last Name">Last Name:</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="Last Name"
                   placeholder="Enter last name" name="lastName"
                   value="${someUser.lastName}">
        </div>
        <div class="col-sm-offset-3 col-sm-6 err-message">
            <c:if test="${lastNameMessage != null}">
                <c:out value="${lastNameMessage}"/>
            </c:if>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-3"
               for="Birthday">Birthday:</label>
        <div class="col-sm-6">
            <input type="date" class="form-control" id="Birthday"
                   placeholder="Enter birthday" name="birthday"
                   value="${someUser.birthday}">
        </div>
        <div class="col-sm-offset-3 col-sm-6 err-message">
            <c:if test="${incorrectDate != null}">
                <div class="alert alert-danger" role="alert">
                    Incorrect birthday
                </div>
            </c:if>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-3"
               for="Role">Role:</label>
        <div class="col-sm-6">
            <select class="form-control" id="Role" name="role">
                <c:choose>
                    <c:when test="${someUser.roleId == 1}">
                        <option value="1">Admin</option>
                        <option value="2">User</option>
                    </c:when>
                    <c:otherwise>
                        <option value="2">User</option>
                        <option value="1">Admin</option>
                    </c:otherwise>
                </c:choose>
            </select>
        </div>
        <div class="col-sm-offset-3 col-sm-6 err-message">
            <c:if test="${roleIdMessage != null}">
                <c:out value="${roleIdMessage}"/>
            </c:if>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-1 col-sm-offset-4">
            <button type="submit" class="btn btn-success">OK</button>
        </div>
        <div class="col-sm-1">
            <a href="/home"
               class="btn btn-primary"
               role="button"
               aria-pressed="true">Cancel</a>
        </div>
    </div>
</form>
</body>
</html>