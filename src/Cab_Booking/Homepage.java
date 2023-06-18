package Cab_Booking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Homepage extends JFrame implements ActionListener{
    JLabel l1;
    Font f1,f2,f3;
    JPanel p1,p2;
    JMenuBar m;
    Homepage(){
        super("Cab Booking Homepage");
        setLocation(0,0);
        setSize(1550,800);

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Cab_Booking/Icons/3.png"));
        Image i1=img.getImage().getScaledInstance(1550,800,Image.SCALE_DEFAULT);
        ImageIcon img1=new ImageIcon(i1);

        l1=new JLabel(img1);
        //l1.setIcon(img1);

        f1=new Font("Lucida Fax",Font.BOLD,20);
        f2=new Font("Gadugi",Font.BOLD,35);
        f3=new Font("MS UI Gothic",Font.BOLD,18);

        m=new JMenuBar();

        JMenu m1=new JMenu("Customer Profile");
        JMenuItem mt1=new JMenuItem("Add Customer Profile");
        JMenuItem mt2=new JMenuItem("View Customer Profile");

        JMenu m2=new JMenu("Manage Customer");
        JMenuItem mt3=new JMenuItem("Update Customer Details");

        JMenu m3=new JMenu("Intracity Cab");
        JMenuItem mt4=new JMenuItem("Book Intracity cab");
        JMenuItem mt5=new JMenuItem("View Intracity Booked cab");

        JMenu m4=new JMenu("Intercity Cab");
        JMenuItem mt6=new JMenuItem("Book Intercity Cab");
        JMenuItem mt7=new JMenuItem("View Intercity Booked cab");

        JMenu m5=new JMenu("Transport");
        JMenuItem mt8=new JMenuItem("Book Package");
        JMenuItem mt9=new JMenuItem("View Booked Package");

        JMenu m6=new JMenu("Bill");
        JMenuItem mt10=new JMenuItem("Check Bill");

        JMenu m7=new JMenu("Delete");
        JMenuItem mt11=new JMenuItem("Delete Customer");

        JMenu m8=new JMenu("About");
        JMenuItem mt12=new JMenuItem("About");
        JMenuItem mt13=new JMenuItem("Exit");

        m1.add(mt1);
        m1.add(mt2);
        m2.add(mt3);
        m3.add(mt4);
        m3.add(mt5);
        m4.add(mt6);
        m4.add(mt7);
        m5.add(mt8);
        m5.add(mt9);
        m6.add(mt10);
        m7.add(mt11);
        m8.add(mt12);
        m8.add(mt13);

        m.add(m1);
        m.add(m2);
        m.add(m3);
        m.add(m4);
        m.add(m5);
        m.add(m6);
        m.add(m7);
        m.add(m8);

        m.setBackground(Color.BLACK);

        m1.setForeground(Color.gray);
        m2.setForeground(Color.gray);
        m3.setForeground(Color.gray);
        m4.setForeground(Color.gray);
        m5.setForeground(Color.gray);
        m6.setForeground(Color.gray);
        m7.setForeground(Color.RED);
        m8.setForeground(Color.gray);

        mt1.setBackground(Color.BLACK);
        mt2.setBackground(Color.BLACK);
        mt3.setBackground(Color.BLACK);
        mt4.setBackground(Color.BLACK);
        mt5.setBackground(Color.BLACK);
        mt6.setBackground(Color.BLACK);
        mt7.setBackground(Color.BLACK);
        mt8.setBackground(Color.BLACK);
        mt9.setBackground(Color.BLACK);
        mt10.setBackground(Color.BLACK);
        mt11.setBackground(Color.BLACK);
        mt12.setBackground(Color.BLACK);
        mt13.setBackground(Color.BLACK);

        mt1.setForeground(Color.YELLOW);
        mt2.setForeground(Color.YELLOW);
        mt3.setForeground(Color.YELLOW);
        mt4.setForeground(Color.YELLOW);
        mt5.setForeground(Color.YELLOW);
        mt6.setForeground(Color.YELLOW);
        mt7.setForeground(Color.YELLOW);
        mt8.setForeground(Color.YELLOW);
        mt9.setForeground(Color.YELLOW);
        mt10.setForeground(Color.YELLOW);
        mt11.setForeground(Color.RED);
        mt12.setForeground(Color.YELLOW);
        mt13.setForeground(Color.YELLOW);

        setJMenuBar(m);
        add(l1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd=e.getActionCommand();
        if (cmd.equals("Add Customer Profile")){
            new Add_Customer();
        }
        else if(cmd.equals("View Customer Profile")){
            new View_Customer().setVisible(true);
        }
        else if(cmd.equals("Update Customer Details")){
            new Update_Customer().setVisible(true);
        }
        else if(cmd.equals("Book Intracity cab")){
            new Book_Intracity_Cab().setVisible(true);
        }
        else if (cmd.equals("View Intracity Booked cab")){
            new View_Intracity_Cab().setVisible(true);
        }
        else if(cmd.equals("Book Intercity cab")){
            new Book_Intercity_Cab().setVisible(true);
        }
        else if (cmd.equals("View Intercity Booked cab")){
            new View_Intercity_Cab().setVisible(true);
        }
        else if (cmd.equals("Book Package")){
            new Book_Package().setVisible(true);
        }
        else if (cmd.equals("View Booked Package")){
            new View_Booked_Package().setVisible(true);
        }
        else if (cmd.equals("Check Bill")){
            new Check_bill().setVisible(true);
        }
        else if (cmd.equals("Delete Customer")){
            //new Delete_Customer().setVisible(true);
        }
        else if (cmd.equals("About")){
            //new About().setVisible(true);
        }
        else if (cmd.equals("Exit")){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Homepage().setVisible(true);
    }
}
