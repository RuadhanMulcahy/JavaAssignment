package assignment1;

import java.awt.*;

import javax.swing.*;

import org.jfree.ui.RefineryUtilities;

public class Display {
	
	JFrame window = new JFrame();
	
	public Display() {
		
		Graph demo = new Graph("chart" );  
	    demo.setSize(400, 300 );    

		SidePanel panel = new SidePanel();
		ToolBar ToolBar = new ToolBar();
		JPanel container = new JPanel();
		
		container.setLayout(new GridLayout(1,2,0,300));
		
		container.add(panel.sideMenu(), BorderLayout.EAST);
		container.add(demo.createDemoPanel(), BorderLayout.WEST);
		
		
		window.setSize(1000, 800);
		window.setResizable(false);
		window.add(ToolBar.topToolBar(), BorderLayout.NORTH);
		window.add(container, BorderLayout.CENTER);
		window.setVisible(true);
		

	}
}