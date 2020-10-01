package vue;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.Controleur;
import modele.Commentaire;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class VueAjouterCommentaire extends Vue{
	
	public static VueAjouterCommentaire instance;
	
	/***
	 * Singleton de la vueAjouterCommentaire
	 * @return intance de la vue ajouter commentaire
	 */
	public static VueAjouterCommentaire getInstance() {if(null == instance)instance = new VueAjouterCommentaire(); return instance;}
	
	protected Controleur controleur;
	
	protected TextField textFieldTitreCommentaire =(TextField) lookup("#vue-ajouter-commentaire-textField-titre");
	protected TextField textFieldNomCommentaire =(TextField) lookup("#vue-ajouter-commentaire-textField-nom");
	protected TextArea textAreaCommentire = (TextArea)lookup("#vue-ajouter-commentaire-textArea-commentaire");
	
	private VueAjouterCommentaire() {
		super("vue_ajouter_commentaire.fxml");
		super.controleur = this.controleur = new Controleur();
		Logger.logMsg(Logger.INFO, "new VueAjouterCommentaire()");
	}
	
	/**
	 * Permet de gerer les controles
	 */
	public void activerControles() {
		super.activerControles();
		Button actionRetour = (Button)lookup("#vue-ajouter-commentaire-action-retour");
		Button actionEnvoyer = (Button)lookup("#vue-ajouter-commentaire-action-envoyer");
		
		actionRetour.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Logger.logMsg(Logger.INFO, "Clic sur BACK VueAjouterCommentaire()");
				controleur.notifierNavigationVueAcceuilCommentaire();
			}});
		
		actionEnvoyer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Logger.logMsg(Logger.INFO, "Clic sur ENVOYER VueAjouterCommentaire()");
				controleur.notifierActionEnvoyerAjouterCommentaire(lireValeurCommentaire());
			}});
	}
	
	protected Commentaire lireValeurCommentaire() {
		Commentaire commentaire = new Commentaire();
		
		commentaire.setTitre(textFieldTitreCommentaire.getText());
		commentaire.setAuteur(textFieldNomCommentaire.getText());
		commentaire.setContenu(textAreaCommentire.getText());
		
		return commentaire;
	}
}
