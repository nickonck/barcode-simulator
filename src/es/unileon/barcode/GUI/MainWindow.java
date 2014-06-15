/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.barcode.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Gonzalo
 */
public class MainWindow extends JFrame {

    private BorderLayout borderLayout;

    private JMenuBar menuBar;
    private JMenu dataMenu;
    private JMenuItem setPercentage;
    private JMenuItem setBarcodeLength;

    private JLabel correct;
    private JLabel incorrect;
    private JLabel empty;

    private JPanel textPanel;
    private JTextField barcodeGenerated;
    private JTextField barcodeResult;

    private JPanel buttonPanel;
    private JButton generateValidBarcode;
    private JButton generateBarcodeDeletedDigit;
    private JButton generateBarcodeChangedDigit;
    private JButton checkButton;

    public MainWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        borderLayout = new BorderLayout();
        this.getContentPane().setLayout(borderLayout);

        //MENU
        menuBar = new JMenuBar();
        this.getContentPane().add(menuBar, BorderLayout.NORTH);
        dataMenu = new JMenu("Datos");
        menuBar.add(dataMenu);
        setPercentage = new JMenuItem("Probabilidad de error");
        dataMenu.add(setPercentage);
        setBarcodeLength = new JMenuItem("Longitud");
        dataMenu.add(setBarcodeLength);

        //Panel de los codigos de barras
        textPanel = new JPanel();
        textPanel.setBackground(Color.white);
        textPanel.setLayout(new GridBagLayout());

        //Panel de los botones
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.white);
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints consts = new GridBagConstraints();

        //Situacion de los paneles
        consts.gridwidth = GridBagConstraints.REMAINDER;
        consts.fill = GridBagConstraints.HORIZONTAL;
        consts.anchor = GridBagConstraints.CENTER;
        this.getContentPane().add(textPanel, BorderLayout.CENTER);
        this.getContentPane().add(buttonPanel, BorderLayout.EAST);

        //IMAGENES
        ImageIcon iconCorrect = new ImageIcon("images/correcto.png");
        ImageIcon iconIncorrect = new ImageIcon("images/incorrecto.png");
        ImageIcon iconVoid = new ImageIcon();
        correct = new JLabel(iconCorrect);
        incorrect = new JLabel(iconIncorrect);
        empty = new JLabel(iconVoid);

        //PANEL IZQUIERDA
        consts.gridwidth = GridBagConstraints.RELATIVE;
        consts.insets = new Insets(10, 0, 10, 0);
        consts.fill = GridBagConstraints.HORIZONTAL;
        consts.ipadx = 200;
        consts.ipady = 20;
        barcodeGenerated = new JTextField("barcode");
        barcodeGenerated.setHorizontalAlignment(JTextField.CENTER);
        barcodeGenerated.setBackground(new Color(235, 237, 237));
        textPanel.add(barcodeGenerated, consts);
       
        consts.gridwidth = GridBagConstraints.REMAINDER;
        consts.fill = GridBagConstraints.NONE;
        consts.ipadx = 10;
        textPanel.add(correct, consts);

        consts.gridwidth = GridBagConstraints.RELATIVE;
        barcodeResult = new JTextField("result");
        barcodeResult.setHorizontalAlignment(JTextField.CENTER);
        barcodeResult.setBackground(new Color(235, 237, 237));

        consts.fill = GridBagConstraints.HORIZONTAL;
        consts.ipadx = 200;
        textPanel.add(barcodeResult, consts);
        consts.gridwidth = GridBagConstraints.REMAINDER;
        consts.fill = GridBagConstraints.NONE;
        consts.ipadx = 10;
        textPanel.add(incorrect, consts);

        //PANEL DERECHA: BOTONES
        generateBarcodeChangedDigit = new JButton("Intercambio de digitos");
        generateBarcodeDeletedDigit = new JButton("Borron");
        generateValidBarcode = new JButton("Codigo de barras valido");
        checkButton = new JButton("Test");
        consts.ipadx = 80;
        consts.ipady = 5;
        consts.insets = new Insets(10, 20, 10, 20);
        consts.gridwidth = GridBagConstraints.RELATIVE;

        consts.gridx = 2;
        consts.gridy = 0;
        buttonPanel.add(generateValidBarcode, consts);

        consts.gridwidth = GridBagConstraints.RELATIVE;
        consts.gridx = 2;
        consts.gridy = 1;
        buttonPanel.add(generateBarcodeChangedDigit, consts);
        consts.gridwidth = GridBagConstraints.RELATIVE;
        consts.gridx = 2;
        consts.gridy = 2;
        buttonPanel.add(generateBarcodeDeletedDigit, consts);
        consts.gridwidth = GridBagConstraints.RELATIVE;
        consts.gridx = 2;
        consts.gridy = 3;
        buttonPanel.add(checkButton, consts);

        this.setSize(700, 500);
        this.setVisible(true);
    }

}
