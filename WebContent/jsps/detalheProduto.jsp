<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Detalhes do produto</title>
</head>
<body>
	<h3>Detalhes do produto</h3>
	<div><b>Código:</b> <c:out value="${requestScope.produtoConsultado.codigo}" /></div>
	<div><b>Nome:</b> <c:out value="${requestScope.produtoConsultado.nome}" /></div>
	<div><b>Valor:</b> <fmt:formatNumber type="currency" value="${requestScope.produtoConsultado.valor}" /></div>
	<div><b>Categoria:</b> <c:out value="${requestScope.produtoConsultado.nome_cat}" /></div>
	<br />
	<a href="/LojaVirtual/Servico?cmd=alterar&prod=${requestScope.produtoConsultado.id}">Alterar</a>

	<%@include file="/include/rodape.jsp" %>
</body>
</html>