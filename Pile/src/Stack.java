import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
/**
 * Classe gestion de la pile
 * @author Thibaud Beaufils & Camille Thomeczek
 */
public class Stack extends Observable {

	private ArrayList stack;
	
	public Stack(){
		stack= new ArrayList();
	}

 	public void notifyObservers(){
		 setChanged();
		 notifyObservers();
	}
	

	public void Add(int element) {
		stack.add(element);
		notifyObservers();					
	}

	public void Del() {
		if(!stack.isEmpty())
			{
			stack.remove(stack.size() -1);
			notifyObservers();
			}		
	}

	public void Clr() {
		stack.clear();
		notifyObservers();
	}

	public String getElement(int position){
		return (String) stack.get(position);
	}
	
	public int getSize(){
		return stack.size();
	}
}
