<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Inserisci una nazione</h1> <br>
	<form action="/TutorialSpringBase/country/insert" method="POST">
	<input type="text" name="countryCode"/> <br>
	<input type="text" name="countryName"/> <br>
	<input type="submit" value="INSERISCI"/>
	</form>
</body>
</html>