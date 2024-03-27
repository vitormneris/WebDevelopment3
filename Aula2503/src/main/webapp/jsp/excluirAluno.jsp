<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sistema Acadêmico</title>
</head>
<body>
	<h2>Excluir Aluno</h2>
	<jsp:useBean id="aluno" scope="session"
		class="br.edu.fatecitaquera.model.Aluno" />
	<%
	SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
	%>
	<form action="ServletAluno?cmd=excluir" method="post">
		<table border="1">
			<tr>
				<td>RA:</td>
				<td><input type="text" size="60" name="txtRa"
					value="<%=aluno.getRa()%>" readonly="readonly" /></td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit"
					value="Confirmar exclusão" /></th>
			</tr>
			<tr>
				<th colspan="2"><a href="index.html">Página Principal</a></th>
			</tr>
		</table>
	</form>
</body>
</html>