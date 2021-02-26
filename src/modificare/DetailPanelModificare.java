package modificare;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.*;

import javax.swing.*;

import conectionDB.DBcon;
import meniuprincipal.Carte;

public class DetailPanelModificare extends JPanel {

	private JLabel text;
	private JTextField text_caseta;
	private JButton ok;
	private JLabel alege_modificarea;
	private JButton denumire;
	private JButton autor;
	private JButton an;
	private JButton format;
	private JButton cod;
	private JButton locatie;
	private JTextField modificare;
	private JButton ok2;
	private String introducere = new String("");

	public DetailPanelModificare() {
		setBorder(BorderFactory.createTitledBorder("Modificare"));
		text = new JLabel("Introduceti titlul cartii ale carei date doriti sa le modificati");
		text_caseta = new JTextField(20);
		ok = new JButton("OK");
		alege_modificarea = new JLabel("Alegeti ce doriti sa modificati");
		denumire = new JButton("TITLU");
		autor = new JButton("AUTOR");
		an = new JButton("AN EDITARE");
		format = new JButton("FORMAT");
		cod = new JButton("COD ISBN/ISSN");
		locatie = new JButton("COD LOCATIE");
		modificare = new JTextField(20);
		ok2 = new JButton("OK");
		setLayout(new GridBagLayout());
		GridBagConstraints gc_modificare = new GridBagConstraints();
		gc_modificare.weightx = 10;
		gc_modificare.weighty = 10;

		gc_modificare.gridx = 0;
		gc_modificare.gridy = 0;
		add(text, gc_modificare);

		gc_modificare.gridx = 1;
		gc_modificare.gridy = 0;
		add(text_caseta, gc_modificare);

		gc_modificare.gridx = 2;
		gc_modificare.gridy = 0;
		add(ok, gc_modificare);

		gc_modificare.gridx = 0;
		gc_modificare.gridy = 1;
		add(alege_modificarea, gc_modificare);
		alege_modificarea.setVisible(false);

		gc_modificare.gridx = 0;
		gc_modificare.gridy = 2;
		add(denumire, gc_modificare);
		denumire.setVisible(false);

		gc_modificare.gridx = 1;
		gc_modificare.gridy = 2;
		add(autor, gc_modificare);
		autor.setVisible(false);

		gc_modificare.gridx = 2;
		gc_modificare.gridy = 2;
		add(an, gc_modificare);
		an.setVisible(false);

		gc_modificare.gridx = 0;
		gc_modificare.gridy = 3;
		add(format, gc_modificare);
		format.setVisible(false);

		gc_modificare.gridx = 1;
		gc_modificare.gridy = 3;
		add(cod, gc_modificare);
		cod.setVisible(false);

		gc_modificare.gridx = 2;
		gc_modificare.gridy = 3;
		add(locatie, gc_modificare);
		locatie.setVisible(false);

		gc_modificare.gridx = 0;
		gc_modificare.gridy = 4;
		add(modificare, gc_modificare);
		modificare.setVisible(false);

		gc_modificare.gridx = 1;
		gc_modificare.gridy = 4;
		add(ok2, gc_modificare);
		ok2.setVisible(false);

		

		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				introducere = text_caseta.getText();
				alege_modificarea.setVisible(true);
				denumire.setVisible(true);
				autor.setVisible(true);
				an.setVisible(true);
				format.setVisible(true);
				cod.setVisible(true);
				locatie.setVisible(true);

			}
		});

		denumire.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				modificare.setVisible(true);
				ok2.setVisible(true);

				ok2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							Connection conectare = DBcon.openConection();
							
							
						String sql = "UPDATE aplicatie_biblioteca SET denumire=? WHERE denumire=?";
							PreparedStatement pstm = conectare.prepareStatement(sql);
							pstm.setString(1, modificare.getText());
							pstm.setString(2, text_caseta.getText());
							
							pstm.executeUpdate();
							JOptionPane.showMessageDialog(null, "Modificare efectuata cu succes");
							pstm.close(); 
							conectare.close();
						} catch (Exception ex) {
							System.out.println("EROARE " + ex);
							JOptionPane.showMessageDialog(null, ex.getMessage());

						}

						ascundere_butoane(text_caseta, alege_modificarea, denumire, autor, an, format, cod, locatie,
								modificare, ok2);
					}
				});
			}
		});
		autor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				modificare.setVisible(true);
				ok2.setVisible(true);

				ok2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						try {
							Connection conectare = DBcon.openConection();
							
							String sql = "UPDATE aplicatie_biblioteca SET autor=? WHERE denumire=?";
							PreparedStatement pstm = conectare.prepareStatement(sql);
							pstm.setString(1, modificare.getText());
							pstm.setString(2, text_caseta.getText());
							pstm.executeUpdate();
							JOptionPane.showMessageDialog(null, "Modificare efectuata cu succes");

							pstm.close();
							conectare.close();
						} catch (Exception ex) {
							System.out.println("EROARE " + ex);
							JOptionPane.showMessageDialog(null, ex.getMessage());

						}

						ascundere_butoane(text_caseta, alege_modificarea, denumire, autor, an, format, cod, locatie,
								modificare, ok2);
					}
				});
			}
		});
		an.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				modificare.setVisible(true);
				ok2.setVisible(true);

				ok2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						Connection conectare = DBcon.openConection();
						try {
						
							String sql = "UPDATE aplicatie_biblioteca SET an_editare=? WHERE denumire=?";
							PreparedStatement pstm = conectare.prepareStatement(sql);
							pstm.setString(1, modificare.getText());
							pstm.setString(2, text_caseta.getText());
							pstm.executeUpdate();
							JOptionPane.showMessageDialog(null, "Modificare efectuata cu succes");

							pstm.close();
							conectare.close();
						} catch (Exception ex) {
							System.out.println("EROARE " + ex);
							JOptionPane.showMessageDialog(null, ex.getMessage());
						}

						ascundere_butoane(text_caseta, alege_modificarea, denumire, autor, an, format, cod, locatie,
								modificare, ok2);
					}
				});
			}
		});
		format.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				modificare.setVisible(true);
				ok2.setVisible(true);

				ok2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						Connection conectare = DBcon.openConection();
						try {
							
							String sql = "UPDATE aplicatie_biblioteca SET format=? WHERE denumire=?";
							PreparedStatement pstm = conectare.prepareStatement(sql);
							pstm.setString(1, modificare.getText());
							pstm.setString(2, text_caseta.getText());
							pstm.executeUpdate();
							
							JOptionPane.showMessageDialog(null, "Modificare efectuata cu succes");

							pstm.close();
							conectare.close();
						} catch (Exception ex) {
							System.out.println("EROARE " + ex);
							JOptionPane.showMessageDialog(null, ex.getMessage());

						}

						ascundere_butoane(text_caseta, alege_modificarea, denumire, autor, an, format, cod, locatie,
								modificare, ok2);
					}
				});
			}
		});
		cod.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				modificare.setVisible(true);
				ok2.setVisible(true);

				ok2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						Connection conectare = DBcon.openConection();
						try {
							
							String sql = "UPDATE aplicatie_biblioteca SET cod_ISSN=? WHERE denumire=?";
							PreparedStatement pstm = conectare.prepareStatement(sql);
							pstm.setString(1, modificare.getText());
							pstm.setString(2, text_caseta.getText());
							pstm.executeUpdate();
						
							
							JOptionPane.showMessageDialog(null, "Modificare efectuata cu succes");

							pstm.close();
							conectare.close();
						} catch (Exception ex) {
							System.out.println("EROARE " + ex);
						}

						ascundere_butoane(text_caseta, alege_modificarea, denumire, autor, an, format, cod, locatie,
								modificare, ok2);
					}
				});
			}
		});
		locatie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				modificare.setVisible(true);
				ok2.setVisible(true);

				ok2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						Connection conectare = DBcon.openConection();
						try {
							
							String sql = "UPDATE aplicatie_biblioteca SET cod_locatie=? WHERE denumire=?";
							PreparedStatement pstm = conectare.prepareStatement(sql);
							pstm.setString(1, modificare.getText());
							pstm.setString(2, text_caseta.getText());
							pstm.executeUpdate();
							JOptionPane.showMessageDialog(null, "Modificare efectuata cu succes");
							pstm.close();
							conectare.close();
						} catch (Exception ex) {
							System.out.println("EROARE " + ex);
						}

						ascundere_butoane(text_caseta, alege_modificarea, denumire, autor, an, format, cod, locatie,
								modificare, ok2);
					}
				});
			}
		});

	}

	public void ascundere_butoane(JTextField text_caseta, JLabel alege_modificarea, JButton denumire, JButton autor,
			JButton an, JButton format, JButton cod, JButton locatie, JTextField modificare, JButton ok2) {
		text_caseta.setText("");
		modificare.setText("");
		alege_modificarea.setVisible(false);
		denumire.setVisible(false);
		autor.setVisible(false);
		an.setVisible(false);
		format.setVisible(false);
		cod.setVisible(false);
		locatie.setVisible(false);
		modificare.setVisible(false);
		ok2.setVisible(false);

	}
}