<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>${country.code}</p>
	<p>${country.name}</p>
	<p>
		<a href="../welcome">Ritorna alla home</a>
	</p>
	<form action="/TutorialSpringBase/country/${country.idcountry}"
		method="POST">
		<input type="submit" value="CANCELLA">
	</form>
</body>
</html>