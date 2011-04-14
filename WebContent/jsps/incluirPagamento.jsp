<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registrar Pagamento</title>
</head>
	<body>
		<form action="/LojaVirtual/Servico" method="post">
			<div>Data do Pagamento: (dd/MM/YYYY)</div>
			<div><input type="text" name="data_realizacao" size="30" maxlength="40" /></div>
			<br />
			<div>Total do Pagamento:</div>
			<div><input type="text" name="total_pagamento" size="30" maxlength="40" /></div>
			<br />
			<div>Venda:</div>
			<div>
				<select name="venda">
					<c:forEach items="${requestScope.vendas}" var="venda">
						<option value="${venda.id}"><c:out value="${venda.datarealizacao}"/></option>
					</c:forEach>
				</select>
			</div>
		<br />
			<div><input type="submit" name="salvar" value=" Salvar " /></div>
		
			<input type="hidden" name="cmd" value="salvarPagamento" />
		</form>
		<br />
		<%@include file="/include/rodape.jsp" %>
	</body>
</html>