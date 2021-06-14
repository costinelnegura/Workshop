<%--
  Created by IntelliJ IDEA.
  User: Costinel.G
  Date: 19/05/2021
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
<style>
    * {
        box-sizing: border-box;
    }

    body {
        font-family: Arial, Helvetica, sans-serif;
    }

    /* Style the header */
    header {
        background-color: #666;
        padding: 30px;
        text-align: center;
        font-size: 35px;
        color: white;
    }

    /* Create two columns/boxes that floats next to each other */
    nav {
        float: left;
        width: 30%;
        height: 300px; /* only for demonstration, should be removed */
        background: #ccc;
        padding: 20px;
    }

    /* Style the list inside the menu */
    nav ul {
        list-style-type: none;
        padding: 0;
    }

    article {
        float: left;
        padding: 20px;
        width: 70%;
        background-color: #f1f1f1;
        height: 300px; /* only for demonstration, should be removed */
    }

    /* Clear floats after the columns */
    section::after {
        content: "";
        display: table;
        clear: both;
    }

    /* Style the footer */
    footer {
        background-color: #777;
        padding: 10px;
        text-align: center;
        color: white;
    }

    /* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
    @media (max-width: 600px) {
        nav, article {
            width: 100%;
            height: auto;
        }
    }

    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
    }

    .center {
        margin-left: auto;
        margin-right: auto;
    }
</style>
</head>
<body>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<header>
    <h1>Workshop</h1>
    <h3>
        <a href="${contextPath}/newJob">New </a><a href="${contextPath}/home">Home </a>
        <a href="${contextPath}/invoice">Invoice </a><a href="${contextPath}/tools">Tools</a>
    </h3>

    <form action="search">
        <input type="text" name="registration" placeholder="Search registration">
        <input type="submit" value="Search">
    </form>
</header>

<section>

<table class="center">
    <tr>
        <th>Customer Name</th>
        <th>Vehicle Registration</th>
        <th>Vehicle Make</th>
        <th>Vehicle Model</th>
        <th>...</th>
    </tr>
    <sql:query var="rs" dataSource="jdbc/workshop_db">
        SELECT * FROM claim
    </sql:query>

    <c:forEach var="row" items="${rs.rows}">
        <tr>
            <th>${row.salutation} ${row.first_name} ${row.last_name}</th>
            <th>${row.vehicle_registration}</th>
            <th>${row.vehicle_make}</th>
            <th>${row.vehicle_model}</th>
            <th><a href="">Select</a></th>
        </tr>
    </c:forEach>
</table>





</section>

<footer>
    <p>Workshop 2021</p>
    <p>Made by Costinel Negura</p>
</footer>


</body>
</html>
