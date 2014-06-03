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
    private static int DEFAULT_PROBABILITY=10;
    
    public Simulator(){
        this.errorProbability=DEFAULT_PROBABILITY;
    }
    
    public Simulator(int errorProbability){
        this.errorProbability=errorProbability;
    }
    
    public String getBarcode(){
        String result="";
        for(int i=0; i<12;i++){
            result+=Integer.toString(new Double(Math.random()*9).intValue());
        }
        result+=BarcodeEANFunctions.getControlDigit(result);
        return result;
    }
    
    /**
     * We use a maximum of 3 errors
     * @return 
     */
    public String getBarcodeWithDeletedDigit(){
        StringBuilder result=new StringBuilder(this.getBarcode());
        int posRandom=Math.round(new Double(Math.random()*11).floatValue());
        System.out.println("barcode: " + result.toString());
        result.setCharAt(posRandom, 'X');
        int moreErrorProbability= Math.round(new Double(Math.random()*100).floatValue());
        if(moreErrorProbability<errorProbability){
            int errors=Math.round(new Double(Math.random()*2).floatValue());
            for(int i=0; i<errors+1; i++){
                posRandom=Math.round(new Double(Math.random()*11).floatValue());
                result.setCharAt(posRandom, 'X');
            }
        }
        return result.toString();
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
