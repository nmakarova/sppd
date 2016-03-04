/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1
 */
import callibration_model.Controller;
import java.io.File;
import java.util.ArrayList; 
import java.util.Date;
import java.util.HashMap; 
import java.util.Map; 
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException; 
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager; 
import net.sf.jasperreports.engine.JasperPrint; 
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource; 
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;


 

public class Generator {
Controller controller;
    public Generator(Controller controller) {
        this.controller=controller;
    }
    
   //String pathForSaving = "C:\\Users\\1\\Documents\\NetBeansProjects\\sppd\\version11\\JavaApplication7\\src\\TestResult.pdf"; 
  // String pathForPattern = "C:\\Users\\1\\Documents\\NetBeansProjects\\sppd\\version11\\JavaApplication7\\src\\report1.jasper"; 
  String pathForPattern = "C:\\Program Files\\Detector\\bundles\\report1.jasper";  
   //String subReportFileName="C:\\Users\\1\\Documents\\NetBeansProjects\\sppd\\version11\\JavaApplication7\\src\\filters.jasper";
   String subReportFileName="C:\\Program Files\\Detector\\bundles\\filters.jasper";
    public void create() throws JRException { 
      DataBeanList DataBeanList = new DataBeanList(controller);
      ArrayList<DataBean> dataList = DataBeanList.getDataBeanList();
        ////////////////////////////
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList); 
        Map<String, Object> parameters = new HashMap<String, Object>();
         parameters.put("subreportParameter", subReportFileName);
         JasperPrint jasperPrint = JasperFillManager.fillReport(pathForPattern,
         parameters, beanColDataSource);
JRViewer jv = new JRViewer(jasperPrint); 
        JFrame reportFrame = new JFrame();
        reportFrame.setSize(800, 1000);
reportFrame.getContentPane().add(jv);
reportFrame.validate();
reportFrame.setVisible(true);}
}
 //JasperExportManager.exportReportToPdfFile(jasperPrint, pathForSaving); 
        /*File subPattern = new File(subReportFileName); 
        JasperDesign subjasperDesign = JRXmlLoader.load(subPattern); 
       JasperReport jasperSubReport = JasperCompileManager
            .compileReport(subjasperDesign);
        File reportPattern = new File(pathForPattern); 
        JasperDesign jasperDesign = JRXmlLoader.load(reportPattern); 
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign); 
        
         Map<String, Object> parameters = new HashMap<String, Object>(); 
        parameters.put("DATE", new Date()); 
         parameters.put("subreportParameter", jasperSubReport);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, 
                parameters, beanColDataSource); 
        
       // JasperExportManager.exportReportToPdfFile(jasperPrint, pathForSaving); 
        JRViewer jv = new JRViewer(jasperPrint); 
        JFrame reportFrame = new JFrame();
        reportFrame.setSize(800, 1000);
reportFrame.getContentPane().add(jv);
reportFrame.validate();
reportFrame.setVisible(true);}*/
   
    
   /* public static void main(String[] args) { 
        System.out.println("Начало генерации отчёта"); 
        try { 
            new Generator().create(); 
            System.out.println("Генерация отчёта завершена"); 
        } catch (Exception e) { 
            System.out.println("Во время генерации возникла ошибка: " + e); 
        
                } */
      

