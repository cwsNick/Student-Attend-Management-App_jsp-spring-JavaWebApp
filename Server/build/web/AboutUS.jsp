<%-- 
    Document   : AboutUS
    Created on : 2019/11/24, 下午 09:20:31
    Author     : kem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/ict-taglib.tld" prefix="ict" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>About US</title>
        <style>
            .card {
                margin: auto;
                background-color: white;
                padding: 20px;
                margin-top: 20px;
                box-shadow: 0 0 1px 1px rgba(20, 23, 28, .1), 0 3px 1px 0 rgba(20, 23, 28, .1);
                width: 800px;
            }
        </style>
    </head>
    <body>
        <br><br><br>
        <div class="card">
            <ict:about  content="Established in 1500, Super Hero School is the world's largest super hero education institution. Each year, approximately 100,000 students are provided with comprehensive training to submit internationally recognized hero qualifications.<br><br>
                        The SHS is strong in strength and has a large number of members. It offers a wide range of courses and awards a wide range of accredited qualifications to provide all the rare opportunities for students of all ages and degrees. Our teaching methods focus on teaching practical skills, emphasizing practical experience and effectiveness. The focus is not only on imparting knowledge and skills, but also on \"fight\".<br><br>
                        Our teaching method of \"thinking and practicing\" emphasizes the professional hero technical knowledge, and also cultivates enthusiasm for learning and leads them to the path of \"success\"."  />
        </div>
    </body>
</html>
