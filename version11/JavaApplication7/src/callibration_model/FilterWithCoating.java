/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callibration_model;

/**
 *
 * @author 1
 */
public class FilterWithCoating  extends FilterWithoutCoating implements Filter{
 Material coatingLayer;
 double coatingThickness;
int n_f1;
double [][] X_f1;
double [][]A_f1;
int n_f2;
double [][] X_f2;
double [][]A_f2;

    public Material getCoatingLayer() {
        return coatingLayer;
    }

    public double getCoatingThickness() {
        return coatingThickness;
    }

    public FilterWithCoating(Material coatingBase, double baseThickness,Material coatingLayer, double coatingThickness, double experimentalValue) {
        super(coatingBase, baseThickness, experimentalValue);
        this.coatingLayer = coatingLayer;
        this.coatingThickness = coatingThickness;
        //первый фильтр
     n_f1=coatingBase.SizeOfFile(coatingBase.Name_of_file);
     X_f1=coatingBase.Data_reading(coatingBase.Name_of_file, n_f1);
     A_f1=coatingBase.Material_interpolation(X_f1, n_f1);
       //второй фильтр
     n_f2=coatingLayer.SizeOfFile(coatingLayer.Name_of_file);
     X_f2=coatingLayer.Data_reading(coatingLayer.Name_of_file, n_f2);
     A_f2=coatingLayer.Material_interpolation(X_f2, n_f2);  
    }
    
 @Override
  public double getFunction(double x) {
       double Sd;
        Sd=Math.pow(coatingBase.Point_z(X_f1, A_f1, n_f1, x), baseThickness);
        Sd=Sd*Math.pow(coatingLayer.Point_z(X_f2, A_f2, n_f2, x), coatingThickness);
        return Sd;
  }
}
