import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BottomView implements Observer {

	private final int HEIGHT = 1000;
	private final int WIDTH = 200;
	private JFrame windows;
	private Pannel pannel;
	
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

	public void stop() {
		windows.dispose();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
		/* normalement juste cette ligne devrait suffire pour actualiser l'affichage
		 * avec elmt la liste des entiers à afficher (en ArrayList<String>)
		this.pannel.setElmt(elmt);
		*/
	}
	
	private class Pannel extends JPanel{
		private ArrayList<String> elmts;
		
		public void paintComponent(Graphics g){
			for(String elmt : this.elmts)
				g.drawString(elmt, 10, 120 - (elmts.indexOf(elmt) * 20));
		}
		
		public void setElmt(ArrayList<String> elmts)
		{
			this.elmts.addAll(elmts);
			this.repaint();
		}
	}

}
