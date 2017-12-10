import java.io.IOException;

/**
 * Classe de la vue pour l'affichage du haut de la pile
 * @author Thibaud Beaufils & Camille Thomeczek
 */
public class StackSimulator {

	public static void main(String[] args) {
		try {
			ManagerInput managerInput = new ManagerInput("Log.txt");
			
			BottomView viewBottom = new BottomView();
			TopView viewTop = new TopView();
			
			Stack stack = new Stack();
			stack.addObserver(viewTop);
			viewTop.setStack(stack);
			stack.addObserver(viewBottom);
			viewBottom.setStack(stack);
			
			
			
			while(true){
				managerInput.getNextCommande();
				if(managerInput.ComputeNext() == false)
					System.out.println("Unknow commande");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
