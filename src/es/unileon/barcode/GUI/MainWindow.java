/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unileon.barcode.GUI;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Gonzalo
 */
public class MainWindow extends JFrame{
    
    private BorderLayout borderLayout;
    
    private JMenuBar menuBar;
    private JMenu dataMenu;
    private JMenuItem setPercentage;
    private JMenuItem setBarcodeLength;
    
    private JPanel textPanel;
    private JTextField barcode;
    
    private JPanel buttonPanel;
    private JButton generateValidBarcode;
    private JButton generateBarcodeDeletedDigit;
    private JButton generateBarcodeChangedDigit;
    
    public MainWindow(){
        this.setSize(700, 500);
        this.setVisible(true);
        borderLayout = new BorderLayout();
        this.setLayout(borderLayout);
        menuBar = new JMenuBar();
        this.add(menuBar, BorderLayout.NORTH);
        dataMenu = new JMenu("Datos");
        menuBar.add(dataMenu);
        setPercentage = new JMenuItem("Probabilidad de error");
        dataMenu.add(setPercentage);
        setBarcodeLength = new JMenuItem("Longitud");
        dataMenu.add(setBarcodeLength);
        
        textPanel = new JPanel();
        textPanel.setLayout(new GridBagLayout());
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        
        this.add(textPanel, BorderLayout.WEST);
        this.add(buttonPanel, BorderLayout.EAST);
        
        barcode = new JTextField();
        barcode.setText(this.getHeight() + "X" + this.getWidth());
        textPanel.add(barcode);
    }
    
}
