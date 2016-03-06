
import callibration_model.Controller;
import callibration_model.FilterWithCoating;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1
 */
public class SubReportBeanWithoutCoating {
  private String fNamebase; 
    private String thickbase; 
    private String expvalue;
    private Integer countOfFilters;
    Controller controller;

    public SubReportBeanWithoutCoating(Controller controller) {
        this.controller = controller;
    }
    
     public String getfNamebase() {    
        return fNamebase; 
    } 
 
    public void setfNamebase(int i) { 
     fNamebase=controller.getExperiment().get(i).getMaterialOfBase().Name_of_file;
    } 
    public String getthickbase() { 
        return thickbase; 
    } 
 
    public void setthickbase(int i) { 
      thickbase=Double.toString(controller.getExperiment().get(i).getBaseThickness());  
    } 
     
    public String getExpvalue() {   
        return expvalue; 
    } 
 
    public void setExpvalue(int i) { 
      expvalue=Double.toString(controller.getExperiment().getExperimentalValue(i));
         
    } 
     public Integer getcountOfFilters() { 
        return countOfFilters; 
    }
     public void setcountOfFilters(Integer countOfFilters) { 
      this.countOfFilters=countOfFilters;    
    }   
}
