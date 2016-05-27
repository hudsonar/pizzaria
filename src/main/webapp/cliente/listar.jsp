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
			<h1>Clientes</h1>
		</div>

		<div class="row">
			<div class="col-sm-2">
				<form class="navbar-form" action="<%=request.getContextPath()%>/cliente/novo">
					<button type="submit" class="btn btn-primary">Inserir novo</button>
				</form>
			</div>
			<div class="col-sm-6">
				<form class="navbar-form" action="<%=request.getContextPath()%>/cliente/filtrar">
					<div class="form-group">
						<input type="text" name="busca" placeholder="Digite um nome" class="form-control"/>
							<button type="submit" class="btn btn-success">Filtrar</button>
					</div>
				</form>
			</div>
		</div>

		<table class="table">
			<thead>
				<tr>
					<th>C�digo</th>
					<th>Nome</th>
					<th>CPF</th>
					<th>Telefone</th>
					<th>Email</th>
					<th>Data Nascimento</th>
					<th>Renda Mensal</th>
					<th>A��o</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${itens}" var="x">
					<tr>
						<td>${x.codCliente}</td>
						<td>${x.nome}</td>
						<td>${x.cpf}</td>
						<td>${x.telefone}</td>
						<td>${x.email}</td>
						<td><fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${x.dataNasc}" /></td>
						<td><fmt:setLocale value="pt_BR" /><fmt:formatNumber type="currency" value="${x.renda}" /></td>
						<td><a href="<%=request.getContextPath()%>/cliente/editar?cod=${x.codCliente}" class="btn btn-primary btn-xs">Editar</a>
						<a href="<%=request.getContextPath()%>/cliente/remover?cod=${x.codCliente}" class="btn btn-danger btn-xs">Excluir</a></td>
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