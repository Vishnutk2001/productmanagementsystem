package com.harman.java;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Details {
    public static void main(String[] args) throws SQLException {
        Scanner in = new Scanner(System.in);
        int option;
        while (true){
            System.out.println("Select the option");
            System.out.println("1. Add the PRODUCTS ");
            System.out.println("2. View All products ");
            System.out.println("3. Search a product using product  code ");
            System.out.println("4. Update product details using product Code");
            System.out.println("5. Delete a product  using product Code ");
            System.out.println("6. Display all the details of products  whose price  is greater than 50000");
            System.out.println("7. Display the count of total number of products  in the company");
            System.out.println("8. Display all the product details in alphabetical order");
            System.out.println("9. Exit");
            option = in.nextInt();
            switch (option){
                case 1:
                    System.out.println("1. Add the PRODUCTS");
                    try{
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false", "root", "");
                        Scanner input = new Scanner(System.in);
                        String code,name,brand,price,model,year,date;
                        System.out.println("enter code");
                        code = input.next();
                        System.out.println("enter name");
                        name = input.next();
                        System.out.println("enter brand");
                        brand = input.next();
                        System.out.println("enter price");
                        price = input.next();
                        System.out.println("enter model");
                        model = input.next();
                        System.out.println("enter year");
                        year = input.next();
                        System.out.println("enter date");
                        date = input.next();
                        Statement stmt = c.createStatement();
                        stmt.executeUpdate("INSERT INTO `product`(`code`, `name`, `brand`, `price`, `model`, `year`, `date`) " +
                                "VALUES("+code+",'"+name+"','"+brand+"',"+price+",'"+model+"',"+year+","+date+")");
                        System.out.println("Inserted successfully");


                    }catch (Exception e){
                        System.out.println(e);
                    }break;
                case 2:
                    System.out.println("2. View All products");
                    try {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT  `code`, `name`, `brand`, `price`, `model`, `year`, `date` FROM `product` WHERE 1");
                        while (rs.next()) {
                            System.out.println("code=" + rs.getInt("code"));
                            System.out.println("name=" + rs.getString("name"));
                            System.out.println("brand=" + rs.getString("brand"));
                            System.out.println("price=" + rs.getInt("price"));
                            System.out.println("model=" + rs.getString("model"));
                            System.out.println("year=" + rs.getInt("year"));
                            System.out.println("date=" + rs.getInt("date"));


                        }



                    }catch (Exception e){
                        System.out.println(e);
                    }break;
                case 3:
                    System.out.println("3. Search a product using product  code");
                    try {

                    Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false", "root", "");
                    Statement stmt = c.createStatement();
                    Scanner s = new Scanner(System.in);
                    String code = s.next();
                    ResultSet rs=stmt.executeQuery("SELECT * FROM `product` WHERE code="+code+"");
                    while (rs.next()) {
                        System.out.println("id=" + rs.getInt("id"));
                        System.out.println("code=" + rs.getInt("code"));
                        System.out.println("name=" + rs.getString("name"));
                        System.out.println("brand=" + rs.getString("brand"));
                        System.out.println("price=" + rs.getInt("price"));
                        System.out.println("model=" + rs.getString("model"));
                        System.out.println("year=" + rs.getInt("year"));
                        System.out.println("date=" + rs.getInt("date"));
                    }

                    }catch (Exception e){
                        System.out.println(e);
                    }break;
                case 4:
                    System.out.println("Update product details using product Code");
                    try {

                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        Scanner s = new Scanner(System.in);
                        String code, name, brand, price, model, year, date;
                        System.out.println("enter code");
                        code = s.next();
                        System.out.println("enter name");
                        name = s.next();
                        System.out.println("enter brand");
                        brand = s.next();
                        System.out.println("enter price");
                        price = s.next();
                        System.out.println("enter model");
                        model = s.next();
                        System.out.println("enter year");
                        year = s.next();
                        System.out.println("enter date");
                        date = s.next();
                        stmt.executeUpdate("update product set name='" + name + "',brand='" + brand + "',price=" + price + ",model='" + model + "',year=" + year + ",date='" + date + "' WHERE code=" + code + ")");
                        System.out.println("Updated successfully");
                    }catch (Exception e){
                        System.out.println(e);

                    }break;
                case 5:
                    System.out.println("5. Delete a product  using product Code ");
                    try {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        Scanner s = new Scanner(System.in);
                        String code;
                        code = s.next();
                        stmt.executeUpdate("Delete from product where code=" + code + "");
                        System.out.println("Deleted successfully");
                    }catch (Exception e){
                        System.out.println(e);
                    }break;
                case 6:
                    System.out.println("6. Display all the details of products  whose price  is greater than 50000");
                    try {
                    Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false", "root", "");
                    Statement stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from product where price > 50000");
                    while (rs.next()) {
                        System.out.println("id=" + rs.getInt("id"));
                        System.out.println("code=" + rs.getInt("code"));
                        System.out.println("name=" + rs.getString("name"));
                        System.out.println("brand=" + rs.getString("brand"));
                        System.out.println("price=" + rs.getInt("price"));
                        System.out.println("model=" + rs.getString("model"));
                        System.out.println("year=" + rs.getInt("year"));
                        System.out.println("date=" + rs.getInt("date"));
                    }

                    }catch (Exception e){
                        System.out.println(e);
                    }break;
                case 7:
                    System.out.println("7. Display the count of total number of products  in the company");
                    try {

                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        int count = 0;
                        ResultSet rs = stmt.executeQuery("select name from product");
                        while (rs.next()) {
                            count++;
                        }
                        System.out.println("Number of counts" + count);
                    }catch (Exception e){
                        System.out.println(e);
                    }break;
                case 8:
                    System.out.println("8. Display all the product details in alphabetical order");
                    try {

                    Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false", "root", "");
                    Statement stmt = c.createStatement();
                    ResultSet rs=stmt.executeQuery("select * from product order by name");
                    while (rs.next()) {
                        System.out.println("id=" + rs.getInt("id"));
                        System.out.println("code=" + rs.getInt("code"));
                        System.out.println("name=" + rs.getString("name"));
                        System.out.println("brand=" + rs.getString("brand"));
                        System.out.println("price=" + rs.getInt("price"));
                        System.out.println("model=" + rs.getString("model"));
                        System.out.println("year=" + rs.getInt("year"));
                        System.out.println("date=" + rs.getInt("date"));
                    }

                    }catch (Exception e){
                        System.out.println(e);
                    }break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Invalid option");











            }
        }
    }
}













