package Cab_Booking;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class View_Intracity_Cab extends JFrame {
    JTable jt;
    Font f;
    String [] x={"Booking Id","Customer ID","Driver","Car","Source","Destination","Price"};
    String [][] y=new String[20][10];
    int i=0,j=0;

    View_Intracity_Cab(){
        super("Intracity Cab Booking Details");
        setLocation(0,10);
        setSize(1300,400);

        f=new Font("MS UI Gothic",Font.BOLD,17);

        try{
            Connection_Class obj=new Connection_Class();
            String q="select * from intracity_booked_details";
            ResultSet rs=obj.stm.executeQuery(q);
            while(rs.next()){
                y[i][j++]=rs.getString("booking_id");
                y[i][j++]=rs.getString("username");
                y[i][j++]=rs.getString("driver");
                y[i][j++]=rs.getString("car");
                y[i][j++]=rs.getString("source");
                y[i][j++]=rs.getString("destination");
                y[i][j++]=rs.getString("price");
                i++;
                j=0;
            }
            jt=new JTable(y,x);
        }catch (Exception e){
            e.printStackTrace();
        }
        jt.setFont(f);
        jt.setBackground(Color.BLACK);
        jt.setForeground(Color.ORANGE);

        JScrollPane js=new JScrollPane(jt);
        add(js);

    }

    public static void main(String[] args) {
        new View_Intracity_Cab().setVisible(true);
    }
}
