/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unileon.barcode;

/**
 *
 * @author Gonzalo
 */
public class Simulator {
    
    private int errorProbability;
    
    public Simulator(){
    
    }
    
    public String getBarcode(){
        //TODO
        return null;
    }
    
    public String getBarcodeWithDeletedDigit(){
        //TODO
        return null;
    }
    
    public String getBarcodeWithChangedDigit(){
        //TODO
        return null;
    }

    public int getErrorProbability() {
        return errorProbability;
    }

    public void setErrorProbability(int errorProbability) {
        this.errorProbability = errorProbability;
    }
    
    
}
