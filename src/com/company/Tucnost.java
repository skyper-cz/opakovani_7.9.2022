package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class Tucnost extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (row == 0) {
            Map<TextAttribute, Object> Hashmap = new HashMap<>();
            Hashmap.put(TextAttribute.FAMILY, Font.DIALOG);
            Hashmap.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_HEAVY);
            Hashmap.put(TextAttribute.SIZE, 12);
            l.setFont(Font.getFont(Hashmap));
        } else
            l.getFont().deriveFont(Font.PLAIN);
        return l;
    }
}