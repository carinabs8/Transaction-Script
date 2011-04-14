<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Listagem de Produtos</title>
</head>
<body>

<table width="80%" border="1">
	<caption>LISTAGEM DE PRODUTOS</caption>
	<tr>
		<th>Código</th>
		<th>Descrição</th>
		<th>Categoria</th>
		<th align="right">Valor (R$)</th>
	</tr>

	<!-- Variável para calcular o preço total dos produtos -->
	<c:set var="total" value="0" scope="page" />
	<c:forEach items="${requestScope.produtos}" var="item" >
		<tr>
			
			<td>
				<a href="/LojaVirtual/Servico?cmd=realizarConsulta&codigo=${item.codigo}">
					<c:out value="${item.codigo}" />
				</a>
			</td>
			<td>
				<c:out value="${item.nome}" />
			</td>
			<td>
				<c:out value="${item.nome_cat}" />
			</td>
			<td align="right">
				<fmt:formatNumber type="number" maxIntegerDigits="5" maxFractionDigits="2" minFractionDigits="2" value="${item.valor}" />
			</td>
			<c:set var="total" value="${total + item.valor}" />
		</tr>
	</c:forEach>
	<tr>
		<td colspan="4" align="right">
			<b>
				Total em produtos:
				<fmt:formatNumber type="currency" value="${total}" />
			</b> 
		</td>
	</tr>
</table>

<%@include file="/include/rodape.jsp" %>

</body>
</html>