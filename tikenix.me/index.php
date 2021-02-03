<?php
	$listeCommentaire = simplexml_load_file("https://tikenix.me/service/lecture/commentaires");
	$totalCommantaire = $listeCommentaire[0]->commentaire[0]->nombreCommentaire;

	// On détermine sur quelle page on se trouve
	if(isset($_GET['page']) && !empty($_GET['page'])){
		$currentPage = (int) strip_tags($_GET['page']);
	}else{
		$currentPage = 1;
	}
	// On détermine le nombre commentaire par page
	$parPage = 5;
	// On calcule le nombre de pages total
	$pages = ceil($totalCommantaire / $parPage);
	// Calcul du 1er commentaire de la page
	$premier = ($currentPage * $parPage) - $parPage;

	$urlLimite = ("http://tikenix.me/listerLimiteCommentaire.php?premier=".$premier."&parPage=".$parPage."");
	$listeLimiteCommentaire = simplexml_load_file($urlLimite);
	//print_r($listeLimiteCommentaire);
?> 

<!doctype html>
<html lang="fr">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="decoration/style.css">
		<link rel="icon" href="image/tortue.png">
		<title>Les Croissières Poisson</title>
	</head>
	<header></header>
	<body>
		
		<section id = "contenu">
			<?php
			foreach($listeLimiteCommentaire as $commentaire)
			{
			?>
			<div class="bloc-commentaire">
				<h3 class="auteur"><?=$commentaire->auteur?></h3>
				<h4 class="titre"><?=$commentaire->titre?></h4>
				<p class="commentaire"><?=$commentaire->commentaire?></p>
			</div>
			<?php
			}
			?>
		</section>
		<nav>
			<ul class="pagination">
				<!-- Lien vers la page précédente (désactivé si on se trouve sur la 1ère page) -->
				<li class="page-item" <?= ($currentPage == 1) ? "hidden" : "" ?>>
					<a href="./?page=<?= $currentPage - 1 ?>" class="page-link">Précédente</a>
				</li>
				<?php for($page = 1; $page <= $pages; $page++): ?>
					<!-- Lien vers chacune des pages (activé si on se trouve sur la page correspondante) -->
					<li class="page-item <?= ($currentPage == $page) ? "active" : "" ?>">
						<a href="./?page=<?= $page ?>" class="page-link"><?= $page ?></a>
					</li>
				<?php endfor ?>
					<!-- Lien vers la page suivante (désactivé si on se trouve sur la dernière page) -->
					<li class="page-item" <?= ($currentPage == $pages) ? "hidden" : "" ?>>
					<a href="./?page=<?= $currentPage + 1 ?>" class="page-link">Suivante</a>
				</li>
			</ul>
		</nav>
		<div class="logo-right"><img class="baleine-droite" src="image/baleine.png"></div>
		<div class="logo-left"><img class="baleine-gauche"src="image/baleine.png"></div>
	</body>
</html>