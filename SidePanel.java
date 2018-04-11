package assignment1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class SidePanel  implements ActionListener {
	
	String[] options = {"", "1", "2", "3", "4", "5"};
	String[] columnNames1 = {"","Station Area", "Description"};
	String[] columnNames2 = {"Dates", "TOC", "ORD", "MOB", "IA", "MAV", "CD"};   
	String[] type = {"", "Pie Chart", "Graph"};
	
	JComboBox dropDown1 = new JComboBox(columnNames1);
	JComboBox dropDown2 = new JComboBox();
	JComboBox dropDown3 = new JComboBox();
	JComboBox dropDown4 = new JComboBox();
	JComboBox dropDown5 = new JComboBox();
	JComboBox dropDown6 = new JComboBox(type);
	
	JLabel blank1 = new JLabel("");
	JLabel blank2 = new JLabel("");
	JLabel blank3 = new JLabel("");
	JLabel blank4 = new JLabel("");
	JLabel blank5 = new JLabel("");
	JLabel blank6 = new JLabel("");
	JLabel blank7 = new JLabel("");
	
	JButton button1 = new JButton("View");
	
	String selection = "";
	
	JPanel container = new JPanel();
	JFrame window = new JFrame();
	
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
		
		JPanel sidePanel = new JPanel();
		
		sidePanel.setPreferredSize(new Dimension(100,200));
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
		
		dropDown1.setMaximumSize(new Dimension(100,20));
		dropDown2.setMaximumSize(new Dimension(100,20));
		dropDown3.setMaximumSize(new Dimension(100,20));
		dropDown4.setMaximumSize(new Dimension(100,20));
		dropDown5.setMaximumSize(new Dimension(100,20));
		dropDown6.setMaximumSize(new Dimension(100, 20));
		
		blank1.setMaximumSize(new Dimension(100,20));
		blank2.setMaximumSize(new Dimension(100,20));
		blank3.setMaximumSize(new Dimension(100,20));
		blank4.setMaximumSize(new Dimension(100,20));
		blank5.setMaximumSize(new Dimension(100,20));
		blank6.setMaximumSize(new Dimension(100, 20));
		blank7.setMaximumSize(new Dimension(100, 20));
		
		dropDown1.addActionListener(this);
		dropDown2.addActionListener(this);
		dropDown6.addActionListener(this);
		button1.addActionListener(this);
		
		sidePanel.add(blank1);
		sidePanel.add(dropDown1);
		sidePanel.add(blank2);
		sidePanel.add(dropDown2);
		sidePanel.add(blank3);
		sidePanel.add(dropDown3);
		sidePanel.add(blank4);
		sidePanel.add(dropDown4);
		sidePanel.add(blank5);
		sidePanel.add(dropDown5);
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
			
		}
		else if(actions.getSource() == dropDown4) {
			
		}
		else if(actions.getSource() == dropDown5) {
			
		}
		else if(actions.getSource() == dropDown6) {
			
			String check2 = (String) dropDown6.getSelectedItem();
			
			switch (check2) {
				
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

