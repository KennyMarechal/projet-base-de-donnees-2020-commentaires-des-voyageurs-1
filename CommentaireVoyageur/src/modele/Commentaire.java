package modele;

import java.sql.Timestamp;

public class Commentaire
{
	protected int id;
	protected String titre;
	protected String auteur;
	protected String contenu;
	protected Timestamp date;
	protected int note;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public int getNote() {
		return this.note;
	}
}
