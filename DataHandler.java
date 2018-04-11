package assignment1;

import java.sql.*;
import java.util.*;

public class DataHandler {
	
	String val1 = "";
	String val2 = "";
	String val3 = "";
	String val4 = "";
	String val5 = "";
	
	int i = 0;
	
	public DataHandler(String val1, String val2, String val3, String val4, String val5) {
		
		this.val1 = val1;
		this.val2 = val2;
		this.val3 = val3;
		this.val4 = val4;
		this.val5 = val5;
	}
	
	public DataHandler() {
		
	}
	
	public void mainDriver() {	
		
		try {
			
			Connection myConn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "system", "student");
			
			Statement myStmt = myConn.createStatement();
			
			ResultSet stat1 = myStmt.executeQuery("select count(" + val1 + ") from FIRESTAT where " + val1 +  " = '" + val2 + "' and " + val3 + " between '" + val4 + "' and '" + val5 + "'");
			//ResultSet stat1 = myStmt.executeQuery("select unique(Description) from FIRESTAT");
			//ResultSet stat1 = myStmt.executeQuery("count(" + val1 + ")");
			
			while (stat1.next()) {
				
				//System.out.println(stat1.getString("Description") + " | " + stat1.getString("DATES") + ("|") + stat1.getString("STATIONAREA"));
				//System.out.println(stat1.getString("count(" + val1 + ")"));
				System.out.println(stat1.getString("count(" + val1 + ")"));
				
			}
			
		}
		catch (Exception exc) {
			
			exc.printStackTrace();
		}
	}
	
	public List<String> retrieveVars(String value) {
		
		List<String> list = new ArrayList<String>();
		
		try {
			
			Connection myConn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "system", "student");
			
			Statement myStmt = myConn.createStatement();
			
			ResultSet stat1 = myStmt.executeQuery("select unique(" + value + ") from FIRESTAT");
			
			while (stat1.next()) {
				
				list.add(stat1.getString(value));
			}
		}
		catch (Exception exc) {
			
			exc.printStackTrace();
		}
		
		return list;
	}
}
