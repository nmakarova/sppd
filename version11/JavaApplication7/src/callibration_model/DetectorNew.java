package callibration_model;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1
 */
public class DetectorNew {
  Material base;
  Material contact;
  double idealDiod;
  final double SILICIUM_DETECTOR=0.273;
  final double DIAMOND_DETECTOR=0.074;
  double [] paspParam;
  double [] realParam;
    public DetectorNew(Material base, Material contact, int detectorType) {
        this.base = base;
        this.contact = contact;
      if (detectorType==0){
          idealDiod=SILICIUM_DETECTOR;
      }
      else idealDiod=DIAMOND_DETECTOR;
    }

    public double getIdealDiod() {
        return idealDiod;
    }

    public Material getContact() {
        return contact;
    }

    public Material getBase() {
        return base;
    }

    public double[] getPaspParam() {
        return paspParam;
    }

    public void setPaspParam(double[] paspParam) {
        this.paspParam = paspParam;
    }

    public double[] getRealParam() {
        return realParam;
    }

    public void setRealParam(double[] realParam) {
        this.realParam = realParam;
    }
  
}
