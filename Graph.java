package assignment1;

import java.awt.FlowLayout;
import java.util.Collection;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
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
	
   public Graph( List<String> countTitle, List<String> countResult, String title ) {
      super( title ); 
      setContentPane(createDemoPanel( ));
      
      this.countTitle = countTitle;
      this.countResult = countResult;
   }
   
   private static PieDataset createDataset( ) {
	  
	  int i;
	   
	  DefaultPieDataset dataset = new DefaultPieDataset( );
	  
	  System.out.println("Size" + countTitle.size());
	   
	  for(String x: countResult) intCountResult.add(Integer.valueOf(x));
	  
	  for(i=0; i < countTitle.size(); i++) {
		  
		  System.out.println(countTitle.get(i));
		  dataset.setValue(countTitle.get(i) + "[" + i + "]", intCountResult.get(i));
	  }
	 
	  return dataset;         
   }
   
   private static JFreeChart createChart( PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Mobile Sales",   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);

      return chart;
   }
   
   public JPanel createDemoPanel( ) {
      JFreeChart chart = createChart(createDataset( ) );  
      JPanel graphPanel = new JPanel();
      graphPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
      
      JPanel test = new ChartPanel(chart);  
      
      graphPanel.add(test);
      
      return graphPanel;
   }
   
}