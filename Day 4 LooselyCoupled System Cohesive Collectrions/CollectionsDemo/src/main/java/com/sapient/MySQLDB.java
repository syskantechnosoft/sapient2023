package com.sapient;

import com.sapient.util.DBUtil;

import java.util.*;

public class MySQLDB {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> tableNames = DBUtil.getTableNames();
        int i = 1;
        int choice = 0;
        String selectedTable = null;
        Map<Integer, String> tables = new HashMap<Integer, String>();
        int operation = 0;
        DBUtil dbUtil = new DBUtil();
        for (String table : tableNames) {
            tables.put(i, table);
            // System.out.println("\t\t\t" + i + "." + table);
            i++;
        }
        Set<Integer> tableNumber = tables.keySet();
        System.out.println("Welcome to MySQL Java Application");
        while (choice != i) {
            operation = 0;
//			System.out.println("i=" + i);
//			System.out.println("choice =" + choice);
            System.out.println("\t\t\t List of Tables Available in Sapient DB");
            for (Integer key : tableNumber) {
                System.out.println("\t\t\t" + key + "." + tables.get(key));
            }
            System.out.println("\t\t\t" + i + ".Exit");
            System.out.print("Please select the table you want to Operate:[1-" + i + "]:");
            choice = input.nextInt();
            if (choice == i) {
                break;
            } else {
//				System.out.println("Entering Else block");
                selectedTable = tables.get(choice);
                while (operation < 7) {
                    System.out.println("Selected Table is :======:" + selectedTable);
                    System.out.println("\t 1. Show Contents\r\n" + "\t 2. Add a Row\r\n" + "\t 3. Delete a Row\r\n"
                            + "\t 4. Edit a Row\r\n" + "\t 5. Count total Records(ROWS)\r\n" + "\t 6. Search a Row\r\n"
                            + "\t 7. Back to Main menu\r\n");
                    System.out.print("Please Enter your choice:[1-7]:");
                    operation = input.nextInt();

                    switch (operation) {
                        case 1:
                            dbUtil.getAll(selectedTable);
                            break;
                        case 2:
                            dbUtil.addData(selectedTable);
                            break;
                        case 3:
                            dbUtil.getMetaData(selectedTable);
                            System.out.println("Enter id to delete :");
                            String id = "";
                            id = input.next();
                            dbUtil.deleteData(selectedTable, id);
                            break;
                        case 4:
                            break;
                        case 5:
                            dbUtil.getMetaData(selectedTable);
                            System.out.println(
                                    "Total Rows in " + selectedTable + " is :" + dbUtil.getRowCount(selectedTable));
                            break;
                        case 6:
                            dbUtil.getMetaData(selectedTable);
                            System.out.println("Enter id to search :");
                            String id1 = "";
                            id1 = input.next();
                            dbUtil.getById(selectedTable, id1);
                            break;
                    }
                }
                dbUtil.clearData();
            }
        }
        DBUtil.closeResources();
        System.out.println("Thanks for using our MySQL Java Application");
        input.close();
    }

}
