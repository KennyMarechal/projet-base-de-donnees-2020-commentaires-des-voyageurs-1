<?php

class CommentaireDAO
{
	public static function listerCommentaires()
	{
		include "accesseur/connexion.php";
		include 'model/Commentaire.php';
		
		$SQL_LISTE_COMMENTAIRE = "SELECT id, titre,contenu, auteur, date, note FROM commentaire ORDER BY date DESC;";
		$requeteListeCommentaire = $basededonnees->prepare($SQL_LISTE_COMMENTAIRE);
		$resultat = $requeteListeCommentaire->execute();
		$listeCommentaires = $requeteListeCommentaire->fetchAll(PDO::FETCH_OBJ);
		$listeCommentaireModel = [];

		foreach($listeCommentaires as $commentaire)
		{
			$commentaireModel = new Commentaire(json_decode(json_encode($commentaire), true));
			array_push($listeCommentaireModel, $commentaireModel);
		}

		return $listeCommentaireModel;
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
		$MESSAGE_SQL_AJOUTER_COMMENTAIRE =
		"INSERT INTO commentaire (titre, auteur, contenu, date, note) VALUES(" .
		":titre," .
		":auteur," .
		":contenu," .
		":date," .
		":note" .
		");";

		$requeteAjouterCommentaire = $basededonnees->prepare($MESSAGE_SQL_AJOUTER_COMMENTAIRE);

		$requeteAjouterCommentaire->bindParam(':titre', $commentaire->titre, PDO::PARAM_STR);
		$requeteAjouterCommentaire->bindParam(':auteur', $commentaire->auteur, PDO::PARAM_STR);
		$requeteAjouterCommentaire->bindParam(':contenu', $commentaire->contenu, PDO::PARAM_STR);
		$requeteAjouterCommentaire->bindParam(':date', $commentaire->date, PDO::PARAM_STR);
		$requeteAjouterCommentaire->bindParam(':note', $commentaire->note, PDO::PARAM_INT);


		$reussiteAjout = $requeteAjouterCommentaire->execute();
		print_r($requeteAjouterCommentaire->errorInfo());
		//var_dump($reussiteAjout);
		//echo $reussiteAjout->fullQuery;
		//echo($reussiteAjout);
	}

	public static function compterCommentaires()
	{
		include "accesseur/connexion.php";

		$SQL_COMPTER_COMMENTAIRE = "SELECT COUNT(*) AS nombreCommentaire FROM commentaire;";
		$requeteCompterCommentaire = $basededonnees->prepare($SQL_COMPTER_COMMENTAIRE);
		$resultat = $requeteCompterCommentaire->execute();
		$nombreCommentaires = $requeteCompterCommentaire->fetchAll(PDO::FETCH_OBJ);

		return $nombreCommentaires;
	}

	public static function listerLimiteCommenataire($premier , $parPage)
	{
		include "accesseur/connexion.php";

		$SQL_LISTER_LIMITE_COMMENTAIRE = "SELECT * FROM commentaire ORDER BY date DESC LIMIT '$parPage' OFFSET '$premier';";
		$requeteListerLimiteCommentaire = $basededonnees->prepare($SQL_LISTER_LIMITE_COMMENTAIRE);
		$resultat = $requeteListerLimiteCommentaire->execute();
		$listerLimiteCommentaires = $requeteListerLimiteCommentaire->fetchAll(PDO::FETCH_OBJ);

		return $listerLimiteCommentaires;
	}
}
?>