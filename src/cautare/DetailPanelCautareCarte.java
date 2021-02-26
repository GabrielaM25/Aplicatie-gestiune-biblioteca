package cautare;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import conectionDB.DBcon;
import meniuprincipal.Carte;

public class DetailPanelCautareCarte extends JPanel{
private JTable tabel;
private DefaultTableModel tableModel;

public DetailPanelCautareCarte(String sql) {
	setBorder(BorderFactory.createTitledBorder("Rezultate cautare"));
	 String[] coloane = { "Titlu", "Autor", "An editare","Format","cod ISSN/ISBN","cod locatie" };
	tableModel= new DefaultTableModel(coloane,0);
	tabel = new JTable(tableModel);
	tableModel.addRow(coloane);
	Color cl =new Color(000000);
	tabel.setBorder(new LineBorder(cl , 2)) ;
		
	
		
	
	setLayout(new GridBagLayout());
	GridBagConstraints gc = new GridBagConstraints();
	gc.gridx=0;
	gc.gridy=0;
	add(tabel, gc);
	
	Connection conectare = DBcon.openConection();
	Statement stm=null;
	ResultSet rs = null;
	try {
		stm = conectare.createStatement();
		rs = stm.executeQuery(sql);
		
		while (rs.next()) {
			Carte c = new Carte();
			c.setDenumire(rs.getString("denumire"));
			c.setAutor(rs.getString("autor"));
			c.setAn(rs.getInt("an_editare"));
			c.setForm(rs.getString("format"));
			c.setCod(rs.getString("cod_ISSN"));
			c.setLocatie(rs.getString("cod_locatie"));
			
			Object []o= {c.getDenumire(),c.getAutor(),c.getAn(),c.getForm(),c.getCod(),c.getLocatie()};
			tableModel.addRow(o);
			tabel.setModel(tableModel);
			tabel.setFillsViewportHeight(true);
		
			
		}
		stm.close();
		
		conectare.close();
		
	}catch (Exception e) {
System.out.println(e);	}
}
}
