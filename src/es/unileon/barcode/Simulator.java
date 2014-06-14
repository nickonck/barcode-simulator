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
        System.out.println("barcode: " + result.toString());
        result.setCharAt(posRandom, 'X');
        int moreErrorProbability= Math.round(new Double(Math.random()*100).floatValue());
        if(moreErrorProbability < errorProbability){
            int errors=Math.round(new Double(Math.random()*2).floatValue());
            for(int i=0; i<errors+1; i++){
                posRandom=Math.round(new Double(Math.random()*barcodeLength).floatValue());
                result.setCharAt(posRandom, 'X');
            }
        }
        return result.toString();
    }
    
    public String getBarcodeWithChangedDigit(String EANBarcode){
        StringBuilder barcode=new StringBuilder(EANBarcode);
        StringBuilder newBarcode = barcode;
        int randomPos = (int)(Math.random()*barcodeLength);
        char number = barcode.charAt(randomPos);
        char nextNumber = barcode.charAt(randomPos+1);
        System.out.println("Barcode Original: "+ barcode.toString());
        System.out.println("Posicion aleatoria: "+ number);
        System.out.println("Posicion siguiente: "+ nextNumber);
        
        newBarcode.setCharAt(randomPos, nextNumber);
        newBarcode.setCharAt(randomPos+1, number);
       System.out.println("Barcode Nuevo: "+ newBarcode.toString());
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

    public void setBarcodeLenght(int barcodeLenght) {
        this.barcodeLength = barcodeLenght;
    }
    
    
}
