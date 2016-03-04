/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callibration_model;

import java.util.ArrayList;

/**
 *
 * @author 1
 */
public class Experiment {
ArrayList <Filter> experiment;

    public Experiment(ArrayList<Filter> experiment) {
        this.experiment = experiment;
    }

 
    public Filter get(int i) {
       Filter filter=experiment.get(i);
       
       return filter;
    }


    public double getExperimentalValue(int i) {
       Filter filter=get(i);
       double experimentalValue=filter.getExperimentalValue();
       return experimentalValue;
    }
}
