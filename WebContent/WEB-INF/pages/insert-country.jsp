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
	<h3>Nazione</h3>
	<form action="/TutorialSpringBase/country" method="POST">
		Codice: <input type="text" value="${country.code}" name="code" /> <br>
		Nome: <input type="text" value ="${country.name}" name="name" /> <br>
		<input type="hidden" value="${country.id}" name="id" /> <br>
		<input type="submit" value="SALVA" /> <br>
	</form>
</body>
</html>