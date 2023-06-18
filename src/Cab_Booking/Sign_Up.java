package Cab_Booking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;

public class Sign_Up extends JFrame implements ActionListener{
    JFrame j;
    JLabel l1,l2,l3,l4;
    JTextField t1,t2,t3;
    JPasswordField p1;
    JButton b1,b2;

    Sign_Up(){
        j=new JFrame("Create new account");
        j.setBackground(Color.WHITE);
        j.setLayout(null);

        l1=new JLabel("Username");
        l2=new JLabel("Password");
        l3=new JLabel("Name");
        l4=new JLabel("Phone No.");
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        p1=new JPasswordField();
        b1=new JButton("Signup");
        b2=new JButton("Back");

        setLayout(null);

        l1.setBounds(40,20,100,30);
        l2.setBounds(40,70,100,30);
        l3.setBounds(40,120,100,30);
        l4.setBounds(40,170,100,30);
        t1.setBounds(150,20,150,30);
        t2.setBounds(150,120,150,30);
        t3.setBounds(150,170,150,30);
        p1.setBounds(150,70,150,30);
        b1.setBounds(40,240,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b2.setBounds(200,240,120,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);

        j.add(l1);
        j.add(l2);
        j.add(l3);
        j.add(l4);
        j.add(t1);
        j.add(p1);
        j.add(t2);
        j.add(t3);
        j.add(b1);
        j.add(b2);

        //j.getContentPane();// Holds the object on frame
        j.setVisible(true);
        j.setSize(550,340);
        j.setLocation(400,300);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            String username= t1.getText();
            String password=p1.getText();
            String name=t2.getText();
            String phone= t3.getText();

            try {
                Connection_Class obj=new Connection_Class();
                String q="insert into customer_sign_up values('"+username+"', '"+password+"', '"+name+"', '"+phone+"')";
                int aa=obj.stm.executeUpdate(q);
                if (aa==1){
                    JOptionPane.showMessageDialog(null,"Account created successfully");
                    new Log_in();
                    this.j.setVisible(false);

                }
                else {
                    JOptionPane.showMessageDialog(null,"Please, Fill all details carefully");
                    this.j.setVisible(false);
                    this.j.setVisible(true);
                }
            }catch (Exception ex){
               // System.out.println("Exception : "+ex.getMessage());
                ex.printStackTrace();
            }
        }
        if (e.getSource()==b2){
            this.j.setVisible(false);
            new Log_in();
        }
    }

    public static void main(String[] args) {
        new Sign_Up();
    }
}