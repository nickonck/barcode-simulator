/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unileon.barcode.ModuleNumber;

/**
 *
 * @author Gonzalo
 */
public class ModuleNumber {
    
    public static int getIntegerInModule(int number, int mod){
        return number%mod;
    }
    
    public static int getFractionInModule(int numerator, int denominator, int mod){
        return (numerator * getInverse(denominator,mod))%mod;
    }
    
    private static int getInverse(int number, int mod){
        return (mod-(number%mod)+mod)%mod;
    
    }
}
