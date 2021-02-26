package adaugare;

import javax.swing.*;

import conectionDB.DBcon;
import meniuprincipal.Carte;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DetailPanelAdaugare extends JPanel {

	private JLabel titlu;
	private JLabel autor;
	private JLabel an_editare;
	private JLabel format;
	private JLabel codISSN;
	private JLabel cod_locatie;
	private JTextField titlu_caseta;
	private JTextField autor_caseta;
	private JTextField an_editare_caseta;
	private JTextField format_caseta;
	private JTextField codISSN_caseta;
	private JTextField cod_locatie_caseta;
	private JButton adauga;

	public DetailPanelAdaugare() {
		setBorder(BorderFactory.createTitledBorder("Adaugare carte"));

		titlu = new JLabel("Titlu : ");
		titlu_caseta = new JTextField(30);
		autor = new JLabel("Autor : ");
		autor_caseta = new JTextField(30);
		an_editare = new JLabel("Anul editarii : ");
		an_editare_caseta =  new JTextField(10);
		format = new JLabel("Formatul cartii : ");
		format_caseta = new JTextField(7);
		codISSN = new JLabel("Cod ISBN/ISSN : ");
		codISSN_caseta = new JTextField(30);
		cod_locatie = new JLabel("Cod locatie : ");
		cod_locatie_caseta = new JTextField(10);
		adauga = new JButton("Adaugare");

		setLayout(new GridBagLayout());
		GridBagConstraints gc_adaugare = new GridBagConstraints();
		gc_adaugare.weightx = 50;
		gc_adaugare.weighty = 50;

		gc_adaugare.gridx = 0;
		gc_adaugare.gridy = 0;
		add(titlu, gc_adaugare);

		gc_adaugare.gridx = 1;
		gc_adaugare.gridy = 0;
		add(titlu_caseta, gc_adaugare);

		gc_adaugare.gridx = 0;
		gc_adaugare.gridy = 1;
		add(autor, gc_adaugare);

		gc_adaugare.gridx = 1;
		gc_adaugare.gridy = 1;
		add(autor_caseta, gc_adaugare);

		gc_adaugare.gridx = 0;
		gc_adaugare.gridy = 2;
		add(an_editare, gc_adaugare);

		gc_adaugare.gridx = 1;
		gc_adaugare.gridy = 2;
		add(an_editare_caseta, gc_adaugare);

		gc_adaugare.gridx = 0;
		gc_adaugare.gridy = 3;
		add(format, gc_adaugare);

		gc_adaugare.gridx = 1;
		gc_adaugare.gridy = 3;
		add(format_caseta, gc_adaugare);

		gc_adaugare.gridx = 0;
		gc_adaugare.gridy = 4;
		add(codISSN, gc_adaugare);

		gc_adaugare.gridx = 1;
		gc_adaugare.gridy = 4;
		add(codISSN_caseta, gc_adaugare);

		gc_adaugare.gridx = 0;
		gc_adaugare.gridy = 5;
		add(cod_locatie, gc_adaugare);

		gc_adaugare.gridx = 1;
		gc_adaugare.gridy = 5;
		add(cod_locatie_caseta, gc_adaugare);

		gc_adaugare.gridx = 0;
		gc_adaugare.gridy = 6;
		add(adauga, gc_adaugare);
		
		adauga.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ev) {
				

				try {
					Connection conectare = DBcon.openConection();
				
					Carte c =new Carte();
					c.setDenumire(titlu_caseta.getText());
					c.setAutor(autor_caseta.getText());
					String s =an_editare_caseta.getText();
					int an=Integer.parseInt(s);
					c.setAn(an);
					c.setCod(codISSN_caseta.getText());
					c.setForm(format_caseta.getText());
					c.setLocatie(cod_locatie_caseta.getText());
					
					 
					String sql="INSERT INTO aplicatie_biblioteca (denumire ,autor,an_editare,cod_ISSN,cod_locatie,format) VALUES ( ?,?,?,?,?,?)";
			
					PreparedStatement pstm = conectare.prepareStatement(sql);
					pstm.setString(1, c.getDenumire());
					pstm.setString(2, c.getAutor());
					pstm.setInt(3, c.getAn());
					pstm.setString(4, c.getCod());
					pstm.setString(5, c.getLocatie());
					pstm.setString(6, c.getForm());
					pstm.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Adaugare efectuata cu succes");
				pstm.close();
				conectare.close();	
							
				}catch (Exception ex) {
System.out.println("EROARE" +ex);		
JOptionPane.showMessageDialog(null, ex.getMessage());}
				titlu_caseta.setText("");
				autor_caseta.setText("");
				an_editare_caseta.setText("");
				codISSN_caseta.setText("");
				format_caseta.setText("");
				cod_locatie_caseta.setText("");
			}
			
		});

	}

}
