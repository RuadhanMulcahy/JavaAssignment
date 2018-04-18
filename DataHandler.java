package assignment1;

import java.sql.*;
import java.util.*;

public class DataHandler {
	
	public DataHandler() {
	}
	
	public String mainDriver(String check, String val1, String val2, String val3, String val4, String val5, String val6, String val7, String val8, String val9) {	
		
		try {
			
			DateTime DT = new DateTime();
			
			ResultSet stat1;
			
			if(check == "Dates") {
				
				String month1 = DT.monthConverter(val5);
				String month2 = DT.monthConverter(val8);
				
				System.out.println("select count(" + val1 + ") from FIRESTAT where " + val1 +  " = '" + val2 + "' and " + val3 + " between '" + val4 + "-" + month1 + "-" + val6 + "' and '" + val7 + "-" + month2 + "-" + val9 + "'");
				
				Connection myConn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "system", "student");
				
				Statement myStmt = myConn.createStatement();
				
			    stat1 = myStmt.executeQuery("select count(" + val1 + ") from FIRESTAT where " + val1 +  " = '" + val2 + "' and " + val3 + " between '" + val4 + "-" + month1 + "-" + val6 + "' and '" + val7 + "-" + month2 + "-" + val9 + "'");
			}
			else {
				
				Connection myConn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "system", "student");
				
				Statement myStmt = myConn.createStatement();
				
				stat1 = myStmt.executeQuery("select count(" + val1 + ") from FIRESTAT where " + val1 +  " = '" + val2 + "' and " + val3 + " between '" + val4 + ":" + val5 + ":" + val6 + "' and '" + val7 + ":" + val8 + ":" + val9 + "'");
			}
			
			while (stat1.next()) {
				
				return(stat1.getString("count(" + val1 + ")"));
			}
		}
		catch (Exception exc) {
			
			exc.printStackTrace();
		}
		return("Error");
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

