package vue;

import controleur.Controleur;
import javafx.stage.Stage;

public class Fenetre extends Navigateur {
	
	@Override
	public void start(Stage stade) throws Exception {
		stade.setHeight(800);
		stade.setWidth(600);
		stade.setTitle("Système Commentaire");
		stade.setScene(Controleur.selectionnerVuePrincipale()); // une vue est appliquer a la fenetre
		stade.show();
		this.stade = stade;				
	};

}
