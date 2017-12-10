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
	private ArrayList<Integer> stack;
	/**
	 * 	Constructeur de la classe.
	 */
	public Stack(){
		stack= new ArrayList<>();
	}
	
	/**
	 * Ajoute un element a la pile
	 * @param element entier a ajouter a la pile
	 */
	public void Add(int element) {
		stack.add(element);
		notifyObservers();					
	}

	/**
	 * Supprime l'element sur le haut de la pile
	 */
	public void Del() {
		if(!stack.isEmpty())
		{
			stack.remove(stack.size() -1);
			notifyObservers();
		}		
	}

	/**
	 * Vide la pile 
	 */
	public void Clr() {
		stack.clear();
		notifyObservers();
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
