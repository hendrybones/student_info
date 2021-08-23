package com.pluralsight.calcengine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException, SQLException, ClassNotFoundException {
        int choice=0;
        System.out.println("\n1. Add Student\n" +
                "2. view Student\n" +
                "3. update Student\n" +
                "4. delete Students\n" +
                "5.search student \n" +
                "0. Exit\n");
        Scanner scan=new Scanner(System.in);
        choice=scan.nextInt();
        switch (choice){
            case 1:
                studentDetails();
                break;
            case 2:
                viewStudent();
                break;
            case 3:
//                updateStudent();
                break;
            case 4:
//                deleteStudent();
                break;
            case 5:
//                searchStudent();
                break;
            default:
                System.out.println("select the correct option");
        }
        while (choice!=0);
    }
    private static void studentDetails() throws ParseException, SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter registration no");
        String regNo = scanner.nextLine();
        System.out.println("enter your course");
        String course = scanner.nextLine();
        System.out.println("enter your gender (male or female)");
        String gender = scanner.nextLine();
        Gender g = Gender.valueOf(gender);
        System.out.println("enter date of birth (dd-MM-yyyy)");
        String date = scanner.nextLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dateOfBirth = simpleDateFormat.parse(date);
        System.out.println("enter date of Admission  (dd-MM-yyyy)");
        String da = scanner.nextLine();
        SimpleDateFormat DateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dateOfAdmission = DateFormat.parse(da);
        Student s = new Student(regNo, g, dateOfBirth, dateOfAdmission);
        System.out.println(s);
        insertStudentDetails(regNo, course, gender, date, da);
    }

    public static int insertStudentDetails(String regNo, String course, String gender, String date, String da) throws SQLException, ClassNotFoundException {

        DbUtil db=new DbUtil();
        Connection con=db.getConnection();
        String sql="insert into student values(?,?,?,?,?);";
        PreparedStatement stmt=con.prepareStatement(sql);
        stmt.setString(1, regNo);
        stmt.setString(2, course);
        stmt.setString(3, gender);
        stmt.setString(4, date);
        stmt.setString(5, da);
        int a= stmt.executeUpdate();
        System.out.println("record inserted successfully");
//        db.closeConnections();
        return a;
    }

    public static int updateStudent(String regNo1,String regN02) throws SQLException, ClassNotFoundException {
        int i = 0;
        try {
            DbUtil db = new DbUtil();
            Connection con = db.getConnection();
//            Scanner input = new Scanner(System.in);
//            System.out.println("enter reg no");
//            String inputName = input.nextLine();
//            System.out.println("enter new regNo");
//            String inputReg = input.nextLine();
            String sql = "update student set regNo=? where regNo=?;";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, regNo1);
            stmt.setString(2, regN02);
            i = stmt.executeUpdate();
            if (i > 0) {
                System.out.println("record updated successfully");
            } else {
                System.out.println("no such record updated in the database");
            }
            db.closeConnections();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return i;

    }
    public  static  void viewStudent()throws SQLException, ClassNotFoundException{
        DbUtil db=new DbUtil();
        Connection con=db.getConnection();
        ResultSet rs=db.readData("select * from student");
        while(rs.next()){
            String c=rs.getString(1) +" "+ rs.getString(2)+" " +rs.getString(3);
            System.out.println(c);
        }
    }
    public static int deleteStudent(String regNo) throws SQLException, ClassNotFoundException {
        int i = 0;
        try {
            DbUtil db = new DbUtil();
            Connection con = db.getConnection();
//            System.out.println("enter regNo to delete");
//            Scanner scanner = new Scanner(System.in);
//            String inputReg = scanner.nextLine();
            String sql = "delete from student where regNo=?;";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, regNo);
            i = stmt.executeUpdate();
            if (i > 0) {
                System.out.println("deleted the record from the database");
            } else {
                System.out.println("no such record in the database");
            }
            db.closeConnections();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return i;

    }
    public static String searchStudent(String b)throws SQLException, ClassNotFoundException {
        String a ="";
        try {
            DbUtil db = new DbUtil();
            Connection con = db.getConnection();
//            System.out.println("enter the regNo to search");
//            Scanner input = new Scanner(System.in);
//            String inputReg = input.nextLine();
            String sql = "select*from student where regNo=?;";
            PreparedStatement stmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1, b);
            ResultSet rs = stmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("there is no such record in the database");
            } else {
                rs.previous();
                while (rs.next()) {
                    a = rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) +
                            rs.getString(4) + " " + rs.getString(5);
                    System.out.println(a);
                }
            }

            db.closeConnections();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return a;

    }

}

