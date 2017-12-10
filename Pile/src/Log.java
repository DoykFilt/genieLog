import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
/**
 * Classe pour l'enregistrement des actions affectuées par l'utilisateur.
 * @author Thibaud Beaufils & Camille Thomeczek
 */
public class Log {
	/**
	 * Le chemin d'accès où placer le log
	 */
	private String path;
	/**
	 * Le fichier
	 */
	private File file;
	/**
	 * Le buffer pour écrire dans le fichier
	 */
	private BufferedWriter out;
	
	/**
	 * Constructeur, créé le fichier si inexistant
	 * @param le chemin d'accès au fichier, string
	 */
	public Log(String path) throws IOException {
		this.path = path;
		file = new File(path);

		if(!file.exists()){
			System.out.println("Log File Creation");
			file.createNewFile();
		}
		
		out = new BufferedWriter(new FileWriter(file));
	}
	
	/**
	 * Permet d'écrire dans une ligne la commande à logger, avec la date
	 * @param la commande, string
	 */
	public void AjouterLigne(String commande) throws IOException {
		System.out.print("log");
		out.write(Instant.now().toString() + " : " + commande);
		out.newLine();
	}
	
	/**
	 * Getter de path
	 */
	public String getPath() {
		return this.path;
	}
	/**
	 * Setter de path
	 */
	public String setPath() {
		return this.path;
	}
	
	/**
	 * Permet de fermer le flux ouvert dans le constructeur
	 */
	public void DesactiverLog() throws IOException{
		this.out.close();
	}

}
