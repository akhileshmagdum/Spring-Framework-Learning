<%--
  Created by IntelliJ IDEA.
  User: Captain
  Date: 24-09-2021
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login</title>
</head>
<body>

<h3>Please login to continue</h3>

<form:form action="${pageContext.request.contextPath}/auth-user" method="post">

    <c:if test="${param.error != null}">
        <i>Please enter registered id or {Username: Michael / Password: fun123}</i>
    </c:if>

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
