package Cab_Booking;

//import java.sql.DriverManager;
import java.sql.*;


public class Connection_Class {
    Connection con = null;
    Statement stm;
    Connection_Class(){
        try{
            //Loading Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println("Driver Loaded");

            //Establishing connection
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_management","root","rishu12345");
            //System.out.println("connection established");
            stm=con.createStatement();
        }
        catch (ClassNotFoundException e){
            //System.out.println("Exception : "+e.getMessage());
            e.printStackTrace();
        }
        catch(SQLException e){
            //System.out.println("SQL Exception : "+e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Connection_Class();
    }
}
