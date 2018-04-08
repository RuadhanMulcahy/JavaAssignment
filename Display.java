package assignment1;

import java.awt.*;

import javax.swing.*;

import org.jfree.ui.RefineryUtilities;

public class Display {
	
	JFrame window = new JFrame();
	
	public Display() {
		
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
		JPanel container = new JPanel();
		SidePanel panel = new SidePanel(container, window);
		ToolBar ToolBar = new ToolBar();;
		
		container.setLayout(new GridLayout(1,1));
		
		window.add(panel.sideMenu(), BorderLayout.WEST);
		
		window.setSize(800, 600);
		window.setResizable(false);
		window.add(ToolBar.topToolBar(), BorderLayout.NORTH);
		window.add(container, BorderLayout.EAST);
		window.setVisible(true);
	}
}