package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import donnee.CommentaireDAO;
import modele.Commentaire;
import vue.Navigateur;
import vue.Vue;
import vue.VueAccueilCommentaire;
import vue.VueAjouterCommentaire;
import vue.VueCommentaires;
//import vue.VueAjouterCommentaire;


public class Controleur {
	
	protected static CommentaireDAO commentaireDAO = new CommentaireDAO();
	
	//protected static List<Commentaire> listeCommentairesMockup;
	
	public Controleur() {
		Logger.logMsg(Logger.INFO, "new Controleur()");
	}
	
	public static Vue selectionnerVuePrincipale() 
	{ 
		/*La vue principale c'est la vue qui comporte les listes*/
		VueAccueilCommentaire.getInstance().afficherCommentaire(commentaireDAO.listerDerniersCommentaires());
		return VueAccueilCommentaire.getInstance();
		//return VueAjouterCommentaire.getInstance();
	}
	
	public void notifierNavigationVueAjoutCommentaire() {
		Navigateur.getInstance().afficherVue(VueAjouterCommentaire.getInstance());
	}
	
	public void notifierNavigationVueAcceuilCommentaire() {
		Navigateur.getInstance().afficherVue(VueAccueilCommentaire.getInstance());
	}
	
	public void notifierActionEnvoyerAjouterCommentaire(Commentaire commentaire) {
		Logger.logMsg(Logger.INFO, "Clic sur ENVOYER reception dans le controleur");
		// enregistrer les infos dans le DAO
		commentaireDAO.ajouterCommentaire(commentaire);
		VueAccueilCommentaire.getInstance().afficherCommentaire(commentaireDAO.listerDerniersCommentaires());
		Navigateur.getInstance().afficherVue(VueAccueilCommentaire.getInstance());
	}

	public void notifierNavigationVueCommentaires(String id)
	{
		Logger.logMsg(Logger.INFO, id);
		//Commentaire commentaire = commentaireDAO.detaillerCommentaire(Integer.parseInt(id));
		
		//VueCommentaires.getInstance().afficherInfosCommentaire(commentaire);
		//Navigateur.getInstance().afficherVue(VueCommentaires.getInstance());
	}

	public void notifierSynchronisation()
	{
		// TODO Auto-generated method stub
		Logger.logMsg(Logger.INFO, "Clic sur Synchroniser");

	}
	

}
