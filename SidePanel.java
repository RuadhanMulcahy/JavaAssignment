package assignment1;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

public class SidePanel extends JPanel {
	
	public SidePanel() {
		
	}
	
	public JPanel sideMenu() {
		
		String[] options = {"", "1", "2", "3", "4", "5"};
		
		JComboBox dropDown1 = new JComboBox(options);
		JComboBox dropDown2 = new JComboBox(options);
		JComboBox dropDown3 = new JComboBox(options);
		JComboBox dropDown4 = new JComboBox(options);
		JComboBox dropDown5 = new JComboBox(options);
		
		JLabel blank1 = new JLabel("");
		JLabel blank2 = new JLabel("");
		JLabel blank3 = new JLabel("");
		JLabel blank4 = new JLabel("");
		JLabel blank5 = new JLabel("");
		
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
}
