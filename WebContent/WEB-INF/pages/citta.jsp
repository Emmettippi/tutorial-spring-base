<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>${citta.code}</p>
	<p>${citta.name}</p>
	<p>
		<a href="../welcome">Ritorna alla home</a>
	</p>
	<form action="/TutorialSpringBase/citta/${citta.idcitta}"
		method="POST">
		<input type="submit" value="CANCELLA">
	</form>
</body>
</html>