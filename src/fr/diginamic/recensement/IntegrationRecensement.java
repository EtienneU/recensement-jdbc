package fr.diginamic.recensement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

public class IntegrationRecensement {

	public static void main(String[] args) throws IOException {
		// lecture du fichier recensement
		String filePath = "C:/Users/urban/OneDrive/OD-Documents/DEV/Diginamic/Java/workspaceSTS/recensement-jdbc/resources/recensement.csv";
//		Recensement recens = new Recensement(filePath);
		Path pathFile = Paths.get(filePath);
		// Récupération des lignes du fichier CSV dans une liste de String
		List<String> infosBrutesVilles = Files.readAllLines(pathFile);
		infosBrutesVilles.remove(0); // Je retire la ligne d'entête

		Connection connection = DbManager.connection();

		// Insertion des lignes du fichier recensement (les villes) dans la table ville
		// de la DB
		Statement statement = null;
		try {
			statement = connection.createStatement();
			for (String line : infosBrutesVilles) {

				// Conversion de chaque ligne CSV en tableau de String
				String[] tabInfosVilles = line.split(";");

				// Récupération des colonnes du CSV qui nous intéressent
				String codeRegion = tabInfosVilles[0];
				String codeDep = tabInfosVilles[2];
				String nomCommune = tabInfosVilles[6];
				int populationTotale = Integer.parseInt(tabInfosVilles[9].replaceAll(" ", ""));

				PreparedStatement prepStatement = connection
						.prepareStatement("INSERT INTO " + "ville(nom, population) " + "VALUES (?, ?)");

				prepStatement.setString(1, nomCommune);
				prepStatement.setInt(2, populationTotale);

				prepStatement.executeUpdate();
			}

			statement.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("Echec de la requête SQL : " + e.getMessage());
		}

	}

}
