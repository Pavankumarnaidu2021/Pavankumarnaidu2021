<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
        }

        .navbar {
            overflow: hidden;
            background-color: #333;
        }

        .navbar a {
            float: left;
            font-size: 16px;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        .dropdown {
            float: left;
            overflow: hidden;
        }

        .dropdown .dropbtn {
            font-size: 16px;
            border: none;
            outline: none;
            color: white;
            padding: 14px 16px;
            background-color: inherit;
            font-family: inherit;
            margin: 0;
        }

        .navbar a:hover, .dropdown:hover .dropbtn {
            background-color: red;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            z-index: 1;
        }

        .dropdown-content a {
            float: none;
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            text-align: left;
        }

        .dropdown-content a:hover {
            background-color: #ddd;
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }
         .button {
             background-color: #333333;
             border: none;
             color: white;
             padding: 14px 40px;
             text-align: center;
             text-decoration: none;
             display: inline-block;
             font-size: 18px;
             margin: 11px 5px;
             cursor: pointer;
             border-radius: 12px;
         }
    </style>
</head>
<body bgcolor="#04F9CD">
<center>
    <h2>Welcome To e-Doctor Appiontment</h2>
    <marquee><i>Welcome to e-Hospitality 24/7 Services...</i></marquee>
    <hr>
</center>
<form method="post" action="/book-appointment">
    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" id="personname" name="personname"></td>
        </tr>
        <tr>
            <td>Age</td>
            <td><input type="text" id="personage" name="personage"></td>
        </tr>
        <tr>
            <td>Date</td>
            <td><input type="text" id="date" name="date"></td>
        </tr>
        <tr>
            <td>Problem</td>
            <td><input type="text" id="problem" name="problem"></td>
        </tr>
    </table>
    <input type="submit" value="Apply" id="book-icu-id" class="button">
</form>
<a href="/appiontmentDetails">Show Appointment Details Information</a>
<h3 style="color: forestgreen">${saveObj}</h3>
<script>

</script>

</body>
</html>