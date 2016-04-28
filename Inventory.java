/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc340project;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

/**
 *
 * @author Michael & jonathan
 */
public class Inventory extends JFrame implements Observer {

    private JTable table;
    //q = quantity  h = helmet
    public static int qh1 = 10;
    public static int qh2 = 10;
    public static int qh3 = 10;
    public static int qh4 = 10;
    public static int qh5 = 10;
    //q = quantity  b = body
    public static int qb1 = 10;
    public static int qb2 = 10;
    public static int qb3 = 10;
    public static int qb4 = 10;
    public static int qb5 = 10;
    //q = quantity  l = legs
    public static int ql1 = 10;
    public static int ql2 = 10;
    public static int ql3 = 10;
    public static int ql4 = 10;
    public static int ql5 = 10;
    //q = quantity  sh = shield
    public static int qsh1 = 10;
    public static int qsh2 = 10;
    public static int qsh3 = 10;
    public static int qsh4 = 10;
    public static int qsh5 = 10;
    //q = quantity  sw = sword
    public static int qsw1 = 10;
    public static int qsw2 = 10;
    public static int qsw3 = 10;
    public static int qsw4 = 10;
    public static int qsw5 = 10;

    public Inventory() {

        String[] titles = {"Item", "Quantity", "Price", "Order Price"};
        Object[][] data = {
            {"Helmet1", qh1, new Integer(150), new Integer(50)},
            {"Helmet2", qh2, new Integer(400), new Integer(300)},
            {"Helmet3", qh3, new Integer(900), new Integer(800)},
            {"Helmet4", qh4, new Integer(1900), new Integer(1800)},
            {"Helmet5", qh5, new Integer(3900), new Integer(3800)},
            {"Body1", qb1, new Integer(400), new Integer(300)},
            {"Body2", qb2, new Integer(1000), new Integer(900)},
            {"Body3", qb3, new Integer(2200), new Integer(2100)},
            {"Body4", qb4, new Integer(4600), new Integer(4500)},
            {"Body5", qb5, new Integer(9400), new Integer(9300)},
            {"Legs1", ql1, new Integer(300), new Integer(200)},
            {"Legs2", ql2, new Integer(700), new Integer(600)},
            {"Legs3", ql3, new Integer(1500), new Integer(1400)},
            {"Legs4", ql4, new Integer(3100), new Integer(3000)},
            {"Legs5", ql5, new Integer(6200), new Integer(6100)},
            {"Shield1", qsh1, new Integer(200), new Integer(100)},
            {"Shield2", qsh2, new Integer(400), new Integer(300)},
            {"Shield3", qsh3, new Integer(600), new Integer(500)},
            {"Shield4", qsh4, new Integer(1200), new Integer(1100)},
            {"Shield5", qsh5, new Integer(2400), new Integer(2300)},
            {"Sword1", qsw1, new Integer(250), new Integer(150)},
            {"Sword2", qsw2, new Integer(500), new Integer(400)},
            {"Sword3", qsw3, new Integer(1000), new Integer(900)},
            {"Sword4", qsw4, new Integer(2000), new Integer(1900)},
            {"Sword5", qsw5, new Integer(4000), new Integer(3900)}};
        
        setTitle("Inventory");
        SpringLayout layout = new SpringLayout();
        Container pane = getContentPane();
        pane.setLayout(layout);

        DefaultTableModel model = new DefaultTableModel(data, titles) {

            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }

        };

        table = new JTable(model);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scroll = new JScrollPane(table);
        add(scroll);
        pack();
        setVisible(true);
        setSize(600, 600);

    }

    @Override
    public void update(Observable o, Object o1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
