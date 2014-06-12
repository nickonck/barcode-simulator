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
    
    private int barcodeLenght;
    private int errorProbability;
    
    private static int DEFAULT_PROBABILITY=10;
    private static int DEFAULT_BARCODE_LENGHT=12;
    
    public Simulator(){
        this.errorProbability=DEFAULT_PROBABILITY;
        this.barcodeLenght=DEFAULT_BARCODE_LENGHT;
    }
    
    public Simulator(int errorProbability, int barcodeLength){
        this.errorProbability=errorProbability;
        this.barcodeLenght=barcodeLength;
    }
    
    public String getBarcode(){
        String result="";
        for(int i=0; i<barcodeLenght;i++){
            result+=Integer.toString(new Double(Math.random()*9).intValue());
        }
        result+=BarcodeEANFunctions.getControlDigit(result);
        return result;
    }
    
    /**
     * We use a maximum of 3 errors
     * @return 
     */
    public String getBarcodeWithDeletedDigit(String EANBarcode){
        StringBuilder result=new StringBuilder(EANBarcode);
        int posRandom=Math.round(new Double(Math.random()*11).floatValue());
        System.out.println("barcode: " + result.toString());
        result.setCharAt(posRandom, 'X');
        int moreErrorProbability= Math.round(new Double(Math.random()*100).floatValue());
        if(moreErrorProbability < errorProbability){
            int errors=Math.round(new Double(Math.random()*2).floatValue());
            for(int i=0; i<errors+1; i++){
                posRandom=Math.round(new Double(Math.random()*barcodeLenght).floatValue());
                result.setCharAt(posRandom, 'X');
            }
        }
        return result.toString();
    }
    
    public String getBarcodeWithChangedDigit(String EANBarcode){
        StringBuilder barcode=new StringBuilder(EANBarcode);
        StringBuilder newBarcode = barcode;
        int randomPos = (int)(Math.random()*barcodeLenght);
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
        return barcodeLenght;
    }

    public void setBarcodeLenght(int barcodeLenght) {
        this.barcodeLenght = barcodeLenght;
    }
    
    
}
