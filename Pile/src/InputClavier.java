public class InputClavier extends Input {

	final static String CLEAR = "CLEAR";
	final static String QUIT = "CLEAR";
	final static String PUSH = "PUSH";
	final static String POP = "POP";
	
	private String commande;
	
	public InputClavier(String commande) {
		super();
	}
	
	public void recognize() {
		int code = -1;
		
		if(commande.contains(CLEAR))
			code = CODECLEAR;
		if(commande.contains(POP))
			code = CODEPOP;
		if(commande.contains(PUSH))
			code = CODEPUSH;
		if(commande.contains(QUIT))
			code = CODEQUIT;
		
		super.setCode(code);
	}
	
	public String getCommande(){
		return this.commande;
	}

	/*Scanner sc2 = null;
    try {
        sc2 = new Scanner(new File("translate.txt"));
    } catch (FileNotFoundException e) {
        e.printStackTrace();  
    }
    while (sc2.hasNextLine()) {
            Scanner s2 = new Scanner(sc2.nextLine());
        while (s2.hasNext()) {
            String s = s2.next();
            System.out.println(s);
        }
    }*/

}
