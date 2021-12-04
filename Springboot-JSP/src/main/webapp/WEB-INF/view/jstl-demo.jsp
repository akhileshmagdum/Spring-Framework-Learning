<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <body>
        <c:set var="income" scope="session" value="${10*8}"/>
        <p>Before Remove Operation</p><c:out value="${income}"/>
        <c:remove var="income"/>
        <p>After remove:</p><c:out value="${income}"/>
    </body>
</html>