/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callibration_model;

import java.util.ArrayList;


/**
 *
 * @author 1
 */
public class Controller {
int coating;
DataFromFile source;
DetectorNew detector;
int countOfFilters;
Experiment experiment;
double [] lowerBorder;
double [] upperBorder;
int [] ifBorder;
int countOfBorders;
double [] paspParam;
    public Controller() {
    }

    public double[] getLowerBorder() {
        return lowerBorder;
    }

    public void setLowerBorder(double[] lowerBorder) {
        this.lowerBorder = lowerBorder;
    }

    public double[] getUpperBorder() {
        return upperBorder;
    }

    public void setUpperBorder(double[] upperBorder) {
        this.upperBorder = upperBorder;
    }

    public int[] getIfBorder() {
        return ifBorder;
    }

    public void setIfBorder(int[] ifBorder) {
        this.ifBorder = ifBorder;
    }

    public int getCountOfBorders() {
        return countOfBorders;
    }

    public void setCountOfBorders(int countOfBorders) {
        this.countOfBorders = countOfBorders;
    }

    public int getCountOfFilters() {
        return countOfFilters;
    }

    public void setCountOfFilters(int countOfFilters) {
        this.countOfFilters = countOfFilters;
    }

    public int isCoating() {
        return coating;
    }

    public void setCoating(int coating) {
        this.coating = coating;
    }

    public double[] getPaspParam() {
        return paspParam;
    }
 public DataFromFile getSource() {
        return source;
    }
 public DetectorNew getDetector() {
        return detector;
    }
 public Experiment getExperiment(){
     return experiment;
 }
    public void setPaspParam(double[] paspParam) {
        this.paspParam = paspParam;
        detector.setPaspParam(paspParam);
    }
    
    public void createSource(String file){
       source=new DataFromFile(file);  
    }
    public void createDetector(String nameBase, String nameContact, int detectorType){
      detector=new DetectorNew(new Material(nameBase), new Material(nameContact), detectorType);  
    }
    public void createCollection(int x, int countOfFilters, String[] NameOfLayer, double [] thickness, double [] expValue){
       
       ArrayList <Filter> filters=new ArrayList();
        if (x==0){
           for (int i=0; i<countOfFilters; i++){
           FilterWithCoating filter=new FilterWithCoating(new Material(NameOfLayer[i]), thickness[i], new Material(NameOfLayer[i+countOfFilters]), thickness[i+countOfFilters], expValue[i]); 
           filters.add(filter);
//experiment.experiment.add(filter);
           }
    }
        else{
         for (int i=0; i<countOfFilters; i++){
             FilterWithoutCoating filter=new FilterWithoutCoating(new Material(NameOfLayer[i]), thickness[i], expValue[i]);
             //experiment.experiment.add(filter);
             filters.add(filter);
         }  
         
        }
       experiment=new Experiment(filters);
    }
    
  public double[] action(){
 Callibration callibration = new Callibration(source, detector, experiment, countOfFilters);
 callibration.setLowerBorder(lowerBorder);
 callibration.setUpperBorder(upperBorder);
 callibration.setIfBorder(ifBorder);
 callibration.setCountOfBorders(countOfBorders);
 double [] realParams=callibration.callibrate();
     
  return realParams;
  }
  
}
