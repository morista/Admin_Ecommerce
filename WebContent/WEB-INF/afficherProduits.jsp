	
	<c:import url="/inc/head.jsp" />
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Produits</h1>
          
          	<c:forEach var="produit" items="${ ListProduit }">
          		<div class="row">
          		 <div class="col-md-4">
					<p><a href=""> <c:out value="${ produit.nom }"/> </a></p>
					<p>Catégory: <c:out value="${ produit.categorie }"/> </p>
					<p>Prix d'achat: <c:out value="${ produit.montantAchat }"/>  </p>
					<p>Prix de vente: <c:out value=" ${ produit.montantVente }"/> </p>
					<p>Nombre vendu: <c:out value="${ produit.vendu }"/> </p>
					<p>Fournisseur <c:out value="${ produit.fournisseurs }"/> </p>
				 </div>
				 <div class="col-md-offset-6 col-md-2">
				 	<a href="<c:url value="/supprime"> <c:param name="idProduit" value="${ produit.id }" /></c:url>"
				 	   class="btn btn-block btn-lg btn-danger">
				 		<span class="glyphicon glyphicon-trash"></span> Supprimer
				 	</a><br><br>
				 	<a href="<c:url value="/supprimerProduit"> <c:param name="idProduit" value="${ produit.id }" /></c:url>" 
				 	   class="btn btn-block btn-lg btn-warning">
				 		<span class="glyphicon glyphicon-edit"></span> Modifier
				 	</a>
				 </div>	
		    	</div><br>
          	
          	</c:forEach>

      </div>

    </div>

    

 </body>
 </html>