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

		.card
		{
			margin-left: 25%;
		}

		.form-control
		{
			margin-left: 12%;
		}
	</style>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
		<title>  Le Rabicoin à ragots- Création de compte</title>
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
			<!-- Add User Form -->
			<div class="card w-50">
				<div class="card-header">
					<h3>Inscription :</h3>
				</div>
				<form method="post" class="form-group">
					<label for="firstname"><strong>Prénom (20 caractères max):</strong></label>
					<input type="text" class="form-control w-75" name="firstname" id="firstname" placeholder="Ex: John" maxlength="20" required>
					<br>
					<br>
					<label for="lastname"><strong>Nom (30 caractères max):</strong></label>
					<input type="text" class="form-control w-75" name="lastname" id="lastname" placeholder="Ex: Doe" maxlength="30" required>
					<br>
					<br>
					<label for="login"><strong>Login (30 caractères max):</strong></label>
					<input type="text" class="form-control w-75" name="login" id="login" placeholder="Ex: MonLoginSécurisé" maxlength="30" required>
					<br>
					<br>
					<label for="password"><strong>Mot de passe (30 caractères max):</strong></label>
					<input type="text" class="form-control w-75" name="password" id="password" placeholder="Ex: MonSuperMotDePasse" maxlength="30" required>
					<br>
					<button type="submit" class="btn btn-primary">Créér un compte</button>
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
