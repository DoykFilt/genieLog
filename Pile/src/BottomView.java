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
	public void update(Observable observable, Object arg1) {
		CommandeStack stack = ( CommandeStack ) observable;
		ArrayList<String> bottomStack = new ArrayList<String>();
		if(stack.getSize() !=0)
		{
			for(int i=0; i<stack.getSize();i++)
				bottomStack.add(stack.getElement(i));
		}
		else
			bottomStack.add("empty stack");
		
		
		
		this.pannel.setElmt(bottomStack);
	}
	
	private class Pannel extends JPanel{
		private ArrayList<String> elmts;
		
		public void paintComponent(Graphics g){
			for(String elmt : this.elmts)
				g.drawString(elmt, 10, 120 - (elmts.indexOf(elmt) * 20));
		}
		
		public void setElmt(ArrayList<String> bottomStack){
			if(!(this.elmts.toString().contentEquals(bottomStack.toString())));
				{
				this.elmts.addAll(bottomStack); // add ? ca remplace les valeurs precedentes ?
				this.repaint();
				}
		}
	}

}
