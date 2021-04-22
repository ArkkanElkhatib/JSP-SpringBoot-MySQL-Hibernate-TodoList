<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Items page</title>
    <link href="<c:url value='/static/styles/root.css' />"  rel="stylesheet"></link>
    <link href="<c:url value='/static/styles/header.css' />"  rel="stylesheet"></link>
    <link href="<c:url value='/static/styles/items.css' />"  rel="stylesheet"></link>
    <link href="<c:url value='/static/styles/footer.css' />"  rel="stylesheet"></link>
</head>
<body>
    <%@include file="header.jsp" %>
    <div>
        <h1>Welcome to the items page!</h1>
        <div class="items__container">
            <c:forEach items="${items}" var="item">
                <div class="item__container">
                    <div>${item.id}</div>
                    <a href="/items/${item.id}">${item.title}</a>
                    <div>${item.description}</div>
                </div>
            </c:forEach>
        </div>
    </div>
    <form method="POST" class="add-item__container">
        <input type="text" name="title" class="add-item__title" placeholder="Title" />
        <input type="text" name="description" class="add-item__desc" placeholder="Description" />
        <input type="submit" value="Add" />
    </form>
    <%@include file="footer.jsp" %>
</body>
</html>