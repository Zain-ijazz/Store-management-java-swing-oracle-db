package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Addproducts extends JFrame implements ActionListener {

  public static JLabel l1, l2, l3, l4,l5, label;
  public   static JTextField t1, t2, t3,t4,t5;

  JButton b;
    JButton button1;
   String name;
   int pricep;
   int quantity;


    Addproducts() {


        JFrame frame = new JFrame();
        ImageIcon icon = new ImageIcon("sabzi.png");
        JLabel label = new JLabel(icon);
        add(label);

        pack();
        setVisible(true);



       l1 = new JLabel("PRODUCT ID: ");
        l1.setFont(new Font("Osward", Font.BOLD, 35));
        l1.setBounds(50, 60, 500, 100);
        l1.setForeground(Color.yellow);
        label.add(l1);
        l2 = new JLabel("PRODUCT NAME: ");
        l2.setFont(new Font("Osward", Font.BOLD, 35));
        l2.setBounds(50, 200, 500, 50);
        l2.setForeground(Color.yellow);
        label.add(l2);
        l3 = new JLabel("PRODUCT PRICE: ");
        l3.setFont(new Font("Osward", Font.BOLD, 35));
        l3.setBounds(50, 300, 500, 100);
        l3.setForeground(Color.yellow);
        label.add(l3);

        l4 = new JLabel("PRODUCT QUANTITY: ");
        l4.setFont(new Font("Osward", Font.BOLD, 35));
        l4.setBounds(50, 450, 500, 50);
        l4.setForeground(Color.yellow);
        label.add(l4);



        t1 = new JTextField(15);
        t1.setBounds(430, 85, 400, 50);
        t1.setFont(new Font("Arial", Font.BOLD, 14));
        label.add(t1);
        t2 = new JTextField(15);
        t2.setBounds(430, 200, 400, 50);
        t2.setFont(new Font("Arial", Font.BOLD, 14));
        label.add(t2);
        t3 = new JTextField(15);
        t3.setBounds(430, 320, 400, 50);
        t3.setFont(new Font("Arial", Font.BOLD, 14));
        label.add(t3);

        t4 = new JTextField(15);
        t4.setBounds(430, 450, 400, 50);
        t4.setFont(new Font("Arial", Font.BOLD, 14));
        label.add(t4);

        b = new JButton("ENTER");
        b.setBackground(Color.white);
        b.setForeground(Color.black);
        b.addActionListener(this);
        button1 = new JButton("Menu");
        button1.setBackground(Color.red);
        button1.setForeground(Color.WHITE);
        button1.addActionListener(this);


        setLayout(null);
        b.setFont(new Font("Arial", Font.BOLD, 20));
        b.setBounds(700, 800, 500, 80);
        label.add(b);

        button1.setFont(new Font("Arial", Font.BOLD, 14));
        button1.setBounds(0, 0, 100, 20);
        label.add(button1);


        setLayout(null);
        setSize(1920,1080);
        getContentPane().setBackground(Color.GRAY);
        setLocation(0, 0);
        setVisible(true);





    }


    public void actionPerformed(ActionEvent ae) {


        if (ae.getSource() == b) {



            String id = t1.getText();
            String name = t2.getText();
            String price = t3.getText();
            String quantity = t4.getText();


            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123");
                System.out.println("Connected");
                Statement st = con.createStatement();
                st.executeQuery("insert into PRODUCT values(" + id + ",'" + name + "'," + price + ","+quantity+")");



            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e.getMessage());
            }

            JOptionPane.showMessageDialog(null,"Product added Successfully!");
            dispose();
            new Addproducts().setVisible(true);
        }


        if (ae.getSource() == button1) {

            dispose();
             new Main().setVisible(true);


        }




    }


    public static void main(String[] args) {

 Addproducts add = new Addproducts();
    }



}







