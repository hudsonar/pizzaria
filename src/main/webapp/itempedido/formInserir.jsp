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
			<h1>Inserir novo Item no pedido: ${item.pedido.codPedido}</h1>
		</div>
		
			<form method="post" name="myform" class="form-horizontal" action="<%=request.getContextPath()%>/itempedido/inserir">
				
				<input type="hidden" name="codPedido" value="${item.pedido.codPedido}" />
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<ul>
							<c:forEach items="${erros}" var="msg">
								<li class="erro">${msg}</li>
							</c:forEach>
						</ul>
					</div>					
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label" for="quantidade">Quantidade:</label>
					<div class="col-sm-5">
						<input type="number" name="quantidade" id="quantidade" value="${item.quantidade}" required="required" class="form-control"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label" for="pizza">Selecione a Pizza:</label>
					<div class="col-sm-5">
						<select name="codPizza" class="form-control">
							<option value="">-- Selecione a pizza--</option>
							<c:forEach items="${pizzas}" var="x">
								<option value="${x.codPizza}" <c:if test="${x == artistaSelecionado}">selected="selected"</c:if>>${x.nome}, <fmt:setLocale value="pt_BR" /><fmt:formatNumber type="currency" value="${x.valorTotal}" /></option>
							</c:forEach> 
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary">Inserir</button>
						<a href="<%=request.getContextPath()%>/itempedido/pedidos" class="btn btn-default">Voltar</a>
					</div>					
				</div>
			</form>
		
	</div>

	<jsp:include page="/resources/templates/footer.jsp"></jsp:include>

	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>