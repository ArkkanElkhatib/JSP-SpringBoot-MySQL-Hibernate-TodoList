<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Home page</title>
    <link href="<c:url value='/static/styles/root.css' />"  rel="stylesheet"></link>
    <link href="<c:url value='/static/styles/header.css' />"  rel="stylesheet"></link>
    <link href="<c:url value='/static/styles/home.css' />"  rel="stylesheet"></link>
    <link href="<c:url value='/static/styles/footer.css' />"  rel="stylesheet"></link>
</head>
<body>
    <%@include file="header.jsp" %>
    <div>
        <h1>Welcome to Home page!</h1>
    </div>
    <%@include file="footer.jsp" %>
</body>
</html>