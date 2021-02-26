package cautare;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DetailPanelCautare extends JPanel {
	private JLabel text;
	private JButton denumire;
	private JButton autor;
	private JButton cod;
	private JButton locatie;
	private JLabel cauta;
	private JTextField cauta_caseta;
	private JButton ok;

	public DetailPanelCautare() {

		setBorder(BorderFactory.createTitledBorder("Cautare"));
		text = new JLabel("Alegeti criteriul de cautare :");
		denumire = new JButton("TITLU");
		autor = new JButton("AUTOR");
		cod = new JButton("COD ISBN/ISSN");
		locatie = new JButton("COD LOCATIE");
		cauta = new JLabel("Cauta :");
		cauta_caseta = new JTextField(25);
		ok = new JButton("OK");

		setLayout(new GridBagLayout());
		GridBagConstraints gc_cautare = new GridBagConstraints();
		
		gc_cautare.weightx = 1;
		gc_cautare.weighty = 1;

		gc_cautare.gridx = 0;
		gc_cautare.gridy = 0;
		add(text, gc_cautare);

		gc_cautare.gridx = 0;
		gc_cautare.gridy = 1;
		add(denumire, gc_cautare);

		gc_cautare.gridx = 1;
		gc_cautare.gridy = 1;
		add(autor, gc_cautare);

		gc_cautare.gridx = 0;
		gc_cautare.gridy = 2;
		add(cod, gc_cautare);

		gc_cautare.gridx = 1;
		gc_cautare.gridy = 2;
		add(locatie, gc_cautare);

		gc_cautare.gridx = 0;
		gc_cautare.gridy = 3;
		add(cauta, gc_cautare);
		cauta.setVisible(false);

		gc_cautare.gridx = 1;
		gc_cautare.gridy = 3;
		add(cauta_caseta, gc_cautare);
		cauta_caseta.setVisible(false);

		gc_cautare.gridx = 2;
		gc_cautare.gridy = 3;
		add(ok, gc_cautare);
		ok.setVisible(false);

		denumire.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(ok, cauta_caseta, cauta);
				ok.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String sql = "SELECT * FROM aplicatie_biblioteca WHERE denumire= '" + cauta_caseta.getText()
								+ "'";
						JFrame cautare_titlu_frame = new CautareCarteFrame("Cauta carte dupa titlu ", sql);
						cautare_titlu_frame.setSize(600, 400);
						cautare_titlu_frame.setVisible(true);

					}
				});

			}
		});
		autor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(ok, cauta_caseta, cauta);
				ok.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						String sql = "SELECT * FROM aplicatie_biblioteca WHERE autor= '" + cauta_caseta.getText() + "'";
						JFrame cautare_autor_frame = new CautareCarteFrame("Cauta carte dupa autor ", sql);
						cautare_autor_frame.setSize(800, 800);
						cautare_autor_frame.setVisible(true);

					}
				});
			}

		});
		cod.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(ok, cauta_caseta, cauta);
				ok.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						String sql = "SELECT * FROM aplicatie_biblioteca WHERE cod_ISSNr= '" + cauta_caseta.getText()
								+ "'";

						JFrame cautare_cod_frame = new CautareCarteFrame("Cauta carte dupa cod ISSN/ISBN ", sql);
						cautare_cod_frame.setSize(800, 800);
						cautare_cod_frame.setVisible(true);
					}
				});
			}
		});
		locatie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(ok, cauta_caseta, cauta);
				ok.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						String sql = "SELECT * FROM aplicatie_biblioteca WHERE cod_locatie= '" + cauta_caseta.getText()
								+ "'";

						JFrame cautare_locatie_frame = new CautareCarteFrame("Cauta carte dupa cod locatie", sql);
						cautare_locatie_frame.setSize(800, 800);
						cautare_locatie_frame.setVisible(true);
					}
				});
			}
		});
	}

	public static void setVisible(JButton ok, JTextField cauta_caseta, JLabel cauta) {
		ok.setVisible(true);
		cauta_caseta.setVisible(true);
		cauta.setVisible(true);
	}
}
