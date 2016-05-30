<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sistema Pizzaria</title>

<!-- Bootstrap core CSS -->
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link
	href="<%=request.getContextPath()%>/resources/css/sticky-footer-navbar.css"
	rel="stylesheet">
</head>

<body>

	<!-- Fixed navbar -->

	<jsp:include page="/resources/templates/navbar.jsp"></jsp:include>

	<!-- Begin page content -->
	<div class="container">
		<div class="page-header">
			<h1>Detalhes do Pedido</h1>
		</div>
		<div>
			<ul class="list-group">
				<li class="list-group-item">Código: ${item.codPedido}</li>
				<li class="list-group-item">Data: <fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${item.data}" /></li>
				<li class="list-group-item">Valor total do pedido: <fmt:setLocale value="pt_BR" /><fmt:formatNumber type="currency" value="${item.valorTotal}" /></li>
			</ul>
		</div>
	</div>
	
	<div class="container">
		<div class="page-header">
			<h2>Itens do pedido</h2>
		</div>
		<div>
			<table class="table">
				<thead>
					<tr>
						<th>Código</th>
						<th>Nome</th>
						<th>Valor Total Pizza</th>
						<th>Quantidade</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${item.itens}" var="x">
						<tr>
							<td>${x.pizza.codPizza}</td>
							<td>${x.pizza.nome}</td>
							<td><fmt:setLocale value="pt_BR" /><fmt:formatNumber type="currency" value="${x.pizza.valorTotal}" /></td>
							<td>${x.quantidade}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	</div>

	<jsp:include page="/resources/templates/footer.jsp"></jsp:include>

	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>