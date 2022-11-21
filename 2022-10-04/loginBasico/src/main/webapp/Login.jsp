<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Login</h1>
		<form action="login" method="post">
			<table>
				<tr>
					<td>Nome</td>
					<td><input type="text" name="userName"></td>
				</tr>
				
				<tr>
					<td>Senha</td>
					<td><input type="password" name="password"></td>
				</tr>
			</table>	
			<input type="submit" value="Entre">
			<p>Ou</p>	
			<p><a class="active" href="Cadastrar.jsp">Cadastre-se</a></p>
		</form>
	</div>	
</body>
</html>