/**
 * Classe de gestion de la saisie par clavier.
 * @author Thibaud Beaufils & Camille Thomeczek
 */
public class InputClavier extends Input {

	final static String CLEAR = "CLEAR";
	final static String QUIT = "QUIT";
	final static String PUSH = "PUSH";
	final static String POP = "POP";
	
	private String commande;
	
	public InputClavier(String commande) {
		super();
		this.commande = commande;
		this.recognize();
	}
	
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
	
	public String getCommande(){
		return this.commande;
	}
}
