package assignment1;

import java.util.Arrays;
import java.util.List;
import javax.swing.JComboBox;

/**
 * 
 * @author Ruadhan
 *
 */

public class DateTime {
	
	/**This class contains all methods relating to dates and times
	 * 
	 */
	
	public DateTime() {
		
	}
	
	//This method fills the JComboBoxes with times or dates depending on what check is equal to.
	public void dateTimeFill(String check, JComboBox box1, JComboBox box2, JComboBox box3) {
		
		int dayMax = 31;
		int monthMax = 12;
		int yearStart = 13;
		int yearMax = 15;
		int hourMax = 12;
		int minuteSecondMax = 60;
		
		
		List<String> dates = Arrays.asList("Dates");
		List<String> times = Arrays.asList("TOC", "ORD", "MOB", "IA", "MAV", "CD");
		
		//Sets for Date
		if(dates.contains(check)) {
			
			//clears any previous content from the JComboBoxes
			box1.removeAllItems();
			box2.removeAllItems();
			box3.removeAllItems();
			
			for (int i = 1, x = 1,  y = yearStart; i <= dayMax; i++) {
				
				box1.addItem(new Integer(i));
				
				if( x  != monthMax + 1) {
					
					box2.addItem(new Integer(x));
					x ++;
				}
				else if( y != yearMax + 1) {
					
					box3.addItem(new Integer(y));
					y++;
				}
			}
		}
		//Sets for Time
		else if (times.contains(check)) {
			
			//clears any previous content from the JComboBoxes
			box1.removeAllItems();
			box2.removeAllItems();
			box3.removeAllItems();
			
			for (int i = 0, x = 0,  y = 0; i <= minuteSecondMax; i++) {
				
				box2.addItem(new Integer(i));
				box3.addItem(new Integer(i));
				
				if( y != hourMax + 1) {
					
					box1.addItem(new Integer(y));
					y++;
				}
			}
		}
	}
	
	//This method changes the day JComboBox depending on what moth is selected
	public void daySetterMonth(JComboBox box1, JComboBox box2 ) {
		
		int check;
		
		if(box2.getSelectedItem() != null) {
			
			check = (int) box2.getSelectedItem();
			
			int dayMax1 = 31;
			int dayMax2 = 30;
			int dayMax3 = 28;
			
			if (check == 0 || check == 1 || check == 3 ||  check == 5 || check == 7 || check == 8 || check == 10 || check == 12) {
				
				box1.removeAllItems();
				
				if (box1.getItemCount() <= dayMax1) {
					
					//JComboBoxes are filled using loops
					for (int i = 1; i <= dayMax1; i++) {
						
						box1.addItem(new Integer(i));
					}
				}
			}
			else if (check == 4 || check == 6 ||  check == 9 || check == 11) {
				
				box1.removeAllItems();
				
				if (box1.getItemCount() <= dayMax2) {
					
					//JComboBoxes are filled using loops
					for (int i = 1; i <= dayMax2; i++) {
						
						box1.addItem(new Integer(i));
					}
				}
			}
			else if (check == 2) {
				
				box1.removeAllItems();
				
				//JComboBoxes are filled using loops
				if(box1.getItemCount() <= dayMax3) {
				
					for (int i = 1; i <= dayMax3; i++) {
						
						box1.addItem(new Integer(i));
					}
				}
			}
		}
	}
	
	//This method converts number month format to worded format so sql queries can be searched
	public String monthConverter(String val) {
		
		String wordMonth = "";
		
		switch (val) {
			
			case "1": 
				wordMonth = "JAN";
				break;
			case "2": 
				wordMonth = "FEB";
				break;
			case "3": 
				wordMonth = "MAR";
				break;
			case "4": 
				wordMonth = "APR";
				break;
			case "5": 
				wordMonth = "MAY";
				break;
			case "6": 
				wordMonth = "JUNE";
				break;
			case "7": 
				wordMonth = "JULY";
				break;
			case "8": 
				wordMonth = "AUG";
				break;
			case "9": 
				wordMonth = "SEPT";
				break;
			case "10": 
				wordMonth = "OCT";
				break;
			case "11": 
				wordMonth = "NOV";
				break;
			case "12": 
				wordMonth = "DEC";
				break;
		}
		
		//returns month in word form
		return wordMonth;
	}
	
}
