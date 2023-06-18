package Cab_Booking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Index_Page extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4;
    JButton b1,b2;
    JPanel p1,p2,p3;
    Font f1,f2;

    Index_Page(){
        super("Welcome");
        setLocation(450,250);
        setSize(500,200);

        f1=new Font("Arial",Font.BOLD,20);
        f2=new Font("Arial",Font.BOLD,15);

        l1=new JLabel("Cab Management System");
        l1.setFont(f1);
        l1.setForeground(Color.RED);
        l1.setHorizontalAlignment(JLabel.CENTER);

        l2=new JLabel("Admin Login");
        l3=new JLabel("Customer Login");

        b1=new JButton("Login");
        b2=new JButton("Login");

        l2.setFont(f2);
        l3.setFont(f2);

        b1.setFont(f2);
        b2.setFont(f2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);

        p2=new JPanel();
        p2.setLayout(new GridLayout(2,2,10,10));
        p2.add(l2);
        p2.add(b1);
        p2.add(l3);
        p2.add(b2);

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Cab_Booking/Icons/10.jpg"));
        Image i1=img.getImage().getScaledInstance(130,100,Image.SCALE_DEFAULT);
        ImageIcon img1=new ImageIcon(i1);
        l4=new JLabel(img1);

        p3=new JPanel();
        p3.setLayout(new GridLayout(1,1,10,10));
        p3.add(l4);

        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");
        add(p3,"West");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            new Admin_Login().setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource()==b2){
            new Log_in().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Index_Page().setVisible(true);
    }
}
