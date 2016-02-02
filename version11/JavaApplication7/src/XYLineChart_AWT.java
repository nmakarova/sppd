/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1
 */
import java.io.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.BasicStroke;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.axis.LogAxis;

public class XYLineChart_AWT extends JFrame{
    public XYLineChart_AWT( String applicationTitle, String chartTitle, int n, int t, double [][][]Y , JPanel jPanel6, double x_max,double x_min, double y_max, double y_min, boolean x_log, boolean y_log)throws Exception
{
    
super(applicationTitle);
//this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
double [][][]Y2=new double [n][t][2];
Y2=Y;
JFreeChart xylineChart = ChartFactory.createXYLineChart(
chartTitle ,
"Число фотонов" ,
"Поглощение" ,
createDataset(n,t,Y2) ,
PlotOrientation.VERTICAL ,
true , true , false);
ChartPanel chartPanel = new ChartPanel( xylineChart );
chartPanel.setPreferredSize( new java.awt.Dimension( 821 , 378 ) );
final XYPlot plot = xylineChart.getXYPlot( );
if (x_log==true){
LogAxis xAxis = new LogAxis("X");
plot.setDomainAxis(xAxis);}
if (y_log==true){
LogAxis yAxis = new LogAxis("Y");
plot.setRangeAxis(yAxis);}
if (x_max!=0||x_min!=0) {x_scale (x_min,x_max, plot);}
if (y_max!=0||y_min!=0) {y_scale (y_min,y_max, plot);}
XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
renderer.setSeriesPaint( 0 , Color.RED );
renderer.setSeriesPaint( 1 , Color.GREEN );
renderer.setSeriesPaint( 2 , Color.YELLOW );
renderer.setSeriesStroke( 0 , new BasicStroke( 1.0f ) );
renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
renderer.setSeriesStroke( 2 , new BasicStroke( 2.0f ) );
plot.setRenderer( renderer );
setContentPane( chartPanel );
jPanel6.add(chartPanel);
jPanel6.validate();
int width = 640; /* Width of the image */
int height = 480; /* Height of the image */
File XYChart = new File( "XYLineChart.jpeg" );
ChartUtilities.saveChartAsJPEG(XYChart, xylineChart, width, height);
}
private void x_scale (double min, double max, XYPlot plot){
  plot.getDomainAxis().setRange(min, max); 
} 
private void y_scale (double min, double max, XYPlot plot){
plot.getRangeAxis().setRange(min, max);  
}
private XYDataset createDataset(int n, int t,double [][][]Y )
{
  double [][][]Y1=new double [n][t][2];  
    Y1=Y;
    final XYSeriesCollection dataset = new XYSeriesCollection( );
 for (int j=0; j<n;j++){   
final XYSeries filter = new XYSeries( "Filter"+Integer.toString(j+1) );
for (int i=0; i<t; i++){
    filter.add(Y1[j][i][0], Y1[j][i][1]);
}
dataset.addSeries( filter );
 }

return dataset;
}

}