package Cab_Booking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Choose_Page extends JFrame implements ActionListener{
    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6;
    JPanel p1,p2;
    Font f1,f2;

    Choose_Page(){
        super("Choose Option");
        setLocation(450,250);
        setSize(400,270);

        f1=new Font("Arial",Font.BOLD,20);
        f2=new Font("Arial",Font.BOLD,15);

        l1=new JLabel("What You Want ??");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f1);

        b1=new JButton("Book Intercity Cab");
        b2=new JButton("Book Intracity Cab");
        b3=new JButton("Book Truck");
        b4=new JButton("Back");
        b5=new JButton("Add Profile");
        b6=new JButton("Update Profile");

        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);

        b5.setBackground(Color.RED);
        b5.setForeground(Color.WHITE);

        b6.setBackground(Color.YELLOW);
        b6.setForeground(Color.BLACK);

        b1.setFont(f2);
        b2.setFont(f2);
        b3.setFont(f2);
        b4.setFont(f2);
        b5.setFont(f2);
        b6.setFont(f2);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);

        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);

        p2=new JPanel();
        p2.setLayout(new GridLayout(5,2,10,10));
        p2.add(b5);
        p2.add(b6);
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);

        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            new Book_Intercity_Cab().setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource()==b2){
            new Book_Intracity_Cab().setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource()==b3){
            new Book_Package().setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource()==b4){
            this.setVisible(false);
            new Index_Page().setVisible(true);
        }
        if (e.getSource()==b5){
            new Add_Customer().setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource()==b6){
            new Update_Customer().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Choose_Page().setVisible(true);
    }
}
