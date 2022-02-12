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
	    <a class="navbar-brand" href="#">IPVA</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="#">IPVA</a>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>

<div class="col-9 conteudo">
	<form action="ProjetoFinalIPVAServlet" method="post">
		<c:choose>
			<c:when test="${ ipva == null }">
				<div class="container mt-5 col-6" style="outline: 1px solid #d5d5d5; border-radius: 11px; padding: 16px;">
					<h1 >Adicionar IPVA</h1>
					<label style="margin-right: 17px;">Ano:</label>
					<input type="text" class="form-control" name="ano"/>
				
					<button type="submit" name="optionIPVA" value="inserirIPVA" class="btn btn-primary col-2 mb-3 mt-3">Salvar</button>
				</div>
			</c:when>
			<c:otherwise>
				<div class="container mt-5 col-6" style="outline: 1px solid #d5d5d5; border-radius: 11px; padding: 16px;">
					<h1 >Atualizar IPVA</h1>
					<input type="hidden" name="id" value="${ipva.id}"/>
					<label style="margin-right: 17px;">Ano:</label>
					<input type="text" name="ano" class="form-control" value="${ipva.ano}"/>
					
					<button type="submit" name="optionIPVA" value="atualizarIPVA" class="btn btn-primary col-2 mb-3 mt-3">Atualizar</button>
				</div>
			</c:otherwise>
		</c:choose>
	</form>
</div>
</body>
</html>