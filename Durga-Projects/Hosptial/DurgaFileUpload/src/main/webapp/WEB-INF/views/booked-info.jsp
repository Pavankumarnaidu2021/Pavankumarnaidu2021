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
    <H2>Patient and ICU Beds Information</H2>
</center>
<h4><span style="color: forestgreen; text-align: left">No Of Available Beds: ${avalaibleBeds}</span> <span
        style="color: #f44336; text-align: right">No Of Booked Beds: ${bookedBeds}</span></h4>
<hr>

<table border="1">
    <tr>
        <th>INFOID</th>
        <th>NAME</th>
        <th>AGE</th>
        <th>ADDRESS</th>
        <th>GENDER</th>
        <th>ROOMNUM</th>
        <th>BEDNUM</th>
    </tr>
    <c:forEach items="${bedInformations}" var="ob">
        <tr>
            <td>${ob.getBookBedInformationId()}</td>
            <td>${ob.patientName}</td>
            <td>${ob.patientAge}</td>
            <td>${ob.patientAddr}</td>
            <td>${ob.patientGender}</td>
            <td>${ob.roomNum}</td>
            <td>${ob.bedNum}</td>
        </tr>
    </c:forEach>
</table>
<a href="/home"><input type="button" class="button" value="Home"></a>
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