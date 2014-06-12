/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unileon.barcode;

import es.unileon.barcode.exception.InvalidBarcodeException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gonzalo
 */
public class SimulatorTests {
    
    private BarcodeEAN barcodeEAN;
    private Simulator simulator;
    
    @Before
    public void setUp() {
        barcodeEAN = new BarcodeEAN();
        simulator = new Simulator();
    }

    
    @Test
    public void getBarcodeTest() throws InvalidBarcodeException {
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
        assertTrue(barcodeEAN.isSecuenceValid(simulator.getBarcode()));
    }
    
    @Test
    public void getBarcodeWithDeletedDigitTest(){
       // simulator.setErrorProbability(100);
        System.out.println(simulator.getBarcodeWithDeletedDigit(simulator.getBarcode()));
        System.out.println(simulator.getBarcodeWithDeletedDigit(simulator.getBarcode()));
        System.out.println(simulator.getBarcodeWithDeletedDigit(simulator.getBarcode()));
        System.out.println(simulator.getBarcodeWithDeletedDigit(simulator.getBarcode()));
        System.out.println(simulator.getBarcodeWithDeletedDigit(simulator.getBarcode()));
        System.out.println(simulator.getBarcodeWithDeletedDigit(simulator.getBarcode()));
        System.out.println(simulator.getBarcodeWithDeletedDigit(simulator.getBarcode()));
        System.out.println(simulator.getBarcodeWithDeletedDigit(simulator.getBarcode()));
        System.out.println(simulator.getBarcodeWithDeletedDigit(simulator.getBarcode()));
        System.out.println(simulator.getBarcodeWithDeletedDigit(simulator.getBarcode()));
        System.out.println(simulator.getBarcodeWithDeletedDigit(simulator.getBarcode()));
    }
}
