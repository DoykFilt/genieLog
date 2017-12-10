import java.io.IOException;

public class StackSimulator {

	public static void main(String[] args) {
		try {
			ManagerInput managerInput = new ManagerInput("Log.txt");
			
			BottomView viewBottom = new BottomView();
			TopView viewTop = new TopView();
			
			Stack stack = new Stack();
			stack.addObserver(viewTop);
			stack.addObserver(viewBottom);
			
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
