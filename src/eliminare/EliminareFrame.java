package eliminare;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class EliminareFrame extends JFrame {

	private DetailPanelEliminare detpan_eliminare;

	public EliminareFrame(String nume) {
		super(nume);
		setLayout(new BorderLayout());
		detpan_eliminare = new DetailPanelEliminare();
		Container container_eliminare = getContentPane();
		container_eliminare.add(detpan_eliminare, BorderLayout.CENTER);
	}

}
