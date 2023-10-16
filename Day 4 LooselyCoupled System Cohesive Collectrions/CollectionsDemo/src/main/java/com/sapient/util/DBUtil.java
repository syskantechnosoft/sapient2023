package com.sapient.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DBUtil {

    private static String url = "jdbc:mysql://localhost:3306/sapient";
    private static String url1 = "jdbc:mysql://localhost:3306/";
    private static String username = "root";
    private static String password = "root";
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet result = null;
    private static PreparedStatement pStatement = null;
    private static List<String> dbNames = new ArrayList<String>();
    private static List<String> tableNames = new ArrayList<String>();
    private int status = 0;
    private List<Object> objects = new ArrayList<Object>();
    private Object object = new Object();
    private Map<String, String> tableStructure = new HashMap<>();
    private int columnCount = 0;
    private ResultSetMetaData rsmd = null;
    private String pkeyName = null;
    private String pkeyType = null;
    private Scanner input = new Scanner(System.in);
    private Set<String> colNames = null;
    private List<String> colTypes = null;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(String dbName) {
        Connection conn = null;
        String fullUrl = url1 + dbName;
        try {
            conn = DriverManager.getConnection(fullUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection = conn;
        return conn;
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection = conn;
        return conn;
    }

    public void clearData () {
        tableStructure.clear();
        colNames.clear();
        colTypes.clear();
    }

    public static Connection getConnection1() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url1, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection = conn;
        return conn;
    }

    public static List<String> getTableNames() {
        getConnection();
        try {
            statement = connection.createStatement();
            result = statement.executeQuery("show tables");
            while (result.next()) {
                tableNames.add(result.getString(1));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tableNames;
    }

    public static List<String> getTableNames(String dbName) {
        getConnection(dbName);
        try {
            statement = connection.createStatement();
            result = statement.executeQuery("show tables");
            while (result.next()) {
                tableNames.add(result.getString(1));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tableNames;
    }

    public static List<String> getDBNames() {
        getConnection1();
        try {
            statement = connection.createStatement();
            result = statement.executeQuery("show databases");
            System.out.println("List of Available Databases");
            System.out.println("_______________________________");
            while (result.next()) {
                dbNames.add(result.getString(1));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dbNames;
    }

    public void getMetaData(String tableName) {
        getConnection();
        String query = "select * from " + tableName + " limit 1";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(query);
            rsmd = result.getMetaData();
            columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                tableStructure.put(rsmd.getColumnName(i), rsmd.getColumnTypeName(i));
            }
            pkeyName = rsmd.getColumnName(1);
            pkeyType = rsmd.getColumnTypeName(1);
            colNames = tableStructure.keySet();
            colTypes = new ArrayList<>();
            for (String col : colNames) {
                colTypes.add(tableStructure.get(col));
            }
            System.out.println("table Structure :" + tableStructure);
            System.out.println("pkey Name:" + pkeyName);
            System.out.println("pkey Type:" + pkeyType);
            System.out.println("colNames:" + colNames);
            System.out.println("colTypes:" + colTypes);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int addData(String tableName) {
        getMetaData(tableName);
        status = 0;
        StringBuffer query = new StringBuffer("insert into " + tableName + "  (");
        StringBuffer cols = new StringBuffer();
        StringBuffer qm = new StringBuffer();
        for (String col : colNames) {
            cols.append(col + ",");
            qm.append("?,");
        }
        cols.deleteCharAt(cols.lastIndexOf(","));
        qm.deleteCharAt(qm.lastIndexOf(","));
        System.out.println("cols :" + cols + " qm :" + qm);
        query.append(cols).append(") values (").append(qm).append(")");
        System.out.println("query = " + query);

        try {
            pStatement = connection.prepareStatement(query.toString());
            int i = 1;
            for (String col : colNames) {
                System.out.print("Please Enter " + col + " of Type -" + tableStructure.get(col) + " :");
                String str = input.nextLine();
                pStatement.setString(i, str);
                i++;
            }
            status = pStatement.executeUpdate();
            if (status != 0)
                System.out.println(status + " Record Inserted Successfully!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public int deleteData(String tableName, String id) {
        getMetaData(tableName);
        status = 0;
        StringBuffer query = new StringBuffer("delete from ");
        query.append(tableName).append(" where ").append(pkeyName).append("=").append(id);
        System.out.println("query = " + query);
        try {
            statement = connection.createStatement();
            status = statement.executeUpdate(query.toString());
            if (status != 0)
                System.out.println(" Record deleted Successfully!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public int editData(String tableName, String id) {
        return status;
    }

    public int getRowCount(String tableName) {
        int rowCount = 0;
        getConnection();
        String query = "select count(*) from " + tableName;
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(query);
            if(result.next())
                rowCount = result.getInt(1);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rowCount;
    }

    public List<Object> getAll(String tableName) {
        getMetaData(tableName);
        StringBuffer query = new StringBuffer("select * from ");
        query.append(tableName);
        System.out.println("query = " + query);
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(query.toString());
            while (result.next()) {
                for (String col : colNames)
                    System.out.print(result.getString(col) + "\t");
                System.out.print("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return objects;
    }

    public Object getById(String tableName, String id) {
        getMetaData(tableName);
        StringBuffer query = new StringBuffer("select * from ");
        query.append(tableName).append(" where ").append(pkeyName).append("=").append(id);
        System.out.println("query = " + query);
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(query.toString());
            if (result.next()) {
                for (String col : colNames)
                    System.out.print(result.getString(col) + "\t");
                System.out.print("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return object;
    }

    public static void closeResources() {
        try {
            if (result != null)
                result.close();
            if (pStatement != null)
                pStatement.close();
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
