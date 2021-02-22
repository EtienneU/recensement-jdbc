package fr.diginamic.recensement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DbManager {
	
	public static ResourceBundle configFile = ResourceBundle.getBundle("database");

	static {
		String driverClass = configFile.getString("db.driver");
		// Chargement du Driver de la DB MySQL (on peut faire de même avec MariaDB)
		try {
			Class.forName(driverClass);
			// Class.forName() va charger la classe dont le nom est passée en paramètre
			// Les blocs statiques de celles-ci vont s'exécuter
			// notamment la méthode DriverManager.registerDriver(new Driver());
			// qui nous permet de charger le pilote nécessaire à la connexion à la DB
		} catch (ClassNotFoundException e) {
			System.out.println("Echec de chargement du Driver");
		}
	}
	
	public static Connection connection() {
		String dbUrl = configFile.getString("db.url");
		String dbUserName = configFile.getString("db.user.name");
		String dbUserPwd = configFile.getString("db.user.pwd");
		// Demande de connection a une DB de type MySQL
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(dbUrl, dbUserName, dbUserPwd);
//			System.out.println("Connexion ouverte : " + !connection.isClosed());
		} catch (SQLException e) {
			System.out.println("Echec de connexion à la base de données : " + e.getMessage());
		}
		return connection;
	}
}
