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
public class BarcodeEANFunctions {
    
    public static char getControlDigit(String barcode){
        int result=0;
        for(int i=0; i<barcode.length(); i++){
            if((i+1)%2==0){
                result+=3*Integer.parseInt(Character.toString(barcode.charAt(i)));
            }else{
                result+=Integer.parseInt(Character.toString(barcode.charAt(i)));
            }
        }
        result=result%10;
        result=10-result;
        result=result%10;
        return Integer.toString(result).charAt(0);
    }
    
    public static boolean isSecuenceValid(String barcode){
        boolean result= false;
        return result;
    }
    
    public static char calculateDeletedDigit(String barcode){
        return ' ';
    }
}
