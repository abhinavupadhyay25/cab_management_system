package Cab_Booking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Update_Customer extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
    JPanel p1,p2,p3;
    JButton b1,b2;
    Font f1,f2;
    Choice ch;

    Update_Customer(){
        super("Update Customer Details");
        setSize(740,700);
        setLocation(50,50);

        f1=new Font("Arial",Font.BOLD,25);
        f2=new Font("Arial",Font.BOLD,18);

        ch=new Choice();
        try{
            Connection_Class obj=new Connection_Class();
            String q="select username from customer_profile";
            ResultSet rs=obj.stm.executeQuery(q);
            while(rs.next()){
                ch.add(rs.getString("username"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        l1=new JLabel("Update Customer");
        l1.setHorizontalAlignment(JLabel.CENTER);

        l2=new JLabel("Username");
        l3=new JLabel("Name");
        l4=new JLabel("Age");
        l5=new JLabel("Date Of Birth");
        l6=new JLabel("Address");
        l7=new JLabel("Phone");
        l8=new JLabel("Email");
        l9=new JLabel("Country");
        l10=new JLabel("Gender");
        l11=new JLabel("Aadhar");

        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        t5=new JTextField();
        t6=new JTextField();
        t7=new JTextField();
        t8=new JTextField();
        t9=new JTextField();

        b1=new JButton("Update");
        b2=new JButton("Back");

        b1.addActionListener(this);
        b2.addActionListener(this);

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

        t1.setFont(f2);
        t2.setFont(f2);
        t3.setFont(f2);
        t4.setFont(f2);
        t5.setFont(f2);
        t6.setFont(f2);
        t7.setFont(f2);
        t8.setFont(f2);
        t9.setFont(f2);
        b1.setFont(f2);
        b2.setFont(f2);

        ch.setFont(f2);

        b1.setBackground(Color.BLACK);
        b2.setBackground(Color.RED);

        b1.setForeground(Color.WHITE);
        b2.setForeground(Color.WHITE);

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Cab_Booking/Icons/5.jpg"));
        Image i1=img.getImage().getScaledInstance(200,500,Image.SCALE_DEFAULT);
        ImageIcon img1=new ImageIcon(i1);
        l12=new JLabel(img1);

        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);

        p2=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p2.add(l12);

        p3=new JPanel();
        p3.setLayout(new GridLayout(11,2,10,10));
        p3.add(l2);
        p3.add(ch);
        p3.add(l3);
        p3.add(t1);
        p3.add(l4);
        p3.add(t2);
        p3.add(l5);
        p3.add(t3);
        p3.add(l6);
        p3.add(t4);
        p3.add(l7);
        p3.add(t5);
        p3.add(l8);
        p3.add(t6);
        p3.add(l9);
        p3.add(t7);
        p3.add(l10);
        p3.add(t8);
        p3.add(l11);
        p3.add(t9);

        p3.add(b1);
        p3.add(b2);

        setLayout(new BorderLayout(10,10));

        add(p1,"North");
        add(p2,"West");
        add(p3,"Center");

        ch.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me) {
                try {
                    Connection_Class obj1=new Connection_Class();
                    String username=ch.getSelectedItem();
                    String q1="select * from customer_profile where username ='"+username+"'";
                    ResultSet rs1=obj1.stm.executeQuery(q1);
                    while(rs1.next()){
                        t1.setText(rs1.getString("name"));
                        t2.setText(rs1.getString("age"));
                        t3.setText(rs1.getString("dob"));
                        t4.setText(rs1.getString("address"));
                        t5.setText(rs1.getString("phone"));
                        t6.setText(rs1.getString("email"));
                        t7.setText(rs1.getString("country"));
                        t8.setText(rs1.getString("gender"));
                        t9.setText(rs1.getString("aadhar"));
                    }
                }catch (Exception ex2){
                    ex2.printStackTrace();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            String username=ch.getSelectedItem();
            String name=t1.getText();
            String age=t2.getText();
            String dob=t3.getText();
            String address=t4.getText();
            String phone=t5.getText();
            String email=t6.getText();
            String country=t7.getText();
            String gender=t8.getText();
            String aadhar=t9.getText();

            try {
                Connection_Class obj2=new Connection_Class();
                String q2="update customer_profile set name='"+name+"',age='"+age+"', dob='"+dob+"',address='"+address+"',phone='"+phone+"',email='"+email+"',country='"+country+"',gender='"+gender+"',aadhar='"+aadhar+"' where username='"+username+"'";
                int a=obj2.stm.executeUpdate(q2);
                if(a==1){
                    JOptionPane.showMessageDialog(null,"Your data successfully updated");
                    this.setVisible(false);
                    new View_Customer().setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Please, fill details carefully");
                }
            }
            catch(Exception ex3){
                ex3.printStackTrace();
            }


        }
        if (e.getSource()==b2){
            new Choose_Page().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Update_Customer().setVisible(true);
    }
}
