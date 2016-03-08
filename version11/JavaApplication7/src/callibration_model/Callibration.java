/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callibration_model;

import java.util.Random;

/**
 *
 * @author 1
 */
public class Callibration {

  DataFromFile source;
  DetectorNew detector;
  Experiment experiment;
  int countOfFilters;  
  double [] lowerBorder;
  double [] upperBorder;
  int [] ifBorder;
  int countOfBorders;
    public Callibration(DataFromFile source, DetectorNew detector, Experiment experiment, int countOfFilters) {
        this.source = source;
        this.detector = detector;
        this.experiment = experiment;
        this.countOfFilters = countOfFilters;
    }
    public double[] getLowerBorder() {
        return lowerBorder;
    }

    public void setLowerBorder(double[] lowerBorder) {
        this.lowerBorder = lowerBorder;
    }

    public double[] getUpperBorder() {
        return upperBorder;
    }

    public void setUpperBorder(double[] upperBorder) {
        this.upperBorder = upperBorder;
    }

    public int[] getIfBorder() {
        return ifBorder;
    }

    public void setIfBorder(int[] ifBorder) {
        this.ifBorder = ifBorder;
    }

    public int getCountOfBorders() {
        return countOfBorders;
    }

    public void setCountOfBorders(int countOfBorders) {
        this.countOfBorders = countOfBorders;
    }
    
   public double nevjazka(double[] I1, double[] I0) {
       double T0=0;
          T0=0;
        for(int k=0; k<countOfFilters; k++){
           T0=T0+Math.pow((I1[k]-I0[k]),2);
        }
         return T0;
    }
   public double detector_current(Filter filter, double[] b) {
       final double e0=1.6e-19;
        double current=0; 
       //находим верхний предел интегрирования
       int n=source.SizeOfFile(source.Name_of_file);
        //находим точки разбиения
          double  X[][]=source.Data_reading(source.Name_of_file, n);
   //детектор
       int n_d1=detector.base.SizeOfFile(detector.base.Name_of_file);
       double [][]X_d1=detector.base.Data_reading(detector.base.Name_of_file, n_d1);
       double [][]A_d1=detector.base.Material_interpolation(X_d1, n_d1);
       int n_d2=detector.contact.SizeOfFile(detector.contact.Name_of_file);
       double [][]X_d2=detector.contact.Data_reading(detector.contact.Name_of_file, n_d2);
       double [][]A_d2=detector.contact.Material_interpolation(X_d2, n_d2);
    
       for (int i=0; i<n-1;i++){
        double Sd;
        Sd=filter.getFunction(X[i][0]);
        double S;
        S=detector.idealDiod*b[0]*Math.pow(detector.base.Point_z(X_d1, A_d1, n_d1, X[i][0]), b[1]);
        S=S*Math.pow(detector.contact.Point_z(X_d2, A_d2, n_d2, X[i][0]), b[2]);
        S=S*(1-Math.pow(detector.base.Point_z(X_d1, A_d1, n_d1, X[i][0]), b[3]));
       current=current+Sd*S*X[i][1]*X[i][0]*Math.abs(X[i+1][0]-X[i][0]);  
       }
     return current*e0*1000000; 
   }
   public double [] callibrate(){
       double [] realParams=new double [4];
       if(countOfBorders!=0){
       // начальная точка
        double [] x1=new double[4];
        x1[0]=detector.paspParam[0]; 
        x1[1]=detector.paspParam[1];
        x1[2]=detector.paspParam[2];
        x1[3]=detector.paspParam[3];
        // объявления массивов для токов детектора
        double [] I0= new double [countOfFilters];
        double [] I1= new double [countOfFilters];
        //Начальная инициализация экспериментальными токами
        for (int i=0;i<countOfFilters; i++){
        I0[i]= experiment.getExperimentalValue(i);
        }
        double [] l=new double [countOfBorders];
        double [] u=new double [countOfBorders];
        int k=2*countOfBorders;
       double [][] c=new double [k][countOfBorders];
       double [] xc=new double [countOfBorders];
       int jj=0, zz=0, yy=0;
       boolean flag1=false; boolean flag2=false;
       //переменные для неявного ограничения r1+r2<=0.5
       double r1=detector.paspParam[1]; 
       double r2=detector.paspParam[2]; 
       for (int i=0;i<4; i++){
        if (ifBorder[i]==1) {
            c[0][jj]=x1[i];
            l[jj]=lowerBorder[i];
            u[jj]=upperBorder[i];
            if (i==1){
              flag1=true;
              r1=x1[i];
              zz=jj;
            }
            if (i==2){
              flag2=true;
              r2=x1[i];
              yy=jj;
            }
            jj=jj+1;
        }  
       }
      //инициализируем начальную точку комплекса
        for (int j=0; j<countOfBorders; j++){
            xc[j]=c[0][j];
        } 
        double [] c1=new double [4];
        jj=0;
        if (ifBorder[0]==0){c1[0]=detector.paspParam[0];} else {c1[0]=c[0][jj]; jj=jj+1;}
        if (ifBorder[1]==0){c1[1]=detector.paspParam[1];} else {c1[1]=c[0][jj]; jj=jj+1;}
        if (ifBorder[2]==0){c1[2]=detector.paspParam[2];} else {c1[2]=c[0][jj]; jj=jj+1;}
        if (ifBorder[3]==0){c1[3]=detector.paspParam[3];} else {c1[3]=c[0][jj]; jj=jj+1;}
       Random r=new Random();
       double [] F=new double[k];
        for (int t=0;t<countOfFilters; t++){
            I1[t]=detector_current(experiment.get(t), c1);
        }
        /// Ищем сумму квадратов невязок между экспериментом и значениями токов
 ////с паспортными параметрами
        F[0]=nevjazka(I1, I0);
        double v=0.1;
        for (int i=1; i<k; i++){
           v=v+0.1;
           for (int j=0; j<countOfBorders; j++){
               c[i][j]=l[j]+v*(u[j]-l[j]); 
           }
           if (flag1==true){r1=c[i][zz];}
           if (flag2==true){r2=c[i][yy];}
          while (r1+r2>0.5){
               for (int j=0;j<countOfBorders;j++){
                   c[i][j]=(c[i][j]+xc[j])/2;
               }
            if (flag1==true){r1=c[i][zz];}
            if (flag2==true){r2=c[i][yy];}   
           }
           for (int j=0;j<countOfBorders;j++){
               xc[j]=((i)*xc[j]+c[i][j])/(i+1);
           }
           jj=0;
        if (ifBorder[0]==0){c1[0]=detector.paspParam[0];} else {c1[0]=c[i][jj]; jj=jj+1;}
        if (ifBorder[1]==0){c1[1]=detector.paspParam[1];} else {c1[1]=c[i][jj]; jj=jj+1;}
        if (ifBorder[2]==0){c1[2]=detector.paspParam[2];} else {c1[2]=c[i][jj]; jj=jj+1;}
        if (ifBorder[3]==0){c1[3]=detector.paspParam[3];} else {c1[3]=c[i][jj]; jj=jj+1;}
            for (int t=0;t<countOfFilters; t++){
            I1[t]=detector_current(experiment.get(t), c1);
        }
        /// Ищем сумму квадратов невязок между экспериментом и значениями токов
 ////с паспортными параметрами
        F[i]=nevjazka(I1, I0);
       }
         for (int j=0; j<k-1; j++){
           for (int i=j+1; i<k; i++){
               if(F[j]>F[i]){
                   double F1;
                   F1=F[j]; F[j]=F[i]; F[i]=F1;
                   double [] Y1=new double [countOfBorders];
                   for (int z=0; z<countOfBorders; z++){
                       Y1[z]=c[j][z]; c[j][z]=c[i][z]; c[i][z]=Y1[z];
                   } 
               }
           }
       }
       double FM=F[0];
       double A=1.3;
       double [] x0=new double [countOfBorders];
       double [] xh=new double [countOfBorders];
       double [] xr=new double [countOfBorders];
       double Fr;
       boolean cl=true;
       double S1; double S2; double D; double DM; double SD;
       S1=0; S2=0; SD=0;
    for (int i=0; i<k; i++){
        S1=S1+F[i];
        S2=S2+F[i]*F[i];
    }
    SD=S2-S1*S1/k;
    SD=SD/k;
    int m=0;
     do{
        for (int j=0; j<countOfBorders; j++){
           xh[j]=c[k-1][j];
           x0[j]=(k*xc[j]-xh[j])/(k-1);
       }
       for (int j=0; j<countOfBorders; j++){
           xr[j]=(1+A)*x0[j]-A*xh[j];
       }
      do{
          for (int i=0; i<countOfBorders; i++){
              if (xr[i]<l[i]) cl=false;
              if (xr[i]>u[i]) cl=false;
          }
          if (flag1==true){r1=xr[zz];}
          if (flag2==true){r2=xr[yy];}
      
       while ((cl==false)||(r1+r2>0.5)){
           m=m+1;
           if (cl==false){
               for (int i=0; i<countOfBorders; i++){
                   if (xr[i]<l[i]) xr[i]=l[i]+0.00000001;
                   if (xr[i]>u[i]) xr[i]=u[i]-0.00000001;
               }
           }
               if (r1+r2>0.5){
                   for (int j=0; j<countOfBorders; j++){
                       xr[j]=(xr[j]+x0[j])/2;
                   }
               }
          cl=true;
          for (int i=0; i<countOfBorders; i++){
              if (xr[i]<l[i]) cl=false;
              if (xr[i]>u[i]) cl=false;
          }
          if (flag1==true){r1=xr[zz];}
          if (flag2==true){r2=xr[yy];}
       }
       jj=0;
        if (ifBorder[0]==0){c1[0]=detector.paspParam[0];} else {c1[0]=xr[jj]; jj=jj+1;}
        if (ifBorder[1]==0){c1[1]=detector.paspParam[1];} else {c1[1]=xr[jj]; jj=jj+1;}
        if (ifBorder[2]==0){c1[2]=detector.paspParam[2];} else {c1[2]=xr[jj]; jj=jj+1;}
        if (ifBorder[3]==0){c1[3]=detector.paspParam[3];} else {c1[3]=xr[jj]; jj=jj+1;}
      for (int t=0;t<countOfFilters; t++){
            I1[t]=detector_current(experiment.get(t), c1);
        }
        /// Ищем сумму квадратов невязок между экспериментом и значениями токов
 ////с паспортными параметрами
        Fr=nevjazka(I1, I0);
       if (Fr>=F[k-1]){
         for (int j=0; j<countOfBorders; j++){
                       xr[j]=(xr[j]+x0[j])/2;
                   } 
       }
      }
         while (Fr>=F[k-1]);
    F[k-1]=Fr;
    for (int j=0; j<countOfBorders; j++){
        xc[j]=k*xc[j]-c[k-1][j]+xr[j];
        xc[j]=xc[j]/k;
        c[k-1][j]=xr[j];
    }
    for (int j=0; j<k-1; j++){
           for (int i=j+1; i<k; i++){
               if(F[j]>F[i]){
                   double F1;
                   F1=F[j]; F[j]=F[i]; F[i]=F1;
                   double [] Y1=new double [countOfBorders];
                   for (int z=0; z<countOfBorders; z++){
                       Y1[z]=c[j][z]; c[j][z]=c[i][z]; c[i][z]=Y1[z];
                   } 
               }
           }
       }
    
    S1=0; S2=0; SD=0;
    for (int i=0; i<k; i++){
        S1=S1+F[i];
        S2=S2+F[i]*F[i];
    }
    SD=S2-S1*S1/k;
    SD=SD/k;
    DM=0;
    for (int i=0; i<k-1; i++){
        for (int j=i+1; j<k; j++){
            D=0;
            for (int z=0; z<countOfBorders;z++){
                D=D+Math.pow(c[i][z]-c[j][z], 2);
            }
            D=D*D;
            if (D>DM) DM=0;
        }
    }
    m=m+1;
    //if (m>1) break;
    }
    while (SD>0.00001); 
    jj=0;
     if (ifBorder[0]==0){realParams[0]=detector.paspParam[0];}
     else {realParams[0]=c[0][jj]; jj=jj+1;}
     if (ifBorder[1]==0){realParams[1]=detector.paspParam[1];}
     else {realParams[1]=c[0][jj]; jj=jj+1;}
     if (ifBorder[2]==0){realParams[2]=detector.paspParam[2];}
     else {realParams[2]=c[0][jj]; jj=jj+1;} 
     if (ifBorder[3]==0){realParams[3]=detector.paspParam[3];}
     else {realParams[3]=c[0][jj]; jj=jj+1;}
 }
 else{
 realParams[0]=detector.paspParam[0];
 realParams[1]=detector.paspParam[1];
 realParams[2]=detector.paspParam[2];
 realParams[3]=detector.paspParam[3];
           
       }
     detector.setRealParam(realParams);
     
     return realParams;
   }
}
  

