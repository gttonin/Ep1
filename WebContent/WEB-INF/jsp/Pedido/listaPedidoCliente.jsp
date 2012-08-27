<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pedido</title>
</head>
<body>
	<h3>Listagem de Pedidos de Clientes</h3>
	<table>
		<tr>
			<td>Nome do Cliente:</td>
			<td><c:out value="${pedido.cliente}"></c:out></td>
		</tr>
		<tr>
			<td>Data:</td>
			<td><fmt:formatDate value="${pedido.data.time}" type="date"
					dateStyle="short" /></td>
			
		</tr>
		<tr>
			<td>Valor Total:</td>
			<td style="text-align: right"><fmt:formatNumber value="${total}"
					minFractionDigits="2" type="currency" /></td>
		</tr>
	</table>

	<table border="1" cellpadding="3" cellspacing="3" width="400">
		<tr>
			<td>Item</td>
			<td>Qtd</td>
			<td>Unitário</td>
			<td>Total</td>
		</tr>

		<c:forEach items="${pedido.itens}" var="item">
			<tr>
				<td>${item.nome}</td>
				<td style="text-align: right">${item.qtd}</td>
				<td style="text-align: right"><fmt:formatNumber
						value="${item.valorUnitario}" minFractionDigits="2"
						type="currency" /></td>
				<td style="text-align: right"><fmt:formatNumber
						value="${item.valorUnitario * item.qtd}" minFractionDigits="2"
						type="currency" /></td>
			</tr>

		</c:forEach>



	</table>
</body>
</html>