package assignment1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;

import org.jfree.ui.RefineryUtilities;

/**
 * 
 * @author Ruadhan
 *
 */
public class SidePanel  implements ActionListener {
	
	//Declaring variables and setting them to work with the datasheet
	String[] columnNames1 = {"","StationArea", "Description"};
	String[] columnNames2 = {"Dates", "TOC", "ORD", "MOB", "IA", "MAV", "CD"};
	String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
	String[] type = {"", "Pie Chart", "Graph"};
	
	//Declaring lists and setting them with values
	List<String> dates = Arrays.asList("Dates");
	List<String> times = Arrays.asList("TOC", "ORD", "MOB", "IA", "MAV", "CD");
	
	//Declaring lists that will be used with the DataHandler
	static int listCount;
	static ArrayList<String> countTitle = new ArrayList<String>();
	static ArrayList<String> countResult = new ArrayList<String>();
	
	//Creating DateTime object
	DateTime fill = new DateTime();
	
	//Use arrays instead of single declarations
	
	//Creating JComboBoxes
	JComboBox dropDown1 = new JComboBox(columnNames1);
	JComboBox dropDown2 = new JComboBox();
	JComboBox dropDown3 = new JComboBox();
	JComboBox dropDown4 = new JComboBox();
	JComboBox dropDown5 = new JComboBox();
	JComboBox dropDown6 = new JComboBox(type);
	
	//Each dateTime JCombo box represents a different part of the date or time. ie 17-JAN-15 or 11:20:30
	JComboBox dateTimeTTDD1 = new JComboBox();
	JComboBox dateTimeTTMON1 = new JComboBox();
	JComboBox dateTimeTTYY1 = new JComboBox();
	
	JComboBox dateTimeTTDD2 = new JComboBox();
	JComboBox dateTimeTTMON2 = new JComboBox();
	JComboBox dateTimeTTYY2 = new JComboBox();
	
	//Creating buttons
	JButton button1 = new JButton("View");
	JButton button2 = new JButton("Add");
	JButton button3 = new JButton("New");
	
	JPanel container = new JPanel();
	JFrame window = new JFrame();
	
	String selection = "";
	
	
	/**Declaring values for the data handler. NOTE: I should have made more use 
	 * of arrays, I know this now but its too late.
	 */
	String val1 = "";
	String val2 = "";
	String val3 = "";
	String val4 = "";
	String val5 = "";
	String val6 = "";
	String val7 = "";
	String val8 = "";
	String val9 = "";
	
	//Constructor takes in JPanel and JFrame 
	public SidePanel(JPanel container, JFrame window) {
		
		this.container = container;
		this.window = window;
	}
	
	//Main side menu method
	public JPanel sideMenu() {
		
		//Declaring JLabels and setting them to blank to be used as filler in the GUI
		JLabel blank1 = new JLabel("");
		JLabel blank2 = new JLabel("");
		JLabel blank3 = new JLabel("");
		JLabel blank4 = new JLabel("");
		JLabel blank5 = new JLabel("");
		JLabel blank6 = new JLabel("");
		JLabel blank7 = new JLabel("");
		JLabel blank8 = new JLabel("");
		JLabel blank9 = new JLabel("");
		JLabel blank10 = new JLabel("");
		
		//Declaring the main JPanel that everything will be placed into
		JPanel sidePanel = new JPanel();
		
		//Declaring JPanels to be used as containers
		JPanel container2 = new JPanel(); 
		JPanel container3 = new JPanel();
		JPanel container4 = new JPanel();
		
		button1.setPreferredSize(new Dimension(50, 20));
		
		//Setting sizes and layouts of JPanels
		sidePanel.setPreferredSize(new Dimension(150,200));
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
		
		container2.setMaximumSize(new Dimension(150, 20));
		container2.setLayout(new BoxLayout(container2, BoxLayout.X_AXIS));
		
		container3.setMaximumSize(new Dimension(150, 20));
		container3.setLayout(new BoxLayout(container3, BoxLayout.X_AXIS));
		
		container4.setMaximumSize(new Dimension(150, 20));
		container4.setLayout(new BoxLayout(container4, BoxLayout.X_AXIS));
		
		//Setting sizes of JComboBoxes
		dropDown1.setMaximumSize(new Dimension(100,20));
		dropDown2.setMaximumSize(new Dimension(100,20));
		dropDown3.setMaximumSize(new Dimension(100,20));
		dropDown4.setMaximumSize(new Dimension(100,20));
		dropDown5.setMaximumSize(new Dimension(100,20));
		dropDown6.setMaximumSize(new Dimension(100, 20));
		
		dateTimeTTDD1.setMaximumSize(new Dimension(40, 20));
		dateTimeTTMON1.setMaximumSize(new Dimension(40, 20));
		dateTimeTTYY1.setMaximumSize(new Dimension(40, 20));
		
		dateTimeTTDD2.setMaximumSize(new Dimension(40, 20));
		dateTimeTTMON2.setMaximumSize(new Dimension(40, 20));
		dateTimeTTYY2.setMaximumSize(new Dimension(40, 20));
		
		//Setting sizes of Labels
		blank1.setMaximumSize(new Dimension(100,20));
		blank2.setMaximumSize(new Dimension(100,20));
		blank3.setMaximumSize(new Dimension(100,20));
		blank4.setMaximumSize(new Dimension(100,20));
		blank5.setMaximumSize(new Dimension(100,20));
		blank6.setMaximumSize(new Dimension(100, 20));
		blank7.setMaximumSize(new Dimension(100, 20));
		blank8.setMaximumSize(new Dimension(7, 20));
		blank9.setMaximumSize(new Dimension(7, 20));
		blank10.setMaximumSize(new Dimension(7,20));
		
		//Adding action listeners
		dropDown1.addActionListener(this);
		dropDown2.addActionListener(this);
		dropDown3.addActionListener(this);
		dateTimeTTDD1.addActionListener(this);
		dateTimeTTDD2.addActionListener(this);
		dateTimeTTMON1.addActionListener(this);
		dateTimeTTMON2.addActionListener(this);
		dateTimeTTYY1.addActionListener(this);
		dateTimeTTYY2.addActionListener(this);
		dropDown6.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		
		//Adding GUI to containers
		container2.add(blank8);
		container2.add(dateTimeTTDD1);
		container2.add(dateTimeTTMON1);
		container2.add(dateTimeTTYY1);
		
		container3.add(blank9);
		container3.add(dateTimeTTDD2);
		container3.add(dateTimeTTMON2);
		container3.add(dateTimeTTYY2);
		
		container4.add(blank10);
		container4.add(button2);
		container4.add(button1);
		
		//Adding JPanels and JComboBoxes sidePanel
		sidePanel.add(blank1);
		sidePanel.add(dropDown1);
		sidePanel.add(blank2);
		sidePanel.add(dropDown2);
		sidePanel.add(blank3);
		sidePanel.add(dropDown3);
		sidePanel.add(blank4);
		sidePanel.add(container2);
		sidePanel.add(blank5);
		sidePanel.add(container3);
		sidePanel.add(blank6);
		sidePanel.add(dropDown6);
		sidePanel.add(blank7);
		sidePanel.add(container4);
		
		//Returns side panel to display where it can be dealt with
		return sidePanel;
	}
	
	//Action listener
	public void actionPerformed(ActionEvent actions) {
		
		/**This action listener controls all the JComboBoxes and
		 * and sets the values from the JComboBoxes to equal val1-val9,
		 * which is later passed onto the data handler.
		 */
		
		if(actions.getSource() == dropDown1) {
			
			//First dropDown
			String check = (String) dropDown1.getSelectedItem();
			
			/**This switch statement checks 	what the selected item of dropDown1 is
			 * and changes the contents of dropDown2 accordingly.
			 */
			switch (check) {
				
				case "StationArea":
					/**calls method retrieval which sets contents of dropDown 2 to equal
					 * whatever it queries through the databases.
					 */
					this.retrieval(dropDown2, "StationArea");
					val1 = (String) dropDown1.getSelectedItem();
					break;
				case "Description":
					this.retrieval(dropDown2, "Description");
					val1 = (String) dropDown1.getSelectedItem();
					break;
			}
		}
		else if(actions.getSource() == dropDown2) {
			
			//Sets values of dropDown3
			dropDown3.setModel(new DefaultComboBoxModel(columnNames2));
			val2 = (String) dropDown2.getSelectedItem();
		}
		else if(actions.getSource() == dropDown3) {
			
			/**This else if checks what the value from the dropDown is
			 * and checks whether it is a date or a time.
			 * If it is a date then values of dateTime dropDowns will
			 * be set to dates. If it is a time then values of dateTime 
			 * DropDowns will be set to times.
			 */
			
			String check = (String) dropDown3.getSelectedItem();
			
			if (check == "Dates") {
				
				//clears all dateTime JComboBoxes to allow for dates
				dateTimeTTDD1.removeAllItems();
				dateTimeTTMON1.removeAllItems();
				dateTimeTTYY1.removeAllItems();
				dateTimeTTDD2.removeAllItems();
				dateTimeTTMON2.removeAllItems();
				dateTimeTTYY2.removeAllItems();
				
				//fills JComboBoxes with dates
				fill.dateTimeFill(check, dateTimeTTDD1, dateTimeTTMON1, dateTimeTTYY1);
				fill.dateTimeFill(check, dateTimeTTDD2, dateTimeTTMON2, dateTimeTTYY2);
				
				//sets val3 to selected item. This will eventually be passed to the dataHandler and queried
				val3 = (String) dropDown3.getSelectedItem();
				
				/**sets dateTimeTTMON1 & 2 to selected item 1, this allows the
				 * method in charge of changing the days depending on what month
				 * is selected to operate.
				 */
				dateTimeTTMON1.setSelectedItem(1);
				dateTimeTTMON2.setSelectedItem(1);
				
				//This sets the days in the date depending on what month is selected
				fill.daySetterMonth(dateTimeTTDD1, dateTimeTTMON1);
				fill.daySetterMonth(dateTimeTTDD2, dateTimeTTMON2);
		
			}
			else {
				
				//clears all dateTime JComboBoxes to allow for times
				dateTimeTTDD1.removeAllItems();
				dateTimeTTMON1.removeAllItems();
				dateTimeTTYY1.removeAllItems();
				dateTimeTTDD2.removeAllItems();
				dateTimeTTMON2.removeAllItems();
				dateTimeTTYY2.removeAllItems();
				
				//fills JComboBoxes with times
				fill.dateTimeFill(check, dateTimeTTDD1, dateTimeTTMON1, dateTimeTTYY1);
				fill.dateTimeFill(check, dateTimeTTDD2, dateTimeTTMON2, dateTimeTTYY2); 
				
				//sets val3 to selected item. This will eventually be passed to the dataHandler and queried
				val3 = (String) dropDown3.getSelectedItem();
			}
			
		}
		//These else if's are in charge of the date and time fields
		else if(actions.getSource() == dateTimeTTDD1) {
			
			//checks that dateTimeTTDD1 does not equal null
			if (dateTimeTTDD1.getSelectedItem() != null) {
				
				//converts integer in JComboBox to a string and sets val4 to it
				int convert = (int) dateTimeTTDD1.getSelectedItem();
				
				val4 = Integer.toString(convert);
			}
		}
		else if(actions.getSource() == dateTimeTTMON1) {
			
			String check = (String) dropDown3.getSelectedItem();
			
			if(check == "Dates") {
				
				//Changes days in days field depending on what month it is
				dateTimeTTDD1.removeAllItems();
				fill.daySetterMonth(dateTimeTTDD1, dateTimeTTMON1);
			}
			
			if (dateTimeTTMON1.getSelectedItem() != null) {
				
				//converts integer in JComboBox to a string and sets val4 to it
				int convert = (int) dateTimeTTMON1.getSelectedItem();
				
				val5 = Integer.toString(convert);
			}
		}
		else if(actions.getSource() == dateTimeTTYY1) {
			
			if (dateTimeTTYY1.getSelectedItem() != null) {
				
				int convert = (int) dateTimeTTYY1.getSelectedItem();
				
				//sets val6 to equal convert
				val6 = Integer.toString(convert);
			}
		}
		else if(actions.getSource() == dateTimeTTDD2) {
			
			if (dateTimeTTDD2.getSelectedItem() != null) {
				
				int convert = (int) dateTimeTTDD2.getSelectedItem();
				
				//sets val7 to equal convert
				val7 = Integer.toString(convert);
			}
		}
		else if(actions.getSource() == dateTimeTTMON2) {
			
			String check = (String) dropDown3.getSelectedItem();
			
			if(check == "Dates") {
				
				//Changes days in days field depending on what month it is
				dateTimeTTDD2.removeAllItems();
				fill.daySetterMonth(dateTimeTTDD2, dateTimeTTMON2);
			}
			
			if (dateTimeTTMON2.getSelectedItem() != null) {
				
				int convert = (int) dateTimeTTMON2.getSelectedItem();
				
				//sets val8 to equal convert
				val8 = Integer.toString(convert);
			}
		}
		else if(actions.getSource() == dateTimeTTYY2) {
			
			if (dateTimeTTYY2.getSelectedItem() != null) {
				
				int convert = (int) dateTimeTTYY2.getSelectedItem();
				
				//sets val9 to equal convert
				val9 = Integer.toString(convert);
			}
		}
		
		else if(actions.getSource() == dropDown6) {
			
			String check = (String) dropDown6.getSelectedItem();
			
			//switch statement allows user to select what type of chart they with to use
			switch (check) {
			
				case "Pie Chart":
					
					selection = "Pie Chart";
					break;
				case "Graph":
					
					selection = "Bar Chart";
					break; 
			}
		}
		else if(actions.getSource() == button2) {
			
			String check = (String) dropDown3.getSelectedItem();
			
			//sends values 1-9 to the data transmitter where a query will be run
			this.dataTransmitter(check, val1, val2, val3, val4, val5, val6, val7, val8, val9);
		}
		else if(actions.getSource() == button1) {
			
			String title = (String) dropDown1.getSelectedItem();
			
			//Displays a chart depending on what the user had selected in dropDown 6
			if(selection == "Pie Chart") {
				
				//sets Pie Chart up
				Graph demo = new Graph(countTitle, countResult, title ); 
				
			    demo.setSize(400, 300 );  
			    container.add(demo.createDemoPanel());
			    window.repaint();
			    window.setVisible(true);
			}
			else if(selection == "Bar Chart")
			{
				//sets Bar Chart up
				Graph chart = new Graph(countTitle, countResult, title); 
			    
			    chart.setSize(400, 300 );  
			    container.add(chart.creatBarChart());
			    window.repaint();
			    window.setVisible(true);
			}
		}
	}
	
	/**This method retrieves unique values from the selected database field and adds them to a JComboBox.
	 * Either Description or Station Area.
	 */
	public void retrieval(JComboBox box, String var) {
		
		DataHandler retrieve = new DataHandler();
		
		List<String> list = retrieve.retrieveVars(var);
		
		String[] conversion = new String[list.size()];
		conversion = list.toArray(conversion);
		
		box.setModel(new DefaultComboBoxModel(conversion));
	}
	
	/**This method sends values to the dataHandler which will add whatever it returns to the
	 * list countResult. The CountTitle list is in sync with the countResult list. The method
	 * also adds val2 into countTitle which will be used by the graphs/
	 */
	public void dataTransmitter(String check, String val1, String val2, String val3, String val4, String val5, String val6, String val7, String val8, String val9) {
		
		DataHandler data = new DataHandler();
		
		countResult.add(data.mainDriver(check, val1, val2, val3, val4, val5, val6, val7, val8, val9));
		countTitle.add(val2);
	}
}


