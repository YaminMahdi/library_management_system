package core;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookList {
    public String bId;
    public String name;
    public String author;
    public int quantity;
    public String subject;
    public String section;

    // public BookList()
    // {
        
    // }

    public static void addBook(String nm, String athr, int qan, String sub, String sec) {
        //final String cs = "jdbc:mysql://localhost:3306/library_management_system?serverTimezone=UTC";
        //final String user = "root";
        //final String password = "";
        // Class.forName("org.gjt.mm.mysql.Drive");
        
        try
        {
            //Class.forName("com.mysql.cj.jdbc.Driver");
        	Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:library_management_system.sql");
            //Connection con = DriverManager.getConnection(cs,user,password);
            //Statement st = con.createStatement();
            //Insert data into database
            PreparedStatement ps = con.prepareStatement("INSERT INTO booklist (Name, Author, Quantity, Subject, Section) VALUES (?, ?, ?,  ?, ?)");
            ps.setString(1, nm);
            ps.setString(2, athr);
            ps.setInt(3, qan);
            ps.setString(4, sub);
            ps.setString(5, sec);
            ps.execute();
            JOptionPane.showMessageDialog(null, "New Book Added.");
            con.close();  
            // for (int i = 1; i <= 1; i++) 
            // {

            //     final String sql = "INSERT INTO booklist(BookID) VALUES(" + 2 * i + ")";
            //     st.executeUpdate(sql);
            // }

        } catch (final Exception ex) {

            System.out.println(ex);
        }
    }
    public static ArrayList<BookList> searchBook(String xx)
    {
    	ArrayList<BookList> searchList = new ArrayList<>();
    	//final String cs = "jdbc:mysql://localhost:3306/library_management_system?serverTimezone=UTC";
        //final String user = "root";
        //final String password = "";
        try
        {
            //Connection con = DriverManager.getConnection(cs,user,password);
        	Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:library_management_system.sql");
            Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM booklist WHERE Name LIKE '%"+xx+"%'");   //Retrieve.....executeQuery
			BookList b;
            while(rs.next()) 
            {
                b = new BookList();
                b.bId = rs.getString(1);
                b.name = rs.getString(2);
                b.author = rs.getString(3);
                b.quantity = rs.getInt(4);
                b.subject = rs.getString(5);
                b.section = rs.getString(6);

                searchList.add(b);
            }
            con.close();
            return searchList;
        }
        catch (final Exception ex){
        	JOptionPane.showMessageDialog(null, ex);
        	return searchList;}
			
    	//
    }
    public void removeBook()
    {

    }

    public static ArrayList<BookList> getList() {
    	ArrayList<BookList> getList = new ArrayList<>();
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
            ResultSet rs=stmt.executeQuery("select * from booklist");   //give table name
            BookList b;
            while(rs.next()) 
            {
                b = new BookList();
                b.bId = rs.getString(1);
                b.name = rs.getString(2);
                b.author = rs.getString(3);
                b.quantity = rs.getInt(4);
                b.subject = rs.getString(5);
                b.section = rs.getString(6);

                getList.add(b);
            }
            con.close();
        }
        
       
        catch (final Exception ex){
            JOptionPane.showMessageDialog(null, ex);}
       
        return getList;
    }

    public static int bkCount()
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
            //Data Retrieve from the database
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from booklist");   //give table name
            
            while(rs.next()) 
            {
                count += rs.getInt(4);
                //System.out.println(count);
            }
            con.close();
        }
            //con.close(); 
        catch (final Exception ex){
            JOptionPane.showMessageDialog(null, ex);}
        //count += BorrowerList.bwrCount();
        return count;
    } 
}