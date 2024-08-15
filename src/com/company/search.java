package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.*;


public class search extends JFrame implements ActionListener {
    JPanel panel = new JPanel();
    JLabel label1, label2;

    JTextField textField1, textField2;
    JButton b;
    JLabel l1,l2;
    JTable j1;
    JButton b1;
    String h[]={"PRODUCT ID","PRODUCT NAME","PRODUCT PRICE","PRODUCT QUANTITY"};
    String d[][]=new String[500][4];
    int i=0,j=0;

    search() {

        super("view inventory");
        panel.setBounds(0, 0, 1000, 700);


        b = new JButton("EXIT");
        b.setBackground(Color.RED);
        b.setForeground(Color.BLUE);

        b.addActionListener(this);

        setLayout(null);
        b.setFont(new Font("Arial", Font.BOLD, 20));
        b.setBounds(700, 800, 500, 60);
        add(b);

        label1 = new JLabel("PRODUCT NAME: ");
        label1.setFont(new Font("Osward", Font.BOLD, 25));
        label1.setBounds(130, 200, 450, 120);
        label1.setForeground(Color.black);
        add(label1);

        textField1 = new JTextField(15);
        textField1.setBounds(450, 230, 400, 50);
        textField1.setFont(new Font("Arial", Font.BOLD, 14));
        add(textField1);

        b1 = new JButton("search");
        b1.setBackground(Color.RED);
        b1.setForeground(Color.BLUE);

        b1.addActionListener(this);

        setLayout(null);
        b1.setFont(new Font("Arial", Font.BOLD, 20));
        b1.setBounds(900, 220, 200, 60);
        add(b1);







        j1=new JTable(d,h);
        j1.setSize(1900,200);
        setVisible(true);
        JScrollPane s1=new JScrollPane(j1);
        s1.setSize(1900,200);
        add(s1);

        setSize(1920, 1080);
        setLocation(0, 0);
        setVisible(true);



    }



    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b)
        {
            dispose();
            new Main().setVisible(true);
        }

        if(ae.getSource()==b1)
        {


           String Name1 = textField1.getText();



            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123");
                System.out.println("Connected");
                Statement st = con.createStatement();


                ResultSet rs = st.executeQuery("select * from PRODUCT where name = ('" + Name1 + "')");
                while (rs.next()) {



                    d[i][j++] = rs.getString("ID");
                    d[i][j++] = rs.getString("NAME");
                    d[i][j++] = rs.getString("PRICE");
                    d[i][j++] = rs.getString("QUANTITY");

                    i++;
                    j = 0;
                }

            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e.getMessage());
            }



        }





    }

    public static void main(String[] args) {
        search s = new search();
    }

}
