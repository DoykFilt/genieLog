import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Classe gestion de gestion des entrées
 * @author Thibaud Beaufils & Camille Thomeczek
 */
public class ManagerInput {

	private ArrayList<Input> inputs;
	private Log log;
	private Stack stack;
	private Scanner sc;
	
	/**
	 * 
	 * @param pathLog
	 * @throws IOException
	 */
	public ManagerInput(String pathLog) throws IOException {

		sc = new Scanner(System.in);
		inputs = new ArrayList<>();
		log = new Log(pathLog);
		stack = new Stack();
	}
	
	public void getNextCommande() {
		inputs.add(new InputClavier(sc.nextLine()));
	}

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

	public void DeleteTop() {
		inputs.remove(inputs.size() - 1);
	}
}
