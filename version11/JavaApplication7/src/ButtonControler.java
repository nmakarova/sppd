
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
public class ButtonControler {
   public void createButton(boolean isCheck, JPanel jPanel){
     // jPanel.removeAll();
     //  jPanel.revalidate();
      
    if (isCheck==true){ 
     DiamondButton diamondButton= new DiamondButton();
     diamondButton.DiamondButton(jPanel); 
   } 
    else {
     CilisiumButton cilisiumButton= new CilisiumButton();
     cilisiumButton.CilisiumButton(jPanel);
    }
}
}
