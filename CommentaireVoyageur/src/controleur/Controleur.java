package controleur;

import vue.Vue;
import vue.VueAccueilCommentaire;
import vue.VueAjouterCommentaire;


public class Controleur {
	
	public static Vue selectionnerVuePrincipale() 
	{
		/*La vue principale c'est la vue qui comporte les listes*/
		return VueAccueilCommentaire.getInstance();
		//return VueAjouterCommentaire.getInstance();
	}
}
