<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=ISO-8859-1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Files</title>
</head>
<body bgcolor="#e0ffff">
<h2>File Uploaded Successfully...!</h2>
<hr>
<pre>
<form action="/uploadNewFile">
    <button>Upload New File</button>
</form>

<form action="/showAllFiles">
    <button>Show All Files</button>
</form>
</pre>
</body>
</html>

