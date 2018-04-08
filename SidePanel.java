package assignment1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SidePanel  implements ActionListener {
	 
	//try extending display or graph
	
	String[] options = {"", "1", "2", "3", "4", "5"};
	String[] type = {"", "Pie Chart", "Graph"};
	
	JComboBox dropDown1 = new JComboBox(options);
	JComboBox dropDown2 = new JComboBox(options);
	JComboBox dropDown3 = new JComboBox(options);
	JComboBox dropDown4 = new JComboBox(options);
	JComboBox dropDown5 = new JComboBox(type);
	
	JLabel blank1 = new JLabel("");
	JLabel blank2 = new JLabel("");
	JLabel blank3 = new JLabel("");
	JLabel blank4 = new JLabel("");
	JLabel blank5 = new JLabel("");
	
	JPanel container = new JPanel();
	JFrame window = new JFrame();
	
	public SidePanel(JPanel container, JFrame window) {
		
		this.container = container;
		this.window = window;
	}
	
	public JPanel sideMenu() {
		
		JPanel sidePanel = new JPanel();
		
		sidePanel.setPreferredSize(new Dimension(100,200));
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
		
		dropDown1.setPreferredSize(new Dimension(100,20));
		dropDown1.setMaximumSize(new Dimension(100,20));
		dropDown2.setPreferredSize(new Dimension(100,20));
		dropDown2.setMaximumSize(new Dimension(100,20));
		dropDown3.setPreferredSize(new Dimension(100,20));
		dropDown3.setMaximumSize(new Dimension(100,20));
		dropDown4.setPreferredSize(new Dimension(100,20));
		dropDown4.setMaximumSize(new Dimension(100,20));
		dropDown5.setPreferredSize(new Dimension(100,20));
		dropDown5.setMaximumSize(new Dimension(100,20));
		
		blank1.setPreferredSize(new Dimension(100,20));
		blank1.setMaximumSize(new Dimension(100,20));
		blank2.setPreferredSize(new Dimension(100,20));
		blank2.setMaximumSize(new Dimension(100,20));
		blank3.setPreferredSize(new Dimension(100,20));
		blank3.setMaximumSize(new Dimension(100,20));
		blank4.setPreferredSize(new Dimension(100,20));
		blank4.setMaximumSize(new Dimension(100,20));
		blank5.setPreferredSize(new Dimension(100,20));
		blank5.setMaximumSize(new Dimension(100,20));
		
		dropDown1.addActionListener(this);
		dropDown5.addActionListener(this);
		
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
		
		return sidePanel;
	}

	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == dropDown1) {
			
			String check = (String) dropDown1.getSelectedItem();
		
			switch (check) {
			
				case "1":
					System.out.println("1");
					break;
				case "2":
					System.out.println("2");
					break;
				case "3":
					System.out.println("3");
					break;
				case "4":
					System.out.println("4");
					break;
			}
		}
		else if(e.getSource() == dropDown5) {
			
			String check2 = (String) dropDown5.getSelectedItem();
			
			switch (check2) {
				
				case "Pie Chart":
					Graph demo = new Graph("chart" );  
				    demo.setSize(400, 300 );  
				    container.add(demo.createDemoPanel());
				    window.repaint();
				    window.setVisible(true);
					break;
				case "Graph":
					System.out.println("Graph");
					break; 
			}
		}
	}
}

