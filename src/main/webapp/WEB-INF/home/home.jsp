<%--
  Created by IntelliJ IDEA.
  User: Costinel.G
  Date: 17/05/2021
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home - Workshop</title>
</head>
<body>

<c:forEach var="messageItem" items="${myList}">
    <c:out value="${messageItem}"></c:out>
</c:forEach>

</body>
</html>
