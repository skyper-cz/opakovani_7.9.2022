package com.company;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Operace {

    JTable tabulka = new JTable(new DefaultTableModel(prvniRadek(), new String[]{"Jméno", "Věk"}));

    String[] jmena = new String[10];
    String[] vek = new String[10];
    JTextField vlozeneJmeno = new JTextField();
    JTextField vlozenyVek = new JTextField();
    JTextField hledaneJmeno = new JTextField();
    JTextField hledanyVek = new JTextField();
     JButton addRow = new JButton("Add a row");
    JButton filter = new JButton("Filtrovat");
    JFrame fr = new JFrame("Tabulka");

    public void operace() {
        fr.setBounds(100,200,600, 500);
        fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fr.setLayout(null);
        fr.setResizable(false);

        tabulka.setBounds(1, 100, 582, 358);
        tabulka.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        tabulka.setDefaultRenderer(Object.class, new Tucnost());
        fr.add(tabulka);

        vlozeneJmeno.setBounds(10, 10, 100, 50);
        vlozeneJmeno.setVisible(true);
        fr.add(vlozeneJmeno);

        vlozenyVek.setBounds(10, 70, 100, 50);
        vlozenyVek.setVisible(true);
        fr.add(vlozenyVek);

        hledaneJmeno.setBounds(120, 10, 100, 50);
        hledaneJmeno.setVisible(true);
        fr.add(hledaneJmeno);

        hledanyVek.setBounds(120, 70, 100, 50);
        hledanyVek.setVisible(true);
        fr.add(hledanyVek);

        addRow.setBounds(300, 44, 175, 25);
        addRow.addActionListener(this::AddButton);
        fr.add(addRow);

        filter.setBounds(495, 12, 20, 20);
        filter.addActionListener(this::FilterButton);
        fr.add(filter);


        fr.setVisible(true);
    }
    public void FilterButton(ActionEvent e) {
            tabulka.clearSelection();
            for (int x = 0; x < tabulka.getColumnCount(); x++){
                for (int y = 0; y < tabulka.getRowCount();y++){
                    if (tabulka.getValueAt(y, x).equals(hledaneJmeno.getText())){
                        tabulka.changeSelection(y, x, true, false);
                    }
                }
            }

        fr.update(fr.getGraphics());
    }
    
    public void AddButton(ActionEvent e){
        DefaultTableModel aktualizace = (DefaultTableModel) tabulka.getModel();
        String jmeno = String.valueOf(vlozeneJmeno);
        String vek = String.valueOf(vlozenyVek);
        //aktualizace.addRow(jmeno, vek);
    }

    String[][] prvniRadek() {
        String[][] out = new String[1][1];
        out[0] = new String[]{"Jméno", "Věk"};
        return out;
    }

}