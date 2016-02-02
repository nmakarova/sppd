
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.RandomAccessFile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1
 */
public abstract class Material extends DataFromFile {

    public Material(String Name_of_file) {
        super(Name_of_file);
    }
    //public String Name_of_file;
/*public Material (String Name_of_file){
    this.Name_of_file=Name_of_file;
} 
    /* public int SizeOfFile (String NameOfFile){
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
        
    }*/
     public double [][] Material_interpolation (double [][] X, int n){
         double [][] A = new double [n][2];
         for (int i=1;i<n; i++) {
      A[i][0]=(X[i-1][1]-X[i][1])/(X[i-1][0]-X[i][0]);
      A[i][1]=X[i][1]-A[i][0]*X[i][0];
       }
        return A;
    }
    public double Point_z (double [][] X,double [][] A,int n, double z){
        double y=0;
        // ищем значение функции в заданной точке
     if (z<X[0][0]) y=0;
       if (z>X[n-1][0]) y=1;
      // ищем значение функции в заданной точке
      for (int i=1; i<n-1; i++){
      if (z>=X[i][0]&&z<=X[i+1][0])
       y=A[i][0]*z+A[i][1];
      }
        if (y<0) y=0;
        return y;
    }
 //   public abstract double current_power(double z);
}
