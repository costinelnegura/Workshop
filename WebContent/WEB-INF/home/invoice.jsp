<%--
  Created by IntelliJ IDEA.
  User: Costinel.G
  Date: 20/05/2021
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<head>
    <title>Workshop - Invoice</title>
    <h3>
        <a href="${contextPath}/newJob">New </a><a href="${contextPath}/home">Home </a>
        <a href="${contextPath}/invoice">Invoice </a><a href="${contextPath}/tools">Tools</a>
    </h3>

    <form action="search">
        <input type="text" name="registration" placeholder="Search registration">
        <input type="submit" value="Search">
    </form>
</head>
<body>

    <p align="center">Under Construction...</p>

</body>
</html>
