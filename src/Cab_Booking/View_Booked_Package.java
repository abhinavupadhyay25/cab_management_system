package Cab_Booking;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class View_Booked_Package extends JFrame {
    JTable jt;
    Font f;
    String[]x={"Booking ID","Customer ID","Driver","Truck","Source","Destination","Weight","Distance","Price"};
    String[][]y=new String[20][10];
    int i=0,j=0;

    View_Booked_Package(){
        super("Truck Booked Details");
        setLocation(0,10);
        setSize(1300,400);

        f=new Font("Arial",Font.BOLD,17);

        try{
            Connection_Class obj=new Connection_Class();
            String q="select * from transport_booked_details";
            ResultSet rs=obj.stm.executeQuery(q);
            while(rs.next()){
                y[i][j++]=rs.getString("booking_id");
                y[i][j++]=rs.getString("username");
                y[i][j++]=rs.getString("driver");
                y[i][j++]=rs.getString("truck");
                y[i][j++]=rs.getString("source");
                y[i][j++]=rs.getString("destination");
                y[i][j++]=rs.getString("weight");
                y[i][j++]=rs.getString("distance");
                y[i][j++]=rs.getString("price");

                i++;
                j=0;
            }
            jt=new JTable(y,x);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        jt.setFont(f);
        jt.setBackground(Color.BLACK);
        jt.setForeground(Color.GREEN);

        JScrollPane js=new JScrollPane(jt);
        add(js);
    }

    public static void main(String[] args) {
        new View_Booked_Package().setVisible(true);
    }
}
