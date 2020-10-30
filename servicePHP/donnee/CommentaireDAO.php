<?php
	
class CommentaireDAO
{
	public static function listerCommentaires()
	{
		include "accesseur/connexion.php";
		
		$SQL_LISTE_COMMENTAIRE = "SELECT id, titre, date FROM commentaire ORDER BY date DESC";
		$requeteListeCommentaire = $basededonnees->prepare($SQL_LISTE_COMMENTAIRE);
		$resultat = $requeteListeCommentaire->execute();
		$listeCommentaires = $requeteListeCommentaire->fetchAll(PDO::FETCH_OBJ);
		
		return $listeCommentaires;
	}
	
	public static function listerDernierCommentaire()
	{
		include "accesseur/connexion.php";
		
		$SQL_LISTER_DERNIER_COMMENTAIRE = "SELECT id, titre, date FROM commentaire ORDER BY date DESC LIMIT 1;";
		$requeteDernierCommentaire = $basededonnees->prepare($SQL_LISTER_DERNIER_COMMENTAIRE);
		$resultat = $requeteDernierCommentaire->execute();
		$dernierCommentaire = $requeteDernierCommentaire->fetchAll(PDO::FETCH_OBJ);
		
		return $dernierCommentaire;
	}
	
	public static function ajouterCommentaire($commentaire)
	{
		include "accesseur/connexion.php";
			
		$SQL_AJOUTER_COMMENTAIRE = "INSERT into commentaire(titre, auteur, contenu, date)
			VALUES('$commentaire->titre','$commentaire->auteur','$commentaire->contenu','$commentaire->date')";
				
		$requeteAjouterCommentaire = $basededonnees->prepare($SQL_AJOUTER_COMMENTAIRE);
		$requeteAjouterCommentaire->execute();
		echo($SQL_AJOUTER_COMMENTAIRE);
	}
}
?>