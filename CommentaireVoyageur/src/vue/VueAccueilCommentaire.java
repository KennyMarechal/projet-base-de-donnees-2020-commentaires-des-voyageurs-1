package vue;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.Controleur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modele.Commentaire;

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
		
		
		System.out.println(System.getProperty("user.dir"));
		

		MenuButton menuOptions = (MenuButton)lookup("#vue-accueil-menu-options");
		Image imageMenuBurger = new Image("file:src/vue/decoration/menu-burger.png", 20, 20, true, true);
		menuOptions.setGraphic(new ImageView(imageMenuBurger));
		
		ObservableList<MenuItem> options = menuOptions.getItems();
		
		for (MenuItem menuItem : options)
		{
			menuItem.setOnAction(new EventHandler<ActionEvent>() 
			{
				@Override
				public void handle(ActionEvent e) 
				{
					MenuItem source = (MenuItem)e.getSource();
					
					if(source.getId().equals("vue-accueil-action-synchroniser"))
						controleur.notifierSynchronisation();
				}
			});
		}
		

	}
	
	public void afficherCommentaire(List<Commentaire> listeCommentaire) {
		ListView<String> listeCommentaireListView = (ListView<String>)lookup("#listView");
		ObservableList<String> listeAfficher = FXCollections.observableArrayList();
				
		for(Commentaire commentaire : listeCommentaire) {
			String afficheString =  commentaire.getId() + " " + commentaire.getDate() + " - " + commentaire.getTitre();
			listeAfficher.add(afficheString);
		}
		
		listeCommentaireListView.setItems(listeAfficher);
		listeCommentaireListView.setOnMouseClicked(new EventHandler<Event>()
		{
			@Override
			public void handle(Event arg0)
			{
				String[] chainesItem = listeCommentaireListView.getSelectionModel().getSelectedItem().split(" ");
				controleur.notifierNavigationVueCommentaires(chainesItem[0]);
			}
		});
	}
}
