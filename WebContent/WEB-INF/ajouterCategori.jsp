	
	<c:import url="/inc/head.jsp" />
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Cat�gorie</h1>
          
              <div class="row">
				<form method="post" action="ajouterCategorie" class="form-signin" >
          			<h2>Ajouter un nouveau Cat�gorie</h2>
          			<div class="row">
          				<label class="col-md-2" for="nom">Nom Cat�gorie:</label>
          				<input class="col-md-2 " type="text" name="nom" id="nom" size="20"/>
          			</div><br>
          			
          			<div class="row">
          				<label class="col-md-2" for="description">Description:</label>
          				<input class="col-md-2 " type="text" name="description"/>
          			</div><br>
       
          			<button class="btn btn-primary" type="submit">Ajouter </button>  			          			
                </form>
		      </div>
      </div>

    </div>

    

 </body>
 </html>