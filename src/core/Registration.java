package core;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Registration {
    public static int newId=1;
    public static boolean signUp(String id, String pw, String email)
    {
        //System.out.println(id);
        //System.out.println(pw);
        //System.out.println(email);
        try
        {
            
        	Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:library_management_system.sql");
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //Connection con = DriverManager.getConnection(cs,user,password);
            //Connection con = DriverManager.getConnection("jdbc:mysql: library_management_system.sql");
            //Insert data into database
            PreparedStatement ps = con.prepareStatement("INSERT INTO login (Id, Pass, Email, Valid_Atmp) VALUES (?, ?, ?, ?)");
            ps.setString(1, id);
            ps.setString(2, pw);
            ps.setString(3, email);
            Connection con1 = DriverManager.getConnection("jdbc:sqlite:library_management_system.sql");
            Statement stmt=con1.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from login where Valid_Atmp='"+newId+"'");
            int r=0;
            if(rs.next()&&rs.getInt(4)==1)
            {
                JOptionPane.showMessageDialog(null, "Already Registraed. Try to Login.");
                ps.setInt(4, 0);
                ps.execute();
                r=0;
            }
            else
            {
                ps.setInt(4, 1);
                ps.execute();
                JOptionPane.showMessageDialog(null, "Registration Successfull.");
                r=1;
            }
            con1.close();
            con.close();
            //System.out.println(r);
            if(r==1)
            	return true;
            else
            	return false;
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            return false;}
    }
    public static boolean signIn(String id, String pw)
    {
        //final String cs = "jdbc:mysql:library_management_system.sql";
        //final String user = "root";
        //final String password = "";
        try
        {
            //Class.forName("com.mysql.cj.jdbc.Driver");
        	//Connection con = DriverManager.getConnection(cs,user,password);
        	Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:library_management_system.sql");
            //Data Retrieve from the database
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from login where Id='"+id+"'");   //give table name
            if(rs.next()) 
            {
                String dbPw = rs.getString(2);
                int atmp = rs.getInt(4);
                con.close(); 
                if (pw.equals(dbPw)&&atmp==1){
                    JOptionPane.showMessageDialog(null, "Login Successful.");
                    return true;}
                else if(atmp==1){
                    JOptionPane.showMessageDialog(null, "Invalid Password.");
                    return false;}
                else{
                    JOptionPane.showMessageDialog(null, "Invalid Login.");
                    return false;}
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid Id.");
                return false;}
        }
        catch (Exception ex){
        	JOptionPane.showMessageDialog(null, ex);
            return false;}
    }
}