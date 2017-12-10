import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Classe de la vue pour l'affichage du bas de pile
 * @author Thibaud Beaufils & Camille Thomeczek
 */
public class BottomView implements Observer {

	private final int HEIGHT = 1000;
	private final int WIDTH = 200;
	private JFrame windows;
	private Pannel pannel;
	
	/**
	 * Constructeur de la fenetre d'affichage du bas de la pile
	 */
	public BottomView(){
		this.windows = new JFrame();
		this.windows.setTitle("Stack Bottom");
		this.windows.setSize(HEIGHT, WIDTH);
		this.windows.setLocationRelativeTo(null);
		this.windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.pannel = new Pannel();
		
		this.windows.setContentPane(this.pannel);
		this.windows.setVisible(true);
	}

	/**
	 * fermeture de la fenetre 
	 */
	public void stop() {
		windows.dispose();
	}

	/**
	 * actualisation de la vue lors d'un changement de la pile
	 */
	@Override
	public void update(Observable observable, Object arg1) {
		Stack stack = ( Stack ) observable;
		ArrayList<String> bottomStack = new ArrayList<String>();
		int bottomSize =5;
		if(stack.getSize()<5)
			bottomSize = stack.getSize();
		if(bottomSize !=0)
		{
			for(int i=0; i<bottomSize;i++)
				bottomStack.add(stack.getElement(i));
		}
		else
			bottomStack.add("empty stack");
		
		
		
		this.pannel.setElmt(bottomStack);
	}
	
	/**
	 * Classe de la vue pour l'affichage du bas de la pile
	 * @author Thibaud Beaufils & Camille Thomeczek
	 */
	private class Pannel extends JPanel{
		private ArrayList<String> elmts;
		
		/**
		 * Affiche les element s
		 */
		public void paintComponent(Graphics g){
			for(String elmt : this.elmts)
				g.drawString(elmt, 10, 120 - (elmts.indexOf(elmt) * 20));
		}
		
		/**
		 * Actualise le haut de pile et l'affiche
		 * @param bottomStack nouveaux elemnts en bas de la pile
		 */
		public void setElmt(ArrayList<String> bottomStack){
			if(!(this.elmts.toString().contentEquals(bottomStack.toString())));
				{
					this.elmts.clear();
					this.elmts.addAll(bottomStack); 
					this.repaint();
				}
		}
	}

}
