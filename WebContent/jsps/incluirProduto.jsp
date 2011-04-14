<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Inclusão de produtos</title>
</head>
<body>
	<form action="/LojaVirtual/Servico" method="post">
		<div>Código:</div>
		<div><input type="text" name="codigo" size="6" maxlength="6" /></div>
		<div>Nome:</div>
		<div><input type="text" name="nome" size="30" maxlength="40" /></div>
		<div>Valor:</div>
		<div><input type="text" name="valor" size="8" maxlength="10" /></div>
		<div>Categoria:</div>
		<div>
			<select name="categoria">
				<c:forEach items="${requestScope.categorias}" var="categoria">
					<option value="${categoria.id}"><c:out value="${categoria.nome}"/></option>
				</c:forEach>
			</select>
		</div>
		<br />
		<div><input type="submit" name="salvar" value=" Salvar " /></div>
	
		<input type="hidden" name="cmd" value="salvarInclusao" />
	</form>
	<br />
	<%@include file="/include/rodape.jsp" %>
</body>
</html>