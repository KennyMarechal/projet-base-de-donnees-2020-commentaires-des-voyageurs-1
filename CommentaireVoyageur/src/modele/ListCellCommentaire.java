package modele;

import org.controlsfx.control.Rating;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;

public class ListCellCommentaire extends ListCell<Commentaire>
{
	private HBox boiteNote;
	private Rating note;
	private Text contenu;
	
	public ListCellCommentaire()
	{
		super();
		this.contenu = new Text();
		
		this.note = new Rating();
		this.note.setMax(5);
		this.note.setPartialRating(false);
		this.note.setScaleX(0.8);
		this.note.setScaleY(0.8);
		this.note.setScaleZ(0.8);
		this.note.setMouseTransparent(true);
		
		this.boiteNote = new HBox(this.note, this.contenu);
		this.boiteNote.setAlignment(Pos.CENTER_LEFT);
		this.boiteNote.setSpacing(0);
	}
	
	@Override
	protected void updateItem(Commentaire commentaire, boolean vide)
	{
		super.updateItem(commentaire, vide);
		if (commentaire != null && !vide) 
		{
			this.note.setRating(commentaire.getNote());
			int indexDelimiteurMillisecondes = commentaire.getDate().toString().lastIndexOf('.');
	        contenu.setText(commentaire.getDate().toString().substring(0,indexDelimiteurMillisecondes)+" - "+commentaire.getTitre());
	        
			setGraphic(boiteNote);
			
			//System.out.println("Texte commentaire #"+commentaire.getId()+": "+ this.contenu.getText());
	    } 
		else
	    {
	        setGraphic(null);
	    }
	}
}
