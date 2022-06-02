package ict.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class setUpDB {

    private String url = "";
    private String username = "";
    private String password = "";

    public setUpDB(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException, IOException {
        System.setProperty("jdbc.drivers", "org.apache.derby.jdbc.ClientDriver");
        return DriverManager.getConnection(url, username, password);
    }

    public void createTable() throws SQLException, IOException {
        Connection cnnct = null;
        Statement stmnt = null;

        try {
            cnnct = getConnection();
            stmnt = cnnct.createStatement();
            //ROLE
            String sql = "CREATE TABLE ROLE ("
                    + "RoleType VARCHAR(20) CONSTRAINT PK_ROLE PRIMARY KEY)";
            stmnt.execute(sql);

            //ACCOUNT
            sql = "CREATE TABLE ACCOUNT (" //AccountID use to login , UserID to TEACHER/STUDENT table find user
                    + "AccountID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT PK_ACCOUNT PRIMARY KEY,"
                    + "LoginID VARCHAR(50) NOT NULL, "
                    + "UserID INTEGER NOT NULL, "//Link to TeacherID/StudentID.
                    + "Password VARCHAR(20) NOT NULL, "
                    + "Type VARCHAR(20) REFERENCES ROLE(RoleType))";//User for check link to which table (STUDENT/TEACHER)
            stmnt.execute(sql);

            //DEPARTMENT
            sql = "CREATE TABLE DEPARTMENT ("
                    + "DepartmentID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT PK_DEPARTMENT PRIMARY KEY,"
                    + "DepartmentName VARCHAR(50) NOT NULL, "
                    + "DepartmentDetailed VARCHAR(5000) )";
            stmnt.execute(sql);

            //TEACHER
            sql = "CREATE TABLE TEACHER ("
                    + "TeacherID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT PK_TEACHER PRIMARY KEY,"
                    + "DepartmentID INTEGER NOT NULL REFERENCES DEPARTMENT(DepartmentID), "
                    + "Name VARCHAR(20) NOT NULL)";
            stmnt.execute(sql);

            //STUDENT
            sql = "CREATE TABLE STUDENT ("
                    + "StudentID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT PK_STUDENT PRIMARY KEY,"
                    + "DepartmentID INTEGER NOT NULL REFERENCES DEPARTMENT(DepartmentID), "
                    + "Name VARCHAR(20) NOT NULL )";
            stmnt.execute(sql);

            //CLASS
            sql = "CREATE TABLE CLASS ("
                    + "ClassID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT PK_CLASS PRIMARY KEY,"
                    + "ClassName VARCHAR(20) NOT NULL,"
                    + "DepartmentID INTEGER NOT NULL REFERENCES DEPARTMENT(DepartmentID), "
                    + "Years VARCHAR(20) NOT NULL, "
                    + "Detailed VARCHAR(5000))";
            stmnt.execute(sql);

            //ClassTeacher
            sql = "CREATE TABLE ClassTeacher ("
                    + "ClassTeacherID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT PK_ClassTeacher PRIMARY KEY,"
                    + "ClassID INTEGER REFERENCES CLASS(ClassID),"
                    + "TeacherID INTEGER REFERENCES TEACHER(TeacherID))";
            stmnt.execute(sql);

            //StudentClass
            sql = "CREATE TABLE StudentClass ("
                    + "StudentClassID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT PK_StudentClass PRIMARY KEY,"
                    + "ClassID INTEGER REFERENCES CLASS(ClassID), "
                    + "StudentID INTEGER REFERENCES STUDENT(StudentID))";
            stmnt.execute(sql);

            //SCHOOLDAY
            sql = "CREATE TABLE SCHOOLDAY ("
                    + "SchoolDayID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT PK_SCHOOLDAY PRIMARY KEY,"
                    + "SemName VARCHAR(20) , "
                    + "StartTime DATE NOT NULL, "
                    + "StopTime DATE NOT NULL)";
            stmnt.execute(sql);

            //COURSE
            sql = "CREATE TABLE COURSE ("
                    + "CourseID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT PK_COURSE PRIMARY KEY,"
                    + "CourseName VARCHAR(20) NOT NULL,"
                    + "CourseDetailed VARCHAR(5000))";
            stmnt.execute(sql);

            //LOCATION
            sql = "CREATE TABLE LOCATION ("
                    + "LocationID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT PK_LOCATION PRIMARY KEY,"
                    + "LocationName VARCHAR(20) NOT NULL,"
                    + "CourseDetailed VARCHAR(5000))";
            stmnt.execute(sql);

            //CLASS
            sql = "CREATE TABLE EVENT ("
                    + "EventID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT PK_EVENT PRIMARY KEY,"
                    + "CourseID INTEGER NOT NULL REFERENCES COURSE(CourseID), "
                    + "TeacherID INTEGER REFERENCES TEACHER(TeacherID), "
                    + "ClassID INTEGER REFERENCES CLASS(ClassID), "
                    + "LocationID INTEGER REFERENCES LOCATION(LocationID), "
                    + "Color VARCHAR(20),"
                    + "Date DATE NOT NULL, "
                    + "StartPeriod INTEGER NOT NULL,"
                    + "EndPeriod INTEGER NOT NULL)";
            stmnt.execute(sql);

            //ATTENDANCE
            sql = "CREATE TABLE ATTENDANCE ("
                    + "AttendanceID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT PK_Attendance PRIMARY KEY,"
                    + "SchoolDay DATE,"
                    + "ClassID INTEGER REFERENCES CLASS(ClassID),"
                    + "StudentID INTEGER REFERENCES STUDENT(StudentID), "
                    + "Attendance INTEGER DEFAULT 0"//0=false, 1=true
                    + ")";
            stmnt.execute(sql);

            stmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
