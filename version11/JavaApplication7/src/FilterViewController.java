
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
    FilterView filterview;
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
 public String [] createNameBase(int isCheck,int countOfFilters){
  if (isCheck==0)countOfFilters=2*countOfFilters;
      String [] nameBase= new String [countOfFilters];
      nameBase=filterview.createCoutingBase(countOfFilters);
     return nameBase;   
 }
  public double [] createThickness(int isCheck,int countOfFilters){
  if (isCheck==0)countOfFilters=2*countOfFilters;
      double [] thickness= new double [countOfFilters];
      thickness=filterview.createBaseThickness(countOfFilters);
     return thickness;   
 }
   public double [] createExpValue(int isCheck,int countOfFilters){
      double [] expValue= new double [countOfFilters];
      expValue=filterview.createExpValue(countOfFilters);
     return expValue;   
 }
}
