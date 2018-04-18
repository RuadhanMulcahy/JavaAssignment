package assignment1;

import java.util.ArrayList;
import java.util.List;

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

public class BarChart extends ApplicationFrame {
	
	static List<String> countTitle = new ArrayList<String>();
	static List<String> countResult = new ArrayList<String>();
	static List<Integer> intCountResult = new ArrayList<Integer>();
   
   public BarChart(List<String> countTitle, List<String> countResult, String applicationTitle , String chartTitle) {
	   
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "",            
         "",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
      
      this.countTitle = countTitle;
      this.countResult = countResult;
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
   }
   
   private CategoryDataset createDataset( ) {
      final String x_Axis = "";        
         
      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  
      
      for(String x: countResult) intCountResult.add(Integer.valueOf(x));
	  
      int i;
      
	  for(i=0; i < countTitle.size(); i++) {
		 
		  dataset.addValue(intCountResult.get(i), x_Axis, countTitle.get(i) + "[" + i + "]");
	  }

      return dataset; 
   }

}
