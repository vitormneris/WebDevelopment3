<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body>
	<h1>Multiplication table</h1>
	<%
		//scriplet
		int var = Integer.parseInt(request.getParameter("value"));
		for (int i = 0; i <= 10; i++) {
			out.println(i + " * " + var + " = "+ i * var + "<br>");
		}
	%>
</body>
</html>
