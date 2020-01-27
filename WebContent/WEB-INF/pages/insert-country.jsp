<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Inserisci una nuova nazione:</h3>
<form action="/TutorialSpringBase/country/insert" method="POST">
		Codice: <input type="text" name="countryName" /> <br>
		Nome: <input type="text" name="countryCode" /> <br>
		<input type="submit" value="INSERISCI"/> <br>
	</form>
</body>
</html>