<%--
  Created by IntelliJ IDEA.
  User: costinelnegura
  Date: 15/06/2021
  Time: 15:38
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
            height: 500px; /* only for demonstration, should be removed */
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
            height: 500px; /* only for demonstration, should be removed */
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
            <li><a href="#">Delivery/Collection</a></li>
            <li><a href="#">Claim Details</a></li>
            <li><a href="#">Notes</a></li>
            <li><a href="#">Images</a></li>
            <li><a href="#">History</a></li>
            <li><a href="#">Labour</a></li>
            <li><a href="#">Parts</a></li>
            <li><a href="#">Extra Charges</a></li>
            <li><a href="#">Estimate</a></li>
        </ul>
    </nav>

    <article>
        <h1>Customer</h1>

        <c:set var="customer" value="${customer}"/>

        <form action="updateCustomer">
            <div class="row">
                <div class="column">
                    <label>Salutation:</label>
                </div>
                <div class="column">
                    <select name="salutation" id="salutation">
                        <c:choose>
                            <c:when test="${customer.salutation == 'Mr'}">
                                <option selected value="Mr">Mr</option>
                                <option value="Mrs">Mrs</option>
                                <option value="Miss">Miss</option>
                            </c:when>
                            <c:when test="${customer.salutation == 'Mrs'}">
                                <option value="Mr">Mr</option>
                                <option selected value="Mrs">Mrs</option>
                                <option value="Miss">Miss</option>
                            </c:when>
                            <c:otherwise>
                                <option value="Mr">Mr</option>
                                <option value="Mrs">Mrs</option>
                                <option selected value="Miss">Miss</option>
                            </c:otherwise>
                        </c:choose>
                    </select>
                </div>
            </div>
            <div class="row">
                <div class="column">
                    <label for="fname">First name:</label>
                </div>
                <div class="column">
                    <input type="text" id="fname" name="fname" value="${customer.first_name}">
                </div>
            </div>
            <div class="row">
                <div class="column">
                    <label for="lname">Last name:</label>
                </div>
                <div class="column">
                    <input type="text" id="lname" name="lname" value="${customer.last_name}">
                </div>
            </div>
            <div class="row">
                <div class="column">
                    <label for="address">Address:</label>
                </div>
                <div class="column">
                    <input type="text" id="address" name="address" value="${customer.address}">
                </div>
            </div>
            <div class="row">
                <div class="column">
                    <label for="postcode">Postcode:</label>
                </div>
                <div class="column">
                    <input type="text" id="postcode" name="postcode" value="${customer.postcode}">
                </div>
            </div>
            <div class="row">
                <div class="column">
                    <label for="mobile">Mobile Number:</label>
                </div>
                <div class="column">
                    <input type="text" id="mobile" name="mobile" value="${customer.mobile_number}">
                </div>
            </div>
            <div class="row">
                <div class="column">
                    <label for="email">Email:</label>
                </div>
                <div class="column">
                    <input type="text" id="email" name="email" value="${customer.email}">
                </div>
            </div>
            <div class="row">
                <input type="submit" value="Update">
            </div>
        </form>
    </article>
</section>

<footer>
    <p>Workshop 2021</p>
    <p>Made by Costinel Negura</p>
</footer>

</body>
</html>

