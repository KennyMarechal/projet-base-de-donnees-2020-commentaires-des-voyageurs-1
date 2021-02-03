<?php
	include "donnee/CommentaireDAO.php";
	$commentaireDAO = new CommentaireDAO();
	$listecommentaire = $commentaireDAO->listerCommentaires();
	$nombreCommentaire = $commentaireDAO->compterCommentaires();

	header("Content-type: text/xml");
	echo '<?xml version="1.0" encoding="UTF-8"?>';
	//print_r($nombreCommentaire);
?>
<commentaires>
<?php
	foreach($listecommentaire as $commentaire)
	{
		?>
	<commentaire>
	<id><?=$commentaire->id?></id>
	<titre><?=$commentaire->titre?></titre>
	<commentaire><?=$commentaire->contenu?></commentaire>
	<auteur><?=$commentaire->auteur?></auteur>
	<nombreCommentaire><?=$nombreCommentaire[0]->nombrecommentaire?></nombreCommentaire>
	</commentaire>
	<?php
	}
?>
</commentaires>