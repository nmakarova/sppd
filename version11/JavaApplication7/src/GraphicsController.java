
import callibration_model.Controller;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1
 */
public class GraphicsController {
  Controller controller;
  double xMin, xMax, yMin, yMax;
  boolean xLog, yLog;
  JPanel jPanel;

    public GraphicsController(Controller controller, double xMin, double xMax, double yMin, double yMax, boolean xLog, boolean yLog, JPanel jPanel) {
        this.controller = controller;
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
        this.xLog = xLog;
        this.yLog = yLog;
        this.jPanel = jPanel;
    }
  public  double [][][] createGraphicsModel(){
    double [][][] Y;
    GraphicsModel1 graphicsModel1=new GraphicsModel1(controller);
    Y=graphicsModel1.getY();
    return Y;
  }
  public void createGraphics(){
    int countOfFilters=controller.getCountOfFilters();
    int countOfPoints = controller.getSource().SizeOfFile(controller.getSource().Name_of_file);
    double [][][] Y=createGraphicsModel();
    try{
    XYLineChart_AWT chart = new XYLineChart_AWT("Графики", "Поглощение", countOfFilters, countOfPoints,Y, jPanel,xMax, xMin, yMax, yMin, xLog, yLog);
    chart.pack( );  
    chart.addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
         public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            if (JOptionPane.showConfirmDialog(chart,
            "Are you sure to close this window?", "Really Closing?",
             JOptionPane.YES_NO_OPTION,
             JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
             System.out.println("actionPerformed()");
                }
            }
        });
        }catch(Exception e){};
  }
}
