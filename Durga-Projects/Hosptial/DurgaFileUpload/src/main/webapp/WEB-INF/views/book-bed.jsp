<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Book</title>
    <style>
        .button {
            background-color: #333333;
            border: none;
            color: white;
            padding: 11px 7px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 15px;
            margin: 4px 2px;
            cursor: pointer;
        }
    </style>
</head>
<body bgcolor="#04F9CD">
<center>
    <H2>Book COVID ICU Beds</H2>
</center>
<h4><span style="color: forestgreen; text-align: left">No Of Available Beds: ${avalaibleBeds}</span> <span
        style="color: #f44336; text-align: right">No Of Booked Beds: ${bookedBeds}</span></h4>
<hr>
<form method="post" action="/book-bed">
    <table>
        <tr>
            <td>Patient Name</td>
            <td><input type="text" id="personname" name="personname"></td>
        </tr>
        <tr>
            <td>Patient Age</td>
            <td><input type="text" id="personage" name="personage"></td>
        </tr>
        <tr>
            <td>Residence:</td>
            <td><textarea id="personaddr" name="personaddr"></textarea></td>
        </tr>
        <tr>
            <td>Gender</td>
            <td><select type="text" id="persongen" name="persongen">
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <option value="Others">Others</option>
            </select>
            </td>
        </tr>
        <tr>
            <td>Room Number</td>
            <td><input type="text" id="roomnumber" name="roomnumber"></td>
        </tr>
        <tr>
            <td>Bed Number</td>
            <td><input type="text" id="bednumber" name="bednumber"></td>
        </tr>
    </table>
    <input type="submit" value="Book ICU Bed" id="book-icu-id" class="button"></input>
</form>
<a href="/getBookedInfo">Show Booked Information</a>
<h2><span style="color: forestgreen; text-align: right"> ${bookSuccessObj}</span></h2>

<%--<table border="1">
    <tr>
        <th>NAME</th>
        <th>URL</th>
        <th>TYPE</th>
        <th>SIZE</th>
    </tr>
    <c:forEach items="${files}" var="ob">
        <tr>
            <td>${ob.name}</td>
            <td>${ob.url}</td>
            <td>${ob.type}</td>
            <td>${ob.size}</td>
        </tr>
    </c:forEach>
</table>--%>
<script>
    /*var availabebeds =  ${avalaibleBeds};
    if (availabebeds <=0) {
        function myFunction() {
            document.getElementById("book-icu-id").click();
        }
    }*/

</script>

</body>
</html>