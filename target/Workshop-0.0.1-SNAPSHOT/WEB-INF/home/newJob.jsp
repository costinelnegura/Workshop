<%--
  Created by IntelliJ IDEA.
  User: Costinel.G
  Date: 19/05/2021
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        width: 100%;
        background-color: #f1f1f1;
    
    }

    /* Clear floats after the columns */
    section::after {
        content: "";
        display: table;
        clear: both;
    }

    .column {
        float: left;
        width: 15%;
        padding: 10px;

    }

    /* Clear floats after the columns */
    .row:after {
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
    <title>


    </title>
</head>
<body>

<header>
    <h1>Workshop</h1>
    <h3></h3><a>Home </a><a>New </a><a>Search </a><a>Invoice </a><a>Tools</a></h3>
</header>

<section>
    <article>
        <div class="row">
            <div class="column">
                <label>Salutation:</label>
            </div>
            <div class="column">
                <select name="salutation" id="salutation">
                    <option value="Mr">Mr</option>
                    <option value="Mrs">Mrs</option>
                    <option value="Miss">Miss</option>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="column">
                <label for="fname">First name:</label>
            </div>
            <div class="column">
                <input type="text" id="fname" name="fname">
            </div>
        </div>
        <div class="row">
            <div class="column">
                <label for="lname">Last name:</label>
            </div>
            <div class="column">
                <input type="text" id="lname" name="lname">
            </div>
        </div>
        <div class="row">
            <div class="column">
                <label for="address">Address:</label>
            </div>
            <div class="column">
                <input type="text" id="address" name="address">
            </div>
        </div>
        <div class="row">
            <div class="column">
                <label for="postcode">Postcode:</label>
            </div>
            <div class="column">
                <input type="text" id="postcode" name="postcode">
            </div>
        </div>
        <div class="row">
            <div class="column">
                <label for="mobile">Mobile Number:</label>
            </div>
            <div class="column">
                <input type="text" id="mobile" name="mobile">
            </div>
        </div>
        <div class="row">
            <div class="column">
                <label for="email">Email:</label>
            </div>
            <div class="column">
                <input type="text" id="email" name="email">
            </div>
        </div>
        <div class="row">
            <div class="column">
                <label for="vehicle_make">Vehicle Make:</label>
            </div>
            <div class="column">
                <input type="text" id="vehicle_make" name="vehicle_make">
            </div>
        </div>
        <div class="row">
            <div class="column">
                <label for="vehicle_model">Vehicle Model:</label>
            </div>
            <div class="column">
                <input type="text" id="vehicle_model" name="vehicle_model">
            </div>
        </div>
        <div class="row">
            <div class="column">
                <label for="vehicle_registration">Vehicle Registration:</label>
            </div>
            <div class="column">
                <input type="text" id="vehicle_registration" name="vehicle_registration">
            </div>
        </div>
        <div class="row">
            <div class="column">
                <label for="notes">Notes:</label>
            </div>
            <div class="column">
                <input type="text" id="notes" name="notes">
            </div>
        </div>
        <div class="row">
            <input type="submit" value="Submit">
            <input type="button" value="Cancel">
        </div>
    </article>
</section>

<footer>
    <p>Workshop 2021</p>
    <p>Made by Costinel Negura</p>
</footer>

</body>
</html>
