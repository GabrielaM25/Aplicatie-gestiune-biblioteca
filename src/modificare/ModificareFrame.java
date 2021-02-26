package modificare;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class ModificareFrame extends JFrame {

	private DetailPanelModificare detpan_modificare;

	public ModificareFrame(String nume) {
		super(nume);
		setLayout(new BorderLayout());
		detpan_modificare = new DetailPanelModificare();
		Container container_modificare = getContentPane();
		container_modificare.add(detpan_modificare, BorderLayout.CENTER);

	}

}
