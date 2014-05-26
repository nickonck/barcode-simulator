/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unileon.barcode;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
}
