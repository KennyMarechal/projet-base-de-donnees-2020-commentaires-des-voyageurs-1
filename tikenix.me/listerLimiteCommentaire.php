<?php
	include "donnee/CommentaireDAO.php";
    $commentaireDAO = new CommentaireDAO();
    $premier = $_GET['premier'];
    $parPage = $_GET['parPage'];

    $listerLimiteCommentaire = $commentaireDAO->listerLimiteCommenataire($premier,$parPage);

    header("Content-type: text/xml");
	echo '<?xml version="1.0" encoding="UTF-8"?>';
?>
<commentaires>
<?php
	foreach($listerLimiteCommentaire as $commentaire)
	{
		?>
	<commentaire>
	<id><?=$commentaire->id?></id>
	<titre><?=$commentaire->titre?></titre>
	<commentaire><?=$commentaire->contenu?></commentaire>
	<auteur><?=$commentaire->auteur?></auteur>
	</commentaire>
	<?php
	}
?>
</commentaires>