	
	<c:import url="/inc/head.jsp" />
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Produits</h1>
          
              <div class="row">
				<form method="post" action="ajouterProduit" class="form-signin" >
          			<h2>Ajouter un nouveau produit</h2>
          			<div class="row">
          				<label class="col-md-2" for="nom">Nom Produit:</label>
          				<input class="col-md-2 " type="text" name="nom" id="nom" size="20"/>
          			</div><br>
          			<div class="row">
          				<label class="col-md-2" for="type">Catégorie Produit:</label>
          				<select name="type" class="col-md-2 ">
          					<c:forEach var="categorie" items="${ listeCategorie }">
          						<option value="${ categorie.id }">${categorie.id }. ${ categorie.nom }</option>
          					</c:forEach>
          				</select>
          			</div><br>
          			<div class="row">
          				<label class="col-md-2" for="fournisseur">Fournisseur Produit:</label>
          				<select name="fournisseur" class="col-md-2">
          					<c:forEach var="fournisseur" items="${ listeFournisseur }">
          						<option value="${ fournisseur.id }">${ fournisseur.id }. ${ fournisseur.nom }</option>
          					</c:forEach>
          				</select>
          			</div><br>
          			<div class="row">
          				<label class="col-md-2" for="montantAchat">Montant Achat:</label>
          				<input class="col-md-2 " type="text" name="montantAchat"/>
          			</div>
          			<div class="row">
          				<label class="col-md-2" for="montantVente">Montant Vente:</label>
          				<input class="col-md-2 " type="text" name="montantVente"/>
          			</div><br>
          			<div class="row">
          				<label class="col-md-2" for="vendu">Nombre Vendu:</label>
          				<input class="col-md-2 " type="text" name="vendu"/>
          			</div><br>        
          			<button class="btn btn-primary" type="submit">Ajouter </button>  			          			
                </form>
		      </div>
      </div>

    </div>

    

 </body>
 </html>