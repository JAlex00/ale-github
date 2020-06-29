<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

	<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	</head>

	<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="0" />

	<body>
	<form action="http://localhost:8080/FinalProject/ContoSrv">
	<p hidden=>
	<input readonly="readonly" name="op" value="Nuovo">
	</p>
	idConto:
	<br/>
	<input type="text" name="idConto"></input>
	<br/>
	<input type="submit" value="invia"></input>
	</form>
	</body>
</html>