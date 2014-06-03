/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unileon.barcode;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gonzalo
 */
public class SimulatorTests {
    
    private Simulator simulator;
    
    @Before
    public void setUp() {
        simulator = new Simulator();
    }

    
    @Test
    public void getBarcodeTest() throws InvalidBarcodeException {
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
        assertTrue(BarcodeEANFunctions.isSecuenceValid(simulator.getBarcode()));
    }
    
    @Test
    public void getBarcodeWithDeletedDigitTest(){
       // simulator.setErrorProbability(100);
        System.out.println(simulator.getBarcodeWithDeletedDigit());
        System.out.println(simulator.getBarcodeWithDeletedDigit());
        System.out.println(simulator.getBarcodeWithDeletedDigit());
        System.out.println(simulator.getBarcodeWithDeletedDigit());
        System.out.println(simulator.getBarcodeWithDeletedDigit());
        System.out.println(simulator.getBarcodeWithDeletedDigit());
        System.out.println(simulator.getBarcodeWithDeletedDigit());
        System.out.println(simulator.getBarcodeWithDeletedDigit());
        System.out.println(simulator.getBarcodeWithDeletedDigit());
        System.out.println(simulator.getBarcodeWithDeletedDigit());
        System.out.println(simulator.getBarcodeWithDeletedDigit());
    }
}
