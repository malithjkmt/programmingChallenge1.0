/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author Malith
 */
public class Person {
    private String name;
    private int singleTotalPlays;
    
    private int singleEasyWins;
    private int singleEasyDraws;
    
   
    private int singleHardWins;
    private int singleHardDraws;
    
    private int multiTotalPlays;
    
    private int multidraws;
    private int multiWins;

    public Person(String name, int singleTotalPlays, int singleEasyWins, int singleEasyDraws, int singleHardWins, int singleHardDraws, int multiTotalPlays, int multidraws, int multiWins) {
        this.name = name;
        this.singleTotalPlays = singleTotalPlays;
        this.singleEasyWins = singleEasyWins;
        this.singleEasyDraws = singleEasyDraws;
        this.singleHardWins = singleHardWins;
        this.singleHardDraws = singleHardDraws;
        this.multiTotalPlays = multiTotalPlays;
        this.multidraws = multidraws;
        this.multiWins = multiWins;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSingleTotalPlays() {
        return singleTotalPlays;
    }

    public void setSingleTotalPlays(int singleTotalPlays) {
        this.singleTotalPlays = singleTotalPlays;
    }

    public int getSingleEasyWins() {
        return singleEasyWins;
    }

    public void setSingleEasyWins(int singleEasyWins) {
        this.singleEasyWins = singleEasyWins;
    }

    public int getSingleEasyDraws() {
        return singleEasyDraws;
    }

    public void setSingleEasyDraws(int singleEasyDraws) {
        this.singleEasyDraws = singleEasyDraws;
    }

    public int getSingleHardWins() {
        return singleHardWins;
    }

    public void setSingleHardWins(int singleHardWins) {
        this.singleHardWins = singleHardWins;
    }

    public int getSingleHardDraws() {
        return singleHardDraws;
    }

    public void setSingleHardDraws(int singleHardDraws) {
        this.singleHardDraws = singleHardDraws;
    }

    public int getMultiTotalPlays() {
        return multiTotalPlays;
    }

    public void setMultiTotalPlays(int multiTotalPlays) {
        this.multiTotalPlays = multiTotalPlays;
    }

    public int getMultidraws() {
        return multidraws;
    }

    public void setMultidraws(int multidraws) {
        this.multidraws = multidraws;
    }

    public int getMultiWins() {
        return multiWins;
    }

    public void setMultiWins(int multiWins) {
        this.multiWins = multiWins;
    }

}