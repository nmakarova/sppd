
import java.util.ArrayList;
import java.util.Arrays;
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
     public ArrayList<DataBean> getDataBeanList() {
          Object sp=NewJFrame.jSpinner1.getValue();
           int nOF=Integer.parseInt(sp.toString());
     ArrayList <SubReportBean> subBeanList= new ArrayList<SubReportBean>();
    
     for (int i=0;i<nOF;i++){
      SubReportBean subBean = new SubReportBean();
      subBean.setfNamebase(i);
      subBean.setthickbase(i);
      subBean.setfNamespray(i,nOF);
      subBean.setthickspray(i,nOF);
      subBean.setExpvalue(i);
      subBean.setcountOfFilters(nOF);
      subBeanList.add(subBean);
      }
       ArrayList<DataBean> dataBeanList = new ArrayList<DataBean>();
       dataBeanList.add(produce(subBeanList));
       return dataBeanList;
     }
     
     private DataBean produce(List<SubReportBean> subBean) {
      DataBean dataBean = new DataBean();
      dataBean.sethc();
      dataBean.sethd();
      dataBean.seths();
      dataBean.setk();
      dataBean.setFiltersBeanList(subBean);
      dataBean.setsRDataSource();
      return dataBean;
     }
}
