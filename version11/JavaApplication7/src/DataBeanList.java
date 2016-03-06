
import callibration_model.Controller;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1
 */
public class DataBeanList {
   Controller controller;

    public DataBeanList(Controller controller) {
        this.controller = controller;
    }
   
     public ArrayList<DataBean> getDataBeanList() {
         //Object sp=NewJFrame.jSpinner1.getValue();
           int nOF=controller.getCountOfFilters();
     ArrayList <SubReportBean> subBeanList= new ArrayList<SubReportBean>();
      ArrayList <SubReportBeanWithoutCoating> subBeanListwithoutcoating= new ArrayList<SubReportBeanWithoutCoating>();
    if (controller.isCoating()==0){
     for (int i=0;i<nOF;i++){
      SubReportBean subBean = new SubReportBean(controller);
      subBean.setfNamebase(i);
      subBean.setthickbase(i);
      subBean.setfNamespray(i,nOF);
      subBean.setthickspray(i,nOF);
      subBean.setExpvalue(i);
      subBean.setcountOfFilters(nOF);
      subBeanList.add(subBean);
      }
    }
    else{
      for (int i=0;i<nOF;i++){
      SubReportBeanWithoutCoating subBean1 = new SubReportBeanWithoutCoating(controller);   
      subBean1.setfNamebase(i);
      subBean1.setthickbase(i);
      subBean1.setExpvalue(i);
      subBean1.setcountOfFilters(nOF);
      subBeanListwithoutcoating.add(subBean1);
      }   
    /* for (int i=0;i<nOF;i++){
      SubReportBean subBean = new SubReportBean(controller);
      subBean.setfNamebase(i);
      subBean.setthickbase(i);
      subBean.setExpvalue(i);
      subBean.setcountOfFilters(nOF);
      subBeanList.add(subBean);
      }  */ 
    }
   
   
    
    ArrayList<DataBean> dataBeanList = new ArrayList<DataBean>();
       dataBeanList.add(produce(subBeanList, subBeanListwithoutcoating));
       return dataBeanList;
     }
     
     private DataBean produce(List<SubReportBean> subBean, List<SubReportBeanWithoutCoating>subBean1) {
      DataBean dataBean = new DataBean();
      dataBean.setk(controller.getDetector());
      dataBean.sethd(controller.getDetector());
      dataBean.sethc(controller.getDetector());
      dataBean.seths(controller.getDetector());
      dataBean.setsRDataSource(controller.getSource());
      dataBean.setFiltersBeanList(subBean);
      dataBean.setFiltersBeanListWithoutCoating(subBean1);
     
      return dataBean;
     }
    
}
