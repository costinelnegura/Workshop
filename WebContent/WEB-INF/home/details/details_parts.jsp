<%--
  Created by IntelliJ IDEA.
  User: costinelnegura
  Date: 15/06/2021
  Time: 15:45
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
    <nav>
        <ul>
            <li><a href="${contextPath}/details_customer?id=${customer.id}">Customer</a></li>
            <li><a href="${contextPath}/details_vehicle?id=${customer.id}">Vehicle</a></li>
            <li><a href="${contextPath}/details_delivery_collection?id=${customer.id}">Delivery/Collection</a></li>
            <li><a href="${contextPath}/details_claim?id=${customer.id}">Claim Details</a></li>
            <li><a href="${contextPath}/details_notes?id=${customer.id}">Notes</a></li>
            <li><a href="${contextPath}/details_images?id=${customer.id}">Images</a></li>
            <li><a href="${contextPath}/details_history?id=${customer.id}">History</a></li>
            <li><a href="${contextPath}/details_labour?id=${customer.id}">Labour</a></li>
            <li><a href="${contextPath}/details_parts?id=${customer.id}">Parts</a></li>
            <li><a href="${contextPath}/details_extra_charges?id=${customer.id}">Extra Charges</a></li>
            <li><a href="${contextPath}/details_estimate?id=${customer.id}">Estimate</a></li>
        </ul>
    </nav>

    <article>
        <h1>Parts</h1>

    </article>
</section>

<footer>
    <p>Workshop 2021</p>
    <p>Made by Costinel Negura</p>
</footer>

</body>
</html>

