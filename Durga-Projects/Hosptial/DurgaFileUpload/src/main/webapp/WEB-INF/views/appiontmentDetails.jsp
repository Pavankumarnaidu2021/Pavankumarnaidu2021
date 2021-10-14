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
    <H2>Doctor Appointment Details</H2>
</center>
<hr>

<table border="1">
    <tr>
        <th>APPOINTMENT ID</th>
        <th>NAME</th>
        <th>AGE</th>
        <th>DATE</th>
        <th>PROBLEM</th>
    </tr>
    <c:forEach items="${appiontmentDetails}" var="ob">
        <tr>
            <td>${ob.getAppiontmentDetailsId()}</td>
            <td>${ob.patientName}</td>
            <td>${ob.patentAge}</td>
            <td>${ob.appintMentDate}</td>
            <td>${ob.problem}</td>
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