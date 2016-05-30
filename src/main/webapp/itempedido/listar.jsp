<%@ page language="java" contentType="text/html; charset=ISO8859-1"
	pageEncoding="ISO8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO8859-1">
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
			<h1>Pedidos</h1>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>Código</th>
					<th>Data</th>
					<th>Valor Total</th>
					<th>Ação</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${itens}" var="x">
					<tr>
						<td>${x.codPedido}</td>
						<td><fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${x.data}" /></td>
						<td><fmt:setLocale value="pt_BR" /><fmt:formatNumber type="currency" value="${x.valorTotal}" /></td>
						<td><a href="<%=request.getContextPath()%>/itempedido/novo?codPedido=${x.codPedido}" class="btn btn-primary btn-xs">Escolher</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>


	<jsp:include page="/resources/templates/footer.jsp"></jsp:include>

	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>