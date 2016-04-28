/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc340project;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

/**
 *
 * @author Michael & Jonathan
 */
public class OrderInventory extends JFrame implements Observer {

    /*
     private Button clear = new Button("Clear");
     private Button addcart = new Button("Add to order");
     private Button back = new Button("Back");
     private Button checkout = new Button("Confirm order");
     */
    private static final int WIDTH = 750;
    private static final int HEIGHT = 350;
    private static int totalSales = 0;

    private JLabel totalSaleL, totalGoldL;
    private JLabel cashStackL, cashTotalL;
    private JButton order, reset;
    private JButton helm1B, helm2B, helm3B, helm4B, helm5B;
    private JButton body1B, body2B, body3B, body4B, body5B;
    private JButton legs1B, legs2B, legs3B, legs4B, legs5B;
    private JButton shield1B, shield2B, shield3B, shield4B, shield5B;
    private JButton sword1B, sword2B, sword3B, sword4B, sword5B;
    private JList currentSale;
    private DefaultListModel list;
    private JScrollPane salesScroll;

    private OrderButtonHandler ordHandler;
    private ResetButtonHandler rstHandler;
    private Helm1ButtonHandler h1Handler;
    private Helm2ButtonHandler h2Handler;
    private Helm3ButtonHandler h3Handler;
    private Helm4ButtonHandler h4Handler;
    private Helm5ButtonHandler h5Handler;
    private Body1ButtonHandler b1Handler;
    private Body2ButtonHandler b2Handler;
    private Body3ButtonHandler b3Handler;
    private Body4ButtonHandler b4Handler;
    private Body5ButtonHandler b5Handler;
    private Legs1ButtonHandler l1Handler;
    private Legs2ButtonHandler l2Handler;
    private Legs3ButtonHandler l3Handler;
    private Legs4ButtonHandler l4Handler;
    private Legs5ButtonHandler l5Handler;
    private Shield1ButtonHandler sh1Handler;
    private Shield2ButtonHandler sh2Handler;
    private Shield3ButtonHandler sh3Handler;
    private Shield4ButtonHandler sh4Handler;
    private Shield5ButtonHandler sh5Handler;
    private Sword1ButtonHandler sw1Handler;
    private Sword2ButtonHandler sw2Handler;
    private Sword3ButtonHandler sw3Handler;
    private Sword4ButtonHandler sw4Handler;
    private Sword5ButtonHandler sw5Handler;

    public OrderInventory() {

        list = new DefaultListModel();

        totalGoldL = new JLabel("Order Total: ", SwingConstants.LEFT);
        totalSaleL = new JLabel(totalSales + "gp", SwingConstants.RIGHT);

        cashStackL = new JLabel("Cash Stack: ", SwingConstants.LEFT);
        cashTotalL = new JLabel(Inventory.cashStack + "gp", SwingConstants.LEFT);

        currentSale = new JList(list);
        currentSale.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        currentSale.setSelectedIndex(currentSale.getLastVisibleIndex());
        salesScroll = new JScrollPane(currentSale);

        order = new JButton("Order Items");
        order.setPreferredSize(new Dimension(200, 25));
        ordHandler = new OrderButtonHandler();
        order.addActionListener(ordHandler);

        reset = new JButton("Reset Order");
        reset.setPreferredSize(new Dimension(200, 25));
        rstHandler = new ResetButtonHandler();
        reset.addActionListener(rstHandler);

        helm1B = new JButton("Helm 1");
        helm1B.setPreferredSize(new Dimension(100, 50));
        h1Handler = new Helm1ButtonHandler();
        helm1B.addActionListener(h1Handler);

        helm2B = new JButton("Helm 2");
        helm2B.setPreferredSize(new Dimension(100, 50));
        h2Handler = new Helm2ButtonHandler();
        helm2B.addActionListener(h2Handler);

        helm3B = new JButton("Helm 3");
        helm3B.setPreferredSize(new Dimension(100, 50));
        h3Handler = new Helm3ButtonHandler();
        helm3B.addActionListener(h3Handler);

        helm4B = new JButton("Helm 4");
        helm4B.setPreferredSize(new Dimension(100, 50));
        h4Handler = new Helm4ButtonHandler();
        helm4B.addActionListener(h4Handler);

        helm5B = new JButton("Helm 5");
        helm5B.setPreferredSize(new Dimension(100, 50));
        h5Handler = new Helm5ButtonHandler();
        helm5B.addActionListener(h5Handler);

        body1B = new JButton("Body 1");
        body1B.setPreferredSize(new Dimension(100, 50));
        b1Handler = new Body1ButtonHandler();
        body1B.addActionListener(b1Handler);

        body2B = new JButton("Body 2");
        body2B.setPreferredSize(new Dimension(100, 50));
        b2Handler = new Body2ButtonHandler();
        body2B.addActionListener(b2Handler);

        body3B = new JButton("Body 3");
        body3B.setPreferredSize(new Dimension(100, 50));
        b3Handler = new Body3ButtonHandler();
        body3B.addActionListener(b3Handler);

        body4B = new JButton("Body 4");
        body4B.setPreferredSize(new Dimension(100, 50));
        b4Handler = new Body4ButtonHandler();
        body4B.addActionListener(b4Handler);

        body5B = new JButton("Body 5");
        body5B.setPreferredSize(new Dimension(100, 50));
        b5Handler = new Body5ButtonHandler();
        body5B.addActionListener(b5Handler);

        legs1B = new JButton("Legs 1");
        legs1B.setPreferredSize(new Dimension(100, 50));
        l1Handler = new Legs1ButtonHandler();
        legs1B.addActionListener(l1Handler);

        legs2B = new JButton("Legs 2");
        legs2B.setPreferredSize(new Dimension(100, 50));
        l2Handler = new Legs2ButtonHandler();
        legs2B.addActionListener(l2Handler);

        legs3B = new JButton("Legs 3");
        legs3B.setPreferredSize(new Dimension(100, 50));
        l3Handler = new Legs3ButtonHandler();
        legs3B.addActionListener(l3Handler);

        legs4B = new JButton("Legs 4");
        legs4B.setPreferredSize(new Dimension(100, 50));
        l4Handler = new Legs4ButtonHandler();
        legs4B.addActionListener(l4Handler);

        legs5B = new JButton("Legs 5");
        legs5B.setPreferredSize(new Dimension(100, 50));
        l5Handler = new Legs5ButtonHandler();
        legs5B.addActionListener(l5Handler);

        shield1B = new JButton("Shield 1");
        shield1B.setPreferredSize(new Dimension(100, 50));
        sh1Handler = new Shield1ButtonHandler();
        shield1B.addActionListener(sh1Handler);

        shield2B = new JButton("Shield 2");
        shield2B.setPreferredSize(new Dimension(100, 50));
        sh2Handler = new Shield2ButtonHandler();
        shield2B.addActionListener(sh2Handler);

        shield3B = new JButton("Shield 3");
        shield3B.setPreferredSize(new Dimension(100, 50));
        sh3Handler = new Shield3ButtonHandler();
        shield3B.addActionListener(sh3Handler);

        shield4B = new JButton("Shield 4");
        shield4B.setPreferredSize(new Dimension(100, 50));
        sh4Handler = new Shield4ButtonHandler();
        shield4B.addActionListener(sh4Handler);

        shield5B = new JButton("Shield 5");
        shield5B.setPreferredSize(new Dimension(100, 50));
        sh5Handler = new Shield5ButtonHandler();
        shield5B.addActionListener(sh5Handler);

        sword1B = new JButton("Sword 1");
        sword1B.setPreferredSize(new Dimension(100, 50));
        sw1Handler = new Sword1ButtonHandler();
        sword1B.addActionListener(sw1Handler);

        sword2B = new JButton("Sword 2");
        sword2B.setPreferredSize(new Dimension(100, 50));
        sw2Handler = new Sword2ButtonHandler();
        sword2B.addActionListener(sw2Handler);

        sword3B = new JButton("Sword 3");
        sword3B.setPreferredSize(new Dimension(100, 50));
        sw3Handler = new Sword3ButtonHandler();
        sword3B.addActionListener(sw3Handler);

        sword4B = new JButton("Sword 4");
        sword4B.setPreferredSize(new Dimension(100, 50));
        sw4Handler = new Sword4ButtonHandler();
        sword4B.addActionListener(sw4Handler);

        sword5B = new JButton("Sword 5");
        sword5B.setPreferredSize(new Dimension(100, 50));
        sw5Handler = new Sword5ButtonHandler();
        sword5B.addActionListener(sw5Handler);

        salesScroll.setPreferredSize(new Dimension(200, 250));

        setTitle("Order Inventory Menu");
        SpringLayout layout = new SpringLayout();
        Container pane = getContentPane();
        pane.setLayout(layout);

        pane.add(salesScroll);
        layout.putConstraint(SpringLayout.WEST, salesScroll, 525, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, salesScroll, 5, SpringLayout.NORTH, pane);

        pane.add(totalGoldL);
        layout.putConstraint(SpringLayout.WEST, totalGoldL, 525, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, totalGoldL, 265, SpringLayout.NORTH, pane);

        pane.add(cashStackL);
        layout.putConstraint(SpringLayout.WEST, cashStackL, 525, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, cashStackL, 285, SpringLayout.NORTH, pane);

        pane.add(totalSaleL);
        layout.putConstraint(SpringLayout.WEST, totalSaleL, 680, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, totalSaleL, 265, SpringLayout.NORTH, pane);

        pane.add(cashTotalL);
        layout.putConstraint(SpringLayout.WEST, cashTotalL, 680, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, cashTotalL, 285, SpringLayout.NORTH, pane);

        pane.add(helm1B);
        layout.putConstraint(SpringLayout.WEST, helm1B, 5, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, helm1B, 5, SpringLayout.NORTH, pane);

        pane.add(helm2B);
        layout.putConstraint(SpringLayout.WEST, helm2B, 105, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, helm2B, 5, SpringLayout.NORTH, pane);

        pane.add(helm3B);
        layout.putConstraint(SpringLayout.WEST, helm3B, 205, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, helm3B, 5, SpringLayout.NORTH, pane);

        pane.add(helm4B);
        layout.putConstraint(SpringLayout.WEST, helm4B, 305, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, helm4B, 5, SpringLayout.NORTH, pane);

        pane.add(helm5B);
        layout.putConstraint(SpringLayout.WEST, helm5B, 405, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, helm5B, 5, SpringLayout.NORTH, pane);

        pane.add(body1B);
        layout.putConstraint(SpringLayout.WEST, body1B, 5, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, body1B, 60, SpringLayout.NORTH, pane);

        pane.add(body2B);
        layout.putConstraint(SpringLayout.WEST, body2B, 105, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, body2B, 60, SpringLayout.NORTH, pane);

        pane.add(body3B);
        layout.putConstraint(SpringLayout.WEST, body3B, 205, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, body3B, 60, SpringLayout.NORTH, pane);

        pane.add(body4B);
        layout.putConstraint(SpringLayout.WEST, body4B, 305, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, body4B, 60, SpringLayout.NORTH, pane);

        pane.add(body5B);
        layout.putConstraint(SpringLayout.WEST, body5B, 405, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, body5B, 60, SpringLayout.NORTH, pane);

        pane.add(legs1B);
        layout.putConstraint(SpringLayout.WEST, legs1B, 5, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, legs1B, 115, SpringLayout.NORTH, pane);

        pane.add(legs2B);
        layout.putConstraint(SpringLayout.WEST, legs2B, 105, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, legs2B, 115, SpringLayout.NORTH, pane);

        pane.add(legs3B);
        layout.putConstraint(SpringLayout.WEST, legs3B, 205, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, legs3B, 115, SpringLayout.NORTH, pane);

        pane.add(legs4B);
        layout.putConstraint(SpringLayout.WEST, legs4B, 305, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, legs4B, 115, SpringLayout.NORTH, pane);

        pane.add(legs5B);
        layout.putConstraint(SpringLayout.WEST, legs5B, 405, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, legs5B, 115, SpringLayout.NORTH, pane);

        pane.add(shield1B);
        layout.putConstraint(SpringLayout.WEST, shield1B, 5, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, shield1B, 170, SpringLayout.NORTH, pane);

        pane.add(shield2B);
        layout.putConstraint(SpringLayout.WEST, shield2B, 105, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, shield2B, 170, SpringLayout.NORTH, pane);

        pane.add(shield3B);
        layout.putConstraint(SpringLayout.WEST, shield3B, 205, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, shield3B, 170, SpringLayout.NORTH, pane);

        pane.add(shield4B);
        layout.putConstraint(SpringLayout.WEST, shield4B, 305, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, shield4B, 170, SpringLayout.NORTH, pane);

        pane.add(shield5B);
        layout.putConstraint(SpringLayout.WEST, shield5B, 405, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, shield5B, 170, SpringLayout.NORTH, pane);

        pane.add(sword1B);
        layout.putConstraint(SpringLayout.WEST, sword1B, 5, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, sword1B, 225, SpringLayout.NORTH, pane);

        pane.add(sword2B);
        layout.putConstraint(SpringLayout.WEST, sword2B, 105, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, sword2B, 225, SpringLayout.NORTH, pane);

        pane.add(sword3B);
        layout.putConstraint(SpringLayout.WEST, sword3B, 205, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, sword3B, 225, SpringLayout.NORTH, pane);

        pane.add(sword4B);
        layout.putConstraint(SpringLayout.WEST, sword4B, 305, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, sword4B, 225, SpringLayout.NORTH, pane);

        pane.add(sword5B);
        layout.putConstraint(SpringLayout.WEST, sword5B, 405, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, sword5B, 225, SpringLayout.NORTH, pane);

        pane.add(order);
        layout.putConstraint(SpringLayout.WEST, order, 5, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, order, 280, SpringLayout.NORTH, pane);

        pane.add(reset);
        layout.putConstraint(SpringLayout.WEST, reset, 305, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, reset, 280, SpringLayout.NORTH, pane);

        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);

        //PREVIOUS CODE, TESTING NEW LAYOUT ABOVE
        /*
         super("Order Inventory:");
         setSize(600, 600);
         setVisible(true);
         setLayout(new BorderLayout(5, 5));
         Panel bottom = new Panel();
         add(bottom, BorderLayout.SOUTH);
         bottom.setLayout(new GridLayout(4, 2, 5, 5));
         //bottom.add(new Label(""));
         //bottom.add(new Label(""));
         bottom.add(this.addcart);        
         bottom.add(this.clear);
         bottom.add(this.checkout);       
         bottom.add(this.back);
         //allows you to press x to close the window 
         addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent we) {
         System.exit(0);
         }
         }
         );
         back.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
         new MainMenu().setVisible(true);
         setVisible(false);
         }
         });
         */
    }

    public class OrderButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //ADDS CLICKS FOR ITEMS BEING ORDERED
            Inventory.qh1 += Inventory.clickh1;
            Inventory.qh2 += Inventory.clickh2;
            Inventory.qh3 += Inventory.clickh3;
            Inventory.qh4 += Inventory.clickh4;
            Inventory.qh5 += Inventory.clickh5;

            Inventory.qb1 += Inventory.clickb1;
            Inventory.qb2 += Inventory.clickb2;
            Inventory.qb3 += Inventory.clickb3;
            Inventory.qb4 += Inventory.clickb4;
            Inventory.qb5 += Inventory.clickb5;

            Inventory.ql1 += Inventory.clickl1;
            Inventory.ql2 += Inventory.clickl2;
            Inventory.ql3 += Inventory.clickl3;
            Inventory.ql4 += Inventory.clickl4;
            Inventory.ql5 += Inventory.clickl5;

            Inventory.qsh1 += Inventory.clicksh1;
            Inventory.qsh2 += Inventory.clicksh2;
            Inventory.qsh3 += Inventory.clicksh3;
            Inventory.qsh4 += Inventory.clicksh4;
            Inventory.qsh5 += Inventory.clicksh5;

            Inventory.qsw1 += Inventory.clicksw1;
            Inventory.qsw2 += Inventory.clicksw2;
            Inventory.qsw3 += Inventory.clicksw3;
            Inventory.qsw4 += Inventory.clicksw4;
            Inventory.qsw5 += Inventory.clicksw5;
            
            clickReset();

            Inventory.cashStack += totalSales;
            cashTotalL.setText(Integer.toString(Inventory.cashStack) + "gp");
            list.clear();
            totalSales = 0;
            totalSaleL.setText(Integer.toString(totalSales) + "gp");
        }

    }

    public class ResetButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //RESET THE CLICKS
            clickReset();
            list.clear();
            totalSales = 0;
            totalSaleL.setText(Integer.toString(totalSales) + "gp");
        }

    }

    public class Helm1ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Inventory.clickh1++;
            if ((Inventory.clickh1 + Inventory.qh1) > 10) {
                JOptionPane.showMessageDialog(null, "Sorry, we can not have that many items in stock. Please reset the cart", "The Inventory is full", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "For information on how many items we have in stock, please refer to our inventory screen.", "Info", JOptionPane.PLAIN_MESSAGE);

            } else {
                list.addElement("Helm   1   -50 gp");
                totalSales -= 50;
                totalSaleL.setText(Integer.toString(totalSales) + "gp");
            }
        }

    }

    public class Helm2ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Inventory.clickh2++;
            if ((Inventory.clickh2 + Inventory.qh2) > 10) {
                JOptionPane.showMessageDialog(null, "Sorry, we can not have that many items in stock. Please reset the cart", "The Inventory is full", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "For information on how many items we have in stock, please refer to our inventory screen.", "Info", JOptionPane.PLAIN_MESSAGE);

            } else {
                list.addElement("Helm   2   -300 gp");
                totalSales -= 300;
                totalSaleL.setText(Integer.toString(totalSales) + "gp");
            }
        }

    }

    public class Helm3ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Inventory.clickh3++;
            if ((Inventory.clickh3 + Inventory.qh3) > 10) {
                JOptionPane.showMessageDialog(null, "Sorry, we can not have that many items in stock. Please reset the cart", "The Inventory is full", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "For information on how many items we have in stock, please refer to our inventory screen.", "Info", JOptionPane.PLAIN_MESSAGE);

            } else {
                list.addElement("Helm   3   -800 gp");
                totalSales -= 800;
                totalSaleL.setText(Integer.toString(totalSales) + "gp");
            }
        }

    }

    public class Helm4ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Inventory.clickh4++;
            if ((Inventory.clickh4 + Inventory.qh4) > 10) {
                JOptionPane.showMessageDialog(null, "Sorry, we can not have that many items in stock. Please reset the cart", "The Inventory is full", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "For information on how many items we have in stock, please refer to our inventory screen.", "Info", JOptionPane.PLAIN_MESSAGE);

            } else {
                list.addElement("Helm   4   -1800 gp");
                totalSales -= 1800;
                totalSaleL.setText(Integer.toString(totalSales) + "gp");
            }
        }

    }

    public class Helm5ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Inventory.clickh5++;
            if ((Inventory.clickh5 + Inventory.qh5) > 10) {
                JOptionPane.showMessageDialog(null, "Sorry, we can not have that many items in stock. Please reset the cart", "The Inventory is full", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "For information on how many items we have in stock, please refer to our inventory screen.", "Info", JOptionPane.PLAIN_MESSAGE);

            } else {
                list.addElement("Helm   5   -3900 gp");
                totalSales -= 3800;
                totalSaleL.setText(Integer.toString(totalSales) + "gp");
            }
        }

    }

    public class Body1ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Inventory.clickb1++;
            if ((Inventory.clickb1 + Inventory.qb1) > 10) {
                JOptionPane.showMessageDialog(null, "Sorry, we can not have that many items in stock. Please reset the cart", "The Inventory is full", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "For information on how many items we have in stock, please refer to our inventory screen.", "Info", JOptionPane.PLAIN_MESSAGE);

            } else {
                list.addElement("Body   1   -300 gp");
                totalSales -= 300;
                totalSaleL.setText(Integer.toString(totalSales) + "gp");
            }
        }

    }

    public class Body2ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Inventory.clickb2++;
            if ((Inventory.clickb2 + Inventory.qb2) > 10) {
                JOptionPane.showMessageDialog(null, "Sorry, we can not have that many items in stock. Please reset the cart", "The Inventory is full", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "For information on how many items we have in stock, please refer to our inventory screen.", "Info", JOptionPane.PLAIN_MESSAGE);

            } else {
                list.addElement("Body   2   -900 gp");
                totalSales -= 900;
                totalSaleL.setText(Integer.toString(totalSales) + "gp");
            }
        }

    }

    public class Body3ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Inventory.clickb3++;
            if ((Inventory.clickb3 + Inventory.qb3) > 10) {
                JOptionPane.showMessageDialog(null, "Sorry, we can not have that many items in stock. Please reset the cart", "The Inventory is full", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "For information on how many items we have in stock, please refer to our inventory screen.", "Info", JOptionPane.PLAIN_MESSAGE);

            } else {
                list.addElement("Body   1   -2100 gp");
                totalSales -= 2100;
                totalSaleL.setText(Integer.toString(totalSales) + "gp");
            }
        }

    }

    public class Body4ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Inventory.clickb4++;
            if ((Inventory.clickb4 + Inventory.qb4) > 10) {
                JOptionPane.showMessageDialog(null, "Sorry, we can not have that many items in stock. Please reset the cart", "The Inventory is full", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "For information on how many items we have in stock, please refer to our inventory screen.", "Info", JOptionPane.PLAIN_MESSAGE);

            } else {
                list.addElement("Body   4   -4500 gp");
                totalSales -= 400;
                totalSaleL.setText(Integer.toString(totalSales) + "gp");
            };
        }

    }

    public class Body5ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Inventory.clickb5++;
            if ((Inventory.clickb5 + Inventory.qb5) > 10) {
                JOptionPane.showMessageDialog(null, "Sorry, we can not have that many items in stock. Please reset the cart", "The Inventory is full", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "For information on how many items we have in stock, please refer to our inventory screen.", "Info", JOptionPane.PLAIN_MESSAGE);

            } else {
                list.addElement("Body   5   -9300 gp");
                totalSales -= 9300;
                totalSaleL.setText(Integer.toString(totalSales) + "gp");
            }
        }

    }

    public class Legs1ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Inventory.clickl1++;
            if ((Inventory.clickl1 + Inventory.ql1) > 10) {
                JOptionPane.showMessageDialog(null, "Sorry, we can not have that many items in stock. Please reset the cart", "The Inventory is full", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "For information on how many items we have in stock, please refer to our inventory screen.", "Info", JOptionPane.PLAIN_MESSAGE);

            } else {
                list.addElement("Legs   1   -200 gp");
                totalSales -= 200;
                totalSaleL.setText(Integer.toString(totalSales) + "gp");
            }
        }

    }

    public class Legs2ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Inventory.clickl2++;
            if ((Inventory.clickl2 + Inventory.ql2) > 10) {
                JOptionPane.showMessageDialog(null, "Sorry, we can not have that many items in stock. Please reset the cart", "The Inventory is full", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "For information on how many items we have in stock, please refer to our inventory screen.", "Info", JOptionPane.PLAIN_MESSAGE);

            } else {
                list.addElement("Legs   2   -600 gp");
                totalSales -= 600;
                totalSaleL.setText(Integer.toString(totalSales) + "gp");
            }
        }

    }

    public class Legs3ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Inventory.clickl3++;
            if ((Inventory.clickl3 + Inventory.ql3) > 10) {
                JOptionPane.showMessageDialog(null, "Sorry, we can not have that many items in stock. Please reset the cart", "The Inventory is full", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "For information on how many items we have in stock, please refer to our inventory screen.", "Info", JOptionPane.PLAIN_MESSAGE);

            } else {
                list.addElement("Legs   3   -1400 gp");
                totalSales -= 1400;
                totalSaleL.setText(Integer.toString(totalSales) + "gp");
            }
        }

    }

    public class Legs4ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Inventory.clickl4++;
            if ((Inventory.clickl4 + Inventory.ql4) > 10) {
                JOptionPane.showMessageDialog(null, "Sorry, we can not have that many items in stock. Please reset the cart", "The Inventory is full", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "For information on how many items we have in stock, please refer to our inventory screen.", "Info", JOptionPane.PLAIN_MESSAGE);

            } else {
                list.addElement("Legs   4   -3000 gp");
                totalSales -= 3000;
                totalSaleL.setText(Integer.toString(totalSales) + "gp");
            }
        }

    }

    public class Legs5ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Inventory.clickl5++;
            if ((Inventory.clickl5 + Inventory.ql5) > 10) {
                JOptionPane.showMessageDialog(null, "Sorry, we can not have that many items in stock. Please reset the cart", "The Inventory is full", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "For information on how many items we have in stock, please refer to our inventory screen.", "Info", JOptionPane.PLAIN_MESSAGE);

            } else {
                list.addElement("Legs   5   -6200 gp");
                totalSales -= 6200;
                totalSaleL.setText(Integer.toString(totalSales) + "gp");
            }
        }

    }

    public class Shield1ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Inventory.clicksh1++;
            if ((Inventory.clicksh1 + Inventory.qsh1) > 10) {
                JOptionPane.showMessageDialog(null, "Sorry, we can not have that many items in stock. Please reset the cart", "The Inventory is full", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "For information on how many items we have in stock, please refer to our inventory screen.", "Info", JOptionPane.PLAIN_MESSAGE);

            } else {
                list.addElement("Shield   1   -100 gp");
                totalSales -= 100;
                totalSaleL.setText(Integer.toString(totalSales) + "gp");
            }
        }

    }

    public class Shield2ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Inventory.clicksh2++;
            if ((Inventory.clicksh2 + Inventory.qsh2) > 10) {
                JOptionPane.showMessageDialog(null, "Sorry, we can not have that many items in stock. Please reset the cart", "The Inventory is full", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "For information on how many items we have in stock, please refer to our inventory screen.", "Info", JOptionPane.PLAIN_MESSAGE);

            } else {
                list.addElement("Shield   2   -300 gp");
                totalSales -= 300;
                totalSaleL.setText(Integer.toString(totalSales) + "gp");
            }
        }

    }

    public class Shield3ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Inventory.clicksh3++;
            if ((Inventory.clicksh3 + Inventory.qsh3) > 10) {
                JOptionPane.showMessageDialog(null, "Sorry, we can not have that many items in stock. Please reset the cart", "The Inventory is full", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "For information on how many items we have in stock, please refer to our inventory screen.", "Info", JOptionPane.PLAIN_MESSAGE);

            } else {
                list.addElement("Shield   3   -500 gp");
                totalSales -= 500;
                totalSaleL.setText(Integer.toString(totalSales) + "gp");
            }
        }

    }

    public class Shield4ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Inventory.clicksh4++;
            if ((Inventory.clicksh4 + Inventory.qsh4) > 10) {
                JOptionPane.showMessageDialog(null, "Sorry, we can not have that many items in stock. Please reset the cart", "The Inventory is full", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "For information on how many items we have in stock, please refer to our inventory screen.", "Info", JOptionPane.PLAIN_MESSAGE);

            } else {
                list.addElement("Shield   4   -1100 gp");
                totalSales -= 1100;
                totalSaleL.setText(Integer.toString(totalSales) + "gp");
            }
        }

    }

    public class Shield5ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Inventory.clicksh5++;
            if ((Inventory.clicksh5 + Inventory.qsh5) > 10) {
                JOptionPane.showMessageDialog(null, "Sorry, we can not have that many items in stock. Please reset the cart", "The Inventory is full", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "For information on how many items we have in stock, please refer to our inventory screen.", "Info", JOptionPane.PLAIN_MESSAGE);

            } else {
                list.addElement("Shield   5   -2300 gp");
                totalSales -= 2300;
                totalSaleL.setText(Integer.toString(totalSales) + "gp");
            }
        }

    }

    public class Sword1ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Inventory.clicksw1++;
            if ((Inventory.clicksw1 + Inventory.qsw1) > 10) {
                JOptionPane.showMessageDialog(null, "Sorry, we can not have that many items in stock. Please reset the cart", "The Inventory is full", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "For information on how many items we have in stock, please refer to our inventory screen.", "Info", JOptionPane.PLAIN_MESSAGE);

            } else {
                list.addElement("Sword   1   -150 gp");
                totalSales -= 150;
                totalSaleL.setText(Integer.toString(totalSales) + "gp");
            }
        }

    }

    public class Sword2ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Inventory.clicksw2++;
            if ((Inventory.clicksw2 + Inventory.qsw2) > 10) {
                JOptionPane.showMessageDialog(null, "Sorry, we can not have that many items in stock. Please reset the cart", "The Inventory is full", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "For information on how many items we have in stock, please refer to our inventory screen.", "Info", JOptionPane.PLAIN_MESSAGE);

            } else {
                list.addElement("Sword   2   -400 gp");
                totalSales -= 400;
                totalSaleL.setText(Integer.toString(totalSales) + "gp");
            }
        }

    }

    public class Sword3ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Inventory.clicksw3++;
            if ((Inventory.clicksw3 + Inventory.qsw3) > 10) {
                JOptionPane.showMessageDialog(null, "Sorry, we can not have that many items in stock. Please reset the cart", "The Inventory is full", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "For information on how many items we have in stock, please refer to our inventory screen.", "Info", JOptionPane.PLAIN_MESSAGE);

            } else {
                list.addElement("Sword   3   -900 gp");
                totalSales -= 900;
                totalSaleL.setText(Integer.toString(totalSales) + "gp");
            }
        }

    }

    public class Sword4ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Inventory.clicksw4++;
            if ((Inventory.clicksw4 + Inventory.qsw4) > 10) {
                JOptionPane.showMessageDialog(null, "Sorry, we can not have that many items in stock. Please reset the cart", "The Inventory is full", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "For information on how many items we have in stock, please refer to our inventory screen.", "Info", JOptionPane.PLAIN_MESSAGE);

            } else {
                list.addElement("Sword   4   -1900 gp");
                totalSales -= 1900;
                totalSaleL.setText(Integer.toString(totalSales) + "gp");
            }
        }

    }

    public class Sword5ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Inventory.clicksw5++;
            if ((Inventory.clicksw5 + Inventory.qsw5) > 10) {
                JOptionPane.showMessageDialog(null, "Sorry, we can not have that many items in stock. Please reset the cart", "The Inventory is full", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "For information on how many items we have in stock, please refer to our inventory screen.", "Info", JOptionPane.PLAIN_MESSAGE);

            } else {
                list.addElement("Sword   5   -3900 gp");
                totalSales -= 3900;
                totalSaleL.setText(Integer.toString(totalSales) + "gp");
            }

        }

    }
    
    public void clickReset() {
        //RESET THE CLICKS
        Inventory.clickh1 = 0;
        Inventory.clickh2 = 0;
        Inventory.clickh3 = 0;
        Inventory.clickh4 = 0;
        Inventory.clickh5 = 0;

        Inventory.clickb1 = 0;
        Inventory.clickb2 = 0;
        Inventory.clickb3 = 0;
        Inventory.clickb4 = 0;
        Inventory.clickb5 = 0;

        Inventory.clickl1 = 0;
        Inventory.clickl2 = 0;
        Inventory.clickl3 = 0;
        Inventory.clickl4 = 0;
        Inventory.clickl5 = 0;

        Inventory.clicksh1 = 0;
        Inventory.clicksh2 = 0;
        Inventory.clicksh3 = 0;
        Inventory.clicksh4 = 0;
        Inventory.clicksh5 = 0;

        Inventory.clicksw1 = 0;
        Inventory.clicksw2 = 0;
        Inventory.clicksw3 = 0;
        Inventory.clicksw4 = 0;
        Inventory.clicksw5 = 0;
    }

    @Override
    public void update(Observable o, Object o1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
