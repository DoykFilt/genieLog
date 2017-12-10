/**
 * Classe abstraite d'une entrée.
 * @author Thibaud Beaufils & Camille Thomeczek
 */
public abstract class Input {

	final static int CODECLEAR = 0;
	final static int CODEQUIT = 1;
	final static int CODEPUSH = 2;
	final static int CODEPOP = 3;
	/**
	 * Correspond au code d'une entrée
	 */
	private int code;
	/**
	 * Constructeur
	 */
	public Input(){
		this.code = -1;
	}
	/**
	 * Getteur de code
	 */
	public int getCode() {
		return this.code;
	}/**
	 * Setteur de code
	 * @param le code, entier
	 */
	public void setCode(int code){
		this.code = code;
	}
}
