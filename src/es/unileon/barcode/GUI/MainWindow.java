/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unileon.barcode.GUI;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
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
    private JTextField barcodeGenerated;
    private JTextField barcodeResult;
    
    private JPanel buttonPanel;
    private JButton generateValidBarcode;
    private JButton generateBarcodeDeletedDigit;
    private JButton generateBarcodeChangedDigit;
    
    public MainWindow(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 500);
        this.setVisible(true);
        borderLayout = new BorderLayout();
        this.getContentPane().setLayout(borderLayout);
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
        GridBagConstraints consts = new GridBagConstraints();
        
        consts.gridwidth=GridBagConstraints.REMAINDER;
        consts.fill=GridBagConstraints.HORIZONTAL;
        consts.anchor=GridBagConstraints.CENTER;
        this.getContentPane().add(textPanel, BorderLayout.WEST);
        this.getContentPane().add(buttonPanel, BorderLayout.EAST);
        
        barcodeGenerated = new JTextField("barcode");
        textPanel.add(barcodeGenerated,consts);
        consts.gridwidth=GridBagConstraints.RELATIVE;
        barcodeResult = new JTextField("result");
        textPanel.add(barcodeResult,consts);
    }
    
}
