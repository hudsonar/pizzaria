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
			<h1>Confirmar Exclusão de Cliente</h1>
		</div>
		<div>
			<ul>
				<li class="list-group-item">Código: ${item.codCliente}</li>
				<li class="list-group-item">Nome: ${item.nome}</li>
				<li class="list-group-item">CPF: ${item.cpf}</li>
				<li class="list-group-item">Email: ${item.email}</li>
				<li class="list-group-item">Telefone: ${item.telefone}</li>
				<li class="list-group-item">Data de Nascimento: <fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${item.dataNasc}" /></li>
				<li class="list-group-item">Renda: <fmt:setLocale value="pt_BR" /><fmt:formatNumber type="currency" value="${item.renda}" /></li>
			</ul>
		</div>				
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<a href="<%=request.getContextPath()%>/cliente/excluir?cod=${item.codCliente}" type="submit" class="btn btn-danger btn-xs">Excluir</a>
					<a href="<%=request.getContextPath()%>/cliente/listar" class="btn btn-default">Voltar</a>
				</div>					
			</div>
		
	</div>

	<jsp:include page="/resources/templates/footer.jsp"></jsp:include>

	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>