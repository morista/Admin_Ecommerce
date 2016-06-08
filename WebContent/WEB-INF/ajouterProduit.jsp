	
	<c:import url="/inc/head.jsp" />
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Produits</h1>
          
              <div class="row">
				<form method="post" action="ajouterProduit" >
          			<h2>Ajouter un nouveau produit</h2>
          			
					  <div class="form-group">
          				<label for="nom">Nom Produit:</label>
          				<input class="form-control" type="text" name="nom" id="nom" size="20"/>
					  </div>
					  <div class="form-group">
          				<label for="type">Catégorie Produit:</label>
          				<select name="type" class="form-control">
          					<c:forEach var="categorie" items="${ listeCategorie }">
          						<option value="${ categorie.id }">${categorie.id }. ${ categorie.nom }</option>
          					</c:forEach>
          				</select>
					  </div>
					  <div class="form-group">
          				<label for="fournisseur">Fournisseur Produit:</label>
          				<select name="fournisseur" class="form-control">
          					<c:forEach var="fournisseur" items="${ listeFournisseur }">
          						<option value="${ fournisseur.id }">${ fournisseur.id }. ${ fournisseur.nom }</option>
          					</c:forEach>
          				</select>
					  </div>
  					  <div class="form-group">
          				<label for="montantAchat">Montant Achat:</label>
          				<input class="form-control" type="text" name="montantAchat"/>
					  </div>
   					  <div class="form-group">
          				<label for="montantVente">Montant Vente:</label>
          				<input class="form-control" type="text" name="montantVente"/>
					  </div>
   					  <div class="form-group">
          				<label for="qtt">Quantite du produit:</label>
          				<input class="form-control" type="text" name="qtt"/>
					  </div>
					  
					  <button type="submit" class="btn btn-default">Valider</button>
 		          			
                </form>
		      </div>
      </div>

    </div>

    

 </body>
 </html>