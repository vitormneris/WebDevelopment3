<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="br.edu.fatecitaquera.model.Aluno"%>
<!DOCTYPE html>
<html>
<head>
<title>Student list</title>
</head>
<body>
	<table width="60%" border="1">
		<tr>
			<th colspan="7"><h1>Student list</h1></th>
			<a href="html/include.html"><img src="image/adicionar-usuario.png" width="30px"></a>
		</tr>
		<tr>
			<th>ID - Update</th>
			<th>Name</th>
			<th>Address</th>
			<th>E-mail</th>
			<th>Birth date</th>
			<th>Period</th>
			<th>Status</th>
		</tr>
		<%
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
				List<Aluno> lista = new ArrayList<Aluno>();
				lista = (ArrayList) request.getAttribute("alunosList");
				// for each
				for (Aluno a : lista) {
		%>
		<tr>
			<td><%=a.getRa()%></td>
			<td><%=a.getNome()%></td>
			<td><%=a.getEndereco()%></td>
			<td><%=a.getEmail()%></td>
			<td><%=data.format(a.getDataNascimento())%></td>
			<td><%=a.getPeriodo()%></td>
			<td>
				<a href="ServletAluno?cmd=exc&txtRa=<%= a.getRa() %>"><img src="image/icons8-apagar-66.png" width="30px"></a>
		 	    <a href="ServletAluno?cmd=atu&txtRa=<%= a.getRa() %>"><img src="image/icons8-editar-50.png" width="30px"></a>
		    </td>
		</tr>
		<%
		}
		%>
		<tr>
			<th colspan="7"><a href="index.html">Página Principal</a></th>
		</tr>
	</table>
</body>
</html>