<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Inserisci una nuova nazione</h1>
<form action="/TutorialSpringBase/country/search" method="POST">
Codice: <input type="text" name="countryCode" /> <br>
Nome: <input type="text" name="countryName" /> <br>
<input type="submit" value="INSERISCI" /> <br>
</form>
</body>
</html>