package Cab_Booking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Check_bill extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4;
    JButton b1,b2,b3,b4;
    Choice ch1;
    JPanel p1,p2,p3;
    Font f1,f2;

    public int price=0;

    Check_bill(){
        super("Check Bills");
        setLocation(50,10);
        setSize(1100,500);

        f1=new Font("Arial",Font.BOLD,25);
        f2=new Font("Arial",Font.BOLD,18);

        l1=new JLabel("Check Total Cab Bill");

        l2=new JLabel("Username");
        l3=new JLabel("name");
        l4=new JLabel("Email");
        l5=new JLabel("Address");
        l6=new JLabel("Price(Rs)");

        l1.setHorizontalAlignment(JLabel.CENTER);

        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();

        t1.setEditable(false);
        t2.setEditable(false);
        t3.setEditable(false);
        t4.setEditable(false);

        ch1=new Choice();

        try {
            Connection_Class ob1=new Connection_Class();
            String q1="select username from customer_profile";
            ResultSet rs1=ob1.stm.executeQuery(q1);
            while (rs1.next()){
                ch1.add(rs1.getString("username"));
            }
            rs1.close();
        }catch(Exception e1){
            e1.printStackTrace();
        }

        l1.setFont(f1);
        l1.setForeground(Color.RED);

        l2.setFont(f2);
        l3.setFont(f2);
        l4.setFont(f2);
        l5.setFont(f2);
        l6.setFont(f2);

        t1.setFont(f2);
        t2.setFont(f2);
        t3.setFont(f2);
        t4.setFont(f2);

        t4.setForeground(Color.RED);

        ch1.setFont(f2);

        b1=new JButton("Intercity Cab");
        b2=new JButton("Intracity Cab");
        b3=new JButton("Transport");
        b4=new JButton("Back");

        b1.setBackground(Color.YELLOW);
        b2.setBackground(Color.YELLOW);
        b3.setBackground(Color.YELLOW);
        b4.setBackground(Color.BLACK);

        b1.setForeground(Color.BLACK);
        b2.setForeground(Color.BLACK);
        b3.setForeground(Color.BLACK);
        b4.setForeground(Color.WHITE);

        b1.setFont(f2);
        b2.setFont(f2);
        b3.setFont(f2);
        b4.setFont(f2);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        ch1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    Connection_Class ob2=new Connection_Class();
                    String username=ch1.getSelectedItem();
                    String q2="select * from customer_profile where username='"+username+"'";
                    ResultSet rs2=ob2.stm.executeQuery(q2);
                    while(rs2.next()){
                        t1.setText(rs2.getString("name"));
                        t2.setText(rs2.getString("email"));
                        t3.setText(rs2.getString("address"));
                    }
                }
                catch(Exception e2){
                    e2.printStackTrace();
                }
            }
        });

        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);

        p2=new JPanel();
        p2.setLayout(new GridLayout(7,2,10,10));
        p2.add(l2);
        p2.add(ch1);
        p2.add(l3);
        p2.add(t1);
        p2.add(l4);
        p2.add(t2);
        p2.add(l5);
        p2.add(t3);
        p2.add(l6);
        p2.add(t4);

        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Cab_Booking/Icons/rup.jpg"));
        Image i1=img.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon img1=new ImageIcon(i1);
        l7=new JLabel(img1);

        p3=new JPanel();
        p3.setLayout(new GridLayout(1,1,10,10));
        p3.add(l7);

        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");
        add(p3,"West");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            price=0;
            String username=ch1.getSelectedItem();
            try{
                Connection_Class ob3=new Connection_Class();
                String q3="select price from intercity_booked_details where username='"+username+"'";
                ResultSet rs3=ob3.stm.executeQuery(q3);
                while (rs3.next()){
                    price=price+Integer.parseInt(rs3.getString("price"));
                }
                t4.setText(price+"");
                rs3.close();
            }
            catch(Exception e3){
                e3.printStackTrace();
            }
        }
        if (e.getSource()==b2){
            price=0;
            String username=ch1.getSelectedItem();
            try{
                Connection_Class ob4=new Connection_Class();
                String q4="select price from intracity_booked_details where username ='"+username+"'";
                ResultSet rs4=ob4.stm.executeQuery(q4);
                while(rs4.next()){
                    price=price+Integer.parseInt(rs4.getString("price"));
                }
                t4.setText(price+"");
                rs4.close();
            }
            catch(Exception e4){
                e4.printStackTrace();
            }
        }
        if (e.getSource()==b3){
            price=0;
            String username=ch1.getSelectedItem();
            try{
                Connection_Class ob5=new Connection_Class();
                String q5="select price from transport_booked_details where username ='"+username+"'";
                ResultSet rs5=ob5.stm.executeQuery(q5);
                while(rs5.next()){
                    price=price+Integer.parseInt(rs5.getString("price"));
                }
                t4.setText(price+"");
                rs5.close();
            }
            catch(Exception e5){
                e5.printStackTrace();
            }
        }
        if (e.getSource()==b4){
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Check_bill().setVisible(true);
    }
}
