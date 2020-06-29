<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

	<head>
	<meta charset="ISO-8859-1">
	<title>UpdateConto</title>
	</head>
	
	<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="0" />
	
	<body>
	<form action="http://localhost:8080/FinalProject/ContoSrv">
	<label for="op">Operazione (0 = accredito; 1 = addebito):</label>
	<br/>
	<input type="number" id="op" name="op" min="0" max="1">
	<br/>
	idConto:
	<br/>
	<input type="text" name="idConto"></input>
	<br/>
	entrate/uscite:
	<br/>
	<input type="text" name="mov"></input>
	<br/>
	<input type="submit" value="invia"></input>
	</form>
	</body>
	
</html>