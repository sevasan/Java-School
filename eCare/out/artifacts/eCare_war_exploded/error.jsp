<%--
  Created by IntelliJ IDEA.
  User: sevasan
  Date: 3/9/2015
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Error</title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/common.css'/>"/>
    <script type="text/javascript" src="<c:url value='/js/jquery-1.11.2.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/login-validation.js'/>"></script>
</head>
<body>
<div id="wrapper">
    <header>
        <h1>Error</h1>
    </header>
    <section id="content" class="clearfix">
        <section id="login-section">
            <div class="content-wrap">
                <div id="error-page">
                    <a href="<c:url value='/LoginPage.jsp'/>">Login page.</a>
                </div>
            </div>
        </section>
    </section>
    <div id="empty-div"></div>
</div>
<footer></footer>
</body>
</html>
