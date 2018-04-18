package assignment1;

import java.awt.FlowLayout;
import java.util.Collection;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import java.util.List;
import java.util.ArrayList;

/**This class uses an external library called JFreeChart which can be 
 * found here: http://www.jfree.org/jfreechart/download/
 * @author Ruadhan
 */

public class Graph extends ApplicationFrame {
   
	//lists that the graphs will use for data
	static List<String> countTitle = new ArrayList<String>();
	static List<String> countResult = new ArrayList<String>();
	static List<Integer> intCountResult = new ArrayList<Integer>();
	
	//title of charts
	static String title;
   
	//constructor takes in lists and a title string
   public Graph( List<String> countTitle, List<String> countResult, String title ) {
      super( title ); 
      setContentPane(createDemoPanel( ));
      
      this.title = title;
      
      this.countTitle = countTitle;
      this.countResult = countResult;
   }
   
   //this method prepares data for pie chart format.
   private static PieDataset createDataset( ) {
	  
	  int i;
	   
	  DefaultPieDataset dataset = new DefaultPieDataset( );
	   
	  //this converts string list to an integer list
	  for(String x: countResult) intCountResult.add(Integer.valueOf(x));
	  
	  //this fills the dataset with the values from the two lists
	  for(i=0; i < countTitle.size(); i++) {
		  
		  dataset.setValue(countTitle.get(i) + "[" + i + "]", intCountResult.get(i));
	  }
	 
	  //returns the dataset
	  return dataset;         
   }
   
   //this method prepares data for bar chart format.
   private static CategoryDataset createDataset1( ) {
	      final String x_Axis = "";        
	      
	      
	      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  
	      
	      for(String x: countResult) intCountResult.add(Integer.valueOf(x));
		  
	      int i;
	      
	    //this fills the dataset with the values from the two lists
		  for(i=0; i < countTitle.size(); i++) {
			 
			  dataset.addValue(intCountResult.get(i), x_Axis, countTitle.get(i) + "[" + i + "]");
		  }

	      return dataset; 
	   }
   
   //this method is in control of how the pie chart is going to look
   private static JFreeChart createChart(PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         title,   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);
      
      //returns pie chart
      return chart;
   }
   
   //this method is in control of how the bar chart is going to work
   private static JFreeChart createChart1(CategoryDataset dataset1) {
	   
	   JFreeChart barChart = ChartFactory.createBarChart(
		         title,           
		         "",            
		         "",            
		         createDataset1(),          
		         PlotOrientation.VERTICAL,           
		         false, true, false);
	   
	   //returns bar chart
	   return barChart;
   }
   
   //this method creates a pieChart
   public JPanel createDemoPanel( ) {
      JFreeChart chart = createChart(createDataset( ) );  
      JPanel graphPanel = new JPanel();
      graphPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
      
      JPanel test = new ChartPanel(chart);  
      
      //adds the panel containing graph to the JPanel, this allows for it to be easily implemented into the GUI
      graphPanel.add(test);
      
      return graphPanel;
   }
   
   //this method creates a bar chart
   public JPanel creatBarChart() {
	   
	  JFreeChart chart = createChart1(createDataset1( ) );  
      JPanel graphPanel = new JPanel();
      graphPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
      
      JPanel test = new ChartPanel(chart);  
      
      //adds the panel containing graph to the JPanel, this allows for it to be easily implemented into the GUI
      graphPanel.add(test);
      
      return graphPanel;
   }
   
}