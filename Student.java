package com.pfs.demo.util;

import javax.print.attribute.standard.PresentationDirection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Student {
    //private int Student_Id;
    private String Student_FirstName;
    private String Student_LastName;
    private String Gender;
    private String Residential_Address;
    private int PhoneNo;
    private int Course_Id;
    /*public int getStudent_Id() {
        return Student_Id;
    }
     public void setStudent_Id(int student_Id) {
        Student_Id = student_Id;
    } */

    public String getStudent_FirstName() {
        return Student_FirstName;
    }
    public void setStudent_FirstName(String student_FirstName) {
        Student_FirstName = student_FirstName;
    }
    public String getStudent_LastName() {
        return Student_LastName;
    }

    public void setStudent_LastName(String student_LastName) {
        Student_LastName = student_LastName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getResidential_Address() {
        return Residential_Address;
    }

    public void setResidential_Address(String residential_Address) {
        Residential_Address = residential_Address;
    }

    public int getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        PhoneNo = phoneNo;
    }

    public int getCourse_Id() {
        return Course_Id;
    }

    public void setCourse_Id(int course_Id) {
        Course_Id = course_Id;
    }

    public boolean isStudent_FirtsNameEqualsStudent_LastName(){
        if (this.Student_FirstName == this.Student_LastName) {
            return true;
    } else {
            return false;
        }

    }



    private Connection getConnection() throws ClassNotFoundException,
            SQLException {
        // Find the class comm.mysql.jdbc.Driver -
        // if the class not found then it throws error
        // ClassNotFoundException

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/m1project",
                "root", "");
        //here IU12 is database name, root is username and password
        return conn;
    }

    public int insertStudent() throws ClassNotFoundException,
            SQLException{
        int result=-1;
        Connection conn = this.getConnection();

        String sql = "INSERT INTO `studentmaster`" +
                 " (`Student_FirstName`, `Student_LastName`, `Gender`, " +
                " `Residential_Address`, `PhoneNo`, `Course_Id`) " +
                " VALUES (?,?,?," +
                "        ?,?,?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1,this.Student_FirstName);
        pstmt.setString(2,this.Student_LastName);
        pstmt.setString(3,this.Gender);
        pstmt.setString(4,this.Residential_Address);
        pstmt.setInt(5,this.PhoneNo);
        pstmt.setInt(6,this.Course_Id);

        result = pstmt.executeUpdate();

        return result;
    }


    public int updateStudent(String Student_FirstName,String Student_LastName,String Gender,
                             String Residential_address,int PhoneNo,int Course_Id) throws SQLException,
            ClassNotFoundException {
        Connection conn = this.getConnection();
        String sql = "UPDATE studentmaster SET Student_FirstName = ?," +
                "Student_LastName = ?, Gender = ?, Residential_address = ?, PhoneNo = ?," +
                " WHERE Course_Id = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1,this.Student_FirstName);
        pstmt.setString(2,this.Student_LastName);
        pstmt.setString(3,Gender);
        pstmt.setString(4,Residential_Address);
        pstmt.setInt(5,PhoneNo);
        pstmt.setInt(6,Course_Id);


        int rowsUpdated =  pstmt.executeUpdate();
        return rowsUpdated;
    }

    public int deleteCourse_Id() throws SQLException, ClassNotFoundException {
        Connection conn = this.getConnection();
        String sql = "DELETE FROM studentmaster WHERE Course_Id =?" ;

        PreparedStatement  pstmt = conn.prepareStatement(sql);
        //First parameter is the id of the company entity
        pstmt.setInt(1,Course_Id);

        int rowsDeleted = pstmt.executeUpdate();
        return rowsDeleted;
    }
}
