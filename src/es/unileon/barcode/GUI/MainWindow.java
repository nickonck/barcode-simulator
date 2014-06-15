/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.barcode.GUI;

import es.unileon.barcode.BarcodeEAN;
import es.unileon.barcode.Simulator;
import es.unileon.barcode.exception.InvalidBarcodeException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Gonzalo
 */
public class MainWindow extends JFrame {

    private JFrame currentFrame;

    private BorderLayout borderLayout;

    private final JMenuBar menuBar;
    private final JMenu dataMenu;
    private final JMenuItem setPercentage;

    private JLabel iconGenerated;
    private JLabel iconResult;

    private JLabel deletedDigit;

    private final JPanel textPanel;
    private JTextField barcodeGenerated;
    private JTextField barcodeResult;

    private final JPanel buttonPanel;
    private final JButton generateValidBarcode;
    private final JButton generateBarcodeDeletedDigit;
    private final JButton generateBarcodeChangedDigit;
    private final JButton checkButton;

    private final ImageIcon iconCorrect;
    private final ImageIcon iconIncorrect;
    private final ImageIcon iconEmpty;
    
    private int percentage ;

    private final Simulator simulator = new Simulator();
    private final BarcodeEAN barcodeEan = new BarcodeEAN();

    public MainWindow() {
        this.setTitle("BARCODE SIMULATOR");
        currentFrame = this;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        borderLayout = new BorderLayout();
        this.getContentPane().setLayout(borderLayout);
        deletedDigit = new JLabel();

        //MENU
        menuBar = new JMenuBar();
        this.getContentPane().add(menuBar, BorderLayout.NORTH);
        dataMenu = new JMenu("Datos");
        menuBar.add(dataMenu);
        setPercentage = new JMenuItem("Probabilidad de error");
        dataMenu.add(setPercentage);
       

        //Panel de los codigos de barras
        textPanel = new JPanel();
        textPanel.setBackground(Color.white);
        textPanel.setLayout(new GridBagLayout());

        //Panel de los botones
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.white);
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints constsLeft = new GridBagConstraints();
        GridBagConstraints constsRight = new GridBagConstraints();

        //Situacion de los paneles
        constsLeft.gridwidth = GridBagConstraints.REMAINDER;
        constsLeft.fill = GridBagConstraints.HORIZONTAL;
        constsLeft.anchor = GridBagConstraints.CENTER;
        this.getContentPane().add(textPanel, BorderLayout.CENTER);
        this.getContentPane().add(buttonPanel, BorderLayout.EAST);

        //IMAGENES
        iconCorrect = new ImageIcon("images/correcto.png");
        iconIncorrect = new ImageIcon("images/incorrecto.png");
        iconEmpty = new ImageIcon("images/empty.png");

        File file = new File("images/correcto.png");
        System.out.println(file.exists());
        iconGenerated = new JLabel(iconEmpty);
        iconResult = new JLabel(iconEmpty);

        //PANEL IZQUIERDA
        //Cuadro barcode
        constsLeft.gridwidth = GridBagConstraints.RELATIVE;
        constsLeft.insets = new Insets(10, 30, 10, 0);
        constsLeft.fill = GridBagConstraints.HORIZONTAL;
        constsLeft.ipadx = 100;
        constsLeft.ipady = 20;
        constsLeft.gridx = 2;
        constsLeft.gridy = 0;
        barcodeGenerated = new JTextField("barcode");
        barcodeGenerated.setEditable(false);
        barcodeGenerated.setHorizontalAlignment(JTextField.CENTER);
        barcodeGenerated.setBackground(new Color(235, 237, 237));

        textPanel.add(barcodeGenerated, constsLeft);

        constsLeft.gridwidth = GridBagConstraints.REMAINDER;
        constsLeft.fill = GridBagConstraints.NONE;
        constsLeft.gridx = 3;
        constsLeft.gridy = 0;
        textPanel.add(iconGenerated, constsLeft);

        constsLeft.gridwidth = GridBagConstraints.RELATIVE;
        barcodeResult = new JTextField("result");
        barcodeResult.setEditable(false);
        barcodeResult.setHorizontalAlignment(JTextField.CENTER);
        barcodeResult.setBackground(new Color(235, 237, 237));
        constsLeft.gridx = 2;
        constsLeft.gridy = 1;
        constsLeft.fill = GridBagConstraints.HORIZONTAL;
        constsLeft.ipadx = 200;

        textPanel.add(barcodeResult, constsLeft);

        constsLeft.gridwidth = GridBagConstraints.REMAINDER;
        constsLeft.fill = GridBagConstraints.NONE;
        constsLeft.ipadx = 10;
        constsLeft.gridx = 3;
        constsLeft.gridy = 1;
        textPanel.add(iconResult, constsLeft);

        constsLeft.gridx = 2;
        constsLeft.gridy = 2;
        textPanel.add(deletedDigit, constsLeft);

        //PANEL DERECHA: BOTONES
        generateBarcodeChangedDigit = new JButton("Intercambio de digitos");
        generateBarcodeDeletedDigit = new JButton("Borron");
        generateValidBarcode = new JButton("Codigo de barras valido");
        checkButton = new JButton("Test");
        constsRight.ipadx = 80;
        constsRight.ipady = 5;
        constsRight.insets = new Insets(10, 20, 10, 20);
        constsRight.gridwidth = GridBagConstraints.REMAINDER;

        
        buttonPanel.add(generateValidBarcode, constsRight);

        buttonPanel.add(generateBarcodeChangedDigit, constsRight);
       
        buttonPanel.add(generateBarcodeDeletedDigit, constsRight);
       
        buttonPanel.add(checkButton, constsRight);

        //CODIGO DE BARRAS VALIDO
        generateValidBarcode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkButton.setEnabled(true);
                barcodeGenerated.setText(simulator.getBarcode());
                System.out.println("texto añadido");
                iconGenerated.setIcon(iconEmpty);
                iconResult.setIcon(iconEmpty);
                barcodeGenerated.setEditable(false);
                barcodeResult.setVisible(false);
                deletedDigit.setText(" ");
                currentFrame.validate();
            }
        });

        //CODIGO DE BARRAS CON BORRON
        generateBarcodeDeletedDigit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkButton.setEnabled(true);
                iconGenerated.setIcon(iconEmpty);
                iconResult.setIcon(iconEmpty);
                barcodeResult.setVisible(true);

                deletedDigit.setText(" ");
                barcodeResult.setText("");
                String originalBarcode = simulator.getBarcode();
                barcodeGenerated.setText(simulator.getBarcodeWithDeletedDigit(originalBarcode));
                currentFrame.validate();

            }
        });

        //CODIGO DE BARRAS INTERCAMBIO DE DIGITOS
        generateBarcodeChangedDigit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                                checkButton.setEnabled(true);

                deletedDigit.setText(" ");
                iconGenerated.setIcon(iconEmpty);
                iconResult.setIcon(iconEmpty);
                barcodeResult.setVisible(true);
                String barcode = simulator.getBarcode();
                barcodeGenerated.setText(barcode);
                barcodeGenerated.setEditable(false);
                barcodeResult.setText(simulator.getBarcodeWithChangedDigit(barcode));
                currentFrame.validate();
            }
        });

        checkButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                checkButton.setEnabled(false);
                try {
                    if (barcodeEan.isSecuenceValid(barcodeGenerated.getText())) {
                        System.out.println("Es correcto");
                        iconGenerated.setIcon(iconCorrect);

                    } else {
                        System.out.println("No es correcto");
                        iconGenerated.setIcon(iconIncorrect);
                    }

                } catch (InvalidBarcodeException ex) {
                    iconGenerated.setIcon(iconIncorrect);
                }

                if (barcodeResult.isVisible() && (barcodeResult.getText().compareTo("") == 0)) {
                    barcodeResult.setVisible(true);
                    StringBuilder barcode = new StringBuilder(barcodeGenerated.getText());
                    try {
                        barcode.setCharAt(barcodeEan.getDeletedPosition(barcodeGenerated.getText()), barcodeEan.calculateDeletedDigit(barcodeGenerated.getText()));
                        barcodeResult.setText(barcode.toString());
                        System.out.println("El borrado esta solucionado");
                        deletedDigit.setText("El numero borrado era: " + String.valueOf(barcodeEan.calculateDeletedDigit(barcodeGenerated.getText())));

                         try {
                        if (barcodeEan.isSecuenceValid(barcodeResult.getText())) {
                            iconResult.setIcon(iconCorrect);
                        } else {
                            iconResult.setIcon(iconIncorrect);
                        }
                    } catch (InvalidBarcodeException ex) {
                        iconResult.setIcon(iconIncorrect);
                    }
                    } catch (InvalidBarcodeException ex) {
                        barcodeResult.setText("No se puede resolver");
                        iconResult.setIcon(iconEmpty);
                    }
                    
                   
                }else if(barcodeResult.isVisible()){
                try {
                        if (barcodeEan.isSecuenceValid(barcodeResult.getText())) {
                            iconResult.setIcon(iconCorrect);
                        } else {
                            iconResult.setIcon(iconIncorrect);
                        }
                    } catch (InvalidBarcodeException ex) {
                        iconResult.setIcon(iconIncorrect);
                    }
                }
                currentFrame.validate();
            }
        }
        );
        
        
        setPercentage.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            
                String percent = JOptionPane.showInputDialog("Ingrese un porcentaje");
               try { 
                    percentage = Integer.parseInt(percent);
                    if(percentage >=0 && percentage <= 100){
                        simulator.setErrorProbability(percentage);
                    }else{
                        JOptionPane.showMessageDialog (null, "Por favor, introduce un valor entre 0 y 100", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch(NumberFormatException ex){  
                    JOptionPane.showMessageDialog (null, "El valor introducido no es valido", "Error", JOptionPane.ERROR_MESSAGE); 
                } 
                percentage = Integer.parseInt(percent);      
            }
        });

        this.setSize(700, 500);

        this.setVisible(
                true);
    }

}
