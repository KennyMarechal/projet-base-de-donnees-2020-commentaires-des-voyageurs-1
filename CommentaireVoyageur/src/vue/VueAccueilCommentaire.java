package vue;

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
	public void activercontroles() {
		super.activerControles();
		actionLaisserCommentaire = (Button)lookup("#vueAccueilActionLaisserCommentaire");
		
		actionLaisserCommentaire.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Clic sur actionLaisserCommentaire VueAcceuilCommentaire()");
			}});
	}
}
