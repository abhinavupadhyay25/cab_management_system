package Cab_Booking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class View_Customer extends JFrame{
    Font f;
    JTable t;
    String [] x={"Username","Name","Age","Date Of Birth","Address","Phone","Email","Country","Gender","Aadhar"};
    String [][] y=new String[20][10];
    int i=0,j=0;

    View_Customer(){
        super("All customer details");
        setSize(1300,400);
        setLocation(0,10);

        f=new Font("MS Ui Gothic",Font.BOLD,17);

        try {
            Connection_Class obj=new Connection_Class();

            String q="select * from customer_profile";
            ResultSet rs=obj.stm.executeQuery(q);
            while(rs.next()){
                y[i][j++]=rs.getString("username");
                y[i][j++]=rs.getString("name");
                y[i][j++]=rs.getString("age");
                y[i][j++]=rs.getString("dob");
                y[i][j++]=rs.getString("address");
                y[i][j++]=rs.getString("phone");
                y[i][j++]=rs.getString("email");
                y[i][j++]=rs.getString("country");
                y[i][j++]=rs.getString("gender");
                y[i][j++]=rs.getString("aadhar");
                i++;
                j=0;
            }
            t=new JTable(y,x);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        t.setFont(f);
        t.setBackground(Color.BLACK);
        t.setForeground(Color.WHITE);

        JScrollPane js=new JScrollPane(t);
        add(js);
    }

    public static void main(String[] args) {
        new View_Customer().setVisible(true);
    }
}
