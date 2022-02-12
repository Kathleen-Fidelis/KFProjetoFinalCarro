<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-success mb-5">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">Carros</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="#">Carros</a>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>

	<div class="container">
		<div class="row justify-content-center">
	      <h1 class= col-4 >Lista de Carros</h1>
	      <hr>
		</div>
	</div>
	
	<div class="container">
		
		<%--<form action="ProjetoFinalCarroServlet" method="post"> --%>
			<a href="form.jsp"><button type="submit" name="option" class="btn btn-primary mb-3" value="insertForm">Cadastrar Carro</button></a>
		<%--</form>--%>
	
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Modelo</th>
					<th scope="col">Ano</th>
					<th scope="col">IPVA</th>
					<th scope="col">Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="carro" items="${carros}">
					<tr>
						<form action="ProjetoFinalCarroServlet" method="post">
							<td>
								<c:out value="${carro.id}"/>
								<input type="hidden" name="id" value="${carro.id}"/>
							</td>
							<td><c:out value="${carro.modelo}"/></td>
							<td><c:out value="${carro.ano}"/></td>
							<td><c:out value="${carro.pagaIPVA}"/>
							<input type="hidden" name="pagaIPVA" value="${carro.pagaIPVA}"/></td>
							<td><button type="submit" name="option" value="delete">Deletar</button>
							<button type="submit" name="option" value="updateForm">Atualizar</button></td>
						</form>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>