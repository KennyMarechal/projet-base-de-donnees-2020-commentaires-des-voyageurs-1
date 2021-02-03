<?php 
	include "donnee/CommentaireDAO.php";
	include "model/Commentaire.php";
	
	print_r($_POST);

	$commentaireDAO = new CommentaireDAO();
	
	$commentaireTableau = $_POST;
	
	$commentaire = new Commentaire();
	
	$commentaire->setTitre($commentaireTableau['titre']);
	$commentaire->setAuteur($commentaireTableau['auteur']);
	$commentaire->setContenu($commentaireTableau['contenu']);
	$commentaire->setDate($commentaireTableau['date']);
	$commentaire->setNote($commentaireTableau['note']);
	
	$commentaireDAO->ajouterCommentaire($commentaire);
?>