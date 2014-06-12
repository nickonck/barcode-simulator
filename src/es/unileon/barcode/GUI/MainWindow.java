/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unileon.barcode.GUI;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

/**
 *
 * @author Gonzalo
 */
public class MainWindow extends JFrame{
    
    private JTextField barcode;
    
    private JButton generateValidBarcode;
    private JButton generateBarcodeDeletedDigit;
    private JButton generateBarcodeChangedDigit;
    
    private BorderLayout borderLayout;
    
    private JMenuBar menuBar;
    private JMenu dataMenu;
    private JMenuItem setBarcode;
    
    public MainWindow(){
        this.setSize(700, 500);
        this.setVisible(true);
        borderLayout = new BorderLayout();
        this.setLayout(borderLayout);
        menuBar = new JMenuBar();
        this.add(menuBar, BorderLayout.NORTH);
        dataMenu = new JMenu("Data");
        menuBar.add(dataMenu);
        setBarcode = new JMenuItem("Set Barcode");
        dataMenu.add(setBarcode);
        
        JTextField text = new JTextField();
        text.setText(this.getHeight() + "X" + this.getWidth());
        this.add(text);
    }
    
}
