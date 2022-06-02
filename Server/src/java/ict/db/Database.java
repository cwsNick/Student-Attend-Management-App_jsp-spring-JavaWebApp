package ict.db;

import ict.bean.AccountBean;
import ict.bean.AttendanceBean;
import ict.bean.ClassBean;
import ict.bean.ClassTeacherBean;
import ict.bean.CourseBean;
import ict.bean.DepartmentBean;
import ict.bean.EventBean;
import ict.bean.LocationBean;
import ict.bean.LoginBean;
import ict.bean.RoleBean;
import ict.bean.SchoolDayBean;
import ict.bean.StudentBean;
import ict.bean.StudentClassBean;
import ict.bean.TeacherBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Database {

    private String url = "";
    private String username = "";
    private String password = "";

    public Database(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException, IOException {
        System.setProperty("jdbc.drivers", "org.apache.derby.jdbc.ClientDriver");
        return DriverManager.getConnection(url, username, password);
    }

    //                  STUDENT
    public ArrayList<StudentBean> queryStudent() {
        Connection cnnct = null;
        Statement pStmnt = null;
        StudentBean studentBean = null;
        ArrayList<StudentBean> studentBeans = new ArrayList();

        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM STUDENT";
            pStmnt = cnnct.createStatement();
            ResultSet rs = null;
            rs = pStmnt.executeQuery(preQueryStatement);
            while (rs.next()) {
                studentBean = new StudentBean();
                studentBean.setStudentID(rs.getString("StudentID"));
                studentBean.setName(rs.getString("Name"));
                studentBean.setDepartmentID(rs.getString("DepartmentID"));
                studentBeans.add(studentBean);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return studentBeans;
    }

    public String queryStudentName(String StudentID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        String Name = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM STUDENT WHERE StudentID = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, StudentID);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                Name = rs.getString("Name");
            }
            pStmnt.close();
            cnnct.close();

        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return Name;
    }

    //                  Teacher
    public ArrayList<TeacherBean> queryTeacher() {
        Connection cnnct = null;
        Statement pStmnt = null;
        TeacherBean teacherBean = null;
        ArrayList<TeacherBean> teacherBeans = new ArrayList();

        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM TEACHER";
            pStmnt = cnnct.createStatement();
            ResultSet rs = null;
            rs = pStmnt.executeQuery(preQueryStatement);
            while (rs.next()) {
                teacherBean = new TeacherBean();
                teacherBean.setTeacherID(rs.getString("TeacherID"));
                teacherBean.setName(rs.getString("Name"));
                teacherBean.setDepartmentID(rs.getString("DepartmentID"));
                teacherBeans.add(teacherBean);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return teacherBeans;
    }

    public String queryTeacherName(String TeacherID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        String Name = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM TEACHER WHERE TeacherID = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, TeacherID);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                Name = rs.getString("Name");
            }
            pStmnt.close();
            cnnct.close();

        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return Name;
    }

    //                  Attendance
    public boolean addAttendanceRecord(String SchoolDay, String ClassID, String StudentID,
            String Attendance) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;

        try {
            cnnct = getConnection();
            String preQueryStatString
                    = "INSERT INTO ATTENDANCE (SchoolDay,ClassID,StudentID,Attendance) VALUES (?,?,?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatString);

            pStmnt.setString(1, SchoolDay);
            pStmnt.setString(2, ClassID);
            pStmnt.setString(3, StudentID);
            pStmnt.setString(4, Attendance);

            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

    public void setAttend(String AttendanceID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE ATTENDANCE SET Attendance = 1 WHERE AttendanceID = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);

            pStmnt.setString(1, AttendanceID);

            int rowCount = pStmnt.executeUpdate();

            pStmnt.close();
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

    public void setNoAttend(String AttendanceID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE ATTENDANCE SET Attendance = 0 WHERE AttendanceID = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);

            pStmnt.setString(1, AttendanceID);

            int rowCount = pStmnt.executeUpdate();

            pStmnt.close();
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

    //                  check which class is in XXX day
    public ArrayList<ClassBean> queryAttendanceClassByDay(String SchoolDay) {
        Connection cnnct = null;
        Statement pStmnt = null;

        ArrayList<ClassBean> ClassBeans = new ArrayList();
        ClassBean cb = null;

        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT DISTINCT CLASSID FROM ATTENDANCE WHERE SCHOOLDAY = '" + SchoolDay + "'";
            pStmnt = cnnct.createStatement();
            ResultSet rs = null;
            rs = pStmnt.executeQuery(preQueryStatement);
            while (rs.next()) {
                cb = queryClassBean(rs.getString("ClassID"));
                ClassBeans.add(cb);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return ClassBeans;
    }

    public ArrayList<AttendanceBean> queryAttendanceSchoolDay(String ClassID) {
        Connection cnnct = null;
        Statement pStmnt = null;
        AttendanceBean attendanceBean = null;
        ArrayList<AttendanceBean> attendanceBeans = new ArrayList();

        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT DISTINCT SchoolDay FROM ATTENDANCE WHERE ClassID =" + ClassID;
            pStmnt = cnnct.createStatement();
            ResultSet rs = null;
            rs = pStmnt.executeQuery(preQueryStatement);
            while (rs.next()) {
                attendanceBean = new AttendanceBean();
                attendanceBean.setSchoolDay(rs.getString("SchoolDay"));
                attendanceBeans.add(attendanceBean);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return attendanceBeans;
    }

    public ArrayList<AttendanceBean> queryAttendance(String SchoolDay, String ClassID) {
        Connection cnnct = null;
        Statement pStmnt = null;
        AttendanceBean attendanceBean = null;
        ArrayList<AttendanceBean> attendanceBeans = new ArrayList();

        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM ATTENDANCE  WHERE SchoolDay = '" + SchoolDay + "' AND ClassID =" + ClassID;
            pStmnt = cnnct.createStatement();
            ResultSet rs = null;
            rs = pStmnt.executeQuery(preQueryStatement);
            while (rs.next()) {
                attendanceBean = new AttendanceBean();
                attendanceBean.setAttendanceID(rs.getString("AttendanceID"));
                attendanceBean.setSchoolDay(rs.getString("SchoolDay"));
                attendanceBean.setClassID(rs.getString("ClassID"));
                attendanceBean.setStudentID(rs.getString("StudentID"));
                attendanceBean.setAttendance(rs.getString("Attendance"));
                attendanceBeans.add(attendanceBean);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return attendanceBeans;
    }

    public ArrayList<AttendanceBean> queryStudentAttendance(String StudentID) {
        Connection cnnct = null;
        Statement pStmnt = null;
        AttendanceBean attendanceBean = null;
        ArrayList<AttendanceBean> attendanceBeans = new ArrayList();

        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM ATTENDANCE  WHERE StudentID = " + StudentID;
            pStmnt = cnnct.createStatement();
            ResultSet rs = null;
            rs = pStmnt.executeQuery(preQueryStatement);
            while (rs.next()) {
                attendanceBean = new AttendanceBean();
                attendanceBean.setAttendanceID(rs.getString("AttendanceID"));
                attendanceBean.setSchoolDay(rs.getString("SchoolDay"));
                attendanceBean.setClassID(rs.getString("ClassID"));
                attendanceBean.setStudentID(rs.getString("StudentID"));
                attendanceBean.setAttendance(rs.getString("Attendance"));
                attendanceBeans.add(attendanceBean);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return attendanceBeans;
    }

    public String queryAttendanceStudentNumber(String SchoolDay, String ClassID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        String nums = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT COUNT(*) AS nums FROM ATTENDANCE WHERE SchoolDay ='" + SchoolDay + "' AND ClassID =" + ClassID;
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                nums = rs.getString("nums");
            }
            pStmnt.close();
            cnnct.close();

        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return nums;
    }

    public String queryAttendanceStudentNoNumber(String SchoolDay, String ClassID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        String nums = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT COUNT(*) AS nums FROM ATTENDANCE WHERE Attendance = 0 AND SchoolDay ='" + SchoolDay + "' AND ClassID =" + ClassID;
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                nums = rs.getString("nums");
            }
            pStmnt.close();
            cnnct.close();

        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return nums;
    }

    public String queryAttendanceStudentPercentage(String SchoolDay, String ClassID) {
        double i = Double.parseDouble(queryAttendanceStudentNumber(SchoolDay, ClassID));
        double n = Double.parseDouble(queryAttendanceStudentYesNumber(SchoolDay, ClassID));

        double Percentage = n / i * 100;
        return Percentage + "%";
    }

    public double queryAttendanceStudentPercentageNum(String SchoolDay, String ClassID) {
        double i = Double.parseDouble(queryAttendanceStudentNumber(SchoolDay, ClassID));
        double n = Double.parseDouble(queryAttendanceStudentYesNumber(SchoolDay, ClassID));

        double Percentage = n / i * 100;
        return Percentage;
    }

    public String queryAbsenceStudentPercentage(String SchoolDay, String ClassID) {
        double i = Double.parseDouble(queryAttendanceStudentNumber(SchoolDay, ClassID));
        double n = Double.parseDouble(queryAttendanceStudentNoNumber(SchoolDay, ClassID));

        double Percentage = n / i * 100;
        return Percentage + "%";
    }

    public String queryAttendanceStudentYesNumber(String SchoolDay, String ClassID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        String nums = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT COUNT(*) AS nums FROM ATTENDANCE WHERE Attendance = 1 AND SchoolDay ='" + SchoolDay + "' AND ClassID =" + ClassID;
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                nums = rs.getString("nums");
            }
            pStmnt.close();
            cnnct.close();

        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return nums;
    }

    public ArrayList<AttendanceBean> queryNoAttendance(String SchoolDay, String ClassID) {
        Connection cnnct = null;
        Statement pStmnt = null;
        AttendanceBean attendanceBean = null;
        ArrayList<AttendanceBean> attendanceBeans = new ArrayList();

        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM ATTENDANCE WHERE Attendance = 0 AND SchoolDay = '" + SchoolDay + "' AND ClassID =" + ClassID;
            pStmnt = cnnct.createStatement();
            ResultSet rs = null;
            rs = pStmnt.executeQuery(preQueryStatement);
            while (rs.next()) {
                attendanceBean = new AttendanceBean();
                attendanceBean.setAttendanceID(rs.getString("AttendanceID"));
                attendanceBean.setSchoolDay(rs.getString("SchoolDay"));
                attendanceBean.setClassID(rs.getString("ClassID"));
                attendanceBean.setStudentID(rs.getString("StudentID"));
                attendanceBean.setAttendance(rs.getString("Attendance"));
                attendanceBeans.add(attendanceBean);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return attendanceBeans;
    }

    public ArrayList<AttendanceBean> queryYesAttendance(String SchoolDay, String ClassID) {
        Connection cnnct = null;
        Statement pStmnt = null;
        AttendanceBean attendanceBean = null;
        ArrayList<AttendanceBean> attendanceBeans = new ArrayList();

        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM ATTENDANCE WHERE Attendance = 1 AND SchoolDay = '" + SchoolDay + "' AND ClassID =" + ClassID;
            pStmnt = cnnct.createStatement();
            ResultSet rs = null;
            rs = pStmnt.executeQuery(preQueryStatement);
            while (rs.next()) {
                attendanceBean = new AttendanceBean();
                attendanceBean.setAttendanceID(rs.getString("AttendanceID"));
                attendanceBean.setSchoolDay(rs.getString("SchoolDay"));
                attendanceBean.setClassID(rs.getString("ClassID"));
                attendanceBean.setStudentID(rs.getString("StudentID"));
                attendanceBean.setAttendance(rs.getString("Attendance"));
                attendanceBeans.add(attendanceBean);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return attendanceBeans;
    }

    public boolean hasAttendance(String SchoolDay, String ClassID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean hasAttendance = false;
        String AttendanceID = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM ATTENDANCE WHERE SchoolDay = ? AND ClassID = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, SchoolDay);
            pStmnt.setString(2, ClassID);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                AttendanceID = rs.getString("AttendanceID");
            }
            if (AttendanceID != null) {
                hasAttendance = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return hasAttendance;
    }

    //                  Event
    public boolean addEventRecord(String CourseID, String TeacherID, String ClassID, String LocationID,
            String Color, String Date, String StartPeriod, String EndPeriod) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;

        try {
            cnnct = getConnection();
            String preQueryStatString
                    = "INSERT INTO EVENT (CourseID,TeacherID,ClassID,LocationID,Color,Date,StartPeriod,EndPeriod) VALUES (?,?,?,?,?,?,?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatString);

            pStmnt.setString(1, CourseID);
            pStmnt.setString(2, TeacherID);
            pStmnt.setString(3, ClassID);
            pStmnt.setString(4, LocationID);
            pStmnt.setString(5, Color);
            pStmnt.setString(6, Date);
            pStmnt.setString(7, StartPeriod);
            pStmnt.setString(8, EndPeriod);

            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

    public Boolean delEventDay(String EventID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "DELETE FROM EVENT WHERE EventID = ? ";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, EventID);

            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();

        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

    public void editEvent(String EventID, String CourseID, String TeacherID, String ClassID, String LocationID,
            String Color, String Date, String StartPeriod, String EndPeriod) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        try {
            cnnct = getConnection();
            String preQueryStatement
                    = "UPDATE EVENT SET CourseID = ?,TeacherID = ?,ClassID = ?,LocationID = ?,"
                    + "Color = ?,Date = ?,StartPeriod = ?,EndPeriod = ? WHERE EventID = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);

            pStmnt.setString(1, CourseID);
            pStmnt.setString(2, TeacherID);
            pStmnt.setString(3, ClassID);
            pStmnt.setString(4, LocationID);

            pStmnt.setString(5, Color);
            pStmnt.setString(6, Date);
            pStmnt.setString(7, StartPeriod);
            pStmnt.setString(8, EndPeriod);

            pStmnt.setString(9, EventID);

            int rowCount = pStmnt.executeUpdate();

            pStmnt.close();
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

    public ArrayList<EventBean> queryEvent() {
        Connection cnnct = null;
        Statement pStmnt = null;
        EventBean eventBean = null;
        ArrayList<EventBean> eventBeans = new ArrayList();

        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM EVENT";
            pStmnt = cnnct.createStatement();
            ResultSet rs = null;
            rs = pStmnt.executeQuery(preQueryStatement);

            while (rs.next()) {
                eventBean = new EventBean();
                eventBean.setEventID(rs.getString("EventID"));

                eventBean.setCourseID(rs.getString("CourseID"));
                eventBean.setTeacherID(rs.getString("TeacherID"));
                eventBean.setClassID(rs.getString("ClassID"));
                eventBean.setLocationID(rs.getString("LocationID"));

                eventBean.setColor(rs.getString("Color"));
                eventBean.setDate(rs.getString("Date"));

                eventBean.setStartPeriod(rs.getString("StartPeriod"));
                eventBean.setEndPeriod(rs.getString("EndPeriod"));

                eventBean.setDurationTime();

                eventBeans.add(eventBean);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return eventBeans;
    }

    ///             School Day
    public boolean addSchoolDayRecord(SchoolDayBean schoolDayBean) {
        return addSchoolDayRecord(schoolDayBean.getSemName(), schoolDayBean.getStartTime(), schoolDayBean.getStopTime());
    }

    public boolean addSchoolDayRecord(String SemName, String StartTime, String StopTime) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatString = "INSERT INTO SCHOOLDAY (SemName,StartTime,StopTime) VALUES (?,?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatString);
            pStmnt.setString(1, SemName);
            pStmnt.setString(2, StartTime);
            pStmnt.setString(3, StopTime);

            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

    public void editSchoolDay(String SchoolDayID, String SemName, String StartTime, String StopTime) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE SCHOOLDAY SET SemName = ?,StartTime = ?,StopTime = ? WHERE SchoolDayID = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);

            pStmnt.setString(1, SemName);
            pStmnt.setString(2, StartTime);
            pStmnt.setString(3, StopTime);
            pStmnt.setString(4, SchoolDayID);

            int rowCount = pStmnt.executeUpdate();

            pStmnt.close();
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

    public Boolean delSchoolDay(String SchoolDayID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "DELETE FROM SCHOOLDAY WHERE SchoolDayID = ? ";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, SchoolDayID);

            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();

        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

    public ArrayList<SchoolDayBean> querySchoolDay() {
        Connection cnnct = null;
        Statement pStmnt = null;
        SchoolDayBean sdb = null;
        ArrayList<SchoolDayBean> SchoolDayBeans = new ArrayList();

        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM SCHOOLDAY";
            pStmnt = cnnct.createStatement();
            ResultSet rs = null;
            rs = pStmnt.executeQuery(preQueryStatement);

            while (rs.next()) {
                sdb = new SchoolDayBean();
                sdb.setSchoolDayID(rs.getString("SchoolDayID"));
                sdb.setSemName(rs.getString("SemName"));
                sdb.setStartTime(rs.getString("StartTime"));
                sdb.setStopTime(rs.getString("StopTime"));

                SchoolDayBeans.add(sdb);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return SchoolDayBeans;
    }

//                          COURSE
///////////////////////////////////////////////////////////////////////////
    public boolean addCourse(CourseBean CourseBean) {
        return addCourse(CourseBean.getCourseName(), CourseBean.getCourseDetailed());
    }

    public boolean addCourse(String CourseName, String CourseDetailed) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatString = "INSERT INTO COURSE (CourseName,CourseDetailed) VALUES (?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatString);
            pStmnt.setString(1, CourseName);
            pStmnt.setString(2, CourseDetailed);

            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

    public Boolean delCourse(String CourseID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "DELETE FROM COURSE WHERE CourseID = ? ";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, CourseID);

            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();

        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

    public void editCourse(String CourseID, String CourseName, String CourseDetailed) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE COURSE SET CourseName = ?, CourseDetailed = ? WHERE CourseID = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);

            pStmnt.setString(1, CourseName);
            pStmnt.setString(2, CourseDetailed);

            pStmnt.setString(3, CourseID);

            int rowCount = pStmnt.executeUpdate();

            pStmnt.close();
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

    public ArrayList<CourseBean> queryCourse() {
        Connection cnnct = null;
        Statement pStmnt = null;
        CourseBean courseBean = null;
        ArrayList<CourseBean> courseBeans = new ArrayList();

        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM COURSE";
            pStmnt = cnnct.createStatement();
            ResultSet rs = null;
            rs = pStmnt.executeQuery(preQueryStatement);
            while (rs.next()) {
                courseBean = new CourseBean();
                courseBean.setCourseID(rs.getString("CourseID"));
                courseBean.setCourseName(rs.getString("CourseName"));
                courseBean.setCourseDetailed(rs.getString("CourseDetailed"));
                courseBeans.add(courseBean);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return courseBeans;
    }

    public String queryCourse(String CourseID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        String CourseName = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM COURSE WHERE CourseID = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, CourseID);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                CourseName = rs.getString("CourseName");
            }
            pStmnt.close();
            cnnct.close();

        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return CourseName;
    }
//                          Location
///////////////////////////////////////////////////////////////////////////

    public boolean addLocation(LocationBean LocationBean) {
        return addDepartmentRecord(LocationBean.getLocationName(), LocationBean.getCourseDetailed());
    }

    public boolean addLocation(String LocationName, String Detailed) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatString = "INSERT INTO LOCATION (LocationName,CourseDetailed) VALUES (?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatString);
            pStmnt.setString(1, LocationName);
            pStmnt.setString(2, Detailed);

            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

    public Boolean delLocation(String LocationID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "DELETE FROM LOCATION WHERE LocationID = ? ";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, LocationID);
            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();

        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

    public void editLocation(String LocationID, String LocationName, String Detailed) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE LOCATION SET LocationName = ?, CourseDetailed = ? WHERE LocationID = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);

            pStmnt.setString(1, LocationName);
            pStmnt.setString(2, Detailed);

            pStmnt.setString(3, LocationID);

            int rowCount = pStmnt.executeUpdate();

            pStmnt.close();
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

    public ArrayList<LocationBean> queryLocation() {
        Connection cnnct = null;
        Statement pStmnt = null;
        LocationBean locationBean = null;
        ArrayList<LocationBean> locationBeans = new ArrayList();

        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM LOCATION";
            pStmnt = cnnct.createStatement();
            ResultSet rs = null;
            rs = pStmnt.executeQuery(preQueryStatement);
            while (rs.next()) {
                locationBean = new LocationBean();
                locationBean.setLocationID(rs.getString("LocationID"));
                locationBean.setLocationName(rs.getString("LocationName"));
                locationBean.setCourseDetailed(rs.getString("CourseDetailed"));
                locationBeans.add(locationBean);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return locationBeans;
    }

    public String queryLocation(String LocationID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        String LocationName = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM LOCATION WHERE LocationID = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, LocationID);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                LocationName = rs.getString("LocationName");
            }
            pStmnt.close();
            cnnct.close();

        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return LocationName;
    }

//                          Department
///////////////////////////////////////////////////////////////////////////
    public boolean addDepartmentRecord(DepartmentBean departmentBean) {
        return addDepartmentRecord(departmentBean.getDepartmentName(), departmentBean.getDepartmentDetailed());
    }

    public boolean addDepartmentRecord(String DepartmentName, String DepartmentDetailed) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatString = "INSERT INTO DEPARTMENT (DepartmentName,DepartmentDetailed) VALUES (?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatString);
            pStmnt.setString(1, DepartmentName);
            pStmnt.setString(2, DepartmentDetailed);
            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

    public ArrayList<DepartmentBean> queryDepartment() {
        Connection cnnct = null;
        Statement pStmnt = null;
        DepartmentBean cb = null;
        ArrayList<DepartmentBean> DepartmentBean = new ArrayList();

        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM DEPARTMENT";
            pStmnt = cnnct.createStatement();
            ResultSet rs = null;
            rs = pStmnt.executeQuery(preQueryStatement);
            while (rs.next()) {
                cb = new DepartmentBean();
                cb.setDepartmentID(rs.getString("DepartmentID"));
                cb.setDepartmentName(rs.getString("DepartmentName"));
                cb.setDepartmentDetailed(rs.getString("DepartmentDetailed"));
                DepartmentBean.add(cb);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return DepartmentBean;
    }

    public String queryDepartment(String DepartmentID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        String DepartmentName = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM DEPARTMENT WHERE DepartmentID = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, DepartmentID);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                DepartmentName = rs.getString("DepartmentName");
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return DepartmentName;
    }

    public Boolean delDepartmentRecord(String DepartmentID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "DELETE FROM DEPARTMENT WHERE DepartmentID = ? ";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, DepartmentID);
            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

    public boolean canEditDepartmentRecord(String DepartmentID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        boolean canEdit = false;

        try {
            cnnct = getConnection();

            String type = "";

            String preQueryStatement = "SELECT * FROM TEACHER WHERE DepartmentID = ? ";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, DepartmentID);

            ResultSet rs = null;
            rs = pStmnt.executeQuery();

            if (!rs.next()) { //can TEACHER Table no data link to DepartmentID
                canEdit = true;
            }

            pStmnt.close();
            cnnct.close();

            return canEdit;

        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
                return false;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        return canEdit;
    }

    public void editDepartmentRecord(DepartmentBean DepartmentBean) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE DEPARTMENT SET DepartmentName = ?, DepartmentDetailed = ? WHERE DepartmentID = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);

            pStmnt.setString(1, DepartmentBean.getDepartmentName());
            pStmnt.setString(2, DepartmentBean.getDepartmentDetailed());

            pStmnt.setString(3, DepartmentBean.getDepartmentID());

            int rowCount = pStmnt.executeUpdate();

            pStmnt.close();
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

    public void editDepartmentRecord(String DepartmentID, String DepartmentName, String DepartmentDetailed) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE DEPARTMENT SET DepartmentName = ?, DepartmentDetailed = ? WHERE DepartmentID = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);

            pStmnt.setString(1, DepartmentName);
            pStmnt.setString(2, DepartmentDetailed);

            pStmnt.setString(3, DepartmentID);

            int rowCount = pStmnt.executeUpdate();

            pStmnt.close();
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

//                          Role
///////////////////////////////////////////////////////////////////////////
    public boolean addRoleRecord(RoleBean rb) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatString = "INSERT INTO ROLE VALUES (?)";
            pStmnt = cnnct.prepareStatement(preQueryStatString);
            pStmnt.setString(1, rb.getRole());
            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

    public ArrayList<RoleBean> queryRole() {
        Connection cnnct = null;
        Statement pStmnt = null;
        RoleBean cb = null;
        ArrayList<RoleBean> RoleBeans = new ArrayList();
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM ROLE";
            pStmnt = cnnct.createStatement();
            ResultSet rs = null;
            rs = pStmnt.executeQuery(preQueryStatement);
            while (rs.next()) {
                cb = new RoleBean();
                cb.setRole(rs.getString("RoleType"));
                RoleBeans.add(cb);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return RoleBeans;
    }

    public Boolean delRoleRecord(String role) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "DELETE FROM ROLE WHERE RoleType = ? ";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, role);
            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

//////////////////////////////////////////////////////////////////////////////
    public boolean addAccount(AccountBean ab) {
        return addAccount(ab.getLoginID(), ab.getPassword(), ab.getType(), ab.getDepartmentOrYears(), ab.getName());
    }

    public boolean addAccount(String LoginID, String password, String type, String departmentID, String name) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();

            String preQueryStatString = "";
            String IDtype = "";
            String addUserType = "";

            //Step 1 add to Teacher/Student Table.
            if (type.equals("Teacher")) {
                preQueryStatString = "INSERT INTO TEACHER ( DepartmentID , Name ) VALUES (?,?)";

                IDtype = "TeacherID";
                addUserType = "TEACHER";

            } else if (type.equals("Student")) {
                preQueryStatString = "INSERT INTO STUDENT ( DepartmentID , Name ) VALUES (?,?)";

                IDtype = "StudentID";
                addUserType = "STUDENT";
            }
            pStmnt = cnnct.prepareStatement(preQueryStatString);
            pStmnt.setString(1, departmentID);
            pStmnt.setString(2, name);

            int rowCount = pStmnt.executeUpdate();
            int rowCount2;

            //Step 2 get new account user id
            String preQueryStatement = "SELECT MAX(" + IDtype + ") AS id FROM " + addUserType;
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                IDtype = rs.getString("id");
            }

            if (rowCount == 0) {
                if (type.equals("Teacher")) {
                    preQueryStatement = "DELETE FROM TEACHER WHERE TeacherID = ?";

                } else if (type.equals("Student")) {
                    preQueryStatement = "DELETE FROM STUDENT WHERE StudentID = ?";
                }

                pStmnt = cnnct.prepareStatement(preQueryStatement);
                pStmnt.setString(1, IDtype);
                rowCount += pStmnt.executeUpdate();
                return false;
            }

            //Step 3 add user id and type for connect to Teacher/Student Table.
            preQueryStatString = "INSERT INTO ACCOUNT (LoginID , UserID , Type , Password) VALUES (?,?,?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatString);
            pStmnt.setString(1, LoginID);
            pStmnt.setString(2, IDtype);
            pStmnt.setString(3, type);
            pStmnt.setString(4, password);
            rowCount2 = pStmnt.executeUpdate();

            if (rowCount >= 1 && rowCount2 >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();

        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

    public ArrayList<AccountBean> queryAccount() {
        Connection cnnct = null;
        Statement pStmnt = null;
        AccountBean ab = null;
        ArrayList<AccountBean> AccountBeans = new ArrayList();
        try {
            cnnct = getConnection();

            String preQueryStatement = "SELECT * FROM APP.ACCOUNT, APP.TEACHER WHERE APP.ACCOUNT.UserID=APP.TEACHER.TeacherID";
            pStmnt = cnnct.createStatement();
            ResultSet rs = null;
            rs = pStmnt.executeQuery(preQueryStatement);
            while (rs.next()) {
                ab = new AccountBean();
                ab.setLoginID(rs.getString("LoginID"));
                ab.setAccountID(rs.getString("AccountID"));
                ab.setUserID(rs.getString("UserID"));
                ab.setPassword(rs.getString("Password"));
                ab.setType(rs.getString("Type"));
                ab.setDepartmentOrYears(rs.getString("DepartmentID"));
                ab.setName(rs.getString("Name"));
                AccountBeans.add(ab);
            }

            preQueryStatement = "SELECT * FROM APP.ACCOUNT a, APP.STUDENT s WHERE s.StudentID=a.UserID";
            rs = pStmnt.executeQuery(preQueryStatement);
            while (rs.next()) {
                ab = new AccountBean();
                ab.setLoginID(rs.getString("LoginID"));
                ab.setAccountID(rs.getString("AccountID"));
                ab.setUserID(rs.getString("UserID"));
                ab.setPassword(rs.getString("Password"));
                ab.setType(rs.getString("Type"));
                ab.setDepartmentOrYears(rs.getString("DepartmentID"));
                ab.setName(rs.getString("Name"));
                AccountBeans.add(ab);
            }

            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return AccountBeans;
    }

    public Boolean delAccountRecord(String AccountID, String UserID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();

            //Get Type of user from table , to avoid user in web side not save type data
            String deleteUserType = "";
            String preQueryStatement = "SELECT Type AS Type FROM ACCOUNT WHERE AccountID = ? ";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, AccountID);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                deleteUserType = rs.getString("Type");
            }

            //delete account part 1
            preQueryStatement = "DELETE FROM ACCOUNT WHERE AccountID = ? ";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, AccountID);
            int rowCount = pStmnt.executeUpdate();

            //delete account part 2
            if (deleteUserType.equals("Teacher")) {
                preQueryStatement = "DELETE FROM TEACHER WHERE TeacherID = ?";
                pStmnt = cnnct.prepareStatement(preQueryStatement);
                pStmnt.setString(1, UserID);
                rowCount += pStmnt.executeUpdate();

            } else if (deleteUserType.equals("Student")) {
                preQueryStatement = "DELETE FROM STUDENT WHERE StudentID = ?";
                pStmnt = cnnct.prepareStatement(preQueryStatement);
                pStmnt.setString(1, UserID);
                rowCount += pStmnt.executeUpdate();
            }
            System.out.println("delete part 2 ");

            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

    public void editAccountRecord(AccountBean ab) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE ACCOUNT SET LoginID = ?, Password = ?, Type = ? WHERE AccountID = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, ab.getLoginID());
            pStmnt.setString(2, ab.getPassword());
            pStmnt.setString(3, ab.getType());
            pStmnt.setString(4, ab.getAccountID());
            int rowCount = pStmnt.executeUpdate();

            String type = "";
            preQueryStatement = "SELECT * FROM ACCOUNT WHERE AccountID = ? ";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, ab.getAccountID());
            ResultSet rs = null;
            rs = pStmnt.executeQuery();

            while (rs.next()) {
                type = rs.getString("Type");
            }

            if ("Admin".equals(type)) {

            } else if ("Teacher".equals(type)) {
                System.out.println("UPDATE TEACHER" + type);

                preQueryStatement = "UPDATE TEACHER SET Name = ?, DepartmentID = ? WHERE TeacherID = ?";

                pStmnt = cnnct.prepareStatement(preQueryStatement);
                pStmnt.setString(1, ab.getName());
                pStmnt.setString(2, ab.getDepartmentOrYears());
                pStmnt.setString(3, ab.getUserID());
                rowCount += pStmnt.executeUpdate();

            } else if ("Student".equals(type)) {
                System.out.println("UPDATE STUDENT" + type);

                preQueryStatement = "UPDATE STUDENT SET Name = ? , DepartmentID = ? WHERE StudentID = ?";

                pStmnt = cnnct.prepareStatement(preQueryStatement);
                pStmnt.setString(1, ab.getName());
                pStmnt.setString(2, ab.getDepartmentOrYears());
                pStmnt.setString(3, ab.getUserID());
                rowCount += pStmnt.executeUpdate();
            }

            //rowCount == 2 table updata successful.
            pStmnt.close();
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

//////////////////////////////////////////////////////////////////////////////
    public boolean addClassRecord(String ClassName, String DepartmentID, String Years, String Detailed) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatString = "INSERT INTO CLASS (ClassName,DepartmentID,Years,Detailed) VALUES (?,?,?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatString);
            pStmnt.setString(1, ClassName);
            pStmnt.setString(2, DepartmentID);
            pStmnt.setString(3, Years);
            pStmnt.setString(4, Detailed);

            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();

        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

    public void editClassRecord(String ClassID, String ClassName, String DepartmentID, String Years, String Detailed) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE CLASS SET ClassName = ?, DepartmentID = ?,Years = ?, Detailed = ? WHERE ClassID = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);

            pStmnt.setString(1, ClassName);
            pStmnt.setString(2, DepartmentID);
            pStmnt.setString(3, Years);
            pStmnt.setString(4, Detailed);
            pStmnt.setString(5, ClassID);

            int rowCount = pStmnt.executeUpdate();

            pStmnt.close();
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

    public ArrayList<ClassBean> queryClass() {
        Connection cnnct = null;
        Statement pStmnt = null;
        ClassBean cb = null;
        ArrayList<ClassBean> ClassBeans = new ArrayList();
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM CLASS";
            pStmnt = cnnct.createStatement();
            ResultSet rs = null;
            rs = pStmnt.executeQuery(preQueryStatement);
            while (rs.next()) {
                cb = new ClassBean();

                cb.setClassID(rs.getString("ClassID"));
                cb.setClassName(rs.getString("ClassName"));
                cb.setDepartmentID(rs.getString("DepartmentID"));
                cb.setYears(rs.getString("Years"));
                cb.setDetailed(rs.getString("Detailed"));
                ClassBeans.add(cb);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return ClassBeans;
    }

    public ClassBean queryClassBean(String ClassID) {
        Connection cnnct = null;
        Statement pStmnt = null;
        ClassBean classBean = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM CLASS WHERE ClassID = " + ClassID;
            pStmnt = cnnct.createStatement();
            ResultSet rs = null;
            rs = pStmnt.executeQuery(preQueryStatement);
            while (rs.next()) {
                classBean = new ClassBean();

                classBean.setClassID(rs.getString("ClassID"));
                classBean.setClassName(rs.getString("ClassName"));
                classBean.setDepartmentID(rs.getString("DepartmentID"));
                classBean.setYears(rs.getString("Years"));
                classBean.setDetailed(rs.getString("Detailed"));
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return classBean;
    }

    public String queryClass(String ClassID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        String ClassName = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM CLASS WHERE ClassID = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, ClassID);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                ClassName = rs.getString("ClassName");
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return ClassName;
    }

    public Boolean delClassRecord(String ClassID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;

        try {
            cnnct = getConnection();
            String preQueryStatement = "DELETE FROM CLASS WHERE ClassID = ? ";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, ClassID);

            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

    public boolean addStudentClassRecord(String StudentID, String ClassID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatString = "INSERT INTO StudentClass (StudentID,ClassID) VALUES (?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatString);
            pStmnt.setString(1, StudentID);
            pStmnt.setString(2, ClassID);

            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

    public boolean addClassTeacher(String TeacherID, String ClassID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatString = "INSERT INTO ClassTeacher (TeacherID,ClassID) VALUES (?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatString);
            pStmnt.setString(1, TeacherID);
            pStmnt.setString(2, ClassID);

            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

    public Boolean delClassTeacher(String TeacherID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "DELETE FROM ClassTeacher WHERE TeacherID = ? ";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, TeacherID);

            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();

        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

    public String queryStudentClassID(String ClassID, String StudentID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        String StudentClassID = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM StudentClass WHERE ClassID = ? AND StudentID = ? ";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, ClassID);
            pStmnt.setString(2, StudentID);

            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                StudentClassID = rs.getString("StudentClassID");
            }
            pStmnt.close();
            cnnct.close();

        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return StudentClassID;
    }

    public ArrayList<StudentClassBean> queryStudentClass() {
        Connection cnnct = null;
        Statement pStmnt = null;
        StudentClassBean scb = null;
        ArrayList<StudentClassBean> StudentClassBeans = new ArrayList();
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM StudentClass";
            pStmnt = cnnct.createStatement();
            ResultSet rs = null;
            rs = pStmnt.executeQuery(preQueryStatement);
            while (rs.next()) {
                scb = new StudentClassBean();
                scb.setStudentClassID(rs.getString("StudentClassID"));
                scb.setClassID(rs.getString("ClassID"));
                scb.setStudentID(rs.getString("StudentID"));
                StudentClassBeans.add(scb);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return StudentClassBeans;
    }

    public ArrayList<ClassTeacherBean> queryClassTeacher() {
        Connection cnnct = null;
        Statement pStmnt = null;
        ClassTeacherBean classTeacherBean = null;
        ArrayList<ClassTeacherBean> ClassTeacherBeans = new ArrayList();
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM ClassTeacher";
            pStmnt = cnnct.createStatement();
            ResultSet rs = null;
            rs = pStmnt.executeQuery(preQueryStatement);
            while (rs.next()) {
                classTeacherBean = new ClassTeacherBean();
                classTeacherBean.setClassTeacherID(rs.getString("ClassTeacherID"));
                classTeacherBean.setClassID(rs.getString("ClassID"));
                classTeacherBean.setTeacherID(rs.getString("TeacherID"));
                ClassTeacherBeans.add(classTeacherBean);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return ClassTeacherBeans;
    }

    public ArrayList<ClassTeacherBean> queryClassTeacher(String ClassID) {
        Connection cnnct = null;
        Statement pStmnt = null;
        ClassTeacherBean classTeacherBean = null;
        ArrayList<ClassTeacherBean> ClassTeacherBeans = new ArrayList();
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM ClassTeacher WHERE ClassID = " + ClassID;
            pStmnt = cnnct.createStatement();
            ResultSet rs = null;
            rs = pStmnt.executeQuery(preQueryStatement);
            while (rs.next()) {
                classTeacherBean = new ClassTeacherBean();
                classTeacherBean.setClassTeacherID(rs.getString("ClassTeacherID"));
                classTeacherBean.setClassID(rs.getString("ClassID"));
                classTeacherBean.setTeacherID(rs.getString("TeacherID"));
                ClassTeacherBeans.add(classTeacherBean);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return ClassTeacherBeans;
    }

    public ArrayList<StudentClassBean> queryStudentClass(String ClassID) {
        Connection cnnct = null;
        Statement pStmnt = null;
        StudentClassBean scb = null;
        ArrayList<StudentClassBean> StudentClassBeans = new ArrayList();

        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM StudentClass WHERE ClassID = " + ClassID;
            pStmnt = cnnct.createStatement();
            ResultSet rs = null;
            rs = pStmnt.executeQuery(preQueryStatement);
            while (rs.next()) {
                scb = new StudentClassBean();
                scb.setStudentClassID(rs.getString("StudentClassID"));
                scb.setClassID(rs.getString("ClassID"));
                scb.setStudentID(rs.getString("StudentID"));
                StudentClassBeans.add(scb);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return StudentClassBeans;
    }

    public Boolean delStudentClassRecord(String StudentID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "DELETE FROM StudentClass WHERE StudentID = ? ";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, StudentID);
            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

    public String checkLogin(String LoginID, String Password) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        String type = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM ACCOUNT WHERE LoginID = ? AND Password = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, LoginID);
            pStmnt.setString(2, Password);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                type = rs.getString("Type");
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return type;
    }

    public AccountBean queryUserInfo(String LoginID, String Type, String Password) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        String UserID = null;
        AccountBean accountBean = new AccountBean();
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT UserID FROM ACCOUNT WHERE LoginID = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, LoginID);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                UserID = rs.getString("UserID");
                accountBean.setUserID(UserID);
            }

            if ("Teacher".equals(Type)) {
                preQueryStatement = "SELECT * FROM TEACHER WHERE TeacherID = ?";

            } else if ("Student".equals(Type)) {
                preQueryStatement = "SELECT * FROM STUDENT WHERE StudentID = ?";

            }

            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, UserID);
            ResultSet rs2 = null;
            rs2 = pStmnt.executeQuery();
            while (rs2.next()) {
                accountBean.setName(rs2.getString("Name"));
                accountBean.setDepartmentOrYears(rs2.getString("DepartmentID"));
            }

            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return accountBean;
    }

    public String converterToDate(int dateID) {
        //char grade = args[0].charAt(0);

        switch (dateID) {
            case 1:
                return "8:00 AM";
            case 2:
                return "8:30 AM";
            case 3:
                return "9:00 AM";
            case 4:
                return "9:30 AM";
            case 5:
                return "10:00 AM";
            case 6:
                return "10:30 AM";
            case 7:
                return "11:00 AM";
            case 8:
                return "11:30 AM";
            case 9:
                return "12:00 AM";
            case 10:
                return "12:30 PM";
            case 11:
                return "13:00 PM";
            case 12:
                return "13:30 PM";
            case 13:
                return "14:00 PM";
            case 14:
                return "14:30 PM";
            case 15:
                return "15:00 PM";
            case 16:
                return "15:30 PM";
            case 17:
                return "16:00 PM";
            case 18:
                return "16:30 PM";
            case 19:
                return "17:30 PM";
            case 20:
                return "18:00 PM";
            default:
                return 0 + "";
        }
    }

    public String converterAttendance(String Attendance) {
        //char grade = args[0].charAt(0);
        if ("0".equals(Attendance)) {
            return "Absence";
        } else if ("1".equals(Attendance)) {
            return "Attended";
        }
        return Attendance;

    }
}
