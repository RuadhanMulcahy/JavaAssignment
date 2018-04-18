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

public class SidePanel  implements ActionListener {
	
	String[] options = {"", "1", "2", "3", "4", "5"};
	String[] columnNames1 = {"","StationArea", "Description"};
	String[] columnNames2 = {"Dates", "TOC", "ORD", "MOB", "IA", "MAV", "CD"};
	String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
	String[] type = {"", "Pie Chart", "Graph"};
	
	List<String> dates = Arrays.asList("Dates");
	List<String> times = Arrays.asList("TOC", "ORD", "MOB", "IA", "MAV", "CD");
	
	static int listCount;
	static ArrayList<String> countTitle = new ArrayList<String>();
	static ArrayList<String> countResult = new ArrayList<String>();
	
	DateTime fill = new DateTime();
	
	JComboBox dropDown1 = new JComboBox(columnNames1);
	JComboBox dropDown2 = new JComboBox();
	JComboBox dropDown3 = new JComboBox();
	JComboBox dropDown4 = new JComboBox();
	JComboBox dropDown5 = new JComboBox();
	JComboBox dropDown6 = new JComboBox(type);
	
	JComboBox dateTimeTTDD1 = new JComboBox();
	JComboBox dateTimeTTMON1 = new JComboBox();
	JComboBox dateTimeTTYY1 = new JComboBox();
	
	//change dateTimeTTDD2 to dateTimeHHDD2
	JComboBox dateTimeTTDD2 = new JComboBox();
	JComboBox dateTimeTTMON2 = new JComboBox();
	JComboBox dateTimeTTYY2 = new JComboBox();
	
	JButton button1 = new JButton("View");
	JButton button2 = new JButton("Add");
	JButton button3 = new JButton("New");
	
	JPanel container = new JPanel();
	JFrame window = new JFrame();
	
	String selection = "";
	
	String val1 = "";
	String val2 = "";
	String val3 = "";
	String val4 = "";
	String val5 = "";
	String val6 = "";
	String val7 = "";
	String val8 = "";
	String val9 = "";
	
	public SidePanel(JPanel container, JFrame window) {
		
		this.container = container;
		this.window = window;
	}
	
	public JPanel sideMenu() {
		
		//System.out.println(dateTimeTTDD1.getSelectedItem().getClass().getName());
		
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
		
		JPanel sidePanel = new JPanel();
		JPanel container2 = new JPanel(); 
		JPanel container3 = new JPanel();
		JPanel container4 = new JPanel();
		
		button1.setPreferredSize(new Dimension(50, 20));
		
		sidePanel.setPreferredSize(new Dimension(150,200));
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
		
		container2.setMaximumSize(new Dimension(150, 20));
		container2.setLayout(new BoxLayout(container2, BoxLayout.X_AXIS));
		
		container3.setMaximumSize(new Dimension(150, 20));
		container3.setLayout(new BoxLayout(container3, BoxLayout.X_AXIS));
		
		container4.setMaximumSize(new Dimension(150, 20));
		container4.setLayout(new BoxLayout(container4, BoxLayout.X_AXIS));
		
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
		
		return sidePanel;
	}

	public void actionPerformed(ActionEvent actions) {
		
		if(actions.getSource() == dropDown1) {

			String check = (String) dropDown1.getSelectedItem();
		
			switch (check) {
			
				case "StationArea":
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
			
			dropDown3.setModel(new DefaultComboBoxModel(columnNames2));
			val2 = (String) dropDown2.getSelectedItem();
		}
		else if(actions.getSource() == dropDown3) {
			
			String check = (String) dropDown3.getSelectedItem();
			
			if (check == "Dates") {
				
				dateTimeTTDD1.removeAllItems();
				dateTimeTTMON1.removeAllItems();
				dateTimeTTYY1.removeAllItems();
				dateTimeTTDD2.removeAllItems();
				dateTimeTTMON2.removeAllItems();
				dateTimeTTYY2.removeAllItems();
				
				fill.dateTimeFill(check, dateTimeTTDD1, dateTimeTTMON1, dateTimeTTYY1);
				fill.dateTimeFill(check, dateTimeTTDD2, dateTimeTTMON2, dateTimeTTYY2);
				
				val3 = (String) dropDown3.getSelectedItem();
				
				dateTimeTTMON1.setSelectedItem(1);
				dateTimeTTMON2.setSelectedItem(1);
				
				fill.daySetterMonth(dateTimeTTDD1, dateTimeTTMON1);
				fill.daySetterMonth(dateTimeTTDD2, dateTimeTTMON2);
		
			}
			else {
				
				dateTimeTTDD1.removeAllItems();
				dateTimeTTMON1.removeAllItems();
				dateTimeTTYY1.removeAllItems();
				dateTimeTTDD2.removeAllItems();
				dateTimeTTMON2.removeAllItems();
				dateTimeTTYY2.removeAllItems();
				
				fill.dateTimeFill(check, dateTimeTTDD1, dateTimeTTMON1, dateTimeTTYY1);
				fill.dateTimeFill(check, dateTimeTTDD2, dateTimeTTMON2, dateTimeTTYY2); 
				
				val3 = (String) dropDown3.getSelectedItem();
			}
			
		}
		else if(actions.getSource() == dateTimeTTDD1) {
			
			if (dateTimeTTDD1.getSelectedItem() != null) {
			
				int convert = (int) dateTimeTTDD1.getSelectedItem();
				
				val4 = Integer.toString(convert);
			}
		}
		else if(actions.getSource() == dateTimeTTMON1) {
			
			String check = (String) dropDown3.getSelectedItem();
			
			if(check == "Dates") {
			
				dateTimeTTDD1.removeAllItems();
				fill.daySetterMonth(dateTimeTTDD1, dateTimeTTMON1);
			}
			
			if (dateTimeTTMON1.getSelectedItem() != null) {
				
				int convert = (int) dateTimeTTMON1.getSelectedItem();
				
				val5 = Integer.toString(convert);
			}
		}
		else if(actions.getSource() == dateTimeTTYY1) {
			
			if (dateTimeTTYY1.getSelectedItem() != null) {
				
				int convert = (int) dateTimeTTYY1.getSelectedItem();
				
				val6 = Integer.toString(convert);
			}
		}
		else if(actions.getSource() == dateTimeTTDD2) {
			
			if (dateTimeTTDD2.getSelectedItem() != null) {
				
				int convert = (int) dateTimeTTDD2.getSelectedItem();
				
				val7 = Integer.toString(convert);
			}
		}
		else if(actions.getSource() == dateTimeTTMON2) {
			
			String check = (String) dropDown3.getSelectedItem();
			
			if(check == "Dates") {
				
				dateTimeTTDD2.removeAllItems();
				fill.daySetterMonth(dateTimeTTDD2, dateTimeTTMON2);
			}
			
			if (dateTimeTTMON2.getSelectedItem() != null) {
				
				int convert = (int) dateTimeTTMON2.getSelectedItem();
				
				val8 = Integer.toString(convert);
			}
		}
		else if(actions.getSource() == dateTimeTTYY2) {
			
			if (dateTimeTTYY2.getSelectedItem() != null) {
				
				int convert = (int) dateTimeTTYY2.getSelectedItem();
				
				val9 = Integer.toString(convert);
			}
		}
		
		else if(actions.getSource() == dropDown6) {
			
			String check = (String) dropDown6.getSelectedItem();
			
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
			
			this.dataTransmitter(check, val1, val2, val3, val4, val5, val6, val7, val8, val9);
		}
		else if(actions.getSource() == button1) {
			
			String title = (String) dropDown1.getSelectedItem();
			
			if(selection == "Pie Chart") {
				
				Graph demo = new Graph(countTitle, countResult, title );  
			    demo.setSize(400, 300 );  
			    container.add(demo.createDemoPanel());
			    window.repaint();
			    window.setVisible(true);
			}
			else if(selection == "Bar Chart")
			{
				Graph chart = new Graph(countTitle, countResult, title); 
			    
			    chart.setSize(400, 300 );  
			    container.add(chart.creatBarChart());
			    window.repaint();
			    window.setVisible(true);
			}
		}
	}
	
	public void retrieval(JComboBox box, String var) {
		
		DataHandler retrieve = new DataHandler();
		
		List<String> list = retrieve.retrieveVars(var);
		
		String[] conversion = new String[list.size()];
		conversion = list.toArray(conversion);
		
		box.setModel(new DefaultComboBoxModel(conversion));
	}
	
	public void dataTransmitter(String check, String val1, String val2, String val3, String val4, String val5, String val6, String val7, String val8, String val9) {
		
		DataHandler data = new DataHandler();
		
		countResult.add(data.mainDriver(check, val1, val2, val3, val4, val5, val6, val7, val8, val9));
		countTitle.add(val2);
	}
}


