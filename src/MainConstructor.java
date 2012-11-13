/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 * Copyright (c) Anton Shekhov 
 */
public class MainConstructor {
    public static void main (String [] args){
        Step step = new Step ();
        step.startStep(step.getFirstArray());
        int n = step.getMatchList().size();
        //System.out.println();
        //System.out.println ("matches = " + n);
        int i;
        //step.printArray(step.getStepArray(0));
        /* step.startStep(step.getStepArray(i));
         * System.out.println ("\n" + step.getMatchList().size());*/
        
        for (i = 0; i < n; i++){
         Step temp = new Step ();
         temp.startStep(step.getStepArray(i));
            //temp.printArray(step.getStepArray(i));
            System.out.println ("Step №2, Array #" + (i) + " = " + temp.getMatchList().size());

         }
    }
}

class Work {
    
}
