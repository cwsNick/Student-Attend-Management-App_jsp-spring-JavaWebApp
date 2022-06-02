package ict.servlet;

import ict.bean.AccountBean;
import ict.bean.LoginBean;
import ict.db.Database;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (!isAuthenticated(request) && !("authenticate".equals(action))) {
            doLogin(request, response);
            return;
        }
        if ("authenticate".equals(action)) {
            doAuthenticate(request, response);
        } else if ("logout".equals(action)) {
            doLogout(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED);
        }
    }
    
    protected void doAuthenticate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String LoginID = request.getParameter("accountID");
        String password = request.getParameter("password");
        String targetURL;
        
        init();
        
        String Type = db.checkLogin(LoginID, password);
        
        AccountBean accountBean = db.queryUserInfo(LoginID, Type, password);
        
        if ("Admin".equals(Type)) {
            HttpSession session = request.getSession(true);
            
            LoginBean bean = new LoginBean();
            
            bean.setLoginID(LoginID);
            bean.setPassword(password);
            
            bean.setType("Admin");
            session.setAttribute("LoginBean", bean);
            targetURL = "AdminUI.jsp";
            
        } else if ("Teacher".equals(Type)) {
            HttpSession session = request.getSession(true);
            
            LoginBean bean = new LoginBean();
            bean.setName(accountBean.getName());
            bean.setDepartmentID(accountBean.getDepartmentOrYears());
            bean.setPassword(password);
            bean.setUserID(accountBean.getUserID());
            bean.setType("Teacher");
            session.setAttribute("LoginBean", bean);
            targetURL = "TeacherUI.jsp";
            
        } else if ("Student".equals(Type)) {
            HttpSession session = request.getSession(true);
            
            LoginBean bean = new LoginBean();
            bean.setName(accountBean.getName());
            bean.setDepartmentID(accountBean.getDepartmentOrYears());
            bean.setPassword(password);
            bean.setUserID(accountBean.getUserID());
            bean.setType("Student");
            
            session.setAttribute("LoginBean", bean);
            targetURL = "StudentUI.jsp";
        } else {
            
            
            HttpSession session = request.getSession(true);
            
            LoginBean bean = new LoginBean();
            bean.setLoginID(LoginID);
            bean.setPassword(password);
            bean.setType("Invalid login, please try again");
            
            session.setAttribute("LoginBean", bean);
            
            targetURL = "index.jsp";
        }
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/" + targetURL);
        rd.forward(request, response);
    }
    
    private boolean isAuthenticated(HttpServletRequest request) {
        boolean result = false;
        HttpSession session = request.getSession();
        if (session.getAttribute("LoginBean") != null) {
            result = true;
        }
        return result;
    }
    
    private void doLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String targetURL = "index.jsp";
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/" + targetURL);
        rd.forward(request, response);
    }
    
    private void doLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("LoginBean");
            session.invalidate();
        }
        doLogin(request, response);
    }
    
    private Database db;
    
    public void init() {
        String dbUser = "APP";
        String dbPassword = "APP";
        String dbUrl = "jdbc:derby://localhost:1527/ESDAssignmentDB";
        db = new Database(dbUrl, dbUser, dbPassword);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
