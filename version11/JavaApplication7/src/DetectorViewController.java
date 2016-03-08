
import java.io.File;
import javax.swing.WindowConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1
 */
public class DetectorViewController {
  DetectorFrame detectorView;  
  
    public DetectorFrame getDetectorView() {
        return detectorView;
    }

    public void setDetectorView(File currentDirectory) {
       detectorView=new DetectorFrame(currentDirectory);
       detectorView.setVisible(true);
       detectorView.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
  public int getDetectorType(){
      int detectorType=detectorView.getDetectorType();
      return detectorType;
  }
  public String getBaseName(){
      String baseName=detectorView.getBaseName();
      return baseName;
  }
  public String getContactName(){
      String contactName=detectorView.getContactName();
      return contactName;
  }
  public void setXmlElement(String type, String baseName, String contactName,File currentDirectory){
     // detectorView=new DetectorFrame(currentDirectory);
      detectorView.setXmlElement(type, baseName, contactName);
   }
}
