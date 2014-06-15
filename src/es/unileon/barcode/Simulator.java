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
    
    private int barcodeLength;
    private int errorProbability;
    
    private static final int DEFAULT_PROBABILITY=10;
    private static final int DEFAULT_BARCODE_LENGTH=13;
    
    public Simulator(){
        this.errorProbability=DEFAULT_PROBABILITY;
        this.barcodeLength=DEFAULT_BARCODE_LENGTH;
    }
    
    public Simulator(int errorProbability, int barcodeLength){
        this.errorProbability=errorProbability;
        this.barcodeLength=barcodeLength;
    }
    
    public String getBarcode(){
        String result="";
        for(int i=0; i<barcodeLength-1;i++){
            result+=Integer.toString(new Double(Math.random()*9).intValue());
        }
        BarcodeEAN barcodeEAN = new BarcodeEAN();
        result+=barcodeEAN.getControlDigit(result);
        return result;
    }
    
    /**
     * We use a maximum of 3 errors
     * @param EANBarcode
     * @return 
     */
    public String getBarcodeWithDeletedDigit(String EANBarcode){
        StringBuilder result=new StringBuilder(EANBarcode);
        int posRandom=Math.abs(Math.round(new Double(Math.random()*barcodeLength-1).floatValue()));
        result.setCharAt(posRandom, 'X');
        int moreErrorProbability= Math.round(new Double(Math.random()*100).floatValue());
        if(moreErrorProbability <= errorProbability){
            int errors=(int) Math.floor(Math.random()*(4-2+1)+2);
            for(int i=1; i<errors; i++){
                posRandom=Math.round(new Double(Math.random()*(barcodeLength-1)).floatValue());
                if(result.charAt(posRandom)!='X')
                    result.setCharAt(posRandom, 'X');
                else
                    i--;
            }
        }
        return result.toString();
    }
    
    public String getBarcodeWithChangedDigit(String EANBarcode){
        StringBuilder barcode=new StringBuilder(EANBarcode);
        StringBuilder newBarcode = barcode;
        int randomPos = (int)(Math.random()*(barcodeLength-1));
        char number = barcode.charAt(randomPos);
            char nextNumber = barcode.charAt(randomPos+1);
            newBarcode.setCharAt(randomPos, nextNumber);
            newBarcode.setCharAt(randomPos+1, number);
            return newBarcode.toString();
    }

    public int getErrorProbability() {
        return errorProbability;
    }

    public void setErrorProbability(int errorProbability) {
        this.errorProbability = errorProbability;
    }

    public int getBarcodeLenght() {
        return barcodeLength;
    }
}
