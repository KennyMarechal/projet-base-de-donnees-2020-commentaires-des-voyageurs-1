<?php
	
class CommentaireDAO
{
	public static function listerCommentaires()
	{
		include "accesseur/connexion.php";
		
		$SQL_LISTE_COMMENTAIRE = "SELECT id, titre,contenu, auteur, date, note FROM commentaire ORDER BY date DESC;";
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
			
		/*$SQL_AJOUTER_COMMENTAIRE = "INSERT into commentaire(titre, auteur, contenu, date, note)
			VALUES('$commentaire->titre','$commentaire->auteur','$commentaire->contenu','$commentaire->date','$commentaire->note')";
				
		$requeteAjouterCommentaire = $basededonnees->prepare($SQL_AJOUTER_COMMENTAIRE);
		$requeteAjouterCommentaire->execute();
		echo($SQL_AJOUTER_COMMENTAIRE);*/
		//SELECT to_timestamp(?, 'YYYY-MM-DD HH24:MI:SS')::TIMESTAMP WITHOUT TIME ZONE;
		/*2020-11-24 15:59:56.718
		$MESSAGE_SQL_AJOUTER_COMMENTAIRE =
		"INSERT INTO commentaire (titre, auteur, contenu, date, note) VALUES(" .
		":titre," .
		":auteur," .
		":contenu," .
		"to_timestamp((:date)::timestamp, 'YYYY-MM-DD HH24:MI:SS')::TIMESTAMP WITHOUT TIME ZONE," .
		":note" .
		");";*/

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