package eliminare;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import conectionDB.DBcon;

public class DetailPanelEliminare extends JPanel{
	private JLabel text;
	private JTextField elim_caseta;
	private JButton eliminare;
	
	
	public DetailPanelEliminare() {
		text=new JLabel("Introdu numele cartii pe care doresti sa o elimini :");
				elim_caseta= new JTextField(30);
		eliminare =new JButton("Eliminare");
		
		
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc_eliminare = new GridBagConstraints();
		gc_eliminare.weightx=100;
		gc_eliminare.weighty=70;
		

		gc_eliminare.gridx = 0;
		gc_eliminare.gridy = 0;
		add(text, gc_eliminare);
		
		gc_eliminare.gridx = 1;
		gc_eliminare.gridy = 0;
		add(elim_caseta, gc_eliminare);
		
		gc_eliminare.gridx = 1;
		gc_eliminare.gridy = 1;
		add(eliminare, gc_eliminare);
		
		eliminare.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection conectare = DBcon.openConection();
				
				
				try {
				
					
				String sql = "DELETE FROM aplicatie_biblioteca WHERE denumire =?";
				PreparedStatement pstm = conectare.prepareStatement(sql);
				pstm.setString(1, elim_caseta.getText());
				pstm.executeUpdate();
				JOptionPane.showMessageDialog(null, "Eliminare efectuata cu succes");
				pstm.close();
				conectare.close();
				}catch (Exception ex) {
						System.out.println("EROARE " +ex);	
						JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				
				elim_caseta.setText("");
			}
		});

	}

}
