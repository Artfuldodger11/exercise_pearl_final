<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="css" value="styles/addPage.css"/>
<link type="text/css" rel="stylesheet" href="${css}" media="screen,projection"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head><%@ page isELIgnored="false" %></head>
<body>


<div class="form-style-6">
    <h1>Add XML RSS Feed </h1>
    <form action="add_feed" name = "add_feed" method="get">
        <input type="text" name="rss_feed_url" placeholder="RSS Feed URL"  required/>
        <input type="text" name="rss_feed_name" placeholder="RSS Feed Name" required/>

        <input type="submit" value="Add Feed" />

    </form>
</div>
<div class="form-style-6" >
    <form method="GET" action="/feedList">
        <input type="submit" value="Feed List">
    </form>
    ${Feed_added_message}
</div>


</body>
</html>

