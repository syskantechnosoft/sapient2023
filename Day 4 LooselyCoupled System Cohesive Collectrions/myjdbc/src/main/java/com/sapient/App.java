package com.sapient;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws  Exception
    {

        System.out.println( "Welcome to JDBC" );

        //Step 1 : Load & Register the Driver (Driver)
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Step 2 : Establishing the Connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sapient","root","root");

        //Step 3 : Create & Execute Query
        Statement stmt = conn.createStatement();

        //partial insert
        String insertQuery = "insert into trainer (name,email,mobile,skills) values (?,?,?,?)";
        String updateQuery = "update trainer set name=?, email=?, mobile=?, skills=? where id=?";
        String deleteQuery = "delete from trainer where id =?";
        PreparedStatement pstmt = conn.prepareStatement(insertQuery);

        //Step 4: Storing & Processing the Result
        //Read Operation
        ResultSet rs = stmt.executeQuery("select * from trainer");

        while (rs.next()){
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString("email")+" "+rs.getString(4)+" "+rs.getString(5));
        }

        //Insert Operation
        pstmt.setString(1,"xyz");
        pstmt.setString(2,"xyz@gmail.com");
        pstmt.setString(3,"9809786756");
        pstmt.setString(4,"Java,Python,AI,ML");

        pstmt.execute();
        System.out.println("One Record Inserted!!!");

        //Delete Operation
        PreparedStatement pstmt1 = conn.prepareStatement(deleteQuery);
        pstmt1.setInt(1,104);

        int deleteStatus = 0;
        deleteStatus = pstmt1.executeUpdate();
        if (deleteStatus !=0)
            System.out.println("One Record Deleted Successfully!!!");
        else
            System.out.println("Error while deleting record!!!");

        //Update Operation (Assignment)

        //Step 5 : Closing resources
        rs.close();
        stmt.close();
        conn.close();
    }
}
