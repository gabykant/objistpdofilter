<%@include file="header.jsp" %>

<div class="row">
	<a href="filmform.jsp" class="btn btn-primary">AJOUTER UN FILM</a>
</div>

<div class="row">
	<div class="col-md-12">
		<div class="box">
			<hr />
			<c:choose>
			    <c:when test="${ items.size() != 0 }">
			        <c:forEach var="row" items="${items}">
					    ${row.author}<br/>
					    ${row.title}<br/>
					</c:forEach>
			    </c:when>    
			    <c:otherwise>
			    	<div class="text-center">
			        	<p>Aucune donn&eacute;es &agrave; afficher</p> 
			        </div>
			    </c:otherwise>
			</c:choose>
		</div>
	</div>
</div>

<%@include file="footer.jsp" %>