<%--
  Created by IntelliJ IDEA.
  User: sevasan
  Date: 3/9/2015
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Contracts menu</title>
    <link type="text/css" rel="stylesheet" href="<c:url value='../../css/common.css'/>"/>
</head>
<body>
<div id="wrapper">
    <header>
        <div class="content-wrap">
            <h1>Contracts</h1>
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
                <a href="<c:url value='#'/>">Contracts</a>
            </li>
            <li>
                <a href="<c:url value='/secure/operator/operator?q=PlanList'/>">Tariff plans</a>
            </li>
            <li>
                <a href="<c:url value='/secure/operator/operator?q=OptionList'/>">Options</a>
            </li>
            <li>
                <a href="<c:url value='/secure/operator/operator?q=ClientList'/>">Clients</a>
            </li>
        </ul>
    </nav>
    <section id="content" class="clearfix">
        <section id="page-content">
            <div class="content-wrap">
                <table>
                    <tr>
                        <td>Number</td>
                        <td>Email</td>
                        <td>Plan</td>
                    </tr>
                    <c:forEach var="contract" items="${ContractList}">
                        <tr>
                            <td>${contract.getPhonenumber()}</td>
                            <td>${option.getClient().getUserEmail()}</td>
                            <td>${option.getPlan().getPlanTitle()}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </section>
        <aside>
            <div class="content-wrap">
                Client info here.
            </div>
        </aside>
    </section>
</div>
<footer></footer>
</body>
</html>