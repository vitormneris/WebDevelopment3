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
		int tab = Integer.parseInt(request.getParameter("txtTabuada"));
		for (int i = 0; i <= 10; i++) {
			out.println(i + " * " + tab + " = "+ i * tab + "<br>");
		}
	%>
</body>
</html>
