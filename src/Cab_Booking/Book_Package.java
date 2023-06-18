package Cab_Booking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Random;

public class Book_Package extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
    Choice ch1,ch2,ch3,ch4;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JButton b1,b2;
    JPanel p1,p2,p3;
    Font f1,f2;

    Book_Package(){
        super("Book Truck");
        setLocation(50,10);
        setSize(1100,700);

        f1=new Font("Arial",Font.BOLD,25);
        f2=new Font("Arial",Font.BOLD,18);

        ch1=new Choice();
        ch2=new Choice();
        ch3=new Choice();
        ch4=new Choice();

        try{
            Connection_Class ob1=new Connection_Class();
            String q1="select DISTINCT source from transport_driver";
            ResultSet rs1=ob1.stm.executeQuery(q1);
            while (rs1.next()){
                ch1.add(rs1.getString("source"));
            }
            rs1.close();
        }
        catch(Exception e1){
            e1.printStackTrace();
        }

        try {
            Connection_Class ob2=new Connection_Class();
            String q2="select username from customer_profile";
            ResultSet rs2=ob2.stm.executeQuery(q2);
            while (rs2.next()){
                ch3.add(rs2.getString("username"));
            }
            rs2.close();
        }catch (Exception e2){
            e2.printStackTrace();
        }

        ch4.add("0-10 Kg");
        ch4.add("10-50 Kg");
        ch4.add("50-100 Kg");
        ch4.add("100-500 Kg");
        ch4.add("500-1000 Kg");
        ch4.add("> 1000 Kg");

        l1=new JLabel("Book Truck");

        l2=new JLabel("Booking ID");
        l3=new JLabel("Source");
        l4=new JLabel("Destination");
        l5=new JLabel("Customer ID");
        l6=new JLabel("Customer Name");
        l7=new JLabel("Driver Name");
        l8=new JLabel("Truck");
        l9=new JLabel("FROM");
        l10=new JLabel("TO");
        l11=new JLabel("Weight");
        l12=new JLabel("Distance");
        l13=new JLabel("Price(Rs)");

        l1.setHorizontalAlignment(JLabel.CENTER);

        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        t5=new JTextField();
        t6=new JTextField();
        t7=new JTextField();
        t8=new JTextField();

        t1.setEditable(false);
        t2.setEditable(false);
        t3.setEditable(false);
        t4.setEditable(false);
        t5.setEditable(false);
        t6.setEditable(false);
        t7.setEditable(false);
        t8.setEditable(false);

        b1=new JButton("Book Truck");
        b2=new JButton("Back");

        b1.setBackground(Color.YELLOW);
        b2.setBackground(Color.RED);

        b1.setForeground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        b1.addActionListener(this);
        b2.addActionListener(this);

        Random random=new Random();
        t1.setText(""+Math.abs(random.nextInt()%100000));
        t1.setForeground(Color.RED);

        l1.setFont(f1);

        l2.setFont(f2);
        l3.setFont(f2);
        l4.setFont(f2);
        l5.setFont(f2);
        l6.setFont(f2);
        l7.setFont(f2);
        l8.setFont(f2);
        l9.setFont(f2);
        l10.setFont(f2);
        l11.setFont(f2);
        l12.setFont(f2);
        l13.setFont(f2);

        t1.setFont(f2);
        t2.setFont(f2);
        t3.setFont(f2);
        t4.setFont(f2);
        t5.setFont(f2);
        t6.setFont(f2);
        t7.setFont(f2);
        t8.setFont(f2);

        ch1.setFont(f2);
        ch2.setFont(f2);
        ch3.setFont(f2);
        ch4.setFont(f2);

        b1.setFont(f2);
        b2.setFont(f2);

        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);

        p2=new JPanel();
        p2.setLayout(new GridLayout(13,1,10,10));
        p2.add(l2);
        p2.add(t1);
        p2.add(l3);
        p2.add(ch1);
        p2.add(l4);
        p2.add(ch2);
        p2.add(l5);
        p2.add(ch3);
        p2.add(l6);
        p2.add(t2);
        p2.add(l7);
        p2.add(t3);
        p2.add(l8);
        p2.add(t4);
        p2.add(l9);
        p2.add(t5);
        p2.add(l10);
        p2.add(t6);
        p2.add(l11);
        p2.add(ch4);
        p2.add(l12);
        p2.add(t7);
        p2.add(l13);
        p2.add(t8);

        p2.add(b1);
        p2.add(b2);

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Cab_Booking/Icons/7.jpg"));
        Image i1=img.getImage().getScaledInstance(580,500,Image.SCALE_DEFAULT);
        ImageIcon img1=new ImageIcon(i1);
        l14=new JLabel(img1);

        p3=new JPanel();
        p3.setLayout(new GridLayout(1,1,10,10));
        p3.add(l14);

        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");
        add(p3,"West");

        ch3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Connection_Class ob3= new Connection_Class();
                    String username=ch3.getSelectedItem();
                    String q3="select name from customer_profile where username ='"+username+"'";
                    ResultSet rs3=ob3.stm.executeQuery(q3);
                    while (rs3.next()){
                        t2.setText(rs3.getString("name"));
                    }
                    rs3.close();
                }catch(Exception e3){
                    e3.printStackTrace();
                }
            }
        });

        ch1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ch2.removeAll();
                try{
                    Connection_Class ob4=new Connection_Class();
                    String source=ch1.getSelectedItem();
                    String q4="select destination from transport_driver where source='"+source+"'";
                    ResultSet rs4=ob4.stm.executeQuery(q4);
                    while (rs4.next()){
                        ch2.add(rs4.getString("destination"));
                    }
                    rs4.close();
                }
                catch (Exception e4){
                    e4.printStackTrace();
                }
            }
        });

        ch2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Connection_Class ob5=new Connection_Class();
                    String source=ch1.getSelectedItem();
                    String dest=ch2.getSelectedItem();
                    String q5="select * from transport_driver where source='"+source+"' and destination ='"+dest+"'";
                    ResultSet rs5=ob5.stm.executeQuery(q5);
                    while(rs5.next()){
                        t3.setText(rs5.getString("driver"));
                        t4.setText(rs5.getString("truck"));
                        t5.setText(rs5.getString("source"));
                        t6.setText(rs5.getString("destination"));
                        t7.setText(rs5.getString("distance"));
                        t8.setText(rs5.getString("price"));
                    }
                }catch(Exception e5){
                    e5.printStackTrace();
                }
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            String bid=t1.getText();
            String cid=ch3.getSelectedItem();
            String driver=t3.getText();
            String truck=t4.getText();
            String from=t5.getText();
            String to=t6.getText();
            String weight=ch4.getSelectedItem();
            String dist=t7.getText();
            String price=t8.getText();

            try{
                Connection_Class ob6=new Connection_Class();
                String q6="insert into transport_booked_details values('"+bid+"','"+cid+"','"+driver+"','"+truck+"','"+from+"','"+to+"','"+weight+"','"+dist+"','"+price+"')";
                int a=ob6.stm.executeUpdate(q6);
                if (a==1){
                    JOptionPane.showMessageDialog(null,"Truck Booked Successfully");
                    this.setVisible(false);
                    new Choose_Page().setVisible(true);
                }
            }
            catch(Exception e6){
                e6.printStackTrace();
            }

        }
        if (e.getSource()==b2){
            this.setVisible(false);
            new Choose_Page().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Book_Package().setVisible(true);
    }
}
