<%--
  Created by IntelliJ IDEA.
  User: Captain
  Date: 17-09-2021
  Time: 02:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<html>

<head>
    <title>Welcome to Spring Security</title>
</head>

<body>


<h1>Welcome to Spring Security</h1>

<p>

    User: <security:authentication property="principal.username" />

    <br><br>

    Role(s): <security:authentication property="principal.authorities" />

</p>


<form:form action="${pageContext.request.contextPath}/logout" method="post">

    <input type="submit" value="Logout"/>

</form:form>


</body>
</html>
