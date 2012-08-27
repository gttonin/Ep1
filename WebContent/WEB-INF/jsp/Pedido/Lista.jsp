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
	<h3>Listagem de Pedidos</h3>

	<table border="1" cellpadding="3" cellspacing="3" width="400">
		<tr>
			<td>Cliente</td>
			<td>Data</td>
			<td>Quantidade de  Itens</td>
			<td>Valor Total</td>
		</tr>


		<c:forEach items="${pedidoList}" var="pedido" >

			<c:set var="qtdItens" value="${0}" />
			<c:set var="valTotal" value="${0}" />
			

			<c:forEach items="${pedido.itens}" var="item">

				<c:set var="qtdItens" value="${item.qtd + qtdItens}" />
				<c:set var="valTotal"
					value="${item.qtd*item.valorUnitario + valTotal}" />

				<c:set var="passo" value="${passo + 1}" />
			</c:forEach>

			

				<tr>
					<td>${pedido.cliente}</td>
					<td>${pedido.cliente}</td>

					<td style="text-align: right">${qtdItens}</td>
					<td style="text-align: right"><fmt:formatNumber
							value="${valTotal}" minFractionDigits="2" type="currency" /></td>
				</tr>


		</c:forEach>


	</table>
</body>
</html>