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
	<div>Bem vindo, <b><c:out value="${sessionScope.usuario.nome}" /></b></div>
	<ul>
		<li><a href="/LojaVirtual/Servico?cmd=incluir">Incluir um Produto</a></li>
		<li><a href="/LojaVirtual/Servico?cmd=listar">Listar Produtos</a></li>
		<li><a href="/LojaVirtual/Servico?cmd=consultar">Consultar um Produto</a></li>
		<li><a href="/LojaVirtual/Servico?cmd=incluirCategoria">Incluir uma Categoria</a></li>
		<li><a href="/LojaVirtual/Servico?cmd=incluirPagamento">Registrar Pagamento</a></li>
		<li><a href="/LojaVirtual/Servico?cmd=relatorio_produto_venda">Relatório de Vendas de Produtos</a></li>
	</ul>
</body>
</html>