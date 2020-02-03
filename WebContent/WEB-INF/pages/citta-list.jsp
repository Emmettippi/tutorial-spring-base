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
<ul>
		<c:forEach items="${cittas}" var="citta">
			<li><a href="../citta/${citta.code}">${citta.name}</a></li>
		</c:forEach>
	</ul>
</body>
</html>