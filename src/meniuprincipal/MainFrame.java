package meniuprincipal;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private DetailPanel detailp;

	public MainFrame(String name) {
		super(name);
		setLayout(new BorderLayout());
		detailp = new DetailPanel();
		Container container = getContentPane();
		container.add(detailp, BorderLayout.CENTER);
	}

}
