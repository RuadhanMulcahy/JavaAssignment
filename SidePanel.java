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

public class SidePanel  implements ActionListener {
	
	String[] options = {"", "1", "2", "3", "4", "5"};
	String[] columnNames1 = {"","Station Area", "Description"};
	String[] columnNames2 = {"Dates", "TOC", "ORD", "MOB", "IA", "MAV", "CD"};
	String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
	String[] type = {"", "Pie Chart", "Graph"};
	
	List<String> dates = Arrays.asList("Dates");
	List<String> times = Arrays.asList("TOC", "ORD", "MOB", "IA", "MAV", "CD");
	
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
	
	JPanel container = new JPanel();
	JFrame window = new JFrame();
	
	String selection = "";
	
	String val1 = "Description";
	String val2 = "Fire CAR";
	String val3 = "DATES";
	String val4 = "01-JAN-13";
	String val5 = "13-JAN-13";
	
	DataHandler data = new DataHandler(val1, val2, val3, val4, val5);
	
	public SidePanel(JPanel container, JFrame window) {
		
		this.container = container;
		this.window = window;
	}
	
	public JPanel sideMenu() {
		
		JLabel blank1 = new JLabel("");
		JLabel blank2 = new JLabel("");
		JLabel blank3 = new JLabel("");
		JLabel blank4 = new JLabel("");
		JLabel blank5 = new JLabel("");
		JLabel blank6 = new JLabel("");
		JLabel blank7 = new JLabel("");
		JLabel blank8 = new JLabel("");
		JLabel blank9 = new JLabel("");
		
		JPanel sidePanel = new JPanel();
		JPanel container2 = new JPanel(); 
		JPanel container3 = new JPanel();
		
		sidePanel.setPreferredSize(new Dimension(150,200));
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
		
		container2.setMaximumSize(new Dimension(150, 20));
		container2.setLayout(new BoxLayout(container2, BoxLayout.X_AXIS));
		
		container3.setMaximumSize(new Dimension(150, 20));
		container3.setLayout(new BoxLayout(container3, BoxLayout.X_AXIS));
		
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
		
		dropDown1.addActionListener(this);
		dropDown2.addActionListener(this);
		dropDown3.addActionListener(this);
		dateTimeTTMON1.addActionListener(this);
		dateTimeTTMON2.addActionListener(this);
		dropDown6.addActionListener(this);
		button1.addActionListener(this);
		
		container2.add(blank8);
		container2.add(dateTimeTTDD1);
		container2.add(dateTimeTTMON1);
		container2.add(dateTimeTTYY1);
		
		container3.add(blank9);
		container3.add(dateTimeTTDD2);
		container3.add(dateTimeTTMON2);
		container3.add(dateTimeTTYY2);
		
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
		sidePanel.add(button1);
		
		data.mainDriver();
		
		return sidePanel;
	}

	public void actionPerformed(ActionEvent actions) {
		
		if(actions.getSource() == dropDown1) {

			String check = (String) dropDown1.getSelectedItem();
		
			switch (check) {
			
				case "Station Area":
					this.retrieval(dropDown2, "StationArea");
					break;
				case "Description":
					this.retrieval(dropDown2, "Description");
					break;
			}
		}
		else if(actions.getSource() == dropDown2) {
			
			dropDown3.setModel(new DefaultComboBoxModel(columnNames2));
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
			}
			
		}
		else if(actions.getSource() == dateTimeTTDD1) {
			
		}
		else if(actions.getSource() == dateTimeTTMON1) {
			
			String check = (String) dropDown3.getSelectedItem();
			
			if(check == "Dates") {
			
				dateTimeTTDD1.removeAllItems();
				fill.daySetterMonth(dateTimeTTDD1, dateTimeTTMON1);
			}
		}
		else if(actions.getSource() == dateTimeTTYY1) {
			
		}
		else if(actions.getSource() == dateTimeTTDD2) {
			
		}
		else if(actions.getSource() == dateTimeTTMON2) {
			
			String check = (String) dropDown3.getSelectedItem();
			
			if(check == "Dates") {
				
				dateTimeTTDD2.removeAllItems();
				fill.daySetterMonth(dateTimeTTDD2, dateTimeTTMON2);
			}
		}
		else if(actions.getSource() == dateTimeTTYY2) {
			
		}
		
		else if(actions.getSource() == dropDown6) {
			
			String check = (String) dropDown6.getSelectedItem();
			
			switch (check) {
			
				case "Pie Chart":
					
					selection = "Pie Chart";
					break;
				case "Graph":
					System.out.println("Graph");
					break; 
			}
		}
		else if(actions.getSource() == button1) {
			
			if(selection == "Pie Chart") {
				
				Graph demo = new Graph("chart" );  
			    demo.setSize(400, 300 );  
			    container.add(demo.createDemoPanel());
			    window.repaint();
			    window.setVisible(true);
			}
			else
			{
				System.out.println("Histogram");
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
}


