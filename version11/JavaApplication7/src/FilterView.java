
import java.io.File;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1
 */
public interface FilterView {
 public void createView (int countOfFilers, JPanel viewPanel, File file);
 public String [] createCoutingBase(int countOfFilters);
 public double [] createBaseThickness (int countOfFilters);
 public double [] createExpValue (int countOfFilters);
}
