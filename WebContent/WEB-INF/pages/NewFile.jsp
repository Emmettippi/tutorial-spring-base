<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<H3>Inserisci il codice di una nazione</H3>
<form action="/TutorialSpringBase/country/search" method="POST">
		<input type="text" name="countryCode" />
		<input type="submit" value="CERCA"/>

</body>
</html>