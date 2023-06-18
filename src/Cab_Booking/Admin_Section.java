package Cab_Booking;

import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.*;


public class Admin_Section extends JFrame implements ActionListener {
    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    JPanel p1,p2;
    Font f1,f2;

    Admin_Section(){
        super("Admin");
        setLocation(450,250);
        setSize(400,270);

        f1=new Font("Arial",Font.BOLD,20);
        f2=new Font("Arial",Font.BOLD,15);

        l1=new JLabel("Admin Section");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f1);

        b1=new JButton("Add Intercity Driver");
        b2=new JButton("Add Intracity Driver");
        b3=new JButton("Add Transport Driver");
        b4=new JButton("Intercity Booking Details");
        b5=new JButton("Intracity Booking Details");
        b6=new JButton("Transport Booking Details");
        b7=new JButton("Back");
        b8=new JButton("Delete Customer");

        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);

        b8.setBackground(Color.RED);
        b8.setForeground(Color.WHITE);

        b1.setFont(f2);
        b2.setFont(f2);
        b3.setFont(f2);
        b4.setFont(f2);
        b5.setFont(f2);
        b6.setFont(f2);
        b7.setFont(f2);
        b8.setFont(f2);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);

        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);

        p2=new JPanel();
        p2.setLayout(new GridLayout(4,2,10,10));
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);
        p2.add(b6);
        p2.add(b8);
        p2.add(b7);

        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            new Add_Intercity_Driver().setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource()==b2){
            new Add_Intracity_Driver().setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource()==b3){
            new Add_Transport_Driver().setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource()==b4){
            new View_Intercity_Cab().setVisible(true);
        }
        if (e.getSource()==b5){
            new View_Intracity_Cab().setVisible(true);
        }
        if (e.getSource()==b6){
            new View_Booked_Package().setVisible(true);
        }
        if (e.getSource()==b7){
            this.setVisible(false);
            new Index_Page().setVisible(true);
        }
        if (e.getSource()==b8){
            new Delete_Customer().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Admin_Section().setVisible(true);
    }
}
