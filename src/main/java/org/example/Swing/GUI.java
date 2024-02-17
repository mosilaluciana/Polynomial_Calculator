package org.example.Swing;

import org.example.Model.Polinom;
import org.example.Model.Polinom;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame  {
    private JFrame frame;
    private JTextField fieldPolinom1, fieldPolinom2, fieldPolinomRez;
    private JButton addButton, subButton,mulButton,divButton,derButton,intButton;

    private Polinom Polinom1;
    private Polinom Polinom2;
    private Polinom PolinomRezultat;
    private Polinom PolinomRezultat2;

    public GUI() {


        frame = new JFrame("Calculator de polinoame");
        fieldPolinom1 = new JTextField(20);
        fieldPolinom2 = new JTextField(20);
        fieldPolinomRez = new JTextField(20);

        addButton = new JButton("Adunare");
        subButton = new JButton("Scadere");
        mulButton = new JButton("Inmultire");
        divButton = new JButton("Impartire");
        derButton = new JButton("Derivare");
        intButton = new JButton("Integrare");

        JPanel panel = new JPanel();
        panel.add(new JLabel("Introduceti polinomul 1:"));
        panel.add(fieldPolinom1);
        panel.add(new JLabel("Introduceti polinomul 2:"));
        panel.add(fieldPolinom2);
        panel.add(new JLabel("Rezultat:"));
        panel.add(fieldPolinomRez);
        panel.add(addButton);
        panel.add(subButton);
        panel.add(mulButton);
        panel.add(divButton);
        panel.add(derButton);
        panel.add(intButton);
        frame.add(panel);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(250, 300);
        frame.setLocation(700, 300);
        // fieldPolinomRez.setEnabled(false);


        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Polinom1 = new Polinom(fieldPolinom1.getText());
                Polinom2 = new Polinom(fieldPolinom2.getText());

                Polinom1.PolinomStringToMap();
                Polinom2.PolinomStringToMap();

                PolinomRezultat = new Polinom(Polinom1.ADUNARE(Polinom2));
                PolinomRezultat.MapToString();
                fieldPolinomRez.setText(PolinomRezultat.getString());
            }
        });


        subButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Polinom1 = new Polinom(fieldPolinom1.getText());
                Polinom2 = new Polinom(fieldPolinom2.getText());

                Polinom1.PolinomStringToMap();
                Polinom2.PolinomStringToMap();

                PolinomRezultat = new Polinom(Polinom1.SCADERE(Polinom2));
                PolinomRezultat.MapToString();
                fieldPolinomRez.setText(PolinomRezultat.getString());
            }
        });

        mulButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Polinom1 = new Polinom(fieldPolinom1.getText());
                Polinom2 = new Polinom(fieldPolinom2.getText());

                Polinom1.PolinomStringToMap();
                Polinom2.PolinomStringToMap();

                PolinomRezultat = new Polinom(Polinom1.INMULTIRE(Polinom2));
                PolinomRezultat.MapToString();
                fieldPolinomRez.setText(PolinomRezultat.getString());
            }
        });

        derButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                if (!fieldPolinom1.getText().isEmpty() && fieldPolinom2.getText().isEmpty()) {
                    Polinom1 = new Polinom(fieldPolinom1.getText());
                    Polinom1.PolinomStringToMap();
                    PolinomRezultat = new Polinom(Polinom1.DERIVARE());
                    PolinomRezultat.MapToString();
                    fieldPolinomRez.setText(PolinomRezultat.getString());
                } else if (!fieldPolinom2.getText().isEmpty() && fieldPolinom1.getText().isEmpty()){
                    Polinom2 = new Polinom(fieldPolinom2.getText());
                    Polinom2.PolinomStringToMap();
                    PolinomRezultat = new Polinom(Polinom2.DERIVARE());
                    PolinomRezultat.MapToString();
                    fieldPolinomRez.setText(PolinomRezultat.getString());
                }else
                {   Polinom1 = new Polinom(fieldPolinom1.getText());
                    Polinom1.PolinomStringToMap();
                    PolinomRezultat = new Polinom(Polinom1.DERIVARE());
                    Polinom2 = new Polinom(fieldPolinom2.getText());
                    Polinom2.PolinomStringToMap();
                    PolinomRezultat2 = new Polinom(Polinom2.DERIVARE());
                    PolinomRezultat.MapToString();
                    PolinomRezultat2.MapToString();
                    fieldPolinomRez.setText(PolinomRezultat.getString()+" | "+PolinomRezultat2.getString());
                }

            }
        });


        intButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                if (!fieldPolinom1.getText().isEmpty() && fieldPolinom2.getText().isEmpty()) {
                    Polinom1 = new Polinom(fieldPolinom1.getText());
                    Polinom1.PolinomStringToMap();
                    PolinomRezultat = new Polinom(Polinom1.INTEGRARE());
                    PolinomRezultat.MapToString();
                    fieldPolinomRez.setText(PolinomRezultat.getString());
                } else if (!fieldPolinom2.getText().isEmpty() && fieldPolinom1.getText().isEmpty()){
                    Polinom2 = new Polinom(fieldPolinom2.getText());
                    Polinom2.PolinomStringToMap();
                    PolinomRezultat = new Polinom(Polinom2.INTEGRARE());
                    PolinomRezultat.MapToString();
                    fieldPolinomRez.setText(PolinomRezultat.getString());
                }else
                {   Polinom1 = new Polinom(fieldPolinom1.getText());
                    Polinom1.PolinomStringToMap();
                    PolinomRezultat = new Polinom(Polinom1.INTEGRARE());
                    Polinom2 = new Polinom(fieldPolinom2.getText());
                    Polinom2.PolinomStringToMap();
                    PolinomRezultat2 = new Polinom(Polinom2.INTEGRARE());
                    PolinomRezultat.MapToString();
                    PolinomRezultat2.MapToString();
                    fieldPolinomRez.setText(PolinomRezultat.getString()+" | "+PolinomRezultat2.getString());
                }

            }
        });



    }

}


