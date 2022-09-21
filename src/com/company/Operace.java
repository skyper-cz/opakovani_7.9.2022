package com.company;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Operace {

    JTable tabulka = new JTable(new DefaultTableModel(generatorLidí(8, 8), new String[]{"Jméno", "Věk"}));
    JTextField imput = new JTextField();
     JButton addRow = new JButton("Add a row");
    JButton filter = new JButton("Filtrovat");
    JFrame fr = new JFrame("Tabulka");

    public void operace() {
        fr.setSize(600, 500);
        fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fr.setLayout(null);
        fr.setResizable(false);

        prepare(tabulka);
        tabulka.setBounds(1, 100, 582, 358);
        tabulka.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        tabulka.setDefaultRenderer(Object.class, new Tucnost());

        prepare(imput);
        imput.setBounds(50, 12, 440, 20);

        addRow.setBounds(300, 44, 175, 25);
        addRow.addActionListener(this::AddButton);
        prepare(addRow);

        filter.setBounds(495, 12, 20, 20);
        filter.addActionListener(this::FilterButton);
        prepare(filter);


        fr.setVisible(true);
    }
    public void FilterButton(ActionEvent e) {
            tabulka.clearSelection();
            for (int x = 0; x < tabulka.getColumnCount(); x++){
                for (int y = 0; y < tabulka.getRowCount();y++){
                    if (tabulka.getValueAt(y, x).equals(imput.getText())){
                        tabulka.changeSelection(y, x, true, false);
                    }
                }
            }

        fr.update(fr.getGraphics());
    }
    
    public void AddButton(ActionEvent e){
        DefaultTableModel lordAndSaviorDefaultTableModel = (DefaultTableModel) tabulka.getModel();
        lordAndSaviorDefaultTableModel.addRow(generatorLidí(8));
    }

    public void prepare(JComponent o) {
        o.setVisible(true);
        fr.add(o);
    }

    String[][] generatorLidí(int wordSize, int arraySize) {
        String[][] out = new String[arraySize][2];
        out[0] = new String[]{"Jméno", "Věk"};

        for (int i = 1; i < out.length; i++) {
            StringBuilder borek = new StringBuilder();
            borek.append((char) (Math.random() * (90 - 65) + 65));
            for (int j = 0; j < wordSize; j++) {
                borek.append((char) (Math.random() * (122 - 97) + 97));
            }
            out[i][1] = String.valueOf((int) (Math.random() * 120));
            out[i][0] = borek.toString();
        }
        return out;
    }

    // Jenom na jeden entry
    public Object[] generatorLidí(int wordSize) {
        String[] out = new String[2];
        StringBuilder borek = new StringBuilder();
        borek.append((char) (Math.random() * (90 - 65) + 65));
        for (int j = 0; j < wordSize; j++) {
            borek.append((char) (Math.random() * (122 - 97) + 97));
        }
        out[1] = String.valueOf((int) (Math.random() * 120));
        out[0] = borek.toString();

        return out;
    }
}