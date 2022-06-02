<%-- 
    Document   : index
    Created on : 2019/11/24, 下午 09:17:27
    Author     : kem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page  import="java.util.*" %>
<%@page  import="ict.bean.LoginBean" %>
<%@page  import="ict.db.Database" %>
<%!
    String url = "jdbc:derby://localhost:1527/ESDAssignmentDB";
    String username = "APP";
    String passord = "APP";
    Database DB = new Database(url, username, passord);
%>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="index.css" />
    </head>
    <body>
    <center><h1>Sign in</h1></center>
    <hr>
    <div class="card centerCard">
        <form method="POST" action="LoginController">
            <table border="0">
                <tr>
                <input type="text" style="width: 100%" name="accountID"  required placeholder="Account ID" />
                </tr>
                <br/>
                <br/>
                <tr>
                <input type="password" style="width: 100%" name="password" required placeholder="Password" />
                </tr>
            </table>
            <br />
            <center>
                <input type="hidden" name="action" value="authenticate">
                <input type="submit" name="Login" value="Login" />
                <input type="reset" class="cancelBtn" name="Reset" value="Clear" />
            </center>
        </form>
        <br>
        <br>
    </div>


    <center>
        <button class="btnFunction"><a href="AboutUS.jsp" target="_blank">About US</a></button>
    </center>
</body>

</html>
