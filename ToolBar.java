package assignment1;

import java.awt.Dimension;

import javax.swing.*;

public class ToolBar {
	
	public ToolBar() {
		
	}
	
	public JToolBar topToolBar() {
		
		JToolBar topToolBar = new JToolBar();
		
		JButton button1 = new JButton("Advanced");
		JButton button2 = new JButton("Help");
		
		topToolBar.setPreferredSize(new Dimension(400,50));
		topToolBar.add(button1);
		topToolBar.add(button2);
		
		return topToolBar;
	}

}
