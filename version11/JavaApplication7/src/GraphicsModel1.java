
import callibration_model.Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1
 */
public class GraphicsModel1 {
  double [][][] Y;
  Controller controller;

    public GraphicsModel1(Controller controller) {
        this.controller = controller;
    }
    
  public double [][] createCurrent(int countOfPoints, int numberOfFilter){
   double [][] current=new double[countOfPoints][2]; 
   //находим точки разбиения
    double  X[][]=controller.getSource().Data_reading(controller.getSource().Name_of_file, countOfPoints);
       for (int i=0; i<countOfPoints; i++){
            current [i][0]=X[i][0];
       }
     //детектор
       int n_d1=controller.getDetector().getBase().SizeOfFile(controller.getDetector().getBase().Name_of_file);
       double [][]X_d1=controller.getDetector().getBase().Data_reading(controller.getDetector().getBase().Name_of_file, n_d1);
       double [][]A_d1=controller.getDetector().getBase().Material_interpolation(X_d1, n_d1);
       int n_d2=controller.getDetector().getContact().SizeOfFile(controller.getDetector().getContact().Name_of_file);
       double [][]X_d2=controller.getDetector().getContact().Data_reading(controller.getDetector().getContact().Name_of_file, n_d2);
       double [][]A_d2=controller.getDetector().getContact().Material_interpolation(X_d2, n_d2);
    // параметры калибровки
       double [] realParams=new double [4];
       realParams=controller.getDetector().getRealParam();
       for (int i=0; i<countOfPoints-1;i++){
        double Sd;
        Sd=controller.getExperiment().get(numberOfFilter).getFunction(X[i][0]);
        double S;
        S=controller.getDetector().getIdealDiod()*realParams[0];
        S=S*Math.pow(controller.getDetector().getBase().Point_z(X_d1, A_d1, n_d1, X[i][0]), realParams[1]);
        S=S*Math.pow(controller.getDetector().getContact().Point_z(X_d2, A_d2, n_d2, X[i][0]), realParams[2]);
        S=S*(1-Math.pow(controller.getDetector().getBase().Point_z(X_d1, A_d1, n_d1, X[i][0]), realParams[3]));
      current[i][1]=Sd*S*X[i][1]*X[i][0]*Math.abs(X[i+1][0]-X[i][0]);  
       }
          
   return current;
  } 
    public double[][][] getY() {
    int countOfFilters=controller.getCountOfFilters();
    int countOfPoints = controller.getSource().SizeOfFile(controller.getSource().Name_of_file);
      Y= new double [countOfFilters][countOfPoints][2]; 
       for (int i=0; i<countOfFilters; i++){
            Y[i]=createCurrent(countOfPoints, i);
        }
    return Y;
    }

   
  
}
