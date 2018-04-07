package assignment1;

import java.awt.*;

import javax.swing.*;

import org.jfree.ui.RefineryUtilities;

public class Display {
	
	JFrame window = new JFrame();
	
	public Display() {
		
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		Graph demo = new Graph("chart" );  
	    demo.setSize(400, 300 );    

		SidePanel panel = new SidePanel();
		ToolBar ToolBar = new ToolBar();
		JPanel container = new JPanel();
		
		container.setLayout(new GridLayout(1,1));
		
		window.add(panel.sideMenu(), BorderLayout.WEST);
		container.add(demo.createDemoPanel());
		
		window.setSize(800, 600);
		window.setResizable(false);
		window.add(ToolBar.topToolBar(), BorderLayout.NORTH);
		window.add(container, BorderLayout.EAST);
		window.setVisible(true);
	}
}