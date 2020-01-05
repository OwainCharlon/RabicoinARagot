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
			text-align:center;
		}
	</style>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>
			Le Rabicoin à ragots-  
			<c:choose>
				<c:when test="${ addArticleForm == true }">
					Ajouter_un_article
				</c:when>
				<c:otherwise>
					Modifier_un_article
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
		<main>
			<!-- Add/Update Form For Articles -->
			<div class="container align-items-center">
				<h3 class="alert-secondary">
					<c:choose>
						<c:when test="${ addArticleForm == true }">
							Nouvel article:
						</c:when>
						<c:otherwise>
							Modifier l'article: ${ article.getTitle() }
						</c:otherwise>
					</c:choose>
				</h3>
				<br>
				<br>
				<form method="post" class="form-group">
					<label for="newTitle">
						<strong>
							<c:choose>
								<c:when test="${ addArticleForm == true }">
									Titre du nouvel article (30 caractères max):
								</c:when>
								<c:otherwise>
									Nouveau titre de cet article (30 caractères max):
								</c:otherwise>
							</c:choose>
						</strong>
					</label>
					<input type="text" class="form-control" name="newArticleTitle" id="newArticleTitle" value="${ article.getTitle() }" placeholder="Ex: Un nouveau titre sympa..." maxlength="30" required>
					<br>
					<br>
					<label for="newArticleDescription">
						<strong>
							<c:choose>
								<c:when test="${ addArticleForm == true }">
									Description du nouvel article (65000 caractères max):
								</c:when>
								<c:otherwise>
									Nouvelle description de cet article (65000 caractères max):
								</c:otherwise>
							</c:choose>
						</strong>
					</label>
					<textarea class="form-control" name="newArticleDescription" id="newArticleDescription" rows="3" placeholder="Ex: Une nouvelle description..." maxlength="65000" required>${ article.getArticleDescription() }</textarea>
					<br>
					<br>
					<label for="newArticleDescription">
						<strong>
							<c:choose>
								<c:when test="${ addArticleForm == true }">
									Contenu du nouvel article (65000 caractères max):
								</c:when>
								<c:otherwise>
									Nouveau contenu de cet article (65000 caractères max):
								</c:otherwise>
							</c:choose>
						</strong>
					</label>
					<textarea class="form-control" name="newArticleContent" id="newArticleContent" rows="9" placeholder="Ex: Un nouveau contenu..." maxlength="65000" required>${ article.getArticleContent() }</textarea>
					<br>
					<br>
					<button type="submit" class="btn btn-primary">
						<c:choose>
							<c:when test="${ addArticleForm == true }">
								Créér cet article
							</c:when>
							<c:otherwise>
								Enregistrer les modifications
							</c:otherwise>
						</c:choose>
					</button>
				</form>
			</div>
		</main>
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