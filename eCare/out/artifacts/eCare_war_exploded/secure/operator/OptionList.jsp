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
    <title>Options menu</title>
    <link type="text/css" rel="stylesheet" href="<c:url value='../../css/common.css'/>"/>
    <script type="text/javascript" src="<c:url value='/js/jquery-1.11.2.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/option-list-modify.js'/>"></script>
</head>
<body>
<div id="wrapper">
    <header>
        <div class="content-wrap">
            <h1>Options</h1>
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
                <a href="<c:url value='#'/>">Options</a>
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
                        <td>Title</td>
                        <td>Price</td>
                        <td>Activation</td>
                    </tr>
                    <c:forEach var="option" items="${OptionList}">
                        <tr>
                            <td>${option.getOptionTitle()}</td>
                            <td>${option.getOptionPrice()}</td>
                            <td>${option.getOptionActivationPrice()}</td>
                            <td><a
                                    href="<c:url
                                    value='/secure/operator/operator?q=DeleteOption&optionID=${option.getOptionID()}'
                                    />">delete</a>
                            </td>
                            <td><a id="modify${option.getOptionID()}" href="<c:url
                            value='/secure/operator/operator?q=ViewOption&optionID=${option.getOptionID()}'/>">modify
                            </a>
                                <input type="hidden" id="option-view-trigger" value="${optionView}"/>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </section>
        <aside>
            <div class="content-wrap">
                <form method="post" action="<c:url value='/secure/operator/operator?q=AddOption'/>">
                    <div class="form-element">
                        <label for="title">Title:</label>
                        <input type="text" id="title" name="title"/>
                    </div>
                    <div class="form-element">
                        <label for="price">Price:</label>
                        <input type="number" id="price" name="price"/>
                    </div>
                    <div class="form-element">
                        <label for="activation-price">Activation price:</label>
                        <input type="number" id="activation-price" name="activationPrice"/>
                    </div>
                    <div class="form-element">
                        <input type="submit" value="Create"/>
                    </div>
                </form>
            </div>
        </aside>
    </section>
</div>
<div id="overlay"></div>
<div class="modal-dialog">
    <a id="modify-close" href="#">close</a>
    <c:choose>
        <c:when test="${currentOption != null}">
            <input type="hidden" name="optionID" value="${currentOption}"/>
            <table>
                <c:forEach var="reqOption" items="${currentOption.getRequiredOptions()}">
                    <tr>
                        <td>
                            ${reqOption.getOptionTitle()}
                        </td>
                        <td>
                            <a
                                    href="<c:url value='/secure/operator/operator?q=RemoveReqOption&reqOptionID
                                    =${reqOption.getOptionID()}'/>">delete</a>
                            <%--<c:choose>--%>
                                <%--<c:when test="${currentOption.getRequiredOptions().contains(reqOption)}">--%>
                                    <%--<input type="checkbox" id="box${reqOption.getOptionID()}"--%>
                                               <%--name="required-option" value="${reqOption.getOptionID()}"--%>
                                               <%--checked="checked">--%>
                                <%--</c:when>--%>
                                <%--<c:otherwise>--%>
                                    <%--<input type="checkbox" id="box${reqOption.getOptionID()}"--%>
                                           <%--name="required-option" value="${reqOption.getOptionID()}">--%>
                                <%--</c:otherwise>--%>
                            <%--</c:choose>--%>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <form id="add-req-option" method="post" action="<c:url
            value='/secure/operator/operator?q=AddReqOption&optionID=${currentOption.getOptionID()}'/>">
                <div class="form-element">
                    <input type="text" placeholder="Title" id="reqOptionTitle" name="reqOptionTitle">
                </div>
                <div class="form-element">
                    <input type="submit" value="Add">
                </div>
            </form>
        </c:when>
        <c:otherwise>
            <br>
            empty
        </c:otherwise>
    </c:choose>
</div>
<footer></footer>
</body>
</html>
