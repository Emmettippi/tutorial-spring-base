<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="index">Home</a> <br>
	<ul>
		<c:forEach items="${countries}" var="country">
			<li><a href="country/${country.code}">${country.name}"</a></li>
		</c:forEach>
	</ul>
</body>
</html>