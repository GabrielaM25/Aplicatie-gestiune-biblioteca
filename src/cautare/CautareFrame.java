package cautare;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class CautareFrame extends JFrame {
private DetailPanelCautare dp_cautare;
public CautareFrame(String nume){
	super(nume);
	setLayout(new BorderLayout());
	dp_cautare =new DetailPanelCautare();
	Container cont_cautare=getContentPane();
	cont_cautare.add(dp_cautare,BorderLayout.CENTER);
	
}
}
