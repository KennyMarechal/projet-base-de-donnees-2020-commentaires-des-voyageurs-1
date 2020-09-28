package vue;

import java.awt.Button;

public class VueAccueilCommentaire extends Vue {
	
	public static VueAccueilCommentaire instance;
	
	public static VueAccueilCommentaire getInstance() {if(null == instance)instance = new VueAccueilCommentaire(); return instance;}
	
	protected Button actionLaisserCommentaire;
	
	private VueAccueilCommentaire () {
		super("vue_accueil_commentaire.fxml");
	}
	

}
