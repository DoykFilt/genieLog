import java.io.IOException;

public class StackSimulator {

	public static void main(String[] args) {
		try {
			ManagerInput managerInput = new ManagerInput("Log.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
