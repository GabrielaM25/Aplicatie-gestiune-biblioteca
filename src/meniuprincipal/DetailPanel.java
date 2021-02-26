package meniuprincipal;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JButton;

import adaugare.AdaugareFrame;
import cautare.CautareFrame;
import eliminare.EliminareFrame;
import modificare.ModificareFrame;

public class DetailPanel extends JPanel {
	private JButton add;
	private JButton modify;
	private JButton search;
	private JButton delete;
	
	
	public DetailPanel()
	{ 
		setBorder(BorderFactory.createTitledBorder("Meniu Biblioteca"));
		add=new JButton("ADAUGARE");
		delete =new JButton("ELIMINARE");
		modify=new JButton("MODIFICARE");
		search=new JButton("CAUTARE");
		
		
		add.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame add_frame = new AdaugareFrame("Adaugare");
				add_frame.setSize(800,800);
				add_frame.setVisible(true);
				
			}
		});
		
		delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				JFrame elim_frame = new EliminareFrame("Eliminare");
				elim_frame.setSize(800,800);
				elim_frame.setVisible(true);
			}
				});
		modify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame modif_frame= new ModificareFrame("Modificare");
				modif_frame.setSize(1000,1000);
				modif_frame.setVisible(true);
			}
		});
			search.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
JFrame search_frame= new CautareFrame("Cautare");
search_frame.setSize(800, 800);
search_frame.setVisible(true);
					
					
				}
			});
		setLayout(new GridBagLayout());
		GridBagConstraints gc_main = new GridBagConstraints();
		
		gc_main.weightx = 50;
		gc_main.weighty = 50;
		
		gc_main.gridx = 0;
		gc_main.gridy = 0;
		add(add, gc_main);
		
		gc_main.gridx = 0;
		gc_main.gridy = 1;
		add(delete, gc_main);
		
		gc_main.gridx = 1;
		gc_main.gridy = 1;
		add(modify, gc_main);
		
		gc_main.gridx = 1;
		gc_main.gridy = 0;
		add(search, gc_main);
	}
	

}
