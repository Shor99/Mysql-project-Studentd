package com.javalecture;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        MySQL sql = new MySQL();
        sql.perform("create database Classroom");
        sql.perform("use Classroom");
        sql.perform("CREATE TABLE `Students` (`name` varchar(50), `phone_number` varchar(10) NOT NULL,`age` bigint,`GPA` double NOT NULL, PRIMARY KEY (`name`))");
        sql.perform("INSERT INTO `Students` VALUES ('Sharon','0523912542',33,78.2),('Dorin','0523912543',22,86),('Ofer','0523912544',26,69.1),('Haviv','0523912545',30,93.7),('Dor','0523912546',28,97.12),('Eli','0523912547',29,86),('Dorel','0523912548',26,76)");
        sql.query("SELECT name,GPA FROM Students ORDER BY GPA DESC",(rs)->{
            while(rs.next()){
                System.out.println("Name: " + rs.getString("name") + "\nGPA: " + rs.getString("GPA"));
            }
        });
        sql.query("SELECT name,phone_number,age,GPA FROM Students WHERE name LIKE '%dor%'",(rs)->{
            System.out.println("\nNames that have 'dor' in there name:");
            while(rs.next()){
                System.out.println("\nname: " + rs.getString("name") + "\nphone number: " + rs.getString("phone_number") + "\nage: " +  rs.getString("age") + "\nGPA: " + rs.getString("GPA"));
            }
        });
        sql.query("SELECT name,age,GPA FROM Students WHERE GPA = 86",(rs)->{
            System.out.println("\nStudents who has 86 GPA:");
            while(rs.next()){
                System.out.println("\nname: " + rs.getString("name") +  "\nage: " +  rs.getString("age"));
            }
        });
        sql.query("SELECT name,phone_number,age,GPA FROM Students WHERE GPA > 78 AND age > 28",(rs)->{
            System.out.println("\nStudents who is older than 28 and has more than 78 GPA:");
            while(rs.next()){
                System.out.println("\nname: " + rs.getString("name") + "\nphone number: " + rs.getString("phone_number") + "\nage: " +  rs.getString("age") + "\nGPA: " + rs.getString("GPA"));
            }
        });

    }

}
