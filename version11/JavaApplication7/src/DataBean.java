
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
    private String kPasp; 
    private String hcPasp; 
    private String hdPasp; 
    private String hsPasp; 
    private String lk; 
    private String lhc; 
    private String lhd; 
    private String lhs; 
    private String uk; 
    private String uhc; 
    private String uhd; 
    private String uhs; 
    private String detectorType; 
    private String detectorBaseSource; 
    private String detectorContactSource; 
    private List<SubReportBean> filtersBeanList;
    private List<SubReportBeanWithoutCoating> filtersBeanList1;
    private String sRDataSource; 

    public String getDetectorType() {
        return detectorType;
    }

    public void setdetectorType(DetectorNew detector) {
       int d=detector.getDetectorType();
       if (d==0){
       detectorType="Silicium" ;   
       }
       else{
           detectorType="Diamond";
       }
    }

    public String getDetectorBaseSource() {
        return detectorBaseSource;
    }

    public void setdetectorBaseSource(DetectorNew detector) {
      detectorBaseSource=detector.getBase().Name_of_file;
    }

    public String getDetectorContactSource() {
        return detectorContactSource;
    }

    public void setdetectorContactSource(DetectorNew detector) {
        detectorContactSource=detector.getContact().Name_of_file;
    }

    public String getLk() {
        return lk;
    }

    public void setlk(String lk, int i) {
        if (i==1){
        lk=lk.concat("<=");}
        else{
            lk="";
        }
        this.lk = lk;
    }

    public String getLhc() {
        return lhc;
    }

    public void setlhc(String lhc,int i) {
       if (i==1){
        lhc=lhc.concat("<=");
       }
        else{
            lhc="";
        }
        this.lhc = lhc;
    }

    public String getLhd() {
        return lhd;
    }

    public void setlhd(String lhd,int i) {
        if (i==1){
        lhd=lhd.concat("<=");
       }
        else{
            lhd="";
        }
        
        this.lhd = lhd;
    }

    public String getLhs() {
        return lhs;
    }

    public void setlhs(String lhs,int i) {
       if (i==1){
        lhs=lhs.concat("<=");
       }
        else{
            lhs="";
        }
       
        this.lhs = lhs;
    }

    public String getUk() {
        return uk;
    }

    public void setuk(String uk,int i) {
       if (i==1){
         uk="<="+uk;
       }
        else{
            uk="";
        }
       
        this.uk = uk;
    }

    public String getUhc() {
        return uhc;
    }

    public void setuhc(String uhc,int i) {
        if (i==1){
         uhc="<="+uhc;
       }
        else{
            uhc="";
        }
        
        this.uhc = uhc;
    }

    public String getUhd() {
        return uhd;
    }

    public void setuhd(String uhd,int i) {
        if (i==1){
          uhd="<="+uhd;
       }
        else{
            uhd="";
        }
       
        this.uhd = uhd;
    }

    public String getUhs() {
        return uhs;
    }

    public void setuhs(String uhs,int i) {
       if (i==1){
           uhs="<="+uhs;
       }
        else{
            uhs="";
        }
       
        this.uhs = uhs;
    }

    public String getkPasp() {
        return kPasp;
    }

    public void setkPasp(DetectorNew detector) {
      double [] paspparam=detector.getRealParam();
      kPasp=Double.toString(paspparam[0]);
    }

    public String getHcPasp() {
        return hcPasp;
    }

    public void sethcPasp(DetectorNew detector) {
      double [] paspparam=detector.getRealParam();
      hcPasp=Double.toString(paspparam[2]);
    }

    public String getHdPasp() {
        return hdPasp;
    }

    public void sethdPasp(DetectorNew detector) {
      double [] paspparam=detector.getRealParam();
      hdPasp=Double.toString(paspparam[1]);
    }

    public String getHsPasp() {
        return hsPasp;
    }

    public void sethsPasp(DetectorNew detector) {
      double [] paspparam=detector.getRealParam();
      hsPasp=Double.toString(paspparam[3]);
    }
    
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
   public List<SubReportBeanWithoutCoating> getFiltersBeanListWithoutCoating() {
      return filtersBeanList1;
   }

   public void setFiltersBeanListWithoutCoating(List<SubReportBeanWithoutCoating> filtersBeanList1) {
      this.filtersBeanList1 = filtersBeanList1;
   } 
    public String getsRDataSource() { 
       
        return sRDataSource; 
    } 
 
    public void setsRDataSource(DataFromFile source) { 
      sRDataSource=source.Name_of_file;
    } 

    }
