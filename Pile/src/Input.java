/**
 * Classe abstraite de des entr�es.
 * @author Thibaud Beaufils & Camille Thomeczek
 */
public abstract class Input {

	final static int CODECLEAR = 0;
	final static int CODEQUIT = 1;
	final static int CODEPUSH = 2;
	final static int CODEPOP = 3;
	
	private int code;
	
	public Input(){
		this.code = -1;
	}

	public int getCode() {
		return this.code;
	}
	public void setCode(int code){
		this.code = code;
	}
}
