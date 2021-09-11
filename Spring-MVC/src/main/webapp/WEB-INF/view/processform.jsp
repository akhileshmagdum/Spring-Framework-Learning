<%--
  Created by IntelliJ IDEA.
  User: Captain
  Date: 27-08-2021
  Time: 02:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Basic Form Processed</title>
</head>
<body>
<h1>Welcome!</h1>
<h2>Thank you for filling out the form</h2>
<hr>
Name: ${param.studentName}
<br><br>
Age : ${param.age}
<br><br>
Click on the link below to check randomly allocated class
<a href= "enrollcourse">See Class</a>

</body>
</html>
