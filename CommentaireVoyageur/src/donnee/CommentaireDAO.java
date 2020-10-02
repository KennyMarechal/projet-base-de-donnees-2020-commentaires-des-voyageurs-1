package donnee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import modele.Commentaire;

public class CommentaireDAO
{
	public List<Commentaire> listerMockups()
	{
		List<Commentaire> listeCommentaires = new ArrayList<Commentaire>();
				
		int[] ids = new int[] {1,2,3,4,5,6,7,8,9,10};
		String[] titres = new String[] {"Meilleur voyage de ma vie", "Les vacances de r�ves","Tr�s d��u","Vivement l'ann�e prochaine","Je ne souhaite JAMAIS revenir","Le pire voyage de l'univers", "Meh.", "Tr�s sympathique", "Le personnel doit �tre licenci�", "Passable"};
		String[] auteurs = new String[] {"Jean-Pierre Truchon", "Veronique Dubois", "Marc Tremblay", "Alexis Truc", "Pierre Marley","Annie Loret", "Diane Martin", "Luc Santeur", "Jos� Roche", "Natan Passoulette"};
		String contenu = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
				+ " Maecenas dictum gravida lorem, sit amet blandit lorem."
				+ " Curabitur nibh libero, porttitor in justo id, malesuada dignissim augue."
				+ " Donec tristique erat in enim feugiat, id convallis urna porttitor.";
		String[] dates = new String[] {"2020-08-17", "2020-08-17", "2020-08-16", "2020-08-15", "2020-08-12", "2020-08-10", "2020-08-10", "2020-08-10", "2020-08-09", "2020-07-30"};
		
		
		for(int i = 0; i < 10; i++)
		{
			Commentaire commentaire = new Commentaire();
			commentaire.setId(ids[i]);
			commentaire.setTitre(titres[i]);
			commentaire.setAuteur(auteurs[i]);
			commentaire.setContenu(contenu);
			commentaire.setDate(Timestamp.valueOf(dates[i]));
			listeCommentaires.add(commentaire);
		}
		
		return listeCommentaires;
	}
	
	//Lister les dix derniers commmentaires entr�s
	public List<Commentaire> listerDerniersCommentaires()
	{
		List<Commentaire> listeCommentaires = new ArrayList<Commentaire>();
		Connection connection = BaseDeDonnees.getInstance().getConnection();
		try
		{
			PreparedStatement requeteListerCommentaires = connection.prepareStatement("SELECT titre, date FROM commentaire ORDER BY id DESC LIMIT 10");
			ResultSet curseurListeCommentaires = requeteListerCommentaires.executeQuery();
			
			while(curseurListeCommentaires.next())
			{
				String titre = curseurListeCommentaires.getString("titre");
				Timestamp date = curseurListeCommentaires.getTimestamp("date");
				
				Commentaire commentaire = new Commentaire();
				commentaire.setTitre(titre);
				commentaire.setDate(date);
				listeCommentaires.add(commentaire);
			}
			
			return listeCommentaires;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Commentaire detaillerCommentaire(int id)
	{
		//Connexion BDD
		//SELECT titre, auteur, contenu, date FROM commentaire
		//Creer et retourner l'objet commentaire
		
		return null;
	}
	
	public void enregistrerCommentaire(Commentaire commentaire)
	{
		Connection connection = BaseDeDonnees.getInstance().getConnection();
		try
		{
			PreparedStatement requeteEnregistrerCommentaire =
					connection.prepareStatement("INSERT INTO commentaire (titre, auteur, contenu, date) VALUES (?, ?, ?, ?)");
			requeteEnregistrerCommentaire.setString(1, commentaire.getTitre());
			requeteEnregistrerCommentaire.setString(2, commentaire.getAuteur());
			requeteEnregistrerCommentaire.setString(3, commentaire.getContenu());
			requeteEnregistrerCommentaire.setTimestamp(4, commentaire.getDate());
			requeteEnregistrerCommentaire.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
