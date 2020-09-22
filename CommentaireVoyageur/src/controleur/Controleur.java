package controleur;

import vue.Vue;
import vue.VueAjouterCommentaire;


public class Controleur {
	
	public static Vue selectionnerVuePrincipale() 
	{
		//TODO
		/*La vue principale c'est la vue qui comporte les listes*/
		return VueAjouterCommentaire.getInstance();
	}

}
