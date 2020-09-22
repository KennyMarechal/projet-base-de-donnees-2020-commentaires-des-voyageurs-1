package vue;

import com.sun.media.jfxmedia.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class VueAjouterCommentaire extends Vue {
	
	public static VueAjouterCommentaire intance;
	
	/***
	 * Singleton de la vueAjouterCommentaire
	 * @return intance de la vue ajouter commentaire
	 */
	public static VueAjouterCommentaire getInstance() {if(null == intance)intance = new VueAjouterCommentaire(); return intance;}
	
	protected Button actionRetour;
	protected Button actionEnvoyer;
	
	private VueAjouterCommentaire() {
		super("vue_ajouter_commentaire.fxml");
	}
	
	/**
	 * Permet de gerer les controles
	 */
	public void activercontroles() {
		super.activerControles();
		actionRetour = (Button)lookup("#VueAjouterCommentaireActionRetour");
		actionEnvoyer = (Button)lookup("#VueAjouterCommentaireActionEvoyer");
		
		actionRetour.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Logger.logMsg(Logger.INFO, "Clic sur BACK VueAjouterCommentaire()");
			}});
		
		actionEnvoyer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Logger.logMsg(Logger.INFO, "Clic sur ENVOYER VueAjouterCommentaire()");
			}});
	}

}
