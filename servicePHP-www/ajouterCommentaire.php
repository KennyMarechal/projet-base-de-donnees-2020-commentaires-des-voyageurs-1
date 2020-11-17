<?php 
	include "donnee/CommentaireDAO.php";
	include "model/Commentaire.php";
	
	print_r($_POST);

	$commentaireDAO = new CommentaireDAO();
	
	$commentaireTableau = $_POST;
	
	$commentaire = new Commentaire();
	
	$commentaire->setTitre(addslashes($commentaireTableau['titre']));
	$commentaire->setAuteur(addslashes($commentaireTableau['auteur']));
	$commentaire->setContenu(addslashes($commentaireTableau['contenu']));
	$commentaire->setDate(addslashes($commentaireTableau['date']));
	$commentaire->setNote(addslashes($commentaireTableau['note']));
	
	$commentaireDAO->ajouterCommentaire($commentaire);
?>