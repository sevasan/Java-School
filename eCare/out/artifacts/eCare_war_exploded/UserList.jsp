<%--
  Created by IntelliJ IDEA.
  User: sevasan
  Date: 3/1/2015
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<table>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>
                ${user}
                <a href='/delete?userName=<c:out value="${user}"/>'>delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
