package vue;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class VueAccueilCommentaire extends Vue {
	
	public static VueAccueilCommentaire instance;
	
	public static VueAccueilCommentaire getInstance() {if(null == instance)instance = new VueAccueilCommentaire(); return instance;}
		
	protected Controleur controleur;
	
	private VueAccueilCommentaire () {
		super("vue_accueil_commentaire.fxml");
		super.controleur = this.controleur = new Controleur();
		Logger.logMsg(Logger.INFO, "new VueAccueilCommentaire()");
	}
	
	/**
	 * Permet de gerer les controles
	 */
	public void activerControles(){
		super.activerControles();
		Button actionLaisserCommentaire = (Button)lookup("#vue-accueil-action-laisser-commentaire");
		
		actionLaisserCommentaire.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Logger.logMsg(Logger.INFO, "Clic sur actionLaisserCommentaire VueAcceuilCommentaire()");
				controleur.notifierNavigationVueAjoutCommentaire();
			}});
	}
}
