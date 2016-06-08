	
	<c:import url="/inc/head.jsp" />
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Catégorie</h1>
          
              <div class="row">
				<form method="post" action="ajouterCategorie" >
          			<h2>Ajouter un nouveau Catégorie</h2>
          			
        			  <div class="form-group">
          				<label for="nom">Nom Catégorie:</label>
          				<input class="form-control" type="text" id="nom" name="nom"/>
					  </div>
   					  <div class="form-group">
          				<label for="description">Description:</label>
          				<input class="form-control" type="text" name="description"/>
					  </div>
       
          			<button class="btn btn-default" type="submit">Ajouter </button>  			          			
                </form>
		      </div>
      </div>

    </div>

    

 </body>
 </html>