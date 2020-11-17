<?php
	include "donnee/CommentaireDAO.php";
	$commentaireDAO = new CommentaireDAO();
	$dernierCommentaire = $commentaireDAO->listerDernierCommentaire();

	header("Content-type: text/xml");
	echo '<?xml version="1.0" encoding="UTF-8"?>';
	//print_r($dernierCommentaire);
?>
<commentaires>
<?php
	foreach($dernierCommentaire as $commentaire)
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