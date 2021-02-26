package meniuprincipal;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainPrg {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame meniuframe= new MainFrame("Biblioteca");
				meniuframe.setSize(500,500);
			meniuframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			meniuframe.setVisible(true);
			}
		});

	}

}
