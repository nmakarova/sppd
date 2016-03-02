/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1
 */
import callibration_model.Material;
public class filter extends Material{
    // поля класса
    public String FName_base, FName_spray; // имя файла материала подложки и напыления
    double Thick_base, Thick_spray; // толщина слоя подложки и напыления
    double Exp_value; // экспериментальное значение тока
   // private String s="Значение поля private";
    // конструктор
    public filter (String Name_of_file, String FName_spray, double Thick_base, double Thick_spray, double Exp_value) {
        super(Name_of_file);
        this.FName_spray=FName_spray;
        this.Thick_base=Thick_base;
        this.Thick_spray=Thick_spray;
        this.Exp_value=Exp_value;
        FName_base=Name_of_file;
    } 
    /*public int SizeOfFile (String NameOfFile){
       int n=0;
        File file=new File (NameOfFile);
       BufferedReader bufferedReader;
        try{
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while(bufferedReader.readLine()!=null)
                n++;
              bufferedReader.close();
           }catch(Exception e){ }
        return n;
    }
    public double [][] Material_reading (String NameOfFile, int n) {
         
        // ищем количество строк в файле
       
         double [][]X= new double[n][2];
        File file=new File (NameOfFile);
       //BufferedReader bufferedReader;
     try{
           // FileReader fileReader = new FileReader(file);
            //bufferedReader = new BufferedReader(fileReader);
            //while(bufferedReader.readLine()!=null)
              //  n++;
             RandomAccessFile randomaccessfile = new RandomAccessFile (file, NameOfFile); 
           
        for (int i=0;i<n;i++){
            for (int j=0;j<2;j++){
                X[i][j]=randomaccessfile.readDouble();
            }}
            //bufferedReader.close();
            //Создаем массив для хранения коэффициентов интерполяци
            }catch(Exception e){ }
        return X;   
        
    }
    public double [][] Material_interpolation (double [][] X, int n){
         double [][] A = new double [n][2];
         for (int i=1;i<n; i++) {
      A[i][1]=(X[i-1][2]-X[i][2])/(X[i-1][1]-X[i][1]);
      A[i][2]=X[i][2]-A[i][1]*X[i][1];
       }
        return A;
    }
    public double Point_z (double [][] X,double [][] A,int n, double z){
        double y=0;
        // ищем значение функции в заданной точке
     if (z<X[0][1]) y=0;
       if (z>X[n-1][1]) y=1;
      // ищем значение функции в заданной точке
      for (int i=1; i<n; i++){
      if (z>=X[i][1]&&z<=X[i+1][1])
       y=A[i][1]*z+A[i][2];
      }
        if (y<0) y=0;
        return y;
    }
    public String show (int x){
       // private String s="Значение поля private";
        return s;
        
    }*/
   // @Override
    //public double current_power(double z){
        
      //  return z;
    //}
}
