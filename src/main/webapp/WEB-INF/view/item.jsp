<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Item page</title>
    <link href="<c:url value='/static/styles/root.css' />"  rel="stylesheet"></link>
    <link href="<c:url value='/static/styles/header.css' />"  rel="stylesheet"></link>
    <link href="<c:url value='/static/styles/item.css' />"  rel="stylesheet"></link>
    <link href="<c:url value='/static/styles/footer.css' />"  rel="stylesheet"></link>
</head>
<body>
    <%@include file="header.jsp" %>
    <h1>Welcome to the item page!</h1>
    <div class="item__container">
        <h2>Id: ${item.id}</h2>
        <h3>Title: ${item.title}</h3>
        <p>Description: ${item.description}</p>
    </div>
    <%@include file="footer.jsp" %>
</body>
</html>