/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Malith
 */
public class Test {
    static ArrayList scores = new ArrayList();
   public static void main(String args[]) {
        
        scores.add(8);
        scores.add(1);
        scores.add(-10);
        scores.add(5);
        
        
        
        
        int mal = (Integer)Collections.max(scores);
        
    }
}
