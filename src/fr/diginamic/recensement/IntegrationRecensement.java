package fr.diginamic.recensement;

import java.io.IOException;

import fr.diginamic.recensement.Recensement;

public class IntegrationRecensement {

	public static void main(String[] args) throws IOException {
		// lire le fichier recensement
		String filePath = "C:/Users/urban/OneDrive/OD-Documents/DEV/Diginamic/Java/workspaceSTS/recensement-jdbc/resources/recensement.csv";
		Recensement recens = new Recensement(filePath);
		
		// insérer les villes en DB : charger le driver, créer une connexion, et créer un requete INSERT
		
		
		// Table ville : id, nom, population, id_dep, id_region
		// Table departement : id, code, population, id_region

	}

}
