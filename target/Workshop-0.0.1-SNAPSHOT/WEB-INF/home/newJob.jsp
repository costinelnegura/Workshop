<%--
  Created by IntelliJ IDEA.
  User: Costinel.G
  Date: 20/05/2021
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Workshop - New Job</title>
    <div>
        <a href="">Create</a>
        <a href="">Cancel</a>
    </div>
</head>
<body>
<div align="center">
    <p align="center">Create New Job</p>

    <form>
        <a>Salutation:</a>
        <select name="salutation" id="salutation">
            <option value="Mr">Mr</option>
            <option value="Mrs">Mrs</option>
            <option value="Miss">Miss</option>
        </select><br><br>
        <label for="fname">First name:</label>
        <input type="text" id="fname" name="fname"><br><br>
        <label for="lname">Last name:</label>
        <input type="text" id="lname" name="lname"><br><br>
        <label for="address">Address:</label>
        <input type="text" id="address" name="address"><br><br>
        <label for="postcode">Postcode:</label>
        <input type="text" id="postcode" name="postcode"><br><br>
        <label for="mobile">Mobile Number:</label>
        <input type="text" id="mobile" name="mobile"><br><br>
        <label for="email">Email:</label>
        <input type="text" id="email" name="email"><br><br>
        <label for="vehicle_make">Vehicle Make:</label>
        <input type="text" id="vehicle_make" name="vehicle_make"><br><br>
        <label for="vehicle_model">Vehicle Model:</label>
        <input type="text" id="vehicle_model" name="vehicle_model"><br><br>
        <label for="vehicle_registration">Vehicle Registration:</label>
        <input type="text" id="vehicle_registration" name="vehicle_registration"><br><br>
        <label for="notes">Notes:</label>
        <input type="text" id="notes" name="notes"><br><br>
        <input type="submit" value="Submit">
        <input type="button" value="Cancel">
    </form>
</div>
</body>
</html>
