<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sevasan
  Date: 3/5/2015
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Page</title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/common.css'/>"/>
    <script type="text/javascript" src="<c:url value='/js/jquery-1.11.2.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/login-validation.js'/>"></script>
</head>
<body>
<div id="wrapper">
    <header>

    </header>
    <section id="content" class="clearfix">
        <section id="login-section">
            <div class="content-wrap">
                <h1>Login form</h1>
                <div class="error" id="error-empty-input">
                    Enter valid email and password.
                </div>
                <form id="login-form" method="post" action="<c:url value='/login'/>"
                      onsubmit="return validateForm()">
                    <div class="form-element">
                        <label for="email">Email:</label>
                        <input type="text" id="email" name="email"/>
                    </div>
                    <div class="form-element">
                        <label for="password">Password:</label>
                        <input type="password" id="password" name="password"/>
                    </div>
                    <div class="form-element">
                        <input type="submit" value="Log in"/>
                    </div>
                </form>
            </div>
        </section>
    </section>
    <div id="empty-div"></div>
</div>
<footer></footer>
</body>
</html>
