<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Inserisci il codice di una nazione</h3>
	<form action="/TutorialSpringBase/country/search" method="GET">
		<input type="text" name="countryCode" />
		<input type="submit" value="CERCA"/>
	</form>
</body>
</html>