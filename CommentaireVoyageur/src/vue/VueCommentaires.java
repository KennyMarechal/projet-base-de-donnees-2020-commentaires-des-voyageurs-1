package vue;

import org.controlsfx.control.Rating;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import modele.Commentaire;

public class VueCommentaires extends Vue{

	public static VueCommentaires instance;
	public static VueCommentaires getInstance() {if(null == instance)instance = new VueCommentaires(); return instance;}
		
	protected Controleur controleur;
	
	private VueCommentaires() {
		super("vue_commentaire.fxml");
		super.controleur = this.controleur = new Controleur();
		Logger.logMsg(Logger.INFO, "new VueCommentaires()");
	}
	
	public void activerControles(){
		super.activerControles();
		Button actionRetour = (Button)lookup("#vue-commentaire-action-retour");
		
		actionRetour.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				controleur.notifierNavigationVueAcceuilCommentaire();
			}});
	}

	public void afficherInfosCommentaire(Commentaire commentaire)
	{
		Label labelTitreCommentaire = (Label)lookup("#vue-commentaire-titre");
		Label labelCommentaireVoyageur = (Label)lookup("#vue-commentaire-commentaire-voyageur");
		Label labelNomVoyageur = (Label)lookup("#vue-commentaire-nom-voyageur");
		Label labelDateCommentaire = (Label)lookup("#vue-commentaire-date-commentaire");
		Rating ratingNoteCommentaire = (Rating)lookup("#vue-commentaire-note");
		
		labelTitreCommentaire.setText(commentaire.getTitre());
		labelCommentaireVoyageur.setText(commentaire.getContenu());
		labelNomVoyageur.setText(commentaire.getAuteur());
		labelDateCommentaire.setText(commentaire.getDate().toString());
		ratingNoteCommentaire.setRating(commentaire.getNote());
	}
	
}
