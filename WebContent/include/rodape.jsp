<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<br />
<table width="100%">
	<tr>
		<td><a href="/LojaVirtual/jsps/menu.jsp">Voltar ao menu</a></td>
		<td align="right">Usuário logado: <b><c:out value="${sessionScope.usuario.nome}" /></b></td>
	</tr>
</table>
