package assignment1;

import java.sql.*;

public class DataHandler {
	
	public void mainDriver() {
		
		try {
			
			
			Connection myConn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "system", "student");
			
			Statement myStmt = myConn.createStatement();
			
			ResultSet stat1 = myStmt.executeQuery("select * from FIRESTAT");
			
			while (stat1.next()) {
				
				System.out.println(stat1.getString("DATES") + " | " + stat1.getString("DESCRIPTION"));
			}
		}
		catch (Exception exc) {
			
			exc.printStackTrace();
		}
	}
}
