package com.sapient;

import com.sapient.model.Trainer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleCRUD {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private static Scanner input = new Scanner(System.in);
    private String dbUrl = "jdbc:mysql://localhost:3306/sapient";
    private String username = "root";
    private String password = "root";

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn= DriverManager.getConnection(dbUrl,username,password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public List<Trainer> getTrainers () {
        List<Trainer> trainers = new ArrayList<Trainer>();

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from trainer");
            while(rs.next()){
                Trainer trainer = new Trainer();
                trainer.setId(rs.getInt("id"));
                trainer.setName(rs.getString("name"));
                trainer.setEmail(rs.getString("email"));
                trainer.setMobile(rs.getString("mobile"));
                trainer.setSkills(rs.getString("skills"));
                trainers.add(trainer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return trainers;
    }

    public int insertRecord(Trainer tnr) {
        int status = 0;
        try {
            conn = getConnection();
            ps = conn.prepareStatement("insert into trainer (name,email,mobile,skills) values (?,?,?,?)");
            ps.setString(1,tnr.getName());
            ps.setString(2,tnr.getEmail());
            ps.setString(3,tnr.getMobile());
            ps.setString(4,tnr.getSkills());
            status = ps.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return status;
    }

    public int updateRecord(int id, String colName, String colValue) {
        int status = 0;
        try {
            conn = getConnection();
            ps = conn.prepareStatement("update trainer set "+colName+" =? where id=?");
            ps.setString(1,colValue);
            ps.setInt(2,id);
            status = ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return status;
    }

    public int deleteRecord(int id) {
        int status = 0;
        try {
            conn = getConnection();
            ps = conn.prepareStatement("delete from trainer where id=?");
            ps.setInt(1,id);
            status = ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return status;
    }


    public static void main(String[] args) {
        int choice = 0;
        int id=0;
        String name =null;
        String email = null;
        String mobile = null;
        String skills = null;
        int status = 0;
        String colName = null;
        String colValue = null;

        while (choice>=0){
            System.out.println("Welcome to JDBC CRUD operation Program");
            System.out.println("\t\t 1. View Table Contents");
            System.out.println("\t\t 2. Insert new Record");
            System.out.println("\t\t 3. Edit a Record");
            System.out.println("\t\t 4. Delete a Record");
            System.out.println("\t\t 5. Exit");
            System.out.println("Please Enter your choice [1-5] :");
            choice = input.nextInt();

            switch (choice) {
                case 1 :
                    System.out.println("*******************Table Contents*******************");
                    List<Trainer> trainersList = new ArrayList<Trainer>();
                    trainersList = new SimpleCRUD().getTrainers();
                    System.out.println(trainersList);
                    break;
                case 2:
                    System.out.println("*******************Inserting a new Record*******************");
                    System.out.println("Enter the Name of the Trainer :");
                    name = input.next();
                    System.out.println("Enter the Email of the Trainer :");
                    email = input.next();
                    System.out.println("Enter the Mobile No of the Trainer :");
                    mobile = input.next();
                    System.out.println("Enter the Skills of the Trainer :");
                    skills = input.next();
                    Trainer tnr = new Trainer(name,email,mobile,skills);
                    status = new SimpleCRUD().insertRecord(tnr);
                    if (status!=0)
                        System.out.println(status + " Record inserted Successfully");
                    else
                        System.out.println("Error inserting record!!!");
                    break;
                case 3:
                    System.out.println("*******************Editing a Record*******************");
                    System.out.println("Enter the ID to update :");
                    id = input.nextInt();
                    System.out.println("Enter the Column Name to update :");
                    colName = input.next();
                    System.out.println("Enter the Column Value to Update: ");
                    colValue = input.next();
                    status = new SimpleCRUD().updateRecord(id,colName,colValue);
                    if (status!=0)
                        System.out.println(status + " Record updated Successfully");
                    else
                        System.out.println("Error updating record!!!");
                    break;
                case 4:
                    System.out.println("*******************Deleting a Record*******************");
                    System.out.println("Enter the ID to delete :");
                    id = input.nextInt();
                    status = new SimpleCRUD().deleteRecord(id);
                    if (status!=0)
                        System.out.println(status + " Record deleted Successfully");
                    else
                        System.out.println("Error deleting record!!!");
                    break;
                case 5:
                    System.out.println("Thanks for using our Application. Bye!!!!");
                    System.exit(0);
                default:
                    System.out.println("Please Enter any value between 1-5");
            }
        }

    }


}
