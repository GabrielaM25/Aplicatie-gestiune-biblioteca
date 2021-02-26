package adaugare;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class AdaugareFrame extends JFrame{
	
	private DetailPanelAdaugare detpan_adaugare;
	
	public AdaugareFrame(String nume) {
		super(nume);
		setLayout(new BorderLayout());
		detpan_adaugare= new DetailPanelAdaugare();
		Container container_adaugare = getContentPane();
		container_adaugare.add(detpan_adaugare, BorderLayout.CENTER);
	}

}
