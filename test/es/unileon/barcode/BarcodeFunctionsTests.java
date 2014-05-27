/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unileon.barcode;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gonzalo
 */
public class BarcodeFunctionsTests {
    
    
    @Test
    public void getControlDigitTest() {
        String barcode="590123412345";
        assertEquals(BarcodeEANFunctions.getControlDigit(barcode), '7');
    
        barcode="000000000000";
        assertEquals(BarcodeEANFunctions.getControlDigit(barcode), '0');
    
        barcode="999999999999";
        assertEquals(BarcodeEANFunctions.getControlDigit(barcode), '4');
    
        barcode="841019914040";
        assertEquals(BarcodeEANFunctions.getControlDigit(barcode), '1');
    }
    
    @Test
    public void isSecuenceValidTest() throws InvalidBarcodeException{
        String barcode="5901234123457";
        assertTrue(BarcodeEANFunctions.isSecuenceValid(barcode));
        barcode="0000000000000";
        assertTrue(BarcodeEANFunctions.isSecuenceValid(barcode));
        barcode="9999999999994";
        assertTrue(BarcodeEANFunctions.isSecuenceValid(barcode));
        barcode="8410199140401";
        assertTrue(BarcodeEANFunctions.isSecuenceValid(barcode));
    }
}
