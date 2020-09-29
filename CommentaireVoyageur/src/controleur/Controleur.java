package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import vue.Navigateur;
import vue.Vue;
import vue.VueAccueilCommentaire;
import vue.VueAjouterCommentaire;
//import vue.VueAjouterCommentaire;


public class Controleur {
	
	public Controleur() {
		Logger.logMsg(Logger.INFO, "new Controleur()");
	}
	
	public static Vue selectionnerVuePrincipale() 
	{
		/*La vue principale c'est la vue qui comporte les listes*/
		return VueAccueilCommentaire.getInstance();
		//return VueAjouterCommentaire.getInstance();
	}
	
	public void notifierNavigationVueAjoutCommentaire() {
		Navigateur.getInstance().afficherVue(VueAjouterCommentaire.getInstance());
	}
	
	public void notifierNavigationVueAcceuilCommentaire() {
		Navigateur.getInstance().afficherVue(VueAccueilCommentaire.getInstance());
	}
	
	public void notifierActionEnvoyerAjouterCommentaire() {
		Logger.logMsg(Logger.INFO, "Clic sur ENVOYER reception dans le controleur");
		//TODO enregistrer les infos dans le DAO
	}
}
