package vue;


import com.sun.media.jfxmedia.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class VueAccueilCommentaire extends Vue {
	
	public static VueAccueilCommentaire instance;
	
	public static VueAccueilCommentaire getInstance() {if(null == instance)instance = new VueAccueilCommentaire(); return instance;}
	
	protected Button actionLaisserCommentaire;
	
	private VueAccueilCommentaire () {
		super("vue_accueil_commentaire.fxml");
	}
	
	/**
	 * Permet de gerer les controles
	 */
	public void activerControles(){
		super.activerControles();
		actionLaisserCommentaire = (Button)lookup("#vue-accueil-action-laisser-commentaire");
		
		actionLaisserCommentaire.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Logger.logMsg(Logger.INFO, "Clic sur actionLaisserCommentaire VueAcceuilCommentaire()");
				System.out.println("Clic sur actionLaisserCommentaire VueAcceuilCommentaire()");
			}});
	}
}
