
import callibration_model.DataFromFile;
import callibration_model.DetectorNew;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1
 */
public class DataBean {
    private String k; 
    private String hc; 
    private String hd; 
    private String hs; 
    private List<SubReportBean> filtersBeanList;
    private String sRDataSource; 
    public String getk() { 
       
        return k; 
    } 
 
    public void setk(DetectorNew detector) { 
      double [] realparam=detector.getRealParam();
      k=Double.toString(realparam[0]);
    } 
 
    public String gethc() { 
       
        return hc; 
    } 
    public void sethc(DetectorNew detector) { 
        double [] realparam=detector.getRealParam();
      hc=Double.toString(realparam[2]);
    } 
    
  public String gethd() { 
       
        return hd; 
    } 
 
    public void sethd(DetectorNew detector) { 
       double [] realparam=detector.getRealParam();
      hd=Double.toString(realparam[1]);
    } 
    
     public String geths() { 
        
        return hs; 
    } 
 
    public void seths(DetectorNew detector) { 
       double [] realparam=detector.getRealParam();
      hs=Double.toString(realparam[3]);
    } 
   public List<SubReportBean> getFiltersBeanList() {
      return filtersBeanList;
   }

   public void setFiltersBeanList(List<SubReportBean> filtersBeanList) {
      this.filtersBeanList = filtersBeanList;
   } 
    public String getsRDataSource() { 
       
        return sRDataSource; 
    } 
 
    public void setsRDataSource(DataFromFile source) { 
      sRDataSource=source.Name_of_file;
    } 

    }
