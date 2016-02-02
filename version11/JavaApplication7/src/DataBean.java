
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
 
    public void setk() { 
      k=NewJFrame.jTextField6.getText();
        // this.k = k; 
    } 
 
    public String gethc() { 
       
        return hc; 
    } 
    public void sethc() { 
        hc=NewJFrame.jTextField8.getText(); 
    } 
    
  public String gethd() { 
       
        return hd; 
    } 
 
    public void sethd() { 
        hd=NewJFrame.jTextField7.getText();  
    } 
    
     public String geths() { 
        
        return hs; 
    } 
 
    public void seths() { 
        hs=NewJFrame.jTextField9.getText(); 
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
 
    public void setsRDataSource() { 
      sRDataSource=NewJFrame.jTextField1.getText();
    } 
}
