<?php
$listeCommentaire = simplexml_load_file("https://tikenix.me/service/lecture/commentaires");
?> 

<!doctype html>
<html lang="fr">
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="decoration/style.css">
	<link rel="icon" href="image/tortue.png">
	<title>Les Croissières Poisson</title>
</head>
<body>
<header></header>
	
	<section id = "contenu">
		<h2>Les Derniers Commentaires</h2>
		<?php
		foreach($listeCommentaire as $commentaire)
		{
		?>
		<div class="bloc-commentaire">
            <h3 class="titre"><?=$commentaire->titre?></h3>
			<span class="commentaire"><?=$commentaire->commentaire?></span>
            <div class="auteur"><?=$commentaire->auteur?></div>
        </div>
		<?php
		}
		?>
	</section>
	<div class="logo-right"><img class="baleine-droite" src="image/baleine.png"></div>
	<div class="logo-left"><img class="baleine-gauche"src="image/baleine.png"></div>
</body>
</html>
