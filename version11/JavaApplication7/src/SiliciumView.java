
import java.awt.Color;
import java.awt.Font;
import java.io.*;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1
 */
public class SiliciumView {
    JTextField [] field1;
    JTextField [] field2;
    JTextField [] field3;
            
   public void createView(int countOfFilers, JPanel viewPanel, File file){

       JPanel [] jPan_filter=new JPanel[countOfFilers];
        
        //массив надписей "1. Подложка"
        JLabel [] label1 = new JLabel[countOfFilers];
        //массив текстовых полей для вывода имени файла
      field1 = new JTextField [2*countOfFilers];  
       JButton [] button1 = new JButton [2*countOfFilers];
        // массив надписей "толщина"
        JLabel [] label2 = new JLabel[2*countOfFilers];
        // массив текстовых полей для ввода толщины
       field2 = new JTextField [2*countOfFilers];
        // массив надписей "мкм"
        JLabel [] label3 = new JLabel[2*countOfFilers];
        //массив надписей "2. Напыление"
        JLabel [] label4 = new JLabel[countOfFilers];
        //массив надписей "3. Ток детектора"
         JLabel [] label5 = new JLabel[countOfFilers];
        // массив текстовых полей для ввода тока детектора
      field3 = new JTextField [countOfFilers];
        //массив надписей "мкА/мА"
        JLabel [] label6 = new JLabel[countOfFilers];
        //Массив надписей "Фильтр 1/2/3/..."
        JLabel [] label7 = new JLabel[countOfFilers];
        viewPanel.setSize(300, 300);
        viewPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(3)));
        viewPanel.setLayout(new BoxLayout(viewPanel, BoxLayout.Y_AXIS));
for (int i=0; i<countOfFilers; i++){
            //создаем новые экземпляры
            jPan_filter[i] = new JPanel();
            label1[i] = new JLabel("Подложка");
            field1[i]=new JTextField("Материал подложки");
            field1[i+countOfFilers]=new JTextField("Материал напыления");
            button1[i]=new JButton("Файл");
            button1[i+countOfFilers]=new JButton("Файл");
            label2[i] = new JLabel("Толщина");
            label2[i+countOfFilers] = new JLabel("Толщина");
            field2[i]=new JTextField();
            field2[i+countOfFilers]=new JTextField();
            label3[i] = new JLabel("мкм");
            label3[i+countOfFilers] = new JLabel("мкм");
            label4[i] = new JLabel("Напыление");
            label5[i] = new JLabel("Ток детектора");
            field3[i]=new JTextField();
            label6[i] = new JLabel("мкА/мА");
            label7[i] =new JLabel("Фильтр № ".concat(Integer.toString(i+1)));
            label7[i].setFont(new Font("Verdana", Font.BOLD, 13));
            jPan_filter[i].setSize(250, 250);
            jPan_filter[i].setBorder(BorderFactory.createLineBorder(Color.black));
                ////////
            button1[i].addActionListener(new GetNameOfFile (field1[i], button1[i], file));
            button1[i+countOfFilers].addActionListener(new GetNameOfFile (field1[i+countOfFilers], button1[i+countOfFilers], file));
            // горизонтальная группа панели фильтров
            GroupLayout layout = new GroupLayout(jPan_filter[i]);
            jPan_filter[i].setLayout(layout);
            layout.setAutoCreateGaps(true);
            layout.setAutoCreateContainerGaps(true);
            layout.setHorizontalGroup(layout.createSequentialGroup()
                //Горизонтальная группа "Подложка"
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(label7[i])
                    .addComponent(label1[i])
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(field1[i])
                        .addComponent(button1[i]))
                    .addComponent(label2[i])
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(field2[i])
                        .addComponent(label3[i])))
                //Горизонтальная группа "Напыление"
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(label4[i])
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(field1[i+countOfFilers])
                        .addComponent(button1[i+countOfFilers]))
                    .addComponent(label2[i+countOfFilers])
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(field2[i+countOfFilers])
                        .addComponent(label3[i+countOfFilers])))
                //Горизонтальная группа "Ток детектора"
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(label5[i])
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(field3[i])
                        .addComponent(label6[i]))));
            //Выравниваем размер полей ввода
            layout.linkSize(SwingConstants.HORIZONTAL, field1[i], field1[i+countOfFilers], field3[i]);
            layout.linkSize(SwingConstants.VERTICAL, field1[i], field1[i+countOfFilers], field3[i]);
            layout.linkSize(SwingConstants.HORIZONTAL,field1[i], field2[i], field2[i+countOfFilers]);

            //вертикальная группа панели фильтров
            layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(label7[i])
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(label1[i])
                    .addComponent(label4[i])
                    .addComponent(label5[i]))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(field1[i])
                    .addComponent(button1[i])
                    .addComponent(field1[i+countOfFilers])
                    .addComponent(button1[i+countOfFilers])
                    .addComponent(field3[i])
                    .addComponent(label6[i]))
                //.addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                    .addComponent(label2[i])
                    .addComponent(label2[i+countOfFilers]))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(field2[i])
                    .addComponent(label3[i])
                    .addComponent(field2[i+countOfFilers])
                    .addComponent(label3[i+countOfFilers])));
            viewPanel.add(jPan_filter[i]);
        }
   } 
}
