package Cab_Booking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Admin_Login extends JFrame implements ActionListener{
    JFrame f;
    JLabel l1,l2,l3,l4;
    JTextField t1;
    JPasswordField p1;
    JButton b1,b2;

    Admin_Login(){
        f=new JFrame(" Admin Login Account");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        l1=new JLabel();
        l1.setBounds(0,0,580,350);
        l1.setLayout(null);

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Cab_Booking/Icons/1.png"));
        Image i1=img.getImage().getScaledInstance(580,350,Image.SCALE_DEFAULT);
        ImageIcon img1=new ImageIcon(i1);
        l1.setIcon(img1);

        l2=new JLabel("Login Account");
        l3=new JLabel("Username");
        l4=new JLabel("Password");
        t1=new JTextField();
        p1=new JPasswordField();
        b1=new JButton("Login");
        b2=new JButton("SignUp");

        l2.setBounds(190,30,500,50);
        l2.setForeground(Color.RED);
        l2.setFont(new Font("Airal",Font.BOLD,30));

        l3.setBounds(120,120,150,30);
        l3.setForeground(Color.ORANGE);
        l3.setFont(new Font("Airal",Font.BOLD,20));

        l4.setBounds(120,170,150,30);
        l4.setForeground(Color.ORANGE);
        l4.setFont(new Font("Airal",Font.BOLD,20));

        t1.setBounds(320,120,150,30);
        p1.setBounds(320,170,150,30);

        b1.setBounds(120,220,150,40);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);

        b2.setBounds(320,220,150,40);
        b2.setBackground(Color.RED);
        b2.setForeground(Color.white);
        b2.addActionListener(this);

        f.add(l1);
        l1.add(l2);
        l1.add(l3);
        l1.add(l4);
        l1.add(t1);
        l1.add(p1);
        l1.add(b1);
        l1.add(b2);

        f.setVisible(true);
        f.setSize(580,350);
        f.setLocation(400,300);
        f.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            try {
                Connection_Class obj=new Connection_Class();
                String user=t1.getText();
                String pass=p1.getText();

                String q="select * from admin_sign_up where username = '"+user+"' and password = '"+pass+"'";
                ResultSet rs=obj.stm.executeQuery(q);
                if (rs.next()){
                    new Admin_Section().setVisible(true);
                    f.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null,"You have entered wrong username or password !");
                    f.setVisible(false);
                    f.setVisible(true);
                }
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        }
        if (e.getSource()==b2){
            f.setVisible(false);
            new Admin_Signup();
        }
    }

    public static void main(String[] args) {
        new Admin_Login();
    }
}