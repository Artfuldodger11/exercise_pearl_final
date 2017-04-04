<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="css" value="styles/feedItemsList.css"/>

<link type="text/css" rel="stylesheet" href="${css}" media="screen,projection"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Feed items list</title>
</head>
<body>


<div>

    <h2>Feed</h2> <h1>${model.feedName.getFeed_name()}</h1>
    <h4>total amount of articles : ${model.feedItemsList.size()}</h4>


    <ul>

        <c:forEach  items="${model.feedItemsList}" var="item" begin="0" end="5" varStatus="loop">

                <h3>Title</h3>
                <div class="line1" >${item.getItemTitle()}</div>
                <h3>Description</h3>
                <div class="line2">${item.getItemDescription()}</div>
                <h3>Published date</h3>
                <div class="line1">${item.getItemPublished()}</div>
                <div class="line2"><a href="<c:url value='${item.getItemLink()}' />">Details</a></div>
            <hr color="#f00" height="5px">
        </c:forEach>

    </ul>

</div>

</body>
</html>
