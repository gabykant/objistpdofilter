<%@include file="header.jsp" %>

<div class="row">
	<a href="index.jsp" class="btn btn-primary">LISTE DES FILMS</a>
</div>

<div class="row">
	<div class="col-md-12">
		<div class="box">
			<hr />
			<h2>Connectez vous !</h2>
			<form action="/Module8Seance12/login" method="post">
			  <div class="form-group">
			    <label for="userEmail">Votre identifiant</label>
			    <input type="email" class="form-control" name="userEmail" id="userEmail" placeholder="Entrez votre adresse email" required>
			  </div>
			  <div class="form-group">
			    <label for="userPass">Votre Mot de Passe</label>
			    <input type="password" class="form-control" name="userPass" id="userPass" placeholder="Entrez votre mot de passe" required>
			  </div>
			  <button type="submit" class="btn btn-success">Se Connecter</button>
			</form>
		</div>
	</div>
</div>

<%@include file="footer.jsp" %>