/**
 * Classe de gestion de la saisie par clavier.
 * @author Thibaud Beaufils & Camille Thomeczek
 */
public class InputClavier extends Input {

	final static String CLEAR = "CLEAR";
	final static String QUIT = "QUIT";
	final static String PUSH = "PUSH";
	final static String POP = "POP";
	
	/**
	 * La commande telle que tapé par l'utilisateur
	 */
	private String commande;
	/**
	 * Constructeur
	 * @param commande, string
	 */
	public InputClavier(String commande) {
		super();
		this.commande = commande;
		this.recognize();
	}
	/**
	 * Permet de reconnaitre le type de commande et de choisir le code associé
	 */
	public void recognize() {
		int code = -1;
		
		if(commande.toUpperCase().contains(CLEAR))
			code = CODECLEAR;
		else if(commande.toUpperCase().contains(POP))
			code = CODEPOP;
		else if(commande.toUpperCase().contains(PUSH))
			code = CODEPUSH;
		else if(commande.toUpperCase().contains(QUIT))
			code = CODEQUIT;
		
		super.setCode(code);
	}
	
	/**
	 * Getteur de la commande
	 */
	public String getCommande(){
		return this.commande;
	}
}
