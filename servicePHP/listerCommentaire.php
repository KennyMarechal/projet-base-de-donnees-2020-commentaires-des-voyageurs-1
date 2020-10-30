<?php
	include "donnee/CommentaireDAO.php";
	$commentaireDAO = new CommentaireDAO();
	$listecommentaire = $commentaireDAO->listerCommentaires();

	header("Content-type: text/xml");
	echo '<?xml version="1.0" encoding="UTF-8"?>';
	//print_r($listecommentaire);
?>
<commentaires>
<?php
	foreach($listecommentaire as $commentaire)
	{
		?>
	<commentaire>
	<id><?=$commentaire->id?></id>
	<titre><?=$commentaire->titre?></titre>
	<date><?=$commentaire->date?></date>
	</commentaire>
	<?php
	}
?>
</commentaires>