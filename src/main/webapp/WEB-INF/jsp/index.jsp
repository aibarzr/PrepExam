<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Showdown</title>
</head>
<body>
	<form:form action="brandInsert" method="post">
		<span>Nombre de la marca:</span>
		<form:input type="text" path="name" />
		<input type="submit" value="Guardar nombre marca" />
	</form:form>
	<br />
	<br />
	<br />
	Brand's name is <span><c:out value="${brand.name}" /></span>
</body>
</html>