
import javax.swing.JButton;
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
public class CilisiumButton {
   public void CilisiumButton(JPanel jPanel){
   JButton cilisiumButton= new JButton("Кремниевый детектор"); 
   cilisiumButton.setSize(200, 50);
   jPanel.add(cilisiumButton);
   cilisiumButton.setLocation(20, 20);
   jPanel.validate();
   jPanel.setVisible(true);
 }     
}
