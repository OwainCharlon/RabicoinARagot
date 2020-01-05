<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
		<title>Article-${ article.getTitle() }</title>
		<!-- Bootstrap core CSS -->
		<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
		<style type="text/css">
			body
			{
				padding-top: 56px;
			}

			h3
			{
				text-align: center;
			}
		</style>
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
								<li class="nav-item"><a class="nav-link" href="<%=application.getContextPath()%>/article/manage">Gestion des articles</a></li>
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
			<article class="container">
				<!-- Page Content -->
				<div class="row">
					<!-- Post Content Column -->
					<div class="col-lg-8">
						<!-- Title -->
						<h1 class="mt-4">${ article.getTitle() }</h1>
						<!-- Author -->
						<p class="lead">
							by ${ article.getArticleAuthorFirstname() } ${ article.getArticleAuthorLastname() }
						</p>
						<hr>
						<!-- Date/Time -->
						<p>
							Posted on ${ article.getArticleDate() } 
						</p>
						<hr>
						<!-- Post Content -->
						<p class="lead">
							 ${ article.getArticleContent() } 
						</p>
					</div>
				</div>
				<hr>
				<!-- Comment Form -->
				<h3 class="alert-secondary">Espace commentaires:</h3>
				<c:if test="${ !empty sessionScope.userID }">
					<div class="card my-4">
						<h5 class="card-header">
							Laisse un commentaire :
						</h5>
						<div class="card-body">
							<form method="post" class="form-group">
								<div class="form-group">
									<textarea class="form-control" name="newComment" id="newComment" rows="3" placeholder="Ex: Whoua mais quel article sympa!... " maxlength="65000"></textarea>
								</div>
								<button type="submit" class="btn btn-primary">Commenter</button>
							</form>
						</div>
					</div>
				</c:if>
				<!-- Comments list -->
				<br>
				<c:forEach var="comment" items="${ commentList }"  varStatus="status">
					<div class="media mb-4">
						<img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
						<div class="media-body">
							<h5 class="mt-0">
								Commentaire écrit par ${ comment.getAuthorFirstname() } ${ comment.getAuthorLastname() }, le ${ comment.getCommentDate() }.
							</h5>
							${ comment.getCommentContent() }
						</div>
					</div>
				</c:forEach>
			</article>
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
