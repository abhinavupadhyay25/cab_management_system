package Cab_Booking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Add_Intracity_Driver extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2;
    Font f1,f2;
    JPanel p1,p2;

    Add_Intracity_Driver(){
        super("Add Intracity Driver");
        setLocation(450,50);
        setSize(450,400);

        f1=new Font("Arial",Font.BOLD,20);
        f2=new Font("Arial",Font.BOLD,15);

        l1=new JLabel("Add Intracity Driver");

        l2=new JLabel("Driver name");
        l3=new JLabel("Source");
        l4=new JLabel("Destination");
        l5=new JLabel("Car");
        l6=new JLabel("Price(Rs)");

        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        t5=new JTextField();

        b1=new JButton("Add Intracity Driver");
        b2=new JButton("Back");

        l1.setHorizontalAlignment(JLabel.CENTER);

        b1.addActionListener(this);
        b2.addActionListener(this);

        l1.setForeground(Color.RED);

        l1.setFont(f1);

        l2.setFont(f2);
        l3.setFont(f2);
        l4.setFont(f2);
        l5.setFont(f2);
        l6.setFont(f2);

        t1.setFont(f2);
        t2.setFont(f2);
        t3.setFont(f2);
        t4.setFont(f2);
        t5.setFont(f2);

        b1.setFont(f2);
        b2.setFont(f2);

        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);

        p2=new JPanel();
        p2.setLayout(new GridLayout(6,2,10,10));
        p2.add(l2);
        p2.add(t1);
        p2.add(l3);
        p2.add(t2);
        p2.add(l4);
        p2.add(t3);
        p2.add(l5);
        p2.add(t4);
        p2.add(l6);
        p2.add(t5);

        p2.add(b1);
        p2.add(b2);

        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            String name=t1.getText();
            String source=t2.getText();
            String dest=t3.getText();
            String car=t4.getText();
            String price=t5.getText();

            try {
                Connection_Class obj=new Connection_Class();
                String q="insert into intracity_driver(driver,source,destination,car,price) values('"+name+"','"+source+"','"+dest+"','"+car+"','"+price+"')";
                int a=obj.stm.executeUpdate(q);
                if (a==1){
                    JOptionPane.showMessageDialog(null,"Your data successfully inserted");
                    this.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Please, fill details carefully !");
                }
            }
            catch (Exception ex4){
                ex4.printStackTrace();
            }
        }
        if (e.getSource()==b2){
            this.setVisible(false);
            new Admin_Section().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Add_Intracity_Driver().setVisible(true);
    }
}
