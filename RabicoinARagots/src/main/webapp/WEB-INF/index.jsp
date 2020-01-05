<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="fr">
	<style type="text/css">
		body
		{
			padding-top: 56px;
		}

		main
		{
			text-align: center;
		}
	</style>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
		<title>
			  Le Rabicoin à ragots-  
			<c:choose>
				<c:when test="${ index == true }">
					Accueil
				</c:when>
				<c:otherwise>
					Tous_les_articles
				</c:otherwise>
			</c:choose>
		</title>
		<!-- Bootstrap core CSS -->
		<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<header>
			<!-- Navigation -->
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
				<div class="container">
					<a class="navbar-brand" href="<%=application.getContextPath()%>/">Le Rabicoin à ragots</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
					<div class="collapse navbar-collapse" id="navbarResponsive">
						<ul class="navbar-nav ml-auto">
							<li class="nav-item active">
								<a class="nav-link" href="<%=application.getContextPath()%>/">Accueil<span class="sr-only">(current)</span></a>
							</li>
							<c:if test="${ empty sessionScope.userID }">
								<li class="nav-item"><a class="nav-link" href="<%=application.getContextPath()%>/login">Connexion</a></li>
							</c:if>
							<c:if test="${ !empty sessionScope.userID }">
								<li class="nav-item"><a class="nav-link" href="<%=application.getContextPath()%>/disconnection">Deconnexion</a></li>
							</c:if>
							<c:if test="${ !empty sessionScope.userID }">
								<li class="nav-item"><a class="nav-link" href="<%=application.getContextPath()%>/article/manage">Gérer mon contenu</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</nav>
			<br>
			<br>
			<br>
		</header>
		<!-- Page Content -->
		<div class="container text-align-center">
			<div class="row">
				<!-- Blog Entries Column -->
				<div class="col-md-8">
					<c:choose>
						<c:when test="${ index == true }">
							<h1 class="my-4">
								Bienvenue sur le Rabicoin à ragots, un blog qui ne paie pas de mine.
								<br>
								<br>
								<small>
									Sentez vous libre de parcourir, commenter ou meme rédiger n'importe quel type d'article!
								</small>
							</h1>
						</c:when>
						<c:otherwise>
							<h1 class="my-4">Liste de tous les articles du blog :</h1>
						</c:otherwise>
					</c:choose>
					<!-- Blog Post -->
					<c:forEach var="article" items="${ articleList }"  varStatus="status">
						<div class="card mb-4">
							<img class="card-img-top" src="http://placehold.it/750x300" alt="Card image cap">
							<div class="card-body">
								<h2 class="card-title"><c:out value="${ article.getTitle() }" /></h2>
								<p class="card-text">
									<c:out value="${ article.getArticleDescription() }" />
								</p>
								<a href="<%=application.getContextPath()%>/article/read?id=${ article.getArticleID() }" class="btn btn-primary">Lire la suite &rarr;</a>
							</div>
							<div class="card-footer text-muted">
								Posted on 
								<c:out value="${ article.getArticleDate() }" />
								 by 
								<c:out value="${ article.getArticleAuthorFirstname() } ${ article.getArticleAuthorLastname() }" />
							</div>
						</div>
					</c:forEach>
					<c:choose>
						<c:when test="${ index == true }">
							<div class="pagination justify-content-center mb-4">
								<a href="<%=application.getContextPath()%>/article/all" class="btn btn-primary">Voir tous les articles &rarr;</a>
							</div>
						</c:when>
						<c:otherwise>
							<div class="pagination justify-content-center mb-4">
								<a href="<%=application.getContextPath()%>/" class="btn btn-primary">Retour à l'accueil &rarr;</a>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
				<!-- Sidebar Widgets Column -->
				<div class="col-md-4">
					<!-- Search Widget -->
					<div class="card my-4 center">
						<h5 class="card-header">
							Chercher les articles d'un auteur (51 caractères max):
						</h5>
						<div class="card-body">
							<div class="input-group">
								<form method="post">
									<input type="text" class="form-control" name="searchedAuthor" id="searchedAuthor" placeholder="Ex: John Doe" maxlength="51">
									<br>
									<span class="input-group-btn"><button type="submit" class="btn btn-secondary" >Rechercher</button></span>
								</form>
							</div>
						</div>
					</div>
					<!-- Categories Widget -->
					<c:if test="${ !empty sessionScope.userID }">
						<div class="card my-4 center">
							<h5 class="card-header">
								Quelquechose à raconter ?
							</h5>
							<div class="card-body">
								<div class="row">
									<br>
									<a href="<%=application.getContextPath()%>/article/add" class="btn btn-secondary">Ecrire un article</a>
								</div>
							</div>
						</div>
					</c:if>
				</div>
			</div>
			<!-- /.row -->
		</div>
		<!-- Footer -->
		<footer class="py-5 bg-dark">
			<div class="container">
				<p class="m-0 text-center text-white">
					Site crééé par Owain Charlon en 2019
					<br>
					Lien du template pour le front: https://startbootstrap.com/templates/blog/
				</p>
			</div>
		</footer>
	</body>
</html>