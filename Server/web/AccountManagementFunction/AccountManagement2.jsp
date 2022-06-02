<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page  import="java.util.*" %>
<%@page  import="ict.bean.AccountBean" %>
<%@page  import="ict.db.Database" %>
<%!
    String url = "jdbc:derby://localhost:1527/ESDAssignmentDB";
    String username = "APP";
    String passord = "APP";
    Database DB = new Database(url, username, passord);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <META   HTTP-EQUIV="REFRESH"   CONTENT="0;url=AccountManagement.jsp">
        <title>Account Management</title>
    </head>
    <body>
        <jsp:useBean id="Eaccount" class="ict.bean.AccountBean"  scope="request" />
        <jsp:setProperty name="Eaccount" property="*" />
        
        <jsp:getProperty name="Eaccount" property="loginID" />
        <jsp:getProperty name="Eaccount" property="userID" />
        <jsp:getProperty name="Eaccount" property="accountID" />
        <jsp:getProperty name="Eaccount" property="password" />
        <jsp:getProperty name="Eaccount" property="type" />
        <jsp:getProperty name="Eaccount" property="departmentOrYears" />
        <jsp:getProperty name="Eaccount" property="name" />
        <%
            Eaccount.setName("88888");
            this.DB.editAccountRecord(Eaccount);
        %>
    </body>
</html>
