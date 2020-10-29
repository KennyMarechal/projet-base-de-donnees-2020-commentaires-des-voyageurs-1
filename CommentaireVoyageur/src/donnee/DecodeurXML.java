package donnee;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import modele.Commentaire;

public class DecodeurXML
{

	public List<Commentaire> decoderListe(String xml)
	{
		List<Commentaire> listeCommentaires = new ArrayList<Commentaire>();
		//System.out.println(xml);
		try 
		{
			DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			//@SuppressWarnings("deprecation")

			Document document = parseur.parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));
			String racine = document.getDocumentElement().getNodeName();
					
			System.out.println(racine);
			
			NodeList listeNoeudsCommentaire = document.getElementsByTagName("commentaire");
			for(int position = 0; position < listeNoeudsCommentaire.getLength(); position++)
			{
				//Node noeudPensee = listePensees.item(position);
				Element noeudCommentaire = (Element)listeNoeudsCommentaire.item(position);
				String id = noeudCommentaire.getElementsByTagName("id").item(0).getTextContent();
				String titre = noeudCommentaire.getElementsByTagName("titre").item(0).getTextContent();
//				String auteur = noeudCommentaire.getElementsByTagName("auteur").item(0).getTextContent();
//				String contenu = noeudCommentaire.getElementsByTagName("contenu").item(0).getTextContent();
				String date = noeudCommentaire.getElementsByTagName("date").item(0).getTextContent();
								
				Commentaire commentaire = new Commentaire();
				commentaire.setId(Integer.parseInt(id));
				commentaire.setTitre(titre);
//				commentaire.setAuteur(auteur);
//				commentaire.setContenu(contenu);
				commentaire.setDate(Timestamp.valueOf(date));
				listeCommentaires.add(commentaire);
			}
		} 
		catch (ParserConfigurationException e) 
		{	
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		return listeCommentaires;
	}
	
	public boolean decoderReponseAction(String xml)
	{
		System.out.println("xml" + xml);
		return true;
	}
}
