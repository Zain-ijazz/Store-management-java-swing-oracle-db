package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//import static com.company.Addproducts.*;


public class Main extends JFrame implements ActionListener
{
    JLabel l1;
    JButton b1,b2,b3,b4,b5;
    JTextField t;
    Main()
    {
        JFrame frame = new JFrame();

        ImageIcon icon = new ImageIcon("Untitled design.png");
        JLabel label = new JLabel(icon);
        add(label);


        pack();







        t = new JTextField(15);
        t.setBounds(500, 85, 600, 50);
        t.setFont(new Font("Arial", Font.BOLD, 25));
        t.setBackground(Color.white);
        t.setForeground(Color.black);

        label.add(t);
       t.setEditable(false);
        t.setText("                 Store Management System");






        b1 = new JButton("Add Products");
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b2 = new JButton("View Products");
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.BLACK);
        b3 = new JButton("Remove Product");
        b3.setBackground(Color.WHITE);
        b3.setForeground(Color.BLACK);
        b4 = new JButton("Calculate Bill");
        b4.setBackground(Color.WHITE);
        b4.setForeground(Color.BLACK);
        b5 = new JButton("Search Product");
        b5.setBackground(Color.WHITE);
        b5.setForeground(Color.BLACK);

        setLayout(null);
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(1000,250,450,70);
        label.add(b1);
        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(1000,350,450,70);
        label.add(b3);
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(1000,450,450,70);
        label.add(b2);
        b4.setFont(new Font("Arial", Font.BOLD, 14));
        b4.setBounds(1000,550,450,70);
        label.add(b4);
        b5.setFont(new Font("Arial", Font.BOLD, 14));
        b5.setBounds(1000,650,450,70);
        label.add(b5);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);




        setSize(1920,1080);
        setLocation(0,0);





    }




    public void actionPerformed(ActionEvent e)
    {
if (e.getSource()==b1)
{ setVisible(false);
   dispose();
    new Addproducts().setVisible(true);

}
else if (e.getSource()==b2)
{setVisible(false);

    dispose();

 view v  = new view();


}
else if (e.getSource()==b3)
{
    dispose();
   removeProduct r = new removeProduct();

}
else if (e.getSource()==b4)
{setVisible(false);
    calculateBill cb = new calculateBill();
}

else if (e.getSource()==b5)
{setVisible(false);
    search s = new search();
}



    }

    public static void main(String[] args)
    {


new Main().setVisible(true);




    }






    }

