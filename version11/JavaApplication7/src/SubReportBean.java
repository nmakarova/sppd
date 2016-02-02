/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1
 */
public class SubReportBean {
    private String fNamebase; 
    private String thickbase; 
    private String fNamespray;
    private String thickspray;  
    private String expvalue;
    private Integer countOfFilters;
    
     public String getfNamebase() {    
        return fNamebase; 
    } 
 
    public void setfNamebase(int i) { 
      fNamebase=NewJFrame.field1[i].getText(); 
    } 
    public String getthickbase() { 
        return thickbase; 
    } 
 
    public void setthickbase(int i) { 
      thickbase=NewJFrame.field2[i].getText();  
    } 
     public String getfNamespray() {   
        return fNamespray; 
    } 
 
    public void setfNamespray(int i, int Cof) { 
      fNamespray=NewJFrame.field1[i+Cof].getText();
         
    } 
     public String getthickspray() {   
        return thickspray; 
    } 
 
    public void setthickspray(int i, int Cof) { 
      thickspray=NewJFrame.field2[i+Cof].getText();  
    } 
    public String getExpvalue() {   
        return expvalue; 
    } 
 
    public void setExpvalue(int i) { 
      expvalue=NewJFrame.field3[i].getText();
         
    } 
     public Integer getcountOfFilters() { 
        return countOfFilters; 
    }
     public void setcountOfFilters(Integer countOfFilters) { 
      this.countOfFilters=countOfFilters;    
    } 
}
