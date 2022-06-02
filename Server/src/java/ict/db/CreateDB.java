package ict.db;

import ict.bean.RoleBean;
import ict.bean.AccountBean;
import ict.bean.DepartmentBean;
import java.io.IOException;
import java.sql.SQLException;

public class CreateDB {

    public static void main(String[] args) throws SQLException, IOException {

        String url = "jdbc:derby://localhost:1527/ESDAssignmentDB";
        String username = "APP";
        String passord = "APP";

        Database DB = new Database(url, username, passord);
        setUpDB db = new setUpDB(url, username, passord);

        //base set up for db
        db.createTable();
        /*RoleBean RoleBean = new RoleBean();
        RoleBean RoleBean2 = new RoleBean();
        RoleBean RoleBean3 = new RoleBean();

        RoleBean.setRole("Teacher");
        RoleBean2.setRole("Student");
        RoleBean3.setRole("Admin");

        DB.addRoleRecord(RoleBean);
        DB.addRoleRecord(RoleBean2);
        DB.addRoleRecord(RoleBean3);

        String DepartmentName = "Applied Science";
        String Detail = "The limits of science and technology are being pushed back as new discoveries re-shape the way we see our world. The Applied Science Discipline provides professional and timely education and training in response to these new horizons, which includes the areas of Health Studies, Rehabilitation Services, Medical Centre Operations, Applied Nutritional Studies, Vision Health Care, Biomedical Science, Pharmaceutical Science, Dispensing Studies, Biotechnology, Food Technology and Safety, Analytical Science, Chemical Technology, Beauty and Personal Care Products, Environmental Science, Environmental Protection and Management, Conservation and Tree Management, Occupational Safety and so on.\nApplied Science discipline continuously enhance the quality of the programmes to address the huge manpower needs in various areas of applied science and stay updated amongst the industry. Students are equipped with professional knowledge and skills which allow them to proceed for further studies or embark on a professional career.";
        
        String DepartmentName = "Design";
        String Detail = "Hong Kong has emerged as one of the regional creative capitals, where innovation creates global values and opportunities and generates enormous economic value. In support of the government policy on developing the cultural and creative industries, Design Discipline provides through Hong Kong Design Institute (HKDI) the quality design education that cultivates knowledge, professionalism and new talents facilitating the prosperity of the creative industries and responding to the growing demand for design innovation of enterprises.";

         
        String DepartmentName = "Business";
        String Detail = "Hong Kong prepares to develop as a world class smart city with continuous city innovation and sustainable economic development. To align with this latest development, Business Discipline aims in nurturing talents with multifaceted skills, creativity and innovative mindsets in response to the manpower needs of various business sectors.The Discipline offers a wide spectrum of programmes addressing the challenges created by new business opportunities.  Module syllabi are enhanced with concepts in technology applications, and integrated with Artificial Intelligence (A), Blockchain (B), Cloud Computing (C), Data Analytics (D) and Experience (E) under business operations. Practical and student-centred curriculum, embedded with Project-based Learning and Work-integrated Learning, is adopted in order to develop students’ 21st century competencies for further study and career development.  The Discipline also works closely with industry partners to provide valuable learning opportunities to students, such as organizing professional seminars, study visits and overseas exchange programmes, so as to broaden students’ horizons.";

        DB.addDepartmentRecord(DepartmentName, Detail);
        System.out.println(DB.queryDepartment().toString());

        
        AccountBean AccountBean = new AccountBean();
        AccountBean.setLoginID("ken");
        AccountBean.setName("Ken Chan");
        AccountBean.setType("Student");
        AccountBean.setDepartmentOrYears("1");
        AccountBean.setPassword("edit321");
        //AccountBean.setUserID("1");

        DB.addAccount(AccountBean);
/*        //DB.editAccountRecord(AccountBean);
        System.out.print(DB.queryAccount().toString());
        //DB.delAccountRecord( "4",  "1");
        //DB.delDepartmentRecord("1");
        //System.out.println(DB.canEditDepartmentRecord("2"));

        /*
        DepartmentBean DepartmentBean =new DepartmentBean();
        DepartmentBean.setDepartmentID("2");
        DepartmentBean.setDepartmentName("code");
        DepartmentBean.setDepartmentDetailed("one two");
        DB.editDepartmentRecord(DepartmentBean);
         */
        
        
        //System.out.print(DB.queryUserInfo("ken", "Student", "edit321"));
        //System.out.print(DB.queryUserInfo("ken", "Student", "edit321").getName());
    }
}
