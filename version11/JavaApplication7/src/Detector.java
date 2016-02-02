/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1
 */
public class Detector extends Material {
  // поля класса
    public String FName_base, FName_spray; // имя файла материала подложки и напыления
  //  double Thick_base, Thick_spray; // толщина слоя подложки и напыления
    //double Exp_value; // экспериментальное значение тока
   // private String s="Значение поля private";
    // конструктор
    public Detector (String Name_of_file, String FName_spray) {
        super(Name_of_file);
        this.FName_spray=FName_spray;
       // this.Thick_base=Thick_base;
        //this.Thick_spray=Thick_spray;
        //this.Exp_value=Exp_value;
        FName_base=Name_of_file;
    }    
}
