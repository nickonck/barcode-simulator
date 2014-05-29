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
        String result="";
        for(int i=0; i<12;i++){
            result+=Integer.toString(new Double(Math.random()*9).intValue());
        }
        result+=BarcodeEANFunctions.getControlDigit(result);
        return result;
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
