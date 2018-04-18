package assignment1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;

import javax.swing.*;

/**This toolbar was originally meant to have more buttons implemented however
 * due to time i was'nt able to add them. At the moment the toolbar only
 * has one button that opens up a help text file in whatever the default program
 * is for a text file on the computer.
 * @author Ruadhan
 *
 */

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
	
	//Action listenr for button1
	public void actionPerformed(ActionEvent actions) {
		
		if(actions.getSource() == button1) {
			
			try {
				
				//opens up text file in text editor
				Desktop.getDesktop().open(new java.io.File("library/help.txt"));
			} catch (IOException e) {
		
				e.printStackTrace();
			}
		}
	}
}
