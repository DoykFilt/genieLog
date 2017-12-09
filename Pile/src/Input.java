
public abstract class Input {

	public static int CODECLEAR = 0;
	public static int CODEQUIT = 1;
	public static int CODEPUSH = 2;
	public static int CODEPOP = 3;
	
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
