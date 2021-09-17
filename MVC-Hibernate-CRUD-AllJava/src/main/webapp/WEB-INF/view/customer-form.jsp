<%--
  Created by IntelliJ IDEA.
  User: Captain
  Date: 13-09-2021
  Time: 09:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer Form</title>
</head>
<body>
<h1>Customer Form</h1>
<form:form action="saveCustomer" modelAttribute = "customer" method="post">
    <!--Associating data with customer Id-->
    <form:hidden path="id"/>
    <table>
        <tbody>
            <tr>
                <td><label>First name:</label></td>
                <td><form:input path="firstName"/></td>
            </tr>
            <tr>
                <td><label>Last name:</label></td>
                <td><form:input path="lastName"/></td>
            </tr>
            <tr>
                <td><label>Email:</label></td>
                <td><form:input path="email"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save"></td>
            </tr>
        </tbody>

    </table>
</form:form>

<!--Link is kind of hardcoded their is another approach were we add a welcome page and revert it to that page-->
<p>
    <a href= "/MVC_Hibernate_ProjectCRUD_war/customer/list">Back to List</a>
</p>
</body>
</html>
