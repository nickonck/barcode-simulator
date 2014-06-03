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
        barcode="8412600051016";
        assertTrue(BarcodeEANFunctions.isSecuenceValid(barcode));
    }
    
    @Test(expected=InvalidBarcodeException.class)
    public void isSecuenceValidEsxceptionTest() throws InvalidBarcodeException{
        String barcode="hola";
        BarcodeEANFunctions.isSecuenceValid(barcode);
    }
    
    @Test
    public void calculateDeletedDigitTest() throws InvalidBarcodeException{
        String barcode="59012341X3457";
        assertEquals('2',BarcodeEANFunctions.calculateDeletedDigit(barcode));
        barcode="00X0000000000";
        assertEquals('0',BarcodeEANFunctions.calculateDeletedDigit(barcode));
        barcode="9999X99999994";
        assertEquals('9',BarcodeEANFunctions.calculateDeletedDigit(barcode));
        barcode="841X199140401";
        assertEquals('0',BarcodeEANFunctions.calculateDeletedDigit(barcode));
        barcode="84101X9140401";
        assertEquals('9',BarcodeEANFunctions.calculateDeletedDigit(barcode));
        barcode="8410199X40401";
        assertEquals('1',BarcodeEANFunctions.calculateDeletedDigit(barcode));
        barcode="841019914X401";
        assertEquals('0',BarcodeEANFunctions.calculateDeletedDigit(barcode));
    }
    
    @Test(expected=InvalidBarcodeException.class)
     public void calculateDeletedDigitExceptionTest() throws InvalidBarcodeException{
        String barcode="590X2341X3457";
        assertEquals('2',BarcodeEANFunctions.calculateDeletedDigit(barcode));
     }
    
}
