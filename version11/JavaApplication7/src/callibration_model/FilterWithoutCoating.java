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
public class FilterWithoutCoating implements Filter{
 Material coatingBase;
 double baseThickness;
 double experimentalValue;
 int n_f1;
 double [][] X_f1;
 double [][] A_f1;

    public FilterWithoutCoating(Material coatingBase, double baseThickness, double experimentalValue) {
        this.coatingBase = coatingBase;
        this.baseThickness = baseThickness;
        this.experimentalValue = experimentalValue;
        //первый фильтр
     n_f1=coatingBase.SizeOfFile(coatingBase.Name_of_file);
     X_f1=coatingBase.Data_reading(coatingBase.Name_of_file, n_f1);
     A_f1=coatingBase.Material_interpolation(X_f1, n_f1);
    }

    @Override
    public Material getMaterialOfBase() {
        return coatingBase;
    }

    @Override
    public double getBaseThickness() {
        return baseThickness;
    }

    @Override
    public double getFunction(double x) {
     double Sd;
        Sd=Math.pow(coatingBase.Point_z(X_f1, A_f1, n_f1, x), baseThickness);
    return Sd;
    }

    @Override
    public double getExperimentalValue() {
       return experimentalValue;
    }
    

   
 
}
