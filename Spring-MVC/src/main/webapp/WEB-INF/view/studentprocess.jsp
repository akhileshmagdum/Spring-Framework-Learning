<%--
  Created by IntelliJ IDEA.
  User: Captain
  Date: 29-08-2021
  Time: 07:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Processing Form</title>
</head>
<body>
<h3>Student Processed</h3>
    Student ${student.firstName} ${student.lastName} of age ${student.age} confirmed!
    <br><br>
    The student stays in ${student.state} and he has assigned the programming language ${student.prgLang}
    <br><br>
    Along with his hobbies of ${student.hobby}
</body>
</html>
