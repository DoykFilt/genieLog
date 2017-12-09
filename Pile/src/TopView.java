import java.awt.Component;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
	public void update(Observable arg0, Object arg1) {
		
		/* normalement juste cette ligne devrait suffire pour actualiser l'affichage
		 * avec elmt l'entier (en string)
		this.pannel.setElmt(elmt);
		*/
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
