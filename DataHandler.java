package assignment1;

import java.sql.*;
import java.util.*;

/**
 * 
 * @author Ruadhan
 *
 */

public class DataHandler {
	
	/**This class is in charge of the interactions between the java program and the database
	 * 
	 */
	
	public DataHandler() {
	}
	
	//The main driver runs the main sql query that is run for the graphs
	public String mainDriver(String check, String val1, String val2, String val3, String val4, String val5, String val6, String val7, String val8, String val9) {	
		
		try {
			
			DateTime DT = new DateTime();
			
			ResultSet stat1;
			
			//This if else checks if the sql query should be formatted for dates or times
			if(check == "Dates") {
				
				//val5 an val8 which are months in numbers are converted to worded format
				String month1 = DT.monthConverter(val5);
				String month2 = DT.monthConverter(val8);
				
				//sql query is printed to system.out for trouble shooting
				System.out.println("select count(" + val1 + ") from FIRESTAT where " + val1 +  " = '" + val2 + "' and " + val3 + " between '" + val4 + "-" + month1 + "-" + val6 + "' and '" + val7 + "-" + month2 + "-" + val9 + "'");
				
				//establishes connection with database and give sign in info
				Connection myConn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "system", "student");
				
				Statement myStmt = myConn.createStatement();
				
				//runs query
			    stat1 = myStmt.executeQuery("select count(" + val1 + ") from FIRESTAT where " + val1 +  " = '" + val2 + "' and " + val3 + " between '" + val4 + "-" + month1 + "-" + val6 + "' and '" + val7 + "-" + month2 + "-" + val9 + "'");
			}
			else {
				
				Connection myConn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "system", "student");
				
				Statement myStmt = myConn.createStatement();
				
				stat1 = myStmt.executeQuery("select count(" + val1 + ") from FIRESTAT where " + val1 +  " = '" + val2 + "' and " + val3 + " between '" + val4 + ":" + val5 + ":" + val6 + "' and '" + val7 + ":" + val8 + ":" + val9 + "'");
			}
			
			while (stat1.next()) {
				
				//returns the result from the query
				return(stat1.getString("count(" + val1 + ")"));
			}
		}
		catch (Exception exc) {
			
			//prints sql error
			exc.printStackTrace();
		}
		return("Error");
	}
	
	/**This method gets all unique variables from selected column
	 * 
	 */
	public List<String> retrieveVars(String value) {
		
		//variables will be saved to this list
		List<String> list = new ArrayList<String>();
		
		try {
			
			Connection myConn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "system", "student");
			
			Statement myStmt = myConn.createStatement();
			
			//query gets all unique
			ResultSet stat1 = myStmt.executeQuery("select unique(" + value + ") from FIRESTAT");
			
			//variables are added to list
			while (stat1.next()) {
			
				list.add(stat1.getString(value));
			}
		}
		catch (Exception exc) {
			
			exc.printStackTrace();
		}
		
		//returns list
		return list;
	}
}

