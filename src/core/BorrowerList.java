package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BorrowerList {
    public String id;
    public String name;
    public String brwdBk;
    public String bid;
    public String pnNo;
    public String address;
    
    public static void addBwr(String id, String name, int bid, String pnNo, String add)
    {
        //final String cs = "jdbc:mysql://localhost:3306/library_management_system?serverTimezone=UTC";
        //final String user = "root";
        //final String password = "";
       
        try
        {
            //Connection con = DriverManager.getConnection(cs,user,password);
        	Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:library_management_system.sql");
            PreparedStatement ps = con.prepareStatement("INSERT INTO borrowerlist (ID, Name,Borrowed_Book, Book_Id, Phone_No, Address) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setInt(4, bid);
            ps.setString(5, pnNo);
            ps.setString(6, add);
            Connection con1 = DriverManager.getConnection("jdbc:sqlite:library_management_system.sql");
            Statement stmt=con1.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from booklist where BookID='"+bid+"'");   //Retrieve.....executeQuery
			if(rs.next())
            {
                String bName = rs.getString(2);
                //MODIFY
                int quantity = rs.getInt(4);
                quantity--;
                con1.close();
                Connection con2 = DriverManager.getConnection("jdbc:sqlite:library_management_system.sql");
                PreparedStatement ps2 = con2.prepareStatement("UPDATE booklist SET Quantity = (?) WHERE booklist.BookID ='"+bid+"'");
                ps2.setInt(1, quantity);
                ps2.execute();
                //MODIFY
                ps.setString(3, bName);
                ps.execute();
                con2.close();
                JOptionPane.showMessageDialog(null, "Borrower Added.");
            }
            else
                JOptionPane.showMessageDialog(null, "Wrong Book Id.");
            con.close();  

        } catch (final Exception ex) {

            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void editbwr()
    {

    }
    public static boolean removeBwr(String ID)
    {
    	//final String cs = "jdbc:mysql://localhost:3306/library_management_system?serverTimezone=UTC";
        //final String user = "root";
        //final String password = "";
        int bid;
        try
        {
            //Connection con = DriverManager.getConnection(cs,user,password);
        	Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:library_management_system.sql");
            Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from borrowerlist where ID='"+ID+"'");   //Retrieve.....executeQuery
			if(rs.next())
            {
                //get book id
                bid = rs.getInt(4);
                con.close();
                Connection con1 = DriverManager.getConnection("jdbc:sqlite:library_management_system.sql");
                //System.out.println(bid);
                Statement stmt1=con1.createStatement();  
    			ResultSet rs1=stmt1.executeQuery("select * from booklist where BookID='"+bid+"'");   //Retrieve.....executeQuery
    			if(rs1.next())
                {
                    //MODIFY
                    int quantity = rs1.getInt(4);
                    //System.out.println(quantity);
                    quantity++;
                    //System.out.println(quantity);
                    con1.close();
                    Connection con2 = DriverManager.getConnection("jdbc:sqlite:library_management_system.sql");
                    PreparedStatement ps2 = con2.prepareStatement("UPDATE booklist SET Quantity = (?) WHERE BookID ='"+bid+"'");
                    ps2.setInt(1, quantity);
                    ps2.execute();
                    con2.close();
                    //MODIFY
                } 
            }
            else
                JOptionPane.showMessageDialog(null, "Wrong Borrower Id.");
			
            Connection con3 = DriverManager.getConnection("jdbc:sqlite:library_management_system.sql");
           
            Statement stmt2=con3.createStatement();
            
            ResultSet rs2=stmt2.executeQuery("select * from borrowerlist where ID='"+ID+"'");   //Retrieve.....executeQuery
			if(rs2.next())
            {
				stmt2.executeUpdate("DELETE FROM borrowerlist WHERE ID='"+ID+"'");   //Delete.....executeUpdate
				JOptionPane.showMessageDialog(null, "Borrower Removed.");
				con3.close();
				return true;
            }
            else
            {
                con3.close();
            	return false;
            }
			
        }
        catch (final Exception ex){
        	JOptionPane.showMessageDialog(null, ex);
        	return false;}
            //}
       
    }
    public static ArrayList<BorrowerList> getList() 
    {
    	ArrayList<BorrowerList> getList = new ArrayList<>();
    	//final String cs = "jdbc:mysql://localhost:3306/library_management_system?serverTimezone=UTC";
        //final String user = "root";
        //final String password = "";
        try
        {
            //Connection con = DriverManager.getConnection(cs,user,password);
        	Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:library_management_system.sql");

            //Data Retrieve from the database
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from borrowerlist");   //give table name
            BorrowerList b;
            while(rs.next()) 
            {
                b = new BorrowerList();
                b.id = rs.getString(1);
                b.name = rs.getString(2);
                b.brwdBk = rs.getString(3);
                b.bid = rs.getString(4);
                b.pnNo = rs.getString(5);
                b.address= rs.getString(6);

                getList.add(b);
            }
            con.close();
        }
        catch (final Exception ex){
            JOptionPane.showMessageDialog(null, ex);}
       
        return getList;
    }
    public static int bwrCount()
    {
    	//final String cs = "jdbc:mysql://localhost:3306/library_management_system?serverTimezone=UTC";
        //final String user = "root";
        //final String password = "";
        int count=0;
        try
        {
            //Connection con = DriverManager.getConnection(cs,user,password);
        	Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:library_management_system.sql");
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("SELECT count(*) FROM borrowerlist");   //give table name
            while(rs.next()) 
            {
                count = rs.getInt(1);
            }
            con.close();
        }
            //con.close(); 
        catch (final Exception ex){
            JOptionPane.showMessageDialog(null, ex);}
    	return count;
    }
}