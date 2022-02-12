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

<div class="col-9 conteudo">
	
	<form action="ProjetoFinalCarroServlet" method="post">
		<c:choose>
			<c:when test="${ carro == null }">
				<div class="container mt-5 col-6" style="outline: 1px solid #d5d5d5; border-radius: 11px; padding: 16px;">
					<h1 >Adicionar Carro</h1>
					<div>
						<label style="margin-right: 17px;">Modelo:</label>
						<input type="text" class="form-control" name="modelo"><br>
					</div>
					<div>
						<label style="margin-right: 17px;">Ano:</label>
						<input type="text" class="form-control" name="ano">
					</div>
					
					<div class="mt-3">
						<button type="submit" name="option" value="insert" class="btn btn-primary col-2 mb-3">Salvar</button>
					</div>
				</div>
				
				
			</c:when>
			<c:otherwise>
				<div class="container mt-5 col-6" style="outline: 1px solid #d5d5d5; border-radius: 11px; padding: 16px;">
				<h1 >Atualizar Carro</h1>
					<input type="hidden" name="id" value="${carro.id}"/>
					<div>
						<label style="margin-right: 17px;">Modelo:</label><br>
						<input type="text" class="form-control" name="modelo" value="${carro.modelo}">
					</div>
					<div>
						<label style="margin-right: 17px;">Ano:</label>
						<input type="text" class="form-control" name="ano" value="${carro.ano}"/>
					</div>
					
					<input type="hidden" name="pagaIPVA" value="${carro.pagaIPVA}"/>
					
					<button type="submit" name="option" value="update" class="btn btn-primary col-2 mb-3 mt-3">Atualizar</button>
				</div>
			</c:otherwise>
		</c:choose>
	</form>
</div>
</body>
</html>