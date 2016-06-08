	
	<c:import url="/inc/head.jsp" />
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Produits</h1>
          
          		<table class="table table-inverse">
				  <thead>
				    <tr>
				      <th>#</th>
				      <th>Nom</th>
				      <th>Catégory</th>
				      <th>Prix d'achat</th>
				      <th>Prix de vente</th>
				      <th>Quantite</th>
				      <th>Fournisseur</th>
				      <th>action</th>
				    </tr>
				  </thead>
				  <tbody>
			  		<c:forEach var="produit" items="${ ListProduit }">
					    <tr>
					      <th scope="row"><c:out value="${ produit.id }"/></th>
					      <td><c:out value="${ produit.nom }"/></td>
					      <td><c:out value="${ produit.categorie }"/></td>
					      <td><c:out value="${ produit.montantAchat }"/></td>
					      <td><c:out value="${ produit.montantVente }"/></td>
					      <td><c:out value="${ produit.qtt }"/></td>
					      <td><c:out value="${ produit.fournisseurs }"/></td>
					      <td>
					      	<a title="supprimer" href="<c:url value="/supprime"> <c:param name="idProduit" value="${ produit.id }" /></c:url>" class="btn btn-danger">
					 			<span class="glyphicon glyphicon-trash"></span>
					 		</a>
					      	<a title="modifier" href="<c:url value="/supprimerProduit"> <c:param name="idProduit" value="${ produit.id }" /></c:url>" class="btn btn-warning">
					 			<span class="glyphicon glyphicon-edit"></span>
					 		</a>
					      </td>
					    </tr>
				   	</c:forEach>
				  </tbody>
				</table>

      </div>

    </div>

    

 </body>
 </html>