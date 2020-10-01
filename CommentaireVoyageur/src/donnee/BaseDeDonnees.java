package donnee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDonnees
{
	private Connection connection = null;
	private static BaseDeDonnees instance = null;
	
	public static BaseDeDonnees getInstance()
	{
		if(null == instance) 
			instance = new BaseDeDonnees();
		
		return instance;
	}
	
	private BaseDeDonnees()
	{
		try {
			Class.forName("org.postgresql.Driver");
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/croisiere", "postgres", "Code781227");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection(){return this.connection;}
	
}