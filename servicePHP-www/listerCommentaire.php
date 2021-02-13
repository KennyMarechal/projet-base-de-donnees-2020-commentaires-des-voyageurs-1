<?php
	include "donnee/CommentaireDAO.php";
	$commentaireDAO = new CommentaireDAO();
	$listecommentaire = $commentaireDAO->listerCommentaires();
	$nombreCommentaire = $commentaireDAO->compterCommentaires();

	header("Content-type: text/xml");
	echo '<?xml version="1.0" encoding="UTF-8"?>';
?>
<commentaires>
<?php
	foreach($listecommentaire as $commentaire)
	{
		?>
	<commentaire>
	<id><?=$commentaire->getId()?></id>
	<titre><?=$commentaire->getTitre()?></titre>
	<commentaire><?=$commentaire->getContenu()?></commentaire>
	<auteur><?=$commentaire->getAuteur()?></auteur>
	<nombreCommentaire><?=$nombreCommentaire[0]->nombrecommentaire?></nombreCommentaire>
	</commentaire>
	<?php
	}
?>
</commentaires>