<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Files</title>
</head>
<body bgcolor="#e0ffff">
<h2>Login Success...!</h2>
<hr>
<p>Welcome To Files Upload Page...!</p>
<p>Click on the "Choose File" button to upload a file:</p>

<form action="/uploadFile" method="post" enctype="multipart/form-data">
    <input type="file" id="file" name="file">
    <input type="submit" value="Upload File">
</form>
</body>
</html>