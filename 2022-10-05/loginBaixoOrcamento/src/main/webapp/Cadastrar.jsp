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
		<h1>Cadastro</h1>
		<form action="cadastrar" method="post">
			<table>
				<tr>
					<td>Nome</td>
					<td><input type="text" name="userName"></td>
				</tr>
				
				<tr>
					<td>Senha</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>Confirma Senha</td>
					<td><input type="password" name="passwordConfirm"></td>
				</tr>
			</table>	
			<br/>
			<input type="submit" value="Cadastrar">	
			<br/>
			<p><a class="active" href="Login.jsp">Faça Login</a></p>
		</form>
	</div>	
</body>
</html>