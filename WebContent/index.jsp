<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Menu</title>
</head>
<body>
	<div><c:out value="${requestScope.msgErro}" /></div>
	<br />
	<form action="/LojaVirtual/Servico" method="post">
		<div>Login:</div>
		<div><input type="text" name="login" size="10" maxlength="10" /></div>
		<div>Senha:</div>
		<div><input type="password" name="senha" size="10" maxlength="10" /></div>
		<div><input type="submit" name="confirmar" value=" Login " /></div>
		<input type="hidden" name="cmd" value="login" />
	</form>
</body>
</html>