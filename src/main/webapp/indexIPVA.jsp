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

	<div class="container">
		<div class="row justify-content-center">
	      <h1 class= col-4 >Lista de IPVA</h1>
	      <hr>
		</div>
	</div>
	
	<div class="container">
		
		<form action="ProjetoFinalIPVAServlet" method="post">
			<a href="formIPVA.jsp"><button type="submit" name="optionIPVA" class="btn btn-primary mb-3" value="insertIPVA">Cadastrar IPVA</button></a>
		</form>
	
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Ano</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ipva" items="${listaIPVA}">
					<tr>
						<form action="ProjetoFinalIPVAServlet" method="post">
							<td>
								<c:out value="${ipva.id}"/>
								<input type="hidden" name="id" value="${ipva.id}"/>
							</td>
							<td><c:out value="${ipva.ano}"/></td>
							<td><button type="submit" name="optionIPVA" value="deletarIPVA">Deletar</button>
							<button type="submit" name="optionIPVA" value="updateIPVA">Atualizar</button></td>
						</form>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>