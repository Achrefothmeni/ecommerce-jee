<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><br><br>
<div class="container" id="formProduit">
<div class="panel panel-default">
<div class="panel-heading">Rechercher des Produits</div>
  <div class="panel-body">
	<form action="controleur" method="post"><br>
		<div class="col-xs-2">
			<div class="search">
				<input type="text" name="code" class="form-control" id="idP" value="${idProduit}" >
			</div>
		</div>
<input type="submit" name="action" class="btn btn-primary" value="Chercher">
<input type="submit" name="action" class="btn btn-primary" value="Tous"><br> <br>
<div class="col-xs-2">
	<label class="col-xs-3 control-label">Critere</label>
	<select class="form-control" name="critere" >
  		<optgroup label="critere">
    		<option value="id">Id</option>
    		<option value="motCle">Mot cle</option>
    		<option value="nom">Nom</option>
  		</optgroup>
  		<optgroup label="Categorie">
    		<option value="it">IT</option>
 		</optgroup>
	</select>
</div>
</form>
</div>
</div>
<!--  <table>
<tr>
<td>Id_Produit</td>
<td><input type="number" name="code" value="${idProduit}" ></td>
<td>${errcode}</td>
<td> <input type="submit" name="action" value="Consulter"></td>
<td> <input type="submit" name="action" value="Liste Produits"></td>
</tr>
</table > -->
<br>
<table  class="table table-hover">
<thead>
<tr> 
<th>Code Produit</th> 
<th>Designation</th>
<th>Description</th>
<th>Prix</th> 
<th>Quantite</th>
<th>Selection</th> 
<th>Photo</th>
</tr>
</thead>
<tbody>
<c:forEach items="${Produit}" var="p">
<tr>
<td>${p.idProduit}</td>
<td>${p.designation}</td>
<td>${p.desc}</td>
<td>${p.prix}</td>
<td>${p.qte}</td>
<td>${p.selection}</td>
<td>${p.photo}</td>
</tr>
</c:forEach>
</tbody>
</table>

</div>

</body>
</html>