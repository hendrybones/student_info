package com.pluralsight.calcengine;

import com.mysql.jdbc.Statement;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main main=new Main();
    DbUtil db=new DbUtil();
    Connection con=db.getConnection();
    Statement stCheck= (Statement) con.createStatement();

    MainTest() throws SQLException, ClassNotFoundException {
    }


    @Test
    public  void insertDataTest() throws SQLException, ClassNotFoundException {
        Assertions.assertEquals(1,
                new Main().insertStudentDetails("tuo1","bbit","male","27-06-1996", "2-3-2004"));
    }
    @Test
    public void displayDetails() throws SQLException, ClassNotFoundException {
        ResultSet rs=stCheck.executeQuery("SELECT * FROM student");
    }
    @Test
    public void search() throws SQLException, ClassNotFoundException {

        Assertions.assertEquals("tuo4 software male2-04-1021 23-5-2019",new Main().searchStudent("tuo4"));



    }
    @Test
    public void delete() throws SQLException, ClassNotFoundException {
        String sql="delete from student where regNo=?;";
       Assertions.assertEquals(1,new Main().deleteStudent("tuo4"));

    }
    @Test
    public void update() throws SQLException, ClassNotFoundException {
        String sql="update student set regNo=? where regNo=?;";
        Assertions.assertEquals(1,new Main().updateStudent("tuo2","tuo6"));

    }


}