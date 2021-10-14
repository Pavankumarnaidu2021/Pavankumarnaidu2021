<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>AllFiles</title>
</head>
<body bgcolor="#e0ffff">
<H3>All Files Data Page</H3>
<table border="1">
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
</table>
<form action="/uploadNewFile">
    <button>Goto Upload File</button>
</form>
</body>
</html>