<%--
  Created by IntelliJ IDEA.
  User: Captain
  Date: 24-09-2021
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h3>Please login to continue</h3>

<form:form action="${pageContext.request.contextPath}/auth-user" method="post">
    <!--The name should always be username and password so Spring Security can read it-->
    <p>
        Username : <input type="text" name = "username"/>
    </p>
    <p>
        Password : <input type="password" name = "password"/>
    </p>
    <input type = "submit" value = "Login"/>
</form:form>

</body>
</html>
