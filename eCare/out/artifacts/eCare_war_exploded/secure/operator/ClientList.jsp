<%--
  Created by IntelliJ IDEA.
  User: sevasan
  Date: 3/9/2015
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Clients menu</title>
    <link type="text/css" rel="stylesheet" href="<c:url value='../../css/common.css'/>"/>
</head>
<body>
<div id="wrapper">
    <header>
        <div class="content-wrap">
            <h1>Clients</h1>
            <a href="/logout">
                Logout
            </a>
            <%--<a href="#">--%>
            <%--Hello, <c:out value="${currentUser.getUserName()} ${currentUser.getUserLastName()}"/>--%>
            <%--</a>--%>
        </div>
    </header>
    <nav>
        <ul>
            <li>
                <a href="<c:url value='/secure/operator/Cabinet.jsp'/>">Cabinet</a>
            </li>
            <li>
                <a href="<c:url value='/secure/operator/operator?q=ContractList'/>">Contracts</a>
            </li>
            <li>
                <a href="<c:url value='/secure/operator/operator?q=PlanList'/>">Tariff plans</a>
            </li>
            <li>
                <a href="<c:url value='/secure/operator/operator?q=OptionList'/>">Options</a>
            </li>
            <li>
                <a href="<c:url value='#'/>">Clients</a>
            </li>
        </ul>
    </nav>
    <section id="content" class="clearfix">
        <section id="page-content">
            <div class="content-wrap">
                <table>
                    <tr>
                        <td>Name</td>
                        <td>Last name</td>
                        <td>Email</td>
                    </tr>
                    <c:forEach var="client" items="${ClientList}">
                        <tr>
                            <td>${client.getUserName()}</td>
                            <td>${client.getUserLastName()}</td>
                            <td>${client.getUserEmail()}</td>
                            <td><a
                                    href="<c:url
                                    value='/secure/operator/operator?q=DeleteClient&clientID=${client.getUserID()}'/>">delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </section>
        <aside>
            <div class="content-wrap">
                <form method="post" action="<c:url value='/secure/operator/operator?q=AddClient'/>">
                    <div class="form-element">
                        <label for="name">Name:</label>
                        <input type="text" id="name" name="name"/>
                    </div>
                    <div class="form-element">
                        <label for="lastname">Last name:</label>
                        <input type="text" id="lastname" name="lastname"/>
                    </div>
                    <div class="form-element">
                        <label for="birthdate">Birth date:</label>
                        <input type="date" id="birthdate" name="birthdate"/>
                    </div>
                    <div class="form-element">
                        <label for="idcard">ID card:</label>
                        <input type="text" id="idcard" name="idcard"/>
                    </div>
                    <div class="form-element">
                        <label for="address">Address:</label>
                        <input type="text" id="address" name="address"/>
                    </div>
                    <div class="form-element">
                        <label for="email">Email:</label>
                        <input type="email" id="email" name="email"/>
                    </div>
                    <div class="form-element">
                        <label for="password">Password:</label>
                        <input type="password" id="password" name="password"/>
                    </div>
                    <div class="form-element">
                        <input type="submit" value="Create"/>
                    </div>
                </form>
            </div>
        </aside>
    </section>
</div>
<footer></footer>
</body>
</html>
