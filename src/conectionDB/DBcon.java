package conectionDB;
import java.sql.Connection;
import java.sql.DriverManager;;
public class DBcon {
	
static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Eroare incarcare driver!\n" + e);
		}
		
	}

private final static String url ="jdbc:mysql://localhost:3306/date_proiect_ti_2020";
private final static String user ="root";
private final static String password ="";

public static Connection openConection(){
	Connection con=null;
	
	try {
		con= DriverManager.getConnection(url,user,password);
	}catch (Exception e) {
		System.out.println("ERROR: " + e.getMessage());
	}
	return con;
	}


}
