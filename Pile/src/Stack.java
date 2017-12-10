import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
/**
 * Classe gestion de la pile
 * @author Thibaud Beaufils & Camille Thomeczek
 */
public class Stack extends Observable {
	/**
	 * pile 
	 */
	private ArrayList<Integer> stack = new ArrayList<>();
	/**
	 * 	Constructeur de la classe.
	 */
	/*public Stack(){
		stack= new ArrayList<>();
	}*/
	
	
	public void notifObservers(){
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Ajoute un element a la pile
	 * @param element entier a ajouter a la pile
	 */
	public void Add(int element) {
		stack.add(element);
		notifObservers();
	}

	/**
	 * Supprime l'element sur le haut de la pile
	 */
	public void Del() {
		if(!stack.isEmpty())
		{
			stack.remove(stack.size() -1);
			notifObservers();
		}		
	}

	/**
	 * Vide la pile 
	 */
	public void Clr() {
		stack.clear();
		notifObservers();
	}

	/**
	 * Recupere l'element a la position passée en parametre
	 * @param position position dans la pile pour laquelle on souhaite avoir la valeur
	 * @return element a la position passee en parametres
	 */
	public String getElement(int position){
		return Integer.toString(stack.get(position));
	}
	
	/**
	 * Recupere la taille de la pile
	 * @return taille de la pile
	 */
	public int getSize(){
		return stack.size();
	}
}
