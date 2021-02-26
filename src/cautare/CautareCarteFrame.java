package cautare;

import java.awt.BorderLayout;
import java.awt.*;

import javax.swing.*;

public class CautareCarteFrame extends JFrame  {
	private DetailPanelCautareCarte dp_cautare_carte;
public CautareCarteFrame(String nume,String sql)	{
	super(nume);
	setLayout(new BorderLayout());
	dp_cautare_carte =new DetailPanelCautareCarte(sql);
	Container cont_cautare_carte=getContentPane();
	cont_cautare_carte.add(dp_cautare_carte,BorderLayout.CENTER);
		
	}

}
