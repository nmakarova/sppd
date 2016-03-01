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

    public DetectorNew(Material base, Material contact, int detectorType) {
        this.base = base;
        this.contact = contact;
      if (detectorType==0){
          idealDiod=SILICIUM_DETECTOR;
      }
      else idealDiod=DIAMOND_DETECTOR;
    }
  
}
