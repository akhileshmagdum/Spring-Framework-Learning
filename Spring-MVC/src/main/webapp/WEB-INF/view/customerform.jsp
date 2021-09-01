<%--
  Created by IntelliJ IDEA.
  User: Captain
  Date: 31-08-2021
  Time: 09:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>>
<html>
<head>
    <title>Customer Form</title>
    <style>
        .error{color: red}
    </style>
</head>
<body>
    <form:form action="processform" modelAttribute="customer">
        First Name:<form:input path="firstName"/>
        <form:errors path="firstName" cssClass="error"/>
        <br><br>
        Last Name:<form:input path="lastName"/>
        <br><br>
        Card Points: <form:input path="cardPoints"/>
        <form:errors path="cardPoints" cssClass="error"/>
        <br><br>
        Customer Id: <form:input path="customerIdentity"/>
        <form:errors path="customerIdentity" cssClass="error"/>
        <br><br>
        <input type="submit" value="submit"/>
    </form:form>


</body>
</html>
