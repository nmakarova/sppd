
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
public class DiamondButton {
 
    public void DiamondButton(JPanel jPanel){
        
   JButton diamondButton= new JButton("Алмазный детектор"); 
   diamondButton.setSize(200, 50);
   jPanel.add(diamondButton);
   diamondButton.setLocation(20, 20);
   jPanel.validate();
   jPanel.setVisible(true);
 }   
}
