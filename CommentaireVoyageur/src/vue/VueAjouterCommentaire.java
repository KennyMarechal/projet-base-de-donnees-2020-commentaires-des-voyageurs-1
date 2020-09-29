package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class VueAjouterCommentaire extends Vue{
	
	public static VueAjouterCommentaire instance;
	
	/***
	 * Singleton de la vueAjouterCommentaire
	 * @return intance de la vue ajouter commentaire
	 */
	public static VueAjouterCommentaire getInstance() {if(null == instance)instance = new VueAjouterCommentaire(); return instance;}
	
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
		actionEnvoyer = (Button)lookup("#VueAjouterCommentaireActionEnvoyer");
		
		actionRetour.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Clic sur BACK VueAjouterCommentaire()");
			}});
		
		actionEnvoyer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Clic sur ENVOYER VueAjouterCommentaire()");
			}});
	}
}
