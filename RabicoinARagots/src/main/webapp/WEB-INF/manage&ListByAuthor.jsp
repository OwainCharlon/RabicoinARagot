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
		<meta name="description" content="">
		<meta name="author" content="">
		<title>
			Le Rabicoin à ragots-  
			<c:choose>
				<c:when test="${ articlesByAuthor == true }">
					Articles_par_auteur
				</c:when>
				<c:otherwise>
					Gestion_de_contenu
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
		<main>
			<div class="container align-item-center">
				<h3 class="alert-secondary">
					<c:choose>
						<c:when test="${ articlesByAuthor == true }">
							Voici la liste d'articles de ${ authorFirstname } ${ authorLastname } :
						</c:when>
						<c:otherwise>
							Gérer mes articles :
						</c:otherwise>
					</c:choose>
				</h3>
				<br>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead class="thead-dark">
							<tr>
								<th scope="col">
									ID
								</th>
								<th scope="col">
									Title
								</th>
								<th scope="col">
									Auteur
								</th>
								<th scope="col">
									Date
								</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="article" items="${ articleList }"  varStatus="status">
								<tr>
									<th scope="row">
										${ article.getArticleID() }
									</th>
									<td>
										${ article.getTitle() }
									</td>
									<td>
										${ article.getArticleAuthorFirstname() } ${ article.getArticleAuthorLastname() }
									</td>
									<td>
										${ article.getArticleDate() }
									</td>
									<c:choose>
										<c:when test="${ articlesByAuthor == true }">
											<td>
												<a href="<%=application.getContextPath()%>/article/read?id=${ article.getArticleID() }" class="btn btn-primary">Lire l'article</a>
											</td>
										</c:when>
										<c:otherwise>
											<td>
												<a href="<%=application.getContextPath()%>/article/update?id=${ article.getArticleID() }" class="btn btn-primary">Modifier l'article</a>
											</td>
											<td>
												<a href="<%=application.getContextPath()%>/article/delete?id=${ article.getArticleID() }" class="btn btn-primary">Supprimer l'article</a>
											</td>
										</c:otherwise>
									</c:choose>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<c:if test="${ articlesByAuthor != true }">
					<br>
					<br>
					<h3 class="alert-secondary">Gérer mes commentaires :</h3>
					<br>
					<div class="table-responsive">
						<table class="table table-striped">
							<thead class="thead-dark">
								<tr>
									<th scope="col">
										ID
									</th>
									<th scope="col">
										Contenu
									</th>
									<th scope="col">
										Auteur
									</th>
									<th scope="col">
										Date
									</th>
									<th></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="comment" items="${ commentList }"  varStatus="status">
									<tr>
										<th scope="row">
											${ comment.getCommentID() }
										</th>
										<td>
											${ comment.getCommentContent() }
										</td>
										<td>
											${ comment.getAuthorFirstname() } ${ comment.getAuthorLastname() }
										</td>
										<td>
											${ comment.getCommentDate() }
										</td>
										<td>
											<a href="<%=application.getContextPath()%>/comment/update?id=${ comment.getCommentID() }" class="btn btn-primary">Modifier le commentaire</a>
										</td>
										<td>
											<a href="<%=application.getContextPath()%>/comment/delete?id=${ comment.getCommentID() }" class="btn btn-primary">Supprimer le commentaire</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</c:if>
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