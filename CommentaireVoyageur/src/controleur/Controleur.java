package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import donnee.CommentaireDAO;
import modele.Commentaire;
import vue.Navigateur;
import vue.Vue;
import vue.VueAccueilCommentaire;
import vue.VueAjouterCommentaire;
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
		commentaireDAO.enregistrerCommentaire(commentaire);
		Navigateur.getInstance().afficherVue(VueAccueilCommentaire.getInstance());
	}
	

}
