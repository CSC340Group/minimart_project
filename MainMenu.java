/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc340project;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;


/**
 *
 * @author Michael & Jonathan
 */
public class MainMenu extends Frame implements Observer {

    private Button salesB = new Button("Sales");
    private Button refundB = new Button("Refunds");
    private Button ordersupB = new Button("Order supplies");
    private Button invB = new Button("Inventory");

    public MainMenu() {
        super("The Blacksmith's Shop");
        setSize(600, 600);
        setVisible(true);
        setLayout(new BorderLayout(5, 5));

//        Panel mid = new Panel();
//        add(mid, BorderLayout.CENTER);
//        mid.setLayout(new GridLayout(5, 3, 10, 10));
//        mid.setBackground(Color.black);
        Panel thegrid = new Panel();
        add(thegrid, BorderLayout.CENTER);
        thegrid.setLayout(new GridLayout(2, 2));
        thegrid.setBackground(Color.black);

        
        thegrid.add(this.salesB);
        
        thegrid.add(this.refundB);
        
        thegrid.add(this.ordersupB);
        
        thegrid.add(this.invB);
        

        //allows you to press x to close the window 
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        }
        );

        //opens sales window when button is pressed
        salesB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //open the sales window
                new Sales().setVisible(true);


            }
        });

        //opens refunds window when button is pressed
        refundB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //open the refunds window
                new Refunds().setVisible(true);


            }
        });
        
        //opens order inventory window when button is pressed
        ordersupB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //open the order window
                new OrderInventory().setVisible(true);
                

            }
        });
        
        //opens inventory window when button is pressed
        invB.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               //open the inv window
               new Inventory().setVisible(true);
               

           }
        });

    }

    @Override
    public void update(Observable o, Object o1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
