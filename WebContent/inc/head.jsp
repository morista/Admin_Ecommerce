<!DOCTYPE html>
<html>
  <head>
     <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	<meta charset="utf-8"/>
    <link href="<c:url value="/inc/tut.css"/>" rel="stylesheet">
  </head>
  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button> 
          <a class="navbar-brand" href="#">E-COMMERCE</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
          <li> <a href="#"><span class="glyphicon glyphicon-user"></span> ${sessionScope.sessionUtilisateur.login} </a> </li>

          <li> <a href="<c:url value="/deconnexion"/>"> Deconnexion </a> </li>
          </ul>
            <form role="form" class="navbar-form navbar-right">
              <div class="input-group ">
                <div class="input-group-btn ">
                  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"> Produit 
                    <span class="caret"></span>
                  </button>
                  <ul class="dropdown-menu">
                      <li class="list-group-item">
                        <span class="badge"></span>
                        Informatique
                      </li>
                      <li class="list-group-item">
                        <span class="badge"></span>
                        Meublier
                      </li>
                      <li class="list-group-item">
                        <span class="badge"></span>
                        Cuisine
                      </li>
                      <li class="list-group-item">
                        <span class="badge"></span>
                       Automobile
                      </li>
                  </ul>
                </div>
              <input type="text" class="form-control" >
              </div>
          </form>

        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar list-group">
          
            <li class="list-group-item"><a href="<c:url value="produit"/>">Afficher liste Produits</a></li>
            <li class="list-group-item"><a href="<c:url value="ajouterProduit"/>">Ajouter Produit</a></li>
            <li class="list-group-item"><a href="#">Afficher liste Categories</a></li>
            <li class="list-group-item"><a href="<c:url value="ajouterCategorie"/>">Ajouter Categories</a></li>
            <li class="list-group-item"><a href="">Liste Utilisateur</a></li>
            <li class="list-group-item"><a href="<c:url value="addUser"/>">Ajouter Utilisateur</a></li>
            <li class="list-group-item"><a href="">Liste Commande</a></li>
            <li class="list-group-item"><a href="">Suivi Client</a></li>
            <li class="list-group-item"><a href="">Statistiques</a></li>
       
          </ul>
        </div>