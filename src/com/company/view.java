package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.*;


public class view extends JFrame implements ActionListener {
    JPanel panel = new JPanel();
    JButton b;
    JLabel l1,l2;
    JTable j1;
    JButton b1;
    String h[]={"PRODUCT ID","PRODUCT NAME","PRODUCT PRICE","PRODUCT QUANTITY"};
    String d[][]=new String[500][4];
    int i=0,j=0;

    view() {

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





        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123");
            System.out.println("Connected");
            Statement st = con.createStatement();


            ResultSet rs = st.executeQuery("select* from product ");
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




        j1=new JTable(d,h);
        j1.setSize(1900,800);
        setVisible(true);
        JScrollPane s1=new JScrollPane(j1);
        s1.setSize(1900,800);
        add(s1);

        setSize(1920, 1080);
        setLocation(0, 0);
        setVisible(true);



    }



    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==b)
{
    dispose();
    new Main().setVisible(true);
}
    }

    public static void main(String[] args) {
        view v = new view();
    }

}
