/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;

import java.awt.event.*;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.*;
/**
 *
 * @author 1
 */
public class GetNameOfFile implements ActionListener{
    private JTextField tf;//поле для вывода имени файла
    private JButton button;
    private File file;
   // private String name_of_file; // переменная для хранения абсолютного пути к файлу
    GetNameOfFile (JTextField tf, JButton button, File file) {
        this.tf=tf;
        this.button=button;
        this.file=file;
       // this.name_of_file=name_of_file;
    }
   // @Override
    public void actionPerformed(java.awt.event.ActionEvent evt){
       JFileChooser fileopen = new JFileChooser();
        fileopen.setCurrentDirectory(file);
//int ret = fileopen.showDialog(null, "Открыть файл");                
int returnVal = fileopen.showOpenDialog(button);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = fileopen.getSelectedFile();
      String name_of_file = file.getAbsolutePath();
          // What to do with the file, e.g. display it in a TextArea
          tf.setText(name_of_file);
    }
}
}
