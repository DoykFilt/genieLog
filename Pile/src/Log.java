import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Classe pour l'enregistrement des actions affectuées par l'utilisateur.
 * @author Thibaud Beaufils & Camille Thomeczek
 */
public class Log {
	
	private String path;
	private File file;
	private FileWriter fileWriter;

	private ManagerInput inputManagement;

	public Log(String path) throws IOException {
		this.path = path;
		file = new File(path);

		if(!file.exists())
			file.createNewFile();
		fileWriter = new FileWriter(file);
	}

	public void AjouterLigne(String commande) throws IOException {
		fileWriter.write(commande);
	}

	public String getPath() {
		return this.path;
	}

	public String setPath() {
		return this.path;
	}

}
