<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">
<title>PRODUTO</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>
	<br />
	<div align="center">
		<form action ="produto" method="post">
			<p>
				<b>Professor</b>
			</p>
			<table>
				<tr>
					<td colspan="3">
						<input class="id_input_data" type="number" min="0" step="1" id="codigo" 
								name="codigo" placeholder="Codigo"
								value='<c:out value="${p.codigoProduto }"></<c:out>'>
					</td>	
					<td>
						<input type="submit" id="botao" name="botao" value="Buscar" >
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<input class="input_data" type="text" id="nome" name="nome" placeholder="Nome" 
						value='<c:out value="${p.nomeProduto }"></<c:out>'>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<input class="input_data" type="text" id="valor" name="Valor" 
							placeholder="Valor" value='<c:out value="${p.vlrProduto }"></<c:out>'>
					</td>
				</tr>	
				<tr>
					<td>
						<input type="submit" id="botao" name="botao" value="Cadastrar" >
					</td>
					<td>
						<input type="submit" id="botao" name="botao" value="Alterar" >
					</td>
					<td>
						<input type="submit" id="botao" name="botao" value="Excluir" >
					</td>
					<td>
						<input type="submit" id="botao" name="botao" value="Listar" >
					</td>
				</tr>
			</table>
		</form>	
	</div>
	<br />
	<div align="center">
		<c:if test="${not empty erro }">
			<H2><b><c:out value="${erro}" /></b></H2>
		</c:if>
	</div>
		<div align="center">
		<c:if test="${not empty saida }">
			<H3><b><c:out value="${saida}" /></b></H3>
		</c:if>
	</div>
	<br />
	<div align="center">
		<c:if test="${not empty professores }">
			<table class="table_round">
				<thead>
					<tr>
						<th>Codigo</th>
						<th>Nome </th>
						<th>Titulacao </th>						
					</tr>
				</thead>
				<tbody>
				<c:forEach var="p" items="${professores }">
					<tr>
						<td><c:out value="${p.codigo }"/></td>
						<td><c:out value="${p.nome }"/></td>
						<td><c:out value="${p.titulacao }"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>	
		</c:if>
	</div>	
</body>
</html>