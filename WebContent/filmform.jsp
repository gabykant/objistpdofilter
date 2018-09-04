<%@include file="header.jsp" %>

<div class="row">
	<a href="welcome" class="btn btn-primary">LISTE FILMS</a>
</div>

<div class="row">
	<div class="col-md-12">
		<div class="box">
			<h2>Ajoutez un film dans notre base de donn&eacute;es</h2>
			<form action="/submitFilm" method="post]">
			  <div class="form-group">
			    <label for="filmtitle">Titre du Film</label>
			    <input type="text" class="form-control" id="filmtitle" placeholder="Entrez le titre de votre film">
			  </div>
			  <div class="form-group">
			    <label for="filmauthor">R&eacute;alisateur</label>
			    <input type="text" class="form-control" id="filmauthor" placeholder="Entrez le nom du r&eacute;alisateur du film">
			  </div>
			  <button type="submit" class="btn btn-success">Soumettez Maintenant</button>
			</form>
		</div>
	</div>
</div>

<%@include file="footer.jsp" %>