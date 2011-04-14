<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Relatório de Venda de Produtos</title>
</head>
<body>

<table width="80%" border="1">
	<caption>LISTAGEM DE PRODUTOS</caption>
	<tr>
		<th>Nome</th>
		<th>Total de vendas</th>
	</tr>

	<!-- Variável para calcular o preço total dos produtos -->
	<%--c:set var="total" value="0" scope="page" /--%> 
	<c:forEach items="${requestScope.vendas_produto}" var="item" >
		<tr>
			<td align="center"><c:out value="${item.nome}" /></td>
			<td align="center"><c:out value="${item.quantidade}" /></td>
		</tr>
		<%--c:set var="total" value="${total + item.valor}" /--%>
	</c:forEach>
</table>

<%@include file="/include/rodape.jsp" %>

</body>
</html>