<%--
  Created by IntelliJ IDEA.
  User: Captain
  Date: 29-08-2021
  Time: 07:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>>
<html>
<head>
    <title>Student Form</title>
</head>
<body>
<form:form action="processform" modelAttribute="student">
    First Name:<form:input path="firstName"/>
    <br><br>
    Last Name:<form:input path="lastName"/>
    <br><br>
    Age:<form:input path="age"/>
    <br><br>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>
