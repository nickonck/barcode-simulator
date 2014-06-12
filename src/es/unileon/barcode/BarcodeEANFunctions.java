/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unileon.barcode;

import es.unileon.barcode.exception.InvalidBarcodeException;

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
    
    public static boolean isSecuenceValid(String barcode) throws InvalidBarcodeException{
        boolean result= false;
        if(!isNumber(barcode)){
            throw new InvalidBarcodeException();
        }
        if(barcode.length()==13){
           int control=0;
           for(int i=0; i<barcode.length();i++){
            if((i+1)%2==0){
                control+=3*Integer.parseInt(Character.toString(barcode.charAt(i)));
            }else{
                control+=Integer.parseInt(Character.toString(barcode.charAt(i)));
            }
           }
           if(control%10==0)
               result=true;
        }
        return result;
    }
    
    public static char calculateDeletedDigit(String barcode) throws InvalidBarcodeException{
        // Solve to pair position
        char result = 'X';
        int failPosition=-1;
        if(barcode.length()==13){
           int control=0;
           for(int i=0; i<barcode.length();i++){
            if(Character.isDigit(barcode.charAt(i))){
                if((i+1)%2==0){
                    control+=3*Integer.parseInt(Character.toString(barcode.charAt(i)));
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
                res= ((10 +(-control*7))%10+10)%10;
                System.out.println(control);
            }else{
                res = control%10;
                res = (10-res)%10;
            }
                result=Integer.toString(res).charAt(0);
            }
        }
        System.out.println("Missed: "+result);
        return result;
    }
    
    private static boolean isNumber(String str){
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
    
    private static int getNumberOfChars(String str){
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
}
