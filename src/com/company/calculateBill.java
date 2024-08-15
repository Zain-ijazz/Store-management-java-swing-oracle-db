package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;



public class calculateBill extends JFrame implements ActionListener {
    JLabel label1, label2;
    JButton button1, button2, button3;
    JTextField textField1, textField2;
    public static String Name;
    public static int Quantity;
    public static String n;
    public static int p;
    public static int q;
    public static int Bill;
    public static int TotalBill = 0;
    int flag = 0;

    calculateBill() {

        JFrame frame = new JFrame();
        ImageIcon icon = new ImageIcon("calculate bill.png");
        JLabel label = new JLabel(icon);
        add(label);

        pack();
        setVisible(true);




        label1 = new JLabel("PRODUCT NAME: ");
        label1.setFont(new Font("Osward", Font.BOLD, 23));
        label1.setBounds(130, 100, 450, 100);
        label1.setForeground(Color.white);
        label.add(label1);

        textField1 = new JTextField(15);
        textField1.setBounds(500, 125, 400, 50);
        textField1.setFont(new Font("Arial", Font.BOLD, 14));
        label.add(textField1);


        label2 = new JLabel("  QUANTITY: ");
        label2.setFont(new Font("Osward", Font.BOLD, 23));
        label2.setBounds(130, 210, 450, 100);
        label2.setForeground(Color.white);
        label.add(label2);

        textField2 = new JTextField(15);
        textField2.setBounds(500, 240, 400, 50);
        textField2.setFont(new Font("Arial", Font.BOLD, 14));
        label.add(textField2);
        button1 = new JButton("Menu");
        button1.setBackground(Color.red);
        button1.setForeground(Color.WHITE);
        button1.addActionListener(this);


        button2 = new JButton("ADD");
        button2.setBackground(Color.BLUE);
        button2.setForeground(Color.WHITE);
        button2.addActionListener(this);

        button3 = new JButton("Calculate Bill");
        button3.setBackground(Color.blue);
        button3.setForeground(Color.WHITE);
        button3.addActionListener(this);


        setLayout(null);
        button1.setFont(new Font("Arial", Font.BOLD, 14));
        button1.setBounds(0, 0, 100, 20);
        label.add(button1);


        button2.setFont(new Font("Arial", Font.ITALIC, 14));
        button2.setBounds(640, 340, 100, 50);
        label.add(button2);

        button3.setFont(new Font("Arial", Font.ITALIC, 20));
        button3.setBounds(350, 540, 250, 80);
        label.add(button3);


        setSize(1920, 1080);
        setLocation(0, 0);

      //  getContentPane().setBackground(Color.ORANGE);

        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == button1) {
            dispose();
            new Main().setVisible(true);
        }
        if (ae.getSource() == button2) {

            Name = textField1.getText();
            String Quantity1 = textField2.getText();
            Quantity = Integer.parseInt(Quantity1);


            try {

                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123");
                System.out.println("Connected");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from PRODUCT where name = ('" + Name + "')");
                while(rs.next()){

                    n = rs.getString(2);
                    p = rs.getInt(3);
                    q = rs.getInt(4);

                    System.out.println(n);
                    System.out.println(p);
                    System.out.println(q);
                }




            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e.getMessage());


                dispose();
                removeProduct r = new removeProduct();
            }


            if (q >= Quantity) {
                Bill = p * Quantity;
                q = q - Quantity;

                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123");
                    System.out.println("Connected");
                    Statement st = con.createStatement();
                    st.executeQuery("update  PRODUCT set quantity=(" + q + ") where name = ('" + n + "')");


                } catch (ClassNotFoundException | SQLException e) {
                    System.out.println(e.getMessage());
                }
                TotalBill = TotalBill + Bill;
            } else {
                JOptionPane.showMessageDialog(null, "product not available!");
            }

dispose();
            calculateBill c = new calculateBill();
        }







        if (ae.getSource()==button3)
        {

            JOptionPane.showMessageDialog(null,TotalBill);
            TotalBill=0;

        }


    }

    public static void main(String[] args) {
        calculateBill c = new calculateBill();
    }
}