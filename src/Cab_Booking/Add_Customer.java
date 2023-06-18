package Cab_Booking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Add_Customer extends JFrame implements ActionListener{
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    JButton b1,b2;

    public Add_Customer(){
        f=new JFrame("Add Customer");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        l1=new JLabel();
        l1.setBounds(0,0,900,600);
        l1.setLayout(null);

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Cab_Booking/Icons/4.png"));
        Image i1=img.getImage().getScaledInstance(900,600,Image.SCALE_DEFAULT);
        ImageIcon img1=new ImageIcon(i1);
        l1.setIcon(img1);

        l2=new JLabel("New Customer Details");

        l2.setBounds(280,30,500,50);
        l2.setFont(new Font("Arial",Font.BOLD,30));
        l2.setForeground(Color.BLACK);
        l1.add(l2);

        f.add(l1);

        l3=new JLabel("Customer ID");
        l3.setBounds(50,150,150,30);
        l3.setFont(new Font("Arial",Font.BOLD,20));
        l3.setForeground(Color.ORANGE);
        l1.add(l3);

        t1=new JTextField();
        t1.setBounds(200,150,150,30);
        t1.setFont(new Font("Arial",Font.BOLD,15));
        t1.setForeground(Color.RED);
        t1.setEditable(false);
        l1.add(t1);

        Random random=new Random();
        t1.setText("CST "+Math.abs(random.nextInt()%100000));

        l4=new JLabel("Name");
        l4.setBounds(450,150,200,30);
        l4.setFont(new Font("Airal",Font.BOLD,20));
        l4.setForeground(Color.ORANGE);
        l1.add(l4);

        t2=new JTextField();
        t2.setBounds(600,150,150,30);
        l1.add(t2);

        l5=new JLabel("Age");
        l5.setBounds(50,200,100,30);
        l5.setFont(new Font("Airal",Font.BOLD,20));
        l5.setForeground(Color.ORANGE);
        l1.add(l5);

        t3=new JTextField();
        t3.setBounds(200,200,150,30);
        l1.add(t3);

        l6=new JLabel("Date Of Birth");
        l6.setBounds(450,200,200,30);
        l6.setFont(new Font("Airal",Font.BOLD,20));
        l6.setForeground(Color.ORANGE);
        l1.add(l6);

        t4=new JTextField();
        t4.setBounds(600,200,150,30);
        l1.add(t4);

        l7=new JLabel("Address");
        l7.setBounds(50,250,100,30);
        l7.setFont(new Font("Airal",Font.BOLD,20));
        l7.setForeground(Color.ORANGE);
        l1.add(l7);

        t5=new JTextField();
        t5.setBounds(200,250,150,30);
        l1.add(t5);

        l8=new JLabel("Phone");
        l8.setBounds(450,250,100,30);
        l8.setFont(new Font("Airal",Font.BOLD,20));
        l8.setForeground(Color.ORANGE);
        l1.add(l8);

        t6=new JTextField();
        t6.setBounds(600,250,150,30);
        l1.add(t6);

        l9=new JLabel("Email ID");
        l9.setBounds(50,300,100,30);
        l9.setFont(new Font("Airal",Font.BOLD,20));
        l9.setForeground(Color.ORANGE);
        l1.add(l9);

        t7=new JTextField();
        t7.setBounds(200,300,150,30);
        l1.add(t7);

        l10=new JLabel("Country");
        l10.setBounds(450,300,100,30);
        l10.setFont(new Font("Airal",Font.BOLD,20));
        l10.setForeground(Color.ORANGE);
        l1.add(l10);

        t8=new JTextField();
        t8.setBounds(600,300,150,30);
        l1.add(t8);

        l11=new JLabel("Gender");
        l11.setBounds(50,350,100,30);
        l11.setFont(new Font("Airal",Font.BOLD,20));
        l11.setForeground(Color.ORANGE);
        l1.add(l11);

        t9=new JTextField();
        t9.setBounds(200,350,150,30);
        l1.add(t9);

        l12=new JLabel("Aadhar No");
        l12.setBounds(450,350,100,30);
        l12.setFont(new Font("Arial",Font.BOLD,20));
        l12.setForeground(Color.ORANGE);
        l1.add(l12);

        t10=new JTextField();
        t10.setBounds(600,350,150,30);
        l1.add(t10);

        b1=new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(250,500,150,40);

        b2=new JButton("Cancel");
        b2.setBackground(Color.RED);
        b2.setForeground(Color.WHITE);
        b2.setBounds(450,500,150,40);

        b1.addActionListener(this);
        b2.addActionListener(this);

        l1.add(b1);
        l1.add(b2);

        f.setVisible(true);
        f.setSize(900,600);
        f.setLocation(300,100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            String username=t1.getText();
            String name=t2.getText();
            String age=t3.getText();
            String dob=t4.getText();
            String address=t5.getText();
            String phone=t6.getText();
            String email=t7.getText();
            String country=t8.getText();
            String gender=t9.getText();
            String aadhar=t10.getText();

            try {
                Connection_Class obj=new Connection_Class();

                String q="insert into customer_profile values('"+username+"','"+name+"','"+age+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+country+"','"+gender+"','"+aadhar+"')";

                obj.stm.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details successfully inserted");
                f.setVisible(false);
                new Choose_Page().setVisible(true);
            }
            catch (Exception exception){
                exception.printStackTrace();
            }

        }
        if (e.getSource()==b2){
            f.setVisible(false);
            new Choose_Page().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Add_Customer();
    }
}
