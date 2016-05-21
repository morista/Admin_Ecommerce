	
	<c:import url="/inc/head.jsp" />
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Page d'administration</h1>
          
              <div class="row">
				<form method="post" action="addUser" class="form-signin" >
          			<h2>Ajouter un nouveau Utilisateur</h2>
          			<div class="row">
          				<label class="col-md-2" for="nom">Nom User:</label>
          				<input class="col-md-2 " type="text" name="nom" id="nom" size="20"/>
          			</div><br>
          			<div class="row">
          				<label class="col-md-2" for="type">Type User:</label>
          				<input class="col-md-2 " type="text" name="typeU" id="type"/>
          			</div><br>
          			<div class="row">
          				<label class="col-md-2" for="login">Login User:</label>
          				<input class="col-md-2 " type="text" name="login" id="login"/>
          			</div><br>
          			<div class="row">
          				<label class="col-md-2" for="pass">Mot de Passe:</label>
          				<input class="col-md-2 " type="password" name="pass"/>
          			</div><br>        
          			<button class="btn btn-primary" type="submit">Ajouter </button>  			          			
                </form>
		      </div>
      </div>

    </div>

    

 </body>
 </html>