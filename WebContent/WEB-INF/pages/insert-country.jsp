<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Inserisci una nazione</h3>
	<form action="/TutorialSpringBase/country/insert" method="POST">
	Codice:<input type="text" name="countryCode" /> 
	Nome:<input type="text" name="countryName" /> 
	<input type="submit" name="INSERISCI" /> 
	</form>
</body>
</html>