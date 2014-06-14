/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unileon.barcode;

import es.unileon.barcode.exception.InvalidBarcodeException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Gonzalo
 */
public class BarcodeFunctionsTests {
    
    private BarcodeEAN barcodeEAN;
    
    @Before
    public void setUp(){
        barcodeEAN = new BarcodeEAN();
    }
    
    @Test
    public void getControlDigitTest() {
        String barcode="590123412345";
        assertEquals(barcodeEAN.getControlDigit(barcode), '7');
    
        barcode="000000000000";
        assertEquals(barcodeEAN.getControlDigit(barcode), '0');
    
        barcode="999999999999";
        assertEquals(barcodeEAN.getControlDigit(barcode), '4');
    
        barcode="841019914040";
        assertEquals(barcodeEAN.getControlDigit(barcode), '1');
    }
    
    @Test
    public void isSecuenceValidTest() throws InvalidBarcodeException{
        String barcode="5901234123457";
        assertTrue(barcodeEAN.isSecuenceValid(barcode));
        barcode="0000000000000";
        assertTrue(barcodeEAN.isSecuenceValid(barcode));
        barcode="9999999999994";
        assertTrue(barcodeEAN.isSecuenceValid(barcode));
        barcode="8412600051016";
        assertTrue(barcodeEAN.isSecuenceValid(barcode));
    }
    
    @Test(expected=InvalidBarcodeException.class)
    public void isSecuenceValidEsxceptionTest() throws InvalidBarcodeException{
        String barcode="hola";
        barcodeEAN.isSecuenceValid(barcode);
    }
    
    @Test
    public void calculateDeletedDigitTest() throws InvalidBarcodeException{
        String barcode="59012341X3457";
        assertEquals('2',barcodeEAN.calculateDeletedDigit(barcode));
        barcode="00X0000000000";
        assertEquals('0',barcodeEAN.calculateDeletedDigit(barcode));
        barcode="0X00000000000";
        assertEquals('0',barcodeEAN.calculateDeletedDigit(barcode));
        barcode="9999X99999994";
        assertEquals('9',barcodeEAN.calculateDeletedDigit(barcode));
        barcode="X410199140401";
        assertEquals('8',barcodeEAN.calculateDeletedDigit(barcode));
        barcode="8X10199140401";
        assertEquals('4',barcodeEAN.calculateDeletedDigit(barcode));
        barcode="84X0199140401";
        assertEquals('1',barcodeEAN.calculateDeletedDigit(barcode));
        barcode="841X199140401";
        assertEquals('0',barcodeEAN.calculateDeletedDigit(barcode));
        barcode="8410X99140401";
        assertEquals('1',barcodeEAN.calculateDeletedDigit(barcode));
        barcode="84101X9140401";
        assertEquals('9',barcodeEAN.calculateDeletedDigit(barcode));
        barcode="841019X140401";
        assertEquals('9',barcodeEAN.calculateDeletedDigit(barcode));
        barcode="8410199X40401";
        assertEquals('1',barcodeEAN.calculateDeletedDigit(barcode));
        barcode="84101991X0401";
        assertEquals('4',barcodeEAN.calculateDeletedDigit(barcode));
        barcode="841019914X401";
        assertEquals('0',barcodeEAN.calculateDeletedDigit(barcode));
        barcode="8410199140X01";
        assertEquals('4',barcodeEAN.calculateDeletedDigit(barcode));
        barcode="84101991404X1";
        assertEquals('0',barcodeEAN.calculateDeletedDigit(barcode));
        barcode="841019914040X";
        assertEquals('1',barcodeEAN.calculateDeletedDigit(barcode));
    }
    
    @Test(expected=InvalidBarcodeException.class)
     public void calculateDeletedDigitExceptionTest() throws InvalidBarcodeException{
        String barcode="590X2341X3457";
        assertEquals('2',barcodeEAN.calculateDeletedDigit(barcode));
     }
    
}
