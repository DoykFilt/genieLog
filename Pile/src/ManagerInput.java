import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManagerInput {

	private ArrayList<Input> inputs;
	private Log log;
	private CommandeStack commandeStack;
	
	public ManagerInput(String pathLog) throws IOException {
		inputs = new ArrayList<>();
		log = new Log(pathLog);
		commandeStack = new CommandeStack();
	}

	public boolean ComputeNext() {
		
		if(inputs.get(inputs.size() - 1).getCode() == -1){
			this.DeleteTop();
			return false;
		}
		
		if(inputs.get(inputs.size() - 1).getCode() == Input.CODEQUIT)
			System.exit(0);
		if(inputs.get(inputs.size() - 1).getCode() == Input.CODECLEAR)
			commandeStack.Clr();
		if(inputs.get(inputs.size() - 1).getCode() == Input.CODEPOP)
			commandeStack.Del();
		if(inputs.get(inputs.size() - 1).getCode() == Input.CODEPUSH){
			InputClavier input = (InputClavier)inputs.get(inputs.size() - 1);
			Scanner s = new Scanner(input.getCommande());
			try{
				commandeStack.Add(s.nextInt());
			}catch(InputMismatchException e){
				System.out.println("Error invalid argument in " + InputClavier.PUSH);
			}
		}		
		
		this.DeleteTop();
		return true;
	}

	public void DeleteTop() {
		inputs.remove(inputs.size() - 1);
	}

}
