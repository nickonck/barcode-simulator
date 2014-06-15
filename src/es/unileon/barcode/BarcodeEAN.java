/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unileon.barcode;

import es.unileon.barcode.ModuleNumber.ModuleNumber;
import es.unileon.barcode.exception.InvalidBarcodeException;

/**
 *
 * @author Gonzalo
 */
public class BarcodeEAN {
    
    private int barcodeLength;
    
    private static final int MODULE_BARCODE = 10;
    private static final int DEFAULT_BARCODE_LENGHT=13;
    private static final int MULTIPLY_FACTOR = 3;
    
    public BarcodeEAN(){
        barcodeLength=DEFAULT_BARCODE_LENGHT;
    }
    
    public BarcodeEAN(int barcodeLenght){
        this.barcodeLength=barcodeLenght;
    }
    
    public char getControlDigit(String barcode){
        int result=0;
        for(int i=0; i<barcode.length(); i++){
            if((i+1)%2==0){
                result+=3*Integer.parseInt(Character.toString(barcode.charAt(i)));
            }else{
                result+=Integer.parseInt(Character.toString(barcode.charAt(i)));
            }
        }
        result=ModuleNumber.getIntegerInModule(MODULE_BARCODE-ModuleNumber.getIntegerInModule(result, MODULE_BARCODE),MODULE_BARCODE);
        return Integer.toString(result).charAt(0);
    }
    
    public boolean isSecuenceValid(String barcode) throws InvalidBarcodeException{
        boolean result= false;
        if(!isNumber(barcode)){
            throw new InvalidBarcodeException();
        }
        if(barcode.length()==barcodeLength){
           int control=0;
           for(int i=0; i<barcode.length();i++){
            if((i+1)%2==0){
                control+=MULTIPLY_FACTOR*Integer.parseInt(Character.toString(barcode.charAt(i)));
            }else{
                control+=Integer.parseInt(Character.toString(barcode.charAt(i)));
            }
           }
           if(ModuleNumber.getIntegerInModule(control,MODULE_BARCODE)==0)
               result=true;
        }
        return result;
    }
    
    public char calculateDeletedDigit(String barcode) throws InvalidBarcodeException{
        // Solve to pair position
        char result = 'X';
        int failPosition=-1;
        if(barcode.length()==barcodeLength){
           int control=0;
           for(int i=0; i<barcode.length();i++){
            if(Character.isDigit(barcode.charAt(i))){
                if((i+1)%2==0){
                    control+=MULTIPLY_FACTOR*Integer.parseInt(Character.toString(barcode.charAt(i)));
                }else{
                    control+=Integer.parseInt(Character.toString(barcode.charAt(i)));
                }
            }else{
                if(failPosition==-1)
                    failPosition=i;
                else
                    throw new InvalidBarcodeException();
            }
           }
           if(failPosition!=-1){
            int res=0;
            if((failPosition+1)%2==0){
                res= ModuleNumber.getIntegerInModule((MODULE_BARCODE -(ModuleNumber.getFractionInModule(control, MULTIPLY_FACTOR, MODULE_BARCODE))),MODULE_BARCODE);
                System.out.println(control);
            }else{
                res = ModuleNumber.getIntegerInModule(MODULE_BARCODE-ModuleNumber.getIntegerInModule(control, MODULE_BARCODE),MODULE_BARCODE);
            }
                result=Integer.toString(res).charAt(0);
            }
        }
        System.out.println("Missed: "+result);
        return result;
    }
    public int getDeletedPosition(String barcode) throws InvalidBarcodeException{
        int result=-1;
        if(getNumberOfChars(barcode)!=1){
            throw new InvalidBarcodeException();
        }
        int i=0;
        while(i<barcode.length() && result==-1){
            if(Character.isLetter(barcode.charAt(i))){
                result=i;
            }
            i++;
        }
        return result;
    }
    
    private boolean isNumber(String str){
        boolean result=true;
        if(str!=null){
            int i=0;
            while(i<str.length()&&result){
                if(!Character.isDigit(str.charAt(i))){
                    result=false;
                }
                i++;
            }
        }
        return result;
    }
    
    private int getNumberOfChars(String str){
        int result=0;
        if(str!=null){
            int i=0;
            while(i<str.length()){
                if(!Character.isDigit(str.charAt(i))){
                    result++;
                }
                i++;
            }
        }
        return result;
    }

    public int getBarcodeLength() {
        return barcodeLength;
    }

   
}
