
import java.io.File;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1
 */
public class FilterViewController {
  public void createFilerView(int isCheck,int countOfFilters, JPanel jPanel, File file){
     if (isCheck==0){ 
     SiliciumView siliciumView= new SiliciumView(); 
     siliciumView.createView(countOfFilters, jPanel, file);
     }
     else{
      DiamondView diamondView= new DiamondView(); 
     diamondView.createView(countOfFilters, jPanel, file);
     }
  }
 
}
