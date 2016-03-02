
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import org.w3c.dom.Element;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1
 */
public class DiamondView implements FilterView{
    JTextField [] field1;
    JTextField [] field2;
    JTextField [] field3;
            
   
    @Override
    public void createView(int countOfFilers, JPanel viewPanel, File file){

       JPanel [] jPan_filter=new JPanel[countOfFilers];
        
        //массив надписей "1. Подложка"
        JLabel [] label1 = new JLabel[countOfFilers];
        //массив текстовых полей для вывода имени файла
      field1 = new JTextField [countOfFilers];  
       JButton [] button1 = new JButton [countOfFilers];
        // массив надписей "толщина"
        JLabel [] label2 = new JLabel[countOfFilers];
        // массив текстовых полей для ввода толщины
       field2 = new JTextField [countOfFilers];
        // массив надписей "мкм"
        JLabel [] label3 = new JLabel[countOfFilers];
        
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
            
            button1[i]=new JButton("Файл");
           
            label2[i] = new JLabel("Толщина");
            
            field2[i]=new JTextField();
           
            label3[i] = new JLabel("мкм");
            
            label5[i] = new JLabel("Ток детектора");
            field3[i]=new JTextField();
            label6[i] = new JLabel("мкА/мА");
            label7[i] =new JLabel("Фильтр № ".concat(Integer.toString(i+1)));
            label7[i].setFont(new Font("Verdana", Font.BOLD, 13));
            jPan_filter[i].setSize(250, 250);
            jPan_filter[i].setBorder(BorderFactory.createLineBorder(Color.black));
                ////////
            button1[i].addActionListener(new GetNameOfFile (field1[i], button1[i], file));
            
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
               
                
                //Горизонтальная группа "Ток детектора"
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(label5[i])
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(field3[i])
                        .addComponent(label6[i]))));
            //Выравниваем размер полей ввода
            layout.linkSize(SwingConstants.HORIZONTAL, field1[i], field3[i]);
            layout.linkSize(SwingConstants.VERTICAL, field1[i], field3[i]);
            layout.linkSize(SwingConstants.HORIZONTAL,field1[i], field2[i]);

            //вертикальная группа панели фильтров
            layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(label7[i])
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(label1[i])
                    .addComponent(label5[i]))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(field1[i])
                    .addComponent(button1[i])
                    .addComponent(field3[i])
                    .addComponent(label6[i]))
                    .addGroup(layout.createParallelGroup()
                    .addComponent(label2[i])
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(field2[i])
                    .addComponent(label3[i]))));
            viewPanel.add(jPan_filter[i]);
        }
   }
   public String [] createCoutingBase(int countOfFilters){
       String [] coutingBase=new String [countOfFilters];
       for (int i=0; i<countOfFilters; i++){
           coutingBase[i]=new String(field1[i].getText());
       }
       return coutingBase;
   }
   public double [] createBaseThickness (int countOfFilters){
       double [] baseThickness=new double [countOfFilters];
       for (int i=0; i<countOfFilters; i++){
           baseThickness[i]=Double.parseDouble(field2[i].getText());
       }
       return baseThickness;
   }
    public double [] createExpValue (int countOfFilters){
       double [] expValue=new double [countOfFilters];
       for (int i=0; i<countOfFilters; i++){
           expValue[i]=Double.parseDouble(field2[i].getText());
       }
       return expValue;
   }

    @Override
    public void setXmlElement(int typeOfFilter, Element eElement, int temp, int countOfFilters) {
        field1[temp].setText(eElement.getElementsByTagName("base").item(0).getTextContent());
        field2[temp].setText(eElement.getElementsByTagName("base_th").item(0).getTextContent());
        field3[temp].setText(eElement.getElementsByTagName("cur").item(0).getTextContent());
    }
}
