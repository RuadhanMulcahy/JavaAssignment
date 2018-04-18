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



public class Graph extends ApplicationFrame {
   
	static List<String> countTitle = new ArrayList<String>();
	static List<String> countResult = new ArrayList<String>();
	static List<Integer> intCountResult = new ArrayList<Integer>();
	
	static String title;
	
   public Graph( List<String> countTitle, List<String> countResult, String title ) {
      super( title ); 
      setContentPane(createDemoPanel( ));
      
      this.title = title;
      
      this.countTitle = countTitle;
      this.countResult = countResult;
   }
   
   
   private static PieDataset createDataset( ) {
	  
	  int i;
	   
	  DefaultPieDataset dataset = new DefaultPieDataset( );
	   
	  for(String x: countResult) intCountResult.add(Integer.valueOf(x));
	  
	  for(i=0; i < countTitle.size(); i++) {
		  
		  dataset.setValue(countTitle.get(i) + "[" + i + "]", intCountResult.get(i));
	  }
	 
	  return dataset;         
   }
   
   private static CategoryDataset createDataset1( ) {
	      final String x_Axis = "";        
	         
	      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  
	      
	      for(String x: countResult) intCountResult.add(Integer.valueOf(x));
		  
	      int i;
	      
		  for(i=0; i < countTitle.size(); i++) {
			 
			  dataset.addValue(intCountResult.get(i), x_Axis, countTitle.get(i) + "[" + i + "]");
		  }

	      return dataset; 
	   }
   
   private static JFreeChart createChart(PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         title,   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);

      return chart;
   }
   
   private static JFreeChart createChart1(CategoryDataset dataset1) {
	   
	   JFreeChart barChart = ChartFactory.createBarChart(
		         title,           
		         "",            
		         "",            
		         createDataset1(),          
		         PlotOrientation.VERTICAL,           
		         false, true, false);
	   
	   return barChart;
   }
   
   
   public JPanel createDemoPanel( ) {
      JFreeChart chart = createChart(createDataset( ) );  
      JPanel graphPanel = new JPanel();
      graphPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
      
      JPanel test = new ChartPanel(chart);  
      
      graphPanel.add(test);
      
      return graphPanel;
   }
   
   public JPanel creatBarChart() {
	   
	  JFreeChart chart = createChart1(createDataset1( ) );  
      JPanel graphPanel = new JPanel();
      graphPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
      
      JPanel test = new ChartPanel(chart);  
      
      graphPanel.add(test);
      
      return graphPanel;
   }
   
}