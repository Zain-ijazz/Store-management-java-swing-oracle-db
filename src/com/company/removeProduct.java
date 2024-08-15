package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import static com.company.Addproducts.*;

public class removeProduct extends JFrame implements ActionListener {
    JLabel l1;
    JButton b;
    JButton button5;
    JTextField t;





    removeProduct() {

        JFrame frame = new JFrame();
        ImageIcon icon = new ImageIcon("remove.png");
        JLabel label = new JLabel(icon);
        add(label);

        pack();
        setVisible(true);


        l1 = new JLabel("  ENTER PRODUCT ID TO REMOVE: ");
        l1.setFont(new Font("Osward", Font.BOLD, 25));
        l1.setBounds(650, 60, 500, 120);
        l1.setForeground(Color.white);
        label.add(l1);

        t = new JTextField(15);
        t.setBounds(1100, 92, 400, 50);
        t.setFont(new Font("Arial", Font.BOLD, 14));
        label.add(t);
        b = new JButton("ENTER");
        b.setBackground(Color.BLUE);
        b.setForeground(Color.WHITE);
        b.addActionListener(this);

        button5 = new JButton("Menu");
        button5.setBackground(Color.red);
        button5.setForeground(Color.WHITE);
        button5.addActionListener(this);


        setLayout(null);
        b.setFont(new Font("Arial", Font.BOLD, 14));
        b.setBounds(1150, 250, 250, 80);
        label.add(b);
        button5.setFont(new Font("Arial", Font.BOLD, 14));
        button5.setBounds(0, 0, 100, 20);
        label.add(button5);


        setLayout(null);


        setSize(1920, 1080);
        setLocation(0, 0);

      //  getContentPane().setBackground(Color.ORANGE);

        setVisible(true);




    }


    @Override
    public void actionPerformed(ActionEvent qe) {
        if (qe.getSource() == button5) {

            dispose();
            new Main().setVisible(true);
        }


        if (qe.getSource() == b) {


            String id = t.getText();

            try {

                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123");
                System.out.println("Connected");
                Statement st = con.createStatement();
                st.executeQuery("delete from PRODUCT where id = (" + id + ")");

                JOptionPane.showMessageDialog(null,"Product removed Successfully!");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e.getMessage());


                dispose();
                removeProduct r = new removeProduct();
            }

        }
    }

        public static void main (String[]args){
removeProduct rp = new removeProduct();

        }

}

