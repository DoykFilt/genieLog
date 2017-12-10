import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Classe gestion de gestion des entr�es
 * @author Thibaud Beaufils & Camille Thomeczek
 */
public class ManagerInput {

	private ArrayList<Input> inputs;
	private Log log;
	private Stack stack;
	private Scanner sc;
	
	/**
	 * Constructeur de la classe
	 * @param pathLog chemin du fichier de log
	 * @throws IOException Exception si probleme lors de la creation du fichier
	 */
	public ManagerInput(String pathLog) throws IOException {

		sc = new Scanner(System.in);
		inputs = new ArrayList<>();
		log = new Log(pathLog);
		stack = new Stack();
	}
	
	/**
	 * Accede a la commande saisie
	 */
	public void getNextCommande() {
		inputs.add(new InputClavier(sc.nextLine()));
	}

	/**
	 * Effectue des actions sur la pile en fonction de ce qui est saisit
	 * @return vrai ou faux suivant la saisie
	 */
	public boolean ComputeNext() {
		
		if(inputs.get(inputs.size() - 1).getCode() == -1){
			this.DeleteTop();
			return false;
		}
		
		if(inputs.get(inputs.size() - 1).getCode() == Input.CODEQUIT)
			System.exit(0);
		if(inputs.get(inputs.size() - 1).getCode() == Input.CODECLEAR)
			stack.Clr();
		if(inputs.get(inputs.size() - 1).getCode() == Input.CODEPOP)
			stack.Del();
		if(inputs.get(inputs.size() - 1).getCode() == Input.CODEPUSH){
			InputClavier input = (InputClavier)inputs.get(inputs.size() - 1);
			Scanner s = new Scanner(input.getCommande());
			try{
				s.next();
				stack.Add(s.nextInt());
			}catch(InputMismatchException e){
				System.out.println("Error invalid argument in " + InputClavier.PUSH);
			}
		}		
		
		for(int i = 0; i< stack.getSize(); i++)
			System.out.println(stack.getElement(i));
		
		this.DeleteTop();
		return true;
	}

	/**
	 * supprime la derniere commande effectuee
	 */
	public void DeleteTop() {
		inputs.remove(inputs.size() - 1);
	}
}
