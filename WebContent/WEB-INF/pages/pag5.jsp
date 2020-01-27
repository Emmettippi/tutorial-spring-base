<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>pag5</title>
</head>
<body>

	<h1>New country</h1>

	<form action="/TutorialSpringBase/pag5" method="POST">
		name <br><input type="text" name="countryName" /> <input/> <br><br>
		code <br><input type="text" name="countryCode" /> <input/><br><br>
		<input type="submit" value="INSERT">
	</form>

</body>
</html>