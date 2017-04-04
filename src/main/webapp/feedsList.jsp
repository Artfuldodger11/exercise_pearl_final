<%@ page import="java.util.List" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="css" value="styles/feedList.css"/>
<link type="text/css" rel="stylesheet" href="${css}" media="screen,projection"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <%@ page isELIgnored="false" %>
    <title>Feed List</title>
</head>
<body>

<%
List<?> feedsList = (List<?>) request.getAttribute("feedsList");
%>
<div>
    <h2>Feed List</h2>
    <ul>
        <c:forEach items="${feedsList}" var="feed">
            <li><a href="<c:url value='${feed.getId()}' />">${feed.getFeed_name()}</a></li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
