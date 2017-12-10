import java.awt.Component;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Classe de la vue pour l'affichage du haut de la pile
 * @author Thibaud Beaufils & Camille Thomeczek
 */
public class TopView implements Observer {

	private final int HEIGHT = 200;
	private final int WIDTH = 200;
	private JFrame windows;
	private Pannel pannel;
	
	public TopView(){
		this.windows = new JFrame();
		this.windows.setTitle("Stack Top");
		this.windows.setSize(HEIGHT, WIDTH);
		this.windows.setLocationRelativeTo(null);
		this.windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.pannel = new Pannel();
		
		this.windows.setContentPane(this.pannel);
		this.windows.setVisible(true);
	}

	public void stop() {
		windows.dispose();
	}

	@Override
	public void update(Observable observable, Object arg1) {
		Stack stack = ( Stack ) observable;
		String elmt;
		if(stack.getSize() !=0)
			elmt = stack.getElement(stack.getSize() -1);
		else
			elmt = "empty stack";
		this.pannel.setElmt(elmt);
	}
	
	private class Pannel extends JPanel{
		private String elmt;
		
		public void paintComponent(Graphics g){
			g.drawString(this.elmt, 10, 20);
		}
		
		public void setElmt(String elmt)
		{
			this.elmt = elmt;
			this.repaint();
		}
	}

}
