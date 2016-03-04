/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callibration_model;

/**
 *
 * @author 1
 */
public interface Filter {
 public Material getMaterialOfBase(); 
 public double getBaseThickness();
 public double getExperimentalValue();
 public double getFunction (double x);
}
