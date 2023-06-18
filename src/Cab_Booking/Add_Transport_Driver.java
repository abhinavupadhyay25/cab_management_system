package Cab_Booking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Add_Transport_Driver extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    Font f1,f2;
    JButton b1,b2;
    JTextField t1,t2,t3,t4,t5,t6;
    JPanel p1,p2;

    Add_Transport_Driver(){
        super("Add Transport Driver");
        setLocation(450,50);
        setSize(450,400);

        f1=new Font("Arial",Font.BOLD,20);
        f2=new Font("Arial",Font.BOLD,15);

        l1=new JLabel("Add Transport Driver");

        l2=new JLabel("Driver name");
        l3=new JLabel("Source");
        l4=new JLabel("Destination");
        l5=new JLabel("Truck");
        l6=new JLabel("Price(Rs)");
        l7=new JLabel("Distance");

        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        t5=new JTextField();
        t6=new JTextField();

        b1=new JButton("Add Transport Driver");
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
        l7.setFont(f2);

        t1.setFont(f2);
        t2.setFont(f2);
        t3.setFont(f2);
        t4.setFont(f2);
        t5.setFont(f2);
        t6.setFont(f2);

        b1.setFont(f2);
        b2.setFont(f2);

        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);

        p2=new JPanel();
        p2.setLayout(new GridLayout(7,2,10,10));
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
        p2.add(l7);
        p2.add(t6);

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
            String truck=t4.getText();
            String price=t5.getText();
            String dist=t6.getText();

            try{
                Connection_Class obj=new Connection_Class();
                String q="insert into transport_driver(driver,source,destination,truck,price,distance) values('"+name+"','"+source+"','"+dest+"','"+truck+"','"+price+"','"+dist+"')";
                int a=obj.stm.executeUpdate(q);
                if (a==1){
                    JOptionPane.showMessageDialog(null,"Your data successfully inserted ");
                    this.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Please, fill all details carefully");
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        if (e.getSource()==b2){
            this.setVisible(false);
            new Admin_Section().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Add_Transport_Driver().setVisible(true);
    }
}
