package assignment1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;

import javax.swing.*;

public class ToolBar implements ActionListener {
	
	JButton button1 = new JButton("Help");
	
	public ToolBar() {
		
	}
	
	public JToolBar topToolBar() {
		
		JToolBar topToolBar = new JToolBar();
		
		button1.addActionListener(this);
		
		topToolBar.setFloatable(false);
		
		topToolBar.setPreferredSize(new Dimension(400,50));
		topToolBar.add(button1);
		
		return topToolBar;
	}
	
	public void actionPerformed(ActionEvent actions) {
		
		if(actions.getSource() == button1) {
			
			try {
				
				Desktop.getDesktop().open(new java.io.File("library/help.txt"));
			} catch (IOException e) {
		
				e.printStackTrace();
			}
		}
	}
}
